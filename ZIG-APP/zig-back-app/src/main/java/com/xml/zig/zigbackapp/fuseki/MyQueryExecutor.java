package com.xml.zig.zigbackapp.fuseki;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.text.StringSubstitutor;
import org.apache.jena.atlas.json.JsonArray;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

public class MyQueryExecutor {
	
	public static List<String> trademarks_lst = new ArrayList<>();
	
	
	public static Set<String> executeAllQuery(String spqrql) throws IOException {

		FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();

		System.out.println("Query: " + spqrql);

		QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, spqrql);
		
		ResultSet results = query.execSelect();

		
//		JsonArray ja = query.execJson();
//		System.out.println("JSONNNNN");
//		System.out.println(ja.toString());
		
		String varName;

		RDFNode varValue;

		Set<String> trademarks = new HashSet<>();
		
		while (results.hasNext()) {
			// A single answer from a SELECT query
			QuerySolution querySolution = results.next();

			Iterator<String> variableBindings = querySolution.varNames();

			// Retrieve variable bindings
			while (variableBindings.hasNext()) {

				varName = variableBindings.next();

				varValue = querySolution.get(varName);

				System.out.println(varName + " :: " + varValue);

				trademarks.add(varName + " :: " + varValue);
				
				trademarks_lst.add(varName + " :: " + varValue);

			}

		}

//		ResultSetFormatter.outputAsXML(System.out, results);
//
//		ResultSetFormatter.outputAsJSON(System.out, results);
		
		query.close();

		return trademarks;
	}

	public static void updateQuery(String spqrql) throws IOException {

		FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();

		System.out.println("Query: " + spqrql);

//		QueryExecution query = QueryExecutionFactory.sparqlService(conn.updateEndpoint, spqrql);
		
		UpdateRequest request = UpdateFactory.create(spqrql) ;
		
		// UpdateProcessor sends update request to a remote SPARQL update service. 
        UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, conn.updateEndpoint);
		processor.execute();	

	}

}
