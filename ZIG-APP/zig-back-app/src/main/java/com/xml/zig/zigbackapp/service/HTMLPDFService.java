package com.xml.zig.zigbackapp.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.zig.zigbackapp.repository.TrademarkRepository;
import com.xml.zig.zigbackapp.transformer.HTMLPDFTransformer;

@Service
public class HTMLPDFService {

	@Autowired
	private HTMLPDFTransformer transformer;

	@Autowired
	private TrademarkRepository tr;

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

}
