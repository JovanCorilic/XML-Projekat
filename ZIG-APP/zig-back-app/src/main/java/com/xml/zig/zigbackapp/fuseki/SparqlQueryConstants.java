package com.xml.zig.zigbackapp.fuseki;

public class SparqlQueryConstants {

	public static String getAllTriples() {

		String sparql = " SELECT ?s ?p ?o \n" + "WHERE {" + "GRAPH <http://localhost:4040/Trademark/data/metadata>{"
				+ "?s ?p ?o ." + "}" + "}";

		return sparql;
	}

	public static String getUserTriple(String username, boolean username_not) {

		String filter = " FILTER(?o = '" + username + "' )";

		if (username_not) {
			filter = " FILTER(?o != '" + username + "' )";
		}

		String sparql = " SELECT ?s \n" + "WHERE {" + "GRAPH <http://localhost:4040/Trademark/data/metadata>{"
				+ "?s <http://ftn.uns.ac.rs/trademarks/user> ?o ." + filter + "}" + "}";

		return sparql;
	}

	public static String getDateTriple(Long date1, Long date2, boolean date_not) {

		String filter = " FILTER( xsd:integer(?o) > " + date1 + " && xsd:integer(?o) < " + date2 + " )";

		if (date_not) {
			filter = " FILTER( xsd:integer(?o) < " + date1 + " || xsd:integer(?o) > " + date2 + " )";
			;

		}

		String sparql = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " + "SELECT ?s \n" + "WHERE {"
				+ "GRAPH <http://localhost:4040/Trademark/data/metadata>{"
				+ "?s <http://ftn.uns.ac.rs/trademarks/date> ?o . " + filter + "}"

				+ "}";

		return sparql;
	}

	public static String getTypeTriple(String type, boolean type_not) {

		String filter = " FILTER(?o = '" + type + "' )";

		if (type_not) {
			filter = " FILTER(?o != '" + type + "' )";
		}

		String sparql = "SELECT ?s \n" + "WHERE {" + "GRAPH <http://localhost:4040/Trademark/data/metadata>{"
				+ "?s <http://ftn.uns.ac.rs/trademarks/type> ?o . " + filter + "}"

				+ "}";

		return sparql;
	}

	public static String getStatusTriple(String status, boolean status_not) {

		String filter = " FILTER(?o = '" + status + "' )";

		if (status_not) {
			filter = " FILTER(?o != '" + status + "' )";
		}

		String sparql = "SELECT ?s \n" + "WHERE {" + "GRAPH <http://localhost:4040/Trademark/data/metadata>{"
				+ "?s <http://ftn.uns.ac.rs/trademarks/status> ?o . " + filter + "}"

				+ "}";

		return sparql;
	}
	
	public static String getDateAndStatusTriple(String status , Long date1, Long date2) {

		String filter = " FILTER( xsd:integer(?o) > " + date1 + " && xsd:integer(?o) < "
						+ date2 + " && ?s = ?s2 && ?o2 = \""+ status +"\")";



		String sparql = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "  
				+ "SELECT (COUNT(*) as ?Triples) \n" + "WHERE {" + "GRAPH <http://localhost:4040/Trademark/data/metadata>{"
				+ "?s <http://ftn.uns.ac.rs/trademarks/date> ?o .  "
				+ "?s2 <http://ftn.uns.ac.rs/trademarks/status> ?o2 . "
				+ filter + "}"

				+ "}";

		return sparql;
	}
	
	public static String getStatusForTrademark(String uuid) {

		String sparql = "SELECT ?o \n" 
				+ "WHERE {" 
				+ "GRAPH <http://localhost:4040/Trademark/data/metadata>{"
				+ "<http://ftn.uns.ac.rs/trademarks/"+ uuid + "> <http://ftn.uns.ac.rs/trademarks/status> ?o . " 
				+ "}"
				+ "}";

		return sparql;
	}
	
	public static String getSolutionForTrademark(String uuid) {

		String sparql = "SELECT ?o \n" 
				+ "WHERE {" 
				+ "GRAPH <http://localhost:4040/Trademark/data/metadata>{"
				+ "<http://ftn.uns.ac.rs/trademarks/"+ uuid + "> <http://ftn.uns.ac.rs/trademarks/ref> ?o . " 
				+ "}"
				+ "}";

		return sparql;
	}
	
	//RDF METADATA AND JSON METADATA
	public static String getAllMetadataForTrademark(String uuid) {

		String sparql = "SELECT ?p ?o \n" 
				+ "WHERE {" 
				+ "GRAPH <http://localhost:4040/Trademark/data/metadata>{"
				+ "<http://ftn.uns.ac.rs/trademarks/"+ uuid + "> ?p ?o . " 
				+ "}"
				+ "}";

		return sparql;
	}
	
	

	public static String deleteStatusWait(String id) {

		String sparql = "DELETE DATA { \n" + " GRAPH <http://localhost:4040/Trademark/data/metadata> {"
				+ " <http://ftn.uns.ac.rs/trademarks/" + id + "> <http://ftn.uns.ac.rs/trademarks/status> \"WAIT\" . "
				+ "}" + "}";

		return sparql;
	}

	public static String deleteStatusAccept(String id) {

		String sparql = "DELETE DATA { \n" + " GRAPH <http://localhost:4040/Trademark/data/metadata> {"
				+ " <http://ftn.uns.ac.rs/trademarks/" + id + "> <http://ftn.uns.ac.rs/trademarks/status> \"ACCEPT\" . "
				+ "}" + "}";

		return sparql;
	}
	
	public static String deleteStatusDecline(String id) {

		String sparql = "DELETE DATA { \n" + " GRAPH <http://localhost:4040/Trademark/data/metadata> {"
				+ " <http://ftn.uns.ac.rs/trademarks/" + id + "> <http://ftn.uns.ac.rs/trademarks/status> \"DECLINE\" . "
				+ "}" + "}";

		return sparql;
	}

//	public static String addStatusAcpDec(String id,String status) {
//
//		String sparql = "INSERT DATA{ \n" 
//				+ " GRAPH <http://localhost:4040/Trademark/data/metadata> {"
//				+ " <http://ftn.uns.ac.rs/trademarks/" + id + "> <http://ftn.uns.ac.rs/trademarks/status> \""+ status +"\" . " 
//				+ "}" 
//				+ "}";
//
//		return sparql;
//	}

}
