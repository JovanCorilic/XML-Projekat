package com.xml.zig.zigbackapp.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.xml.zig.zigbackapp.service.HTMLPDFService;


@RestController
@RequestMapping(value = "all/document")
public class HTMLPDFController {

	
	@Autowired
	private HTMLPDFService service;

	@GetMapping(value = "/html/{xmlDocumentId}", produces = { "text/html;charset=UTF-8" })
	public ResponseEntity<String> getTrademarkHtml(HttpServletResponse response,
			@PathVariable("xmlDocumentId") String xmlDocumentId) {
//		System.out.println("CONTROLLER " + xmlDocumentId);
		String xml = service.generateHtml(xmlDocumentId);
//		System.out.println(xml);
//		System.out.println(xml);

		
		ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes());

		response.setContentType("application/html");
//		response.setHeader("Content-Disposition", "attachment; filename=file.html");
//		try {
//			IOUtils.copy(inputStream, response.getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return new ResponseEntity<String>(xml, HttpStatus.OK);
	}

//	@GetMapping(value = "/pdf/{xmlDocumentId}" , produces = { "application/pdf;charset=UTF-8" })
	@GetMapping(value = "/pdf/{xmlDocumentId}")
	public void getTrademarkPDF(HttpServletResponse response, @PathVariable("xmlDocumentId") String xmlDocumentId) {
//		System.out.println("CONTROLLER " + xmlDocumentId);

//		String html = service.generateHtml(xmlDocumentId);
		String html = service.generatePDF(xmlDocumentId);

		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		renderer.createPDF(outputStream, false);
		renderer.finishPDF();
		
//		try {
//			renderer.getFontResolver().addFont("src/main/resources/fonts/CYRIL1.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//			System.out.println("UCITAO FONT");
//		} catch (DocumentException | IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		// octet-stream
		response.setContentType("application/pdf");
		
//		response.setHeader("Content-Disposition", "attachment; filename=file.pdf");
		try {
			IOUtils.copy(inputStream, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(myPdf.toString());

//		String url = new File(inputFile).toURI().toURL().toString();

//        System.out.println(pdf);

//		System.out.println(xml);
//		return new ResponseEntity<String>(pdf,HttpStatus.OK);
	}
	
	

}
