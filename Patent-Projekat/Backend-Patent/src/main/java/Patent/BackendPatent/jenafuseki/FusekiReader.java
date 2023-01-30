package Patent.BackendPatent.jenafuseki;

import Patent.BackendPatent.model.viseMetapodataka.Metapodaci;
import org.apache.commons.text.StringSubstitutor;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class FusekiReader {
    private FusekiReader(){}

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded,encoding);
    }

    /*
    SELECT * FROM <http://localhost:8081/fuseki/Dataset/data/patentMetadata> where{
    ?Dataset <http://www.ftn.uns.ac.rs/rdf/examples/predicate/nazivPatentaSrpski> ?nazivPatentaSrpski .
    FILTER(CONTAINS(UCASE(str(?nazivPatentaSrpski)), UCASE("1"))).
}

     */

    public static ArrayList<String> executeQueryViseMetapodataka(Metapodaci metapodaci, String opcija) throws IOException {
        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();
        String sparqlQuery = "SELECT * FROM <http://localhost:8081/fuseki/Dataset/data/patentMetadata> where{";
        String temp;
        if(opcija.equals("AND"))
            temp= "&&";
        else
            temp="||";
        String filter = "FILTER(";
        if(!metapodaci.getBrojPrijave().equals("")) {
            sparqlQuery += "?Dataset <http://www.ftn.uns.ac.rs/rdf/examples/predicate/brojPrijave> ?brojPrijave . ";
            filter +="CONTAINS(UCASE(str(?brojPrijave)), UCASE(\""+metapodaci.getBrojPrijave()+"\"))";
        }
        if(!metapodaci.getPriznatiDatumPodnosenja().equals("")) {
            sparqlQuery += "?Dataset <http://www.ftn.uns.ac.rs/rdf/examples/predicate/priznatDatumPodnosenja> ?priznatDatumPodnosenja . ";
            if(!filter.equals("FILTER("))
                filter+=" "+temp+" ";
            filter+= "CONTAINS(UCASE(str(?priznatDatumPodnosenja)), UCASE(\""+metapodaci.getPriznatiDatumPodnosenja()+"\"))";
        }
        if(!metapodaci.getSrpskiNaziv().equals("")) {
            sparqlQuery += "?Dataset <http://www.ftn.uns.ac.rs/rdf/examples/predicate/nazivPatentaSrpski> ?nazivPatentaSrpski . ";
            if(!filter.equals("FILTER("))
                filter+=" "+temp+" ";
            filter+="CONTAINS(UCASE(str(?nazivPatentaSrpski)), UCASE(\""+metapodaci.getSrpskiNaziv()+"\"))";
        }
        if (!metapodaci.getEngleskiNaziv().equals("")) {
            sparqlQuery += "?Dataset <http://www.ftn.uns.ac.rs/rdf/examples/predicate/nazivPatentaEngleski> ?nazivPatentaEngleski . ";
            if(!filter.equals("FILTER("))
                filter+=" "+temp+" ";
            filter+="CONTAINS(UCASE(str(?nazivPatentaEngleski)), UCASE(\""+metapodaci.getEngleskiNaziv()+"\"))";
        }
        filter+=").";
        sparqlQuery+=filter+" }";

        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint,sparqlQuery);
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;
        ArrayList<String> foundPatent = new ArrayList<>();
        while(results.hasNext()){
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();
            while(variableBindings.hasNext()){
                varName = variableBindings.next();
                varValue = querySolution.get(varName);
                if(varName.contains("brojPrijave")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }
                else if(varName.contains("nazivPatentaSrpski")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }
                else if(varName.contains("nazivPatentaEngleski")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }else if(varName.equals("Dataset"))
                    foundPatent.add(""+varValue);
                else if (varName.contains("priznatDatumPodnosenja")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }
            }
        }
        query.close();
        return foundPatent;
    }

    public static ArrayList<String>executeQueryResenje(String odluka, String opcija) throws IOException {
        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();
        String sparqlQuery = "";
        switch (opcija){
            case "1":
                sparqlQuery = "SELECT * FROM <http://localhost:8081/fuseki/Dataset/data/resenjeMetadata> where{" +
                        " ?Dataset <http://www.ftn.uns.ac.rs/rdf/resenje/predicate/datumOdlukeOZahtevu> ?datumOdlukeOZahtevu ." +
                        " FILTER(CONTAINS(UCASE(str(?datumOdlukeOZahtevu)), UCASE(\""+odluka+"\"))). " +
                        "}";
                //sparqlQuery = readFile("src/main/resources/rdf/test.rq", StandardCharsets.UTF_8);
                break;
            case "2":
                if (odluka.split(" ").length==1)
                    return new ArrayList<>();
                sparqlQuery = "SELECT * FROM <http://localhost:8081/fuseki/Dataset/data/resenjeMetadata> where{\n" +
                        "    ?Dataset <http://www.ftn.uns.ac.rs/rdf/resenje/predicate/ime> ?ime .\n" +
                        "    ?Dataset <http://www.ftn.uns.ac.rs/rdf/resenje/predicate/prezime> ?prezime .\n" +
                        "    FILTER(CONTAINS(UCASE(str(?ime)), UCASE(\""+odluka.split(" ")[0]+"\"))" +
                        "       && CONTAINS(UCASE(str(?prezime)), UCASE(\""+odluka.split(" ")[1]+"\"))).\n" +
                        "}";
                break;
        }

        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint,sparqlQuery);
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;
        ArrayList<String> foundPatent = new ArrayList<>();
        while(results.hasNext()){
            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();
            // Retrieve variable bindings
            while(variableBindings.hasNext()){
                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                if(varName.contains("datumOdlukeOZahtevu")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }
                else if(varName.contains("ime")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }
                else if(varName.contains("prezime")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }else if(varName.equals("Dataset"))
                    foundPatent.add(""+varValue);
            }
        }
        query.close();
        return foundPatent;
    }

    public static ArrayList<String> executeQueryPatent(Map<String,String> params, String opcija) throws IOException {
        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();
        String QUERY_FILEPATH_PATENT = "src/main/resources/rdf/sparql";
        switch (opcija) {
            case "3":
                QUERY_FILEPATH_PATENT += "EngleskiNaziv.rq";
                break;
            case "2":
                QUERY_FILEPATH_PATENT += "BrojPrijave.rq";
                break;
            case "1":
                QUERY_FILEPATH_PATENT += "SrpskiNaziv.rq";
                break;
            case "4":
                QUERY_FILEPATH_PATENT += "priznatDatumPodnosenja.rq";
                break;
        }
        String sparqlQueryTemplate = readFile(QUERY_FILEPATH_PATENT, StandardCharsets.UTF_8);

        String sparqlQuery = StringSubstitutor.replace(sparqlQueryTemplate,params,"{{","}}");
        System.out.println(sparqlQuery);
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint,sparqlQuery);
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;
        ArrayList<String> foundPatent = new ArrayList<>();
        while(results.hasNext()){
            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();
            // Retrieve variable bindings
            while(variableBindings.hasNext()){
                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                if(varName.contains("brojPrijave")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }
                else if(varName.contains("nazivPatentaSrpski")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }
                else if(varName.contains("nazivPatentaEngleski")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }else if(varName.equals("Dataset"))
                    foundPatent.add(""+varValue);
                else if (varName.contains("priznatDatumPodnosenja")){
                    String value = varValue.toString();
                    foundPatent.add(value);
                }
            }
        }
        //ResultSetFormatter.outputAsXML(System.out,results);
        query.close();
        return foundPatent;
    }

}
