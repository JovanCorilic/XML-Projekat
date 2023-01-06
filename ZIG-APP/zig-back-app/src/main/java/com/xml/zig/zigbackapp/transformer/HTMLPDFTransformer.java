package com.xml.zig.zigbackapp.transformer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@Component
public class HTMLPDFTransformer {

	private static DocumentBuilderFactory documentFactory;

	private static TransformerFactory transformerFactory;
	
	public static final String XSL_FILE = "src/main/resources/data/xslt/trademark.xsl";
	


	public HTMLPDFTransformer() {

		/* Inicijalizacija DOM fabrike */
		documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);
		documentFactory.setIgnoringElementContentWhitespace(true);

		/* Inicijalizacija Transformer fabrike */
		transformerFactory = TransformerFactory.newInstance();

	}

	/**
	 * Creates a PDF using iText Java API
	 * 
	 * @param filePath
	 * @throws IOException
	 * @throws DocumentException
	 */
//	public String generatePDF(String file) throws IOException, DocumentException {
//		
//		
//		System.out.println("PRE");
//		// Step 1
//		Document document = new Document();
//
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		
//		// Step 2
//		PdfWriter writer = PdfWriter.getInstance(document, baos);
//		
//		// Step 3
//		document.open();
//		
//		// Step 4
//		
//		//InputStream targetStream = new ByteArrayInputStream(file.getBytes());
//		
//		InputStream is = new ByteArrayInputStream(this.generateHTMLForPDF(file).getBytes());
//		
//		XMLWorkerHelper.getInstance().parseXHtml(writer, document, is ,Charset.forName("UTF-8"));
//		
//		System.out.println("POSLEzz");
//		
//		document.close();
//		
//		System.out.println("PDSPDS");
//		
//		writer.close();
//		System.out.println("POSLE333");
//		
//		
//		
////		RETURN PDF AS STRING
//		String text = new String( baos.toByteArray(), StandardCharsets.UTF_8 );
//		System.out.println("POSLE2");
//		
//		
////		System.out.println(text);
//		
//		return text;
//
//	}

//	public org.w3c.dom.Document buildDocument(String filePath) {
//
//		org.w3c.dom.Document document = null;
//		try {
//
//			DocumentBuilder builder = documentFactory.newDocumentBuilder();
//			document = builder.parse(new File(filePath));
//
//			if (document != null)
//				System.out.println("[INFO] File parsed with no errors.");
//			else
//				System.out.println("[WARN] Document is null.");
//
//		} catch (Exception e) {
//			return null;
//
//		}
//
//		return document;
//	}
	
	

	public String generateHTML(String xml) throws IOException {

		try {
			
//			System.out.println(xml);
			
			StreamSource xmlSources = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
			
			
			StreamSource xslSource = new StreamSource(Paths.get(XSL_FILE).toAbsolutePath().toFile());
			
			
			Transformer transformer = transformerFactory.newTransformer(xslSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			// Generate XHTML
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");

			// Transform DOM to HTML
//			DOMSource source = new DOMSource(buildDocument(xml));
			StreamResult result = new StreamResult();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			result.setOutputStream(baos);
			
		
			
			
			transformer.transform(xmlSources, result);
			
		
			
			String text = new String( baos.toByteArray(), StandardCharsets.UTF_8 );
//			baos.toString(text);
			
//			System.out.println(text);
			return text;
			
			
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}

