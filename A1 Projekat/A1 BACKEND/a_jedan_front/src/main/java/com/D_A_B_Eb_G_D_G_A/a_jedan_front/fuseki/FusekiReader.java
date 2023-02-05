package com.D_A_B_Eb_G_D_G_A.a_jedan_front.fuseki;

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
    private static final String QUERY_FILEPATH = "src/main/resources/rdf/sparql.rq";
    private static final String QUERY_FILEPATH_ALL = "src/main/resources/rdf/sparqlgetall.rq";
    private static final int BROJ_META_PODATAKA = 5;
    private FusekiReader(){}

    public static ArrayList<String> executeQuery(Map<String,String> params) throws IOException {
        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();
        String sparqlQueryTemplate = readFile(QUERY_FILEPATH, StandardCharsets.UTF_8);
        System.out.println("Query: " + sparqlQueryTemplate);
        String sparqlQuery = StringSubstitutor.replace(sparqlQueryTemplate,params,"{{","}}");
        System.out.println("Query: " + sparqlQuery);
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint,sparqlQuery);
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;
        ArrayList<String> foundPatente = new ArrayList<>();
        while(results.hasNext()){
            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();
            // Retrieve variable bindings
            while(variableBindings.hasNext()){
                varName = variableBindings.next();
                varValue = querySolution.get(varName);
                System.out.println(varName + ": " + varValue);
                if(varName.contains("naslov")){
                    String value = varValue.toString();
                    foundPatente.add(value);
                }
            }
        }
        ResultSetFormatter.outputAsXML(System.out,results);
        query.close();
        return foundPatente;
    }

    public static ArrayList<String> getAllMetadata() throws IOException {
        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();
        String sparqlQuery = readFile(QUERY_FILEPATH_ALL, StandardCharsets.UTF_8);
        System.out.println("Query: " + sparqlQuery);
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint,sparqlQuery);
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;
        ArrayList<String> foundPatente = new ArrayList<>();
        String xml_linija = "\n\t\t<%POLJE%>%VREDNOST%</%POLJE%>";
        int nad_brojac = 0;
        String kraj = "";
        while(results.hasNext()){
            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();
            // Retrieve variable bindings
            int brojac = 0;
            
            while(variableBindings.hasNext()){
                varName = variableBindings.next();
                varValue = querySolution.get(varName);
                System.out.println(varName + ": " + varValue);
                String value = varValue.toString();
                //foundPatente.add(value);
                ++brojac;
                if(brojac == 1){
                    xml_linija = xml_linija.toString().replace("%VREDNOST%", varValue.toString().split("\\^\\^")[0]);
                }else if(brojac == 2){
                    String[] s2 = varValue.toString().split("/");
                    xml_linija = xml_linija.toString().replace("%ELEMENT%", s2[s2.length - 1].replace(".rdf", ""));
                    kraj = "</" + s2[s2.length - 1].replace(".rdf", "") + ">";
                }else{
                    String[] s2 = varValue.toString().split("/");
                    String polje = s2[s2.length - 1].replace("predicate", "");
                    xml_linija = xml_linija.toString().replace("%POLJE%", polje);
                }
            }
            ++nad_brojac;
            if(nad_brojac == BROJ_META_PODATAKA) {
                foundPatente.add( "\t" + kraj.replace("/","") + xml_linija + "\n\t" + kraj);
                xml_linija = "\n\t\t<%POLJE%>%VREDNOST%</%POLJE%>";
                nad_brojac = 0;
            }
            else {
                xml_linija += "\n\t\t<%POLJE%>%VREDNOST%</%POLJE%>";
            }
        }
        ResultSetFormatter.outputAsXML(System.out,results);
        query.close();
        return foundPatente;
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded,encoding);
    }
}
