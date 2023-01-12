package com.xml.zig.zigbackapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.zig.zigbackapp.fuseki.MyQueryExecutor;
import com.xml.zig.zigbackapp.fuseki.SparqlQueryConstants;
import com.xml.zig.zigbackapp.repository.SolutionRepository;
import com.xml.zig.zigbackapp.repository.TrademarkRepository;
import com.xml.zig.zigbackapp.transformer.HTMLPDFTransformer;

@Service
public class HTMLPDFService {

	@Autowired
	private HTMLPDFTransformer transformer;

	@Autowired
	private TrademarkRepository tr;
	
	@Autowired
	private SolutionRepository sr;

	public String generateHtml(String xmlDocumentId) {

		try {
//			System.out.println("STIGO");
			String document = tr.loadTrademark(xmlDocumentId);

//			System.out.println("IZMEDJU");
			String html = transformer.generateHTML(document , HTMLPDFTransformer.XSL_FILE);

//			System.out.println("ZAVRSIO");

			return html;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String generatePDF(String xmlDocumentId) {

		try {
//			System.out.println("STIGO");
			String document = tr.loadTrademark(xmlDocumentId);

//			System.out.println("IZMEDJU");
//			String pdf = transformer.generatePDF(document);

//			System.out.println("ZAVRSIO");

//			return pdf;
			
			String pdf = transformer.generateHTML(document,HTMLPDFTransformer.XSL_FO_FILE);
			
			return pdf;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String generateJSON(String uuid) {
		MyQueryExecutor.trademarks_lst.clear();
		String result = "{ \n\"<" + uuid + ">\" : {";
		try {
			MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getAllMetadataForTrademark(uuid));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String m : MyQueryExecutor.trademarks_lst) {
			
			String part = m.split("::")[1].trim();
			
			String prefix = m.split("::")[0].trim();
			
			if(prefix.equals("p")) {
				result += "\t \"<" + part + ">\"";
			}else {
				result += ": " + part + ", \n";
			}
			
		}
		result += "} \n }";
		
		// TODO Auto-generated method stub
		return result;
	}

	public String generateRDF(String uuid) {
		
		MyQueryExecutor.trademarks_lst.clear();
		
		String result = "<http://ftn.uns.ac.rs/trademarks/" + uuid + ">\n";
		try {
			MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getAllMetadataForTrademark(uuid));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		for(String m : MyQueryExecutor.trademarks_lst) {
//			System.out.println("METADATA: " + m);
			String part = m.split("::")[1].trim();
			
			String prefix = m.split("::")[0].trim();
			
//			System.out.println("PART: " + part);
//			System.out.println("PREFIX: " + prefix);
			if(prefix.equals("p")) {
				result += "\t<" + part + ">\n";
			}else {
				result += "\t\t" + part + " ; \n";
			}

			
		}
		
		// TODO Auto-generated method stub
		return result;
	}

	public String generateSolutionHtml(String xmlDocumentId) {
		try {

			String document = sr.loadSolution(xmlDocumentId);

			String html = transformer.generateHTML(document , HTMLPDFTransformer.XSL_SOLUTION_FILE);

			return html;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String generateReportHtml(Long startdate , Long enddate) {
		try {
			MyQueryExecutor.trademarks_lst.clear();
			
			Set<String> accept = MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getDateAndStatusTriple("ACCEPT",startdate, enddate));
			
			Set<String> decline = MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getDateAndStatusTriple("DECLINE",startdate, enddate));
			
			Set<String> wait = MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getDateAndStatusTriple("WAIT",startdate, enddate));
			
			//"0"^^xsd:integer
			String acc = accept.iterator().next().split("\\^")[0].split("::")[1];
			
			String dec = decline.iterator().next().split("\\^")[0].split("::")[1];
			
			String wa = wait.iterator().next().split("\\^")[0].split("::")[1];
			
			String document = "<report><startdate>" + startdate + "</startdate><enddate>" + enddate + "</enddate>";
				
			document += "<accept>" + acc + "</accept>";
			
			document += "<decline>" + dec + "</decline>";
			
			document += "<wait>" + wa + "</wait>";
			
			
			document += "</report>";
			
			String html = transformer.generateHTML(document , HTMLPDFTransformer.XSL_REPORT_FILE);

			return html;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
