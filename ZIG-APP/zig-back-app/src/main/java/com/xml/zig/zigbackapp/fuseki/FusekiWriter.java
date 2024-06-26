package com.xml.zig.zigbackapp.fuseki;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

public class FusekiWriter {

//	private static final String RDF_FILEPATH = "src/main/resources/data/rdf/rdfOutput.rdf";
	private static final String GRAPH_URI = "metadata";
	
	public static final String PREFIX = "http://ftn.uns.ac.rs/trademarks/";

	public static void saveRDF(String subject,String predicate,String object) throws IOException {
		
		System.out.println("[INFO] Loading triples from an RDF/XML to a model...");
		
		FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();

		Model model = ModelFactory.createDefaultModel();
//		model.read(RDF_FILEPATH);
		//model.setPrefix
//		model.setNsPrefix("td", PREFIX);
		model.add(model.createResource(PREFIX + subject), model.createProperty(PREFIX + predicate), object);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		model.write(out, SparqlUtil.NTRIPLES);
		
		System.out.println("[INFO] Rendering model as RDF/XML...");
		
		model.write(System.out, SparqlUtil.RDF_XML);

		UpdateRequest request = UpdateFactory.create();
		
		UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, conn.updateEndpoint);
		
		processor.execute();
		
		System.out.println("[INFO] Writing the triples to a named graph \"" + GRAPH_URI + "\".");
		
		String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + "/" + GRAPH_URI, new String(out.toByteArray()));
		
		System.out.println(sparqlUpdate);
		
		

		UpdateRequest update = UpdateFactory.create(sparqlUpdate);
		
		processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
		
		processor.execute();

	}
	
	

}
