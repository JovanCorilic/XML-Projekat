package Patent.BackendPatent.jenafuseki;

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
        ResultSetFormatter.outputAsXML(System.out,results);
        query.close();
        return foundPatent;
    }

}
