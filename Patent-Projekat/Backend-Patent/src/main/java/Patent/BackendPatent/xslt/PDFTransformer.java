package Patent.BackendPatent.xslt;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.apache.jena.base.Sys;
import org.xml.sax.SAXException;

/**
 * 
 * Primer demonstrira koriscenje iText PDF programskog API-a za 
 * renderovanje PDF-a na osnovu XML dokumenta. Alternativa Apache FOP-u.
 *
 */
public class PDFTransformer {
	
	private static DocumentBuilderFactory documentFactory;
	
	private static TransformerFactory transformerFactory;
	
	//public static final String INPUT_FILE = "data/xslt/test.xml";
	
	public static final String XSL_FILE = "src/main/resources/xslt/P-1.xsl";

	public static final String XSL_FILE_IZVESTAJ = "src/main/resources/xslt/Izvestaj.xsl";
	
	public static final String HTML_FILE = "src/main/resources/gen/Test.html";
	
	public static final String OUTPUT_FILE = "src/main/resources/gen/Test.pdf";

	static {

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
     * @param filePath
     * @throws IOException
     * @throws DocumentException
     */
    public void generatePDF(String filePath) throws IOException, DocumentException {
        
    	// Step 1
    	Document document = new Document();
        
    	// Step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
        
        // Step 3
        document.open();
        
        // Step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(HTML_FILE));
        
        // Step 5
        document.close();
        
    }

	public static ByteArrayOutputStream generateAndDownloadPDFIzvestaj(String xml)throws Exception{
		try {

			// Initialize Transformer instance
			PDFTransformer pdfTransformer = new PDFTransformer();
			StreamSource transformSource = new StreamSource(new File(XSL_FILE_IZVESTAJ));
			Transformer transformer = transformerFactory.newTransformer(transformSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			// Generate XHTML
			transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

			// Transform DOM to HTML
			DOMSource source = new DOMSource(pdfTransformer.buildDocumentFromString(xml));

			StreamResult result = new StreamResult(new ByteArrayOutputStream());

			transformer.transform(source, result);

			String html = result.getOutputStream().toString();

			Document document = new Document();
			ByteArrayOutputStream temp = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, temp);

			document.open();
			byte[]temp2 = html.getBytes(StandardCharsets.UTF_8);
			XMLWorkerHelper.getInstance().parseXHtml(writer,document,new ByteArrayInputStream(temp2));
			document.close();

			return temp;

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return null;
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
			return null;
		} catch (TransformerException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ByteArrayOutputStream generateAndDownloadPDF(String html)throws Exception{

		Document document = new Document();
		ByteArrayOutputStream temp = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, temp);

		document.open();
		byte[]temp2 = html.getBytes(StandardCharsets.UTF_8);
		XMLWorkerHelper.getInstance().parseXHtml(writer,document,new ByteArrayInputStream(temp2));
		document.close();
		//String string = new String(temp.toByteArray(), StandardCharsets.UTF_16LE);

		/*Writer fstream = null;
		BufferedWriter out = null;

		fstream = new OutputStreamWriter(new FileOutputStream(new File(OUTPUT_FILE)), StandardCharsets.UTF_16LE);
		fstream.write(string);*/
		return temp;
	}

	public org.w3c.dom.Document buildDocumentFromString(String xml) throws ParserConfigurationException, IOException, SAXException {

		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		org.w3c.dom.Document document = db.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));

		if (document != null)
			System.out.println("[INFO] File parsed with no errors.");
		else
			System.out.println("[WARN] Document is null.");

		return document;
	}
    
    public void generateHTML(String xml, String xslPath) throws IOException, ParserConfigurationException, SAXException {
    	
		try {

			// Initialize Transformer instance
			StreamSource transformSource = new StreamSource(new File(xslPath));
			Transformer transformer = transformerFactory.newTransformer(transformSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			// Generate XHTML
			transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

			// Transform DOM to HTML
			DOMSource source = new DOMSource(buildDocumentFromString(xml));
			StreamResult result = new StreamResult(new FileOutputStream(HTML_FILE));
			transformer.transform(source, result);
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
    
    }

	public static String generateAndDownloadHTML(String xml) throws  Exception{
		try {
			xml = xml.replace("xmlns=\"http://www.ftn.uns.rs/P-1\"","");
			// Initialize Transformer instance
			PDFTransformer pdfTransformer = new PDFTransformer();
			StreamSource transformSource = new StreamSource(new File(XSL_FILE));
			Transformer transformer = transformerFactory.newTransformer(transformSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			// Generate XHTML
			transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

			// Transform DOM to HTML
			DOMSource source = new DOMSource(pdfTransformer.buildDocumentFromString(xml));

			StreamResult result = new StreamResult(new ByteArrayOutputStream());

			transformer.transform(source, result);

			return result.getOutputStream().toString();

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return null;
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
			return null;
		} catch (TransformerException e) {
			e.printStackTrace();
			return null;
		}
	}
    
    public static void generate(String xml) throws IOException, DocumentException, ParserConfigurationException, SAXException {

    	System.out.println("[INFO] " + PDFTransformer.class.getSimpleName());
		xml = xml.replace("xmlns=\"http://www.ftn.uns.rs/P-1\"","");
    	// Creates parent directory if necessary
    	File pdfFile = new File(OUTPUT_FILE);

		if (!pdfFile.getParentFile().exists()) {
			System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
			pdfFile.getParentFile().mkdir();
		}

		PDFTransformer pdfTransformer = new PDFTransformer();

		pdfTransformer.generateHTML(xml, XSL_FILE);
		pdfTransformer.generatePDF(OUTPUT_FILE);

		System.out.println("[INFO] File \"" + OUTPUT_FILE + "\" generated successfully.");
		System.out.println("[INFO] End.");
    }
    
}
