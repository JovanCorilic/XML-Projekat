package com.D_A_B_Eb_G_D_G_A.a_jedan_front.service;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.D_A_B_Eb_G_D_G_A.a_jedan_front.fuseki.FusekiReader;
import com.D_A_B_Eb_G_D_G_A.a_jedan_front.fuseki.FusekiWriter;
import com.D_A_B_Eb_G_D_G_A.a_jedan_front.fuseki.MetadataExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import com.D_A_B_Eb_G_D_G_A.a_jedan_front.dto.XMLDto;
import com.D_A_B_Eb_G_D_G_A.a_jedan_front.mapper.XMLMapper;
import com.D_A_B_Eb_G_D_G_A.a_jedan_front.model.AJedan;
import com.D_A_B_Eb_G_D_G_A.a_jedan_front.model.Adresa;

import com.D_A_B_Eb_G_D_G_A.a_jedan_front.repository.A1Repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class XMLService {
	@Autowired
	private final XMLMapper XMLMapper;
	private final A1Repository a1Repository;
	private final MetadataExtractor metadataExtractor;

	public XMLService(XMLMapper XMLMapper, A1Repository a1Repository, MetadataExtractor metadataExtractor) {
		this.XMLMapper = XMLMapper;
		this.a1Repository = a1Repository;
		this.metadataExtractor = metadataExtractor;
	}


	public String XMLMapperTest(XMLDto dto) throws Exception {
		AJedan A1 = (AJedan) XMLMapper.unmarshall(AJedan.class, dto.getText());


		Adresa temp = A1.getJedan().getPodnosilac().getAdresa();
		temp.setUlica("Topolska");
		temp.setBroj("18");
		AJedan.Jedan temp1 = A1.getJedan();
		AJedan.Jedan.Podnosilac temp2 = temp1.getPodnosilac();
		temp2.setAdresa(temp);
		temp1.setPodnosilac(temp2);
		temp1.setTelefonskiBroj("035/0365-035-30");
		A1.setJedan(temp1);

		System.out.println(XMLMapper.marshall(AJedan.class, A1));

		return XMLMapper.marshall(AJedan.class, A1);
	}

	public void saveFromString(String text) throws Exception {
		a1Repository.saveA1(text);
		metadataExtractor.extractMetadata(text);
		System.out.println("saveFromString metadataExtractor : " + metadataExtractor.toString());
		FusekiWriter.saveRDF();
	}

	public String getStanje(String fajl) throws IOException {
		File ff = new File("./src/main/resources/izlaz/Stanje.txt");
		ArrayList<String> lista = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ff))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.substring(1).equals(fajl))
					return line.charAt(0)+"";
			}
		} catch (IOException ex) {
			System.out.format("I/O error: %s%n", ex);
		}
		return "N";
	}

	public void postaviStanje(String fajl, String stanje) throws Exception {
		File ff = new File("./src/main/resources/izlaz/Stanje.txt");
		ArrayList<String> lista = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ff))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if(!line.substring(1).equals(fajl))
					lista.add(line);
			}
		} catch (IOException ex) {
			System.out.format("I/O error: %s%n", ex);
		}
		lista.add(stanje+fajl);

		FileWriter myWriter = new FileWriter(ff);
		for (String ssss: lista) {
			myWriter.write(ssss+"\n");
		}
		myWriter.close();
	}

	public XMLResource getFromName(String text) throws Exception {
		return a1Repository.getA1(text);
	}

	public String[] getAll() throws Exception {
		return a1Repository.getAll();
	}


	public ArrayList<String> searchByMetadata(String naslov, String broj_prijave) throws IOException {
		Map<String, String> params = new HashMap<>();
		params.put("naslov", naslov);
		params.put("broj_prijave", broj_prijave);

		ArrayList<String> result = FusekiReader.executeQuery(params);
		return result;
	}


	public String convertToPDF(String s) throws JAXBException, FileNotFoundException, DocumentException {
		Document document = new Document();


		PdfWriter.getInstance(document, new FileOutputStream(new File("./src/main/resources/izlaz/A-1 PDF Izlaz.pdf")));
		if (!document.isOpen()) {
			document.open();
		}
		AJedan a1 = XMLMapper.unmarshall(AJedan.class, s);
		List<String> lista = getParagrafe(a1);
		for (String par : lista) {
			Paragraph pp = new Paragraph(par);
			document.add(pp);
		}
		document.close();

		return null;
	}


	public String convertToXHTML(String s) throws TransformerException, IOException {
		TransformerFactory tFactory=TransformerFactory.newInstance();

		Source xslDoc=new StreamSource("./src/main/resources/xsl/A-1.xsl");


		//temp file
		File a_temp = new File("./src/main/resources/temp.xml");
		a_temp.createNewFile();

		FileWriter myWriter = new FileWriter(a_temp);
		myWriter.write(s);
		myWriter.close();

		Source xmlDoc=new StreamSource("./src/main/resources/temp.xml");

		String outputFileName="A-1 XHTML Izlaz.xhtml";

		OutputStream htmlFile=new FileOutputStream(new File("./src/main/resources/izlaz/" + outputFileName));
		Transformer trasform=tFactory.newTransformer(xslDoc);
		trasform.transform(xmlDoc, new StreamResult(htmlFile));
		myWriter.close();



		File prepravi = new File("./src/main/resources/izlaz/A-1 XHTML Izlaz.xhtml");

		String text = new String(Files.readAllBytes(Paths.get(prepravi.getPath())), StandardCharsets.UTF_8);
		text = text.replace("<html>", "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html dir=\"rtl\" xmlns=\"http://www.w3.org/1999/xhtml\">");
		text = text.replace("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">", "");
		text = text.replace("<br>", "<br></br>");

		prepravi.createNewFile();

		FileWriter prepraviWriter = new FileWriter(prepravi);
		prepraviWriter.write(text);
		prepraviWriter.close();


		return null;
	}


	public List<String> getParagrafe(AJedan a1)	{
		List<String> paragrafi = new ArrayList<String>();

    	/*String s = "ЗАВОД ЗА ИНТЕЛЕКТУАЛНУ СВОЈИНУ                                             ОБРАЗАЦ А-1" + "\n"+
    	"Београд, Кнегиње Љубице 5" + "\n" + "\n" +
    	"\tЗАХТЕВ ЗА УНОШЕЊЕ У ЕВИДЕНЦИЈУ И ДЕПОНОВАЊЕ АУТОРСКИХ ДЕЛА";
    	paragrafi.add(s);


    	s = "Подносилац - име, презиме, адреса и држављанство аутора или другог носиоца ауторског права ако је подносилац физичко лице, односно пословно име и седиште носиоца ауторског права ако је подносилац правно лице*:" + "\n" + "\n" +
    	    	"Ime: " + autor.getIme() +
    	    	"Prezime: " + autor.getPrezime() +
    	    	"Adresa: " + autor.getAdresa().getGrad() + " / " + autor.getAdresa().getNaziv_ulice() + " " + autor.getAdresa().getBroj_ulice()
    			;
    	paragrafi.add(s);


    	s = "Псеудоним или знак аутора, (ако га има)" + "\n" + "\n" +
    	    	"Ime: " + autor.getIme() +
    	    	"Prezime: " + autor.getPrezime() +
    	    	"Adresa: " + autor.getAdresa().getGrad() + " / " + autor.getAdresa().getNaziv_ulice() + " " + autor.getAdresa().getBroj_ulice()
    			;
    	paragrafi.add(s);

    	s= "Псеудоним или знак аутора, (ако га има):" + "\n" + "\n";
    	try {
    		if(pseudonim != null && pseudonim != "") {
    			s += pseudonim;
    		}
    	}catch (Exception e) {
			s += "[NEMA]";
		}
    	paragrafi.add(s);

    	s= "Име, презиме и адреса пуномоћника, ако се пријава подноси преко пуномоћника:" + "\n" + "\n";
    	try {
    		if( false) {//!= null && pseudonim != "") {//TODO: Promeniti strukturu
    			s += "";
    		}
    	}catch (Exception e) {
			s += "[NEMA]";
		}
    	paragrafi.add(s);


    	s= "Наслов ауторског дела, односно алтернативни наслов, ако га има, по коме ауторско дело може да се идентификује" + "\n" + "\n";
    	s += "Naslov: " + naslov + "\n";
    	try {
    		if( alternativni_naslov!= null && alternativni_naslov != "") {
    			s += "Alternativni naslov: " + alternativni_naslov;
    		}
    	}catch (Exception e) {
			s += "";
		}
    	paragrafi.add(s);


    	s= "Подаци о наслову ауторског дела на коме се заснива дело прераде, ако је у питању ауторско дело прераде, као и податак о аутору изворног дела:" + "\n" + "\n";
    	try {
    		if( podaci_o_zasnivanju!= null && podaci_o_zasnivanju.getPodaci_o_naslovu() != "") {
    			s += "Podaci o naslov: " + podaci_o_zasnivanju.getPodaci_o_naslovu() + "\n";
    		}
    		if( podaci_o_zasnivanju!= null && podaci_o_zasnivanju.getPodaci_o_autoru().getIme() != "") {
    			s += "Podaci o Autoru: " + "\n";
    			s += "\tIme: " + podaci_o_zasnivanju.getPodaci_o_autoru().getIme() + "\n";
    			s += "\tPrezime: " + podaci_o_zasnivanju.getPodaci_o_autoru().getPrezime() + "\n";
    		}
    	}catch (Exception e) {
			s += "";
		}
    	paragrafi.add(s);

    	s = "Подаци о врсти ауторског дела (књижевно дело, музичко дело, ликовно дело, рачунарски програм и др.) *" + "\n" + "\n" +
    	    	"Crsta autorskog dela: " + vrsti_autorskog_dela;
    	paragrafi.add(s);

    	s = "Подаци о форми записа ауторског дела (штампани текст, оптички диск и слично) *:" + "\n" + "\n" +
    	    	"Forma zapisa autorskog dela: " + forma_zapisa_autorskog_dela;
    	paragrafi.add(s);


    	s = "Подаци о аутору ако подносилац пријаве из тачке 1. овог захтева није аутор и то: презиме, име, адреса и држављанство аутора (групе аутора или коаутора), а ако су у питању један или више аутора који нису живи, имена аутора и године смрти аутора а ако је у питању ауторско дело анонимног аутора навод да је ауторско дело дело анонимног аутора: " + "\n" + "\n" +
    			"Ime: " + autor.getIme() +
    	    	"Prezime: " + autor.getPrezime() +
    	    	"Adresa: " + autor.getAdresa().getGrad() + " / " + autor.getAdresa().getNaziv_ulice() + " " + autor.getAdresa().getBroj_ulice()
    			;
    	paragrafi.add(s);

    	s = "Прилози који се подносе уз захтев:" + "\n" + "\n" +
    			"Prilozi: " + podneti_prilozi_zahtev
    			;
    	paragrafi.add(s);



    	s = "\tПОПУЊАВА ЗАВОД" + "\n" +
    			"	Прилози уз пријаву:" + "\n" + "\n" +
    			"Prilozi: " + podneti_prilozi_zahtev+

    			"\n\n- опис ауторског дела (ако је дело поднето на оптичком диску);"+
    			"\n\n- пример ауторског дела (слика, видео запис, аудио запис);"+
    			"\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n";



    	s += "Broj Prijave \n A-"+broj_prijave + "\n"+
    		"Datum Podnosenja \n A-"+datum_podnosenja;

    	paragrafi.add(s);*/

		String s = "ZAVOD ZA INTELEKTUALNU SVOJINU                                             OBRAZAC A-1" + "\n"+
				"Beograd, Kneginje Ljubice 5" + "\n" + "\n" +
				"\t        ZAHTEV ZA UNOŠENjE U EVIDENCIJU I DEPONOVANjE AUTORSKIH DELA\n\n\n";
		paragrafi.add(s);


		s = "\n\n1) Podnosilac - ime, prezime, adresa i državljanstvo autora ili drugog nosioca autorskog prava ako je podnosilac fizičko lice, odnosno poslovno ime i sedište nosioca autorskog prava ako je podnosilac pravno lice*:" + "\n" +
				"\n   Ime: " + a1.getJedan().getPodnosilac().getIme() +
				"   Prezime: " + a1.getJedan().getPodnosilac().getPrezime() +
				"   Adresa: " + a1.getJedan().getPodnosilac().getAdresa().getGrad() + " , " + a1.getJedan().getPodnosilac().getAdresa().getUlica() + " " + a1.getJedan().getPodnosilac().getAdresa().getBroj()+
				"   Drzavljanstvo: " + a1.getJedan().getPodnosilac().getDrzavljanstvo()
				;
		paragrafi.add(s);

		s = "----------------------------------------------------------------------------------------------------------------------------\n"+
			"|          Telefon: " + a1.getJedan().getTelefonskiBroj() + "          |          E-mail: " + a1.getJedan().getEmail() + "          |\n"+
			"----------------------------------------------------------------------------------------------------------------------------";
		paragrafi.add(s);

		s= "\n\n" + "2) Pseudonim ili znak autora, (ako ga ima):" + "\n"+ "\n";
		try {
			if(a1.getDva().getPseudonim() != null && !Objects.equals(a1.getDva().getPseudonim(), "")) {
				s += "   Pseudonim: " + a1.getDva().getPseudonim();
			}
			else if(a1.getDva().getZnakAutora() != null && !Objects.equals(a1.getDva().getZnakAutora(), "")) {
				s += "   Znak Autora: " + a1.getDva().getZnakAutora();
			}
			else{
				s += "   [NEMA]";
			}
		}catch (Exception e) {
			s += "   [NEMA]";
		}
		paragrafi.add(s);

		s= "\n\n" + "3) Ime, prezime i adresa punomoćnika, ako se prijava podnosi preko punomoćnika:" + "\n"+ "\n";
		try {
			if( a1.getTri().getPunomocnik() != null) {
				s += "   Ime: " + a1.getTri().getPunomocnik().getIme();
				s += "\n   Prezime: " + a1.getTri().getPunomocnik().getPrezime();
				s += "\n   Adresa: " + a1.getTri().getPunomocnik().getAdresa().getGrad() + " , " + a1.getTri().getPunomocnik().getAdresa().getUlica() + " " + a1.getTri().getPunomocnik().getAdresa().getBroj();
			}
			else{
				s += "   [NEMA]";
			}
		}catch (Exception e) {
			s += "   [NEMA]";
		}
		paragrafi.add(s);


		s= "\n\n" + "4) Naslov autorskog dela, odnosno alternativni naslov, ako ga ima, po kome autorsko delo može da se identifikuje" + "\n"+ "\n";
		s += "   Naslov/i: \n      " + a1.getCetiri().getNaslov()  + "\n";
		try {
			if( a1.getCetiri().getAlternativniNaslov() != null && a1.getCetiri().getAlternativniNaslov() != "") {
				s += "   Alternativni naslov: " + a1.getCetiri().getAlternativniNaslov();
			}
		}catch (Exception e) {
			s += "";
		}
		paragrafi.add(s);


		s= "\n\n" + "5) Podaci o naslovu autorskog dela na kome se zasniva delo prerade, ako je u pitanju autorsko delo prerade, kao i podatak o autoru izvornog dela:" + "\n"+ "\n";
		try {
			if( a1.getPet().getAutorskoDeloPrerade().getPodaciOOriginalnomAutorskomDelu() != null && a1.getPet().getAutorskoDeloPrerade().getPodaciOOriginalnomAutorskomDelu() != "") {
				s += "   Podaci o naslov: " + a1.getPet().getAutorskoDeloPrerade().getPodaciOOriginalnomAutorskomDelu() + "\n";
			}
			if( a1.getPet().getAutorskoDeloPrerade().getImeAutora() != null && a1.getPet().getAutorskoDeloPrerade().getImeAutora() != "") {
				s += "   Ime i Prezime Autora: " + a1.getPet().getAutorskoDeloPrerade().getImeAutora();
			}
		}catch (Exception e) {
			s += "";
		}
		paragrafi.add(s);

		s = "\n\n" + "6) Podaci o vrsti autorskog dela (književno delo, muzičko delo, likovno delo, računarski program i dr.) *" + "\n"+ "\n" +
				"   Vrsta autorskog dela: " + a1.getSest().getPodaciOVrstiAutorskogDela();
		paragrafi.add(s);

		s = "\n\n" + "7) Podaci o formi zapisa autorskog dela (štampani tekst, optički disk i slično) *:" + "\n" + "\n"+
				"   Forma zapisa autorskog dela: " + a1.getSedam().getPodaciOFormiAutorskogZapisaDela();
		paragrafi.add(s);


		s = "\n\n" + "8) Podaci o autoru ako podnosilac prijave iz tačke 1. ovog zahteva nije autor i to: prezime, ime, adresa i državljanstvo autora (grupe autora ili koautora), a ako su u pitanju jedan ili više autora koji nisu živi, imena autora i godine smrti autora a ako je u pitanju autorsko delo anonimnog autora navod da je autorsko delo delo anonimnog autora: " + "\n" + "\n";
		try {
			for (AJedan.Osam.Podnosioci.ZiviPodnosioci.ZivPodnosilac ziv : a1.getOsam().getPodnosioci().getZiviPodnosioci().getZivPodnosilac()) {
				s += "   Ime i Prezime: " + ziv.getIme() + " " + ziv.getPrezime() +
						"\n   Adresa: " + ziv.getAdresa().getGrad() + " / " + ziv.getAdresa().getUlica() + " " + ziv.getAdresa().getBroj() +
						"\n   Drzavljanstvo: " + ziv.getDrzavljanstvo() + "\n\n";
			}
		}catch (Exception e){}

		try {
			for (AJedan.Osam.Podnosioci.MrtviPodnosioci.MrtavPodnosilac mrtav : a1.getOsam().getPodnosioci().getMrtviPodnosioci().getMrtavPodnosilac()) {
				s += "   Ime i Prezime: " + mrtav.getIme() + " " + mrtav.getPrezime() +
						"\n   Godina Smrti: " + mrtav.getGodinaSmrti() + "\n\n";
			}
		}catch (Exception e){}

		try {
			for (AJedan.Osam.Podnosioci.AnonimniPodnosioci.AnonimanPodnosilac anoniman : a1.getOsam().getPodnosioci().getAnonimniPodnosioci().getAnonimanPodnosilac()) {
				s += "   Ime i Prezime: ******* *************  [Autor je Anoniman]" +
						"\n   Delo Anonimnog Autora: " + anoniman.getDeloAnonimnogAutora() + "\n\n";
			}
		}catch (Exception e){}

		if(s.equals("\n\n8) Podaci o autoru ako podnosilac prijave iz tačke 1. ovog zahteva nije autor i to: prezime, ime, adresa i državljanstvo autora (grupe autora ili koautora), a ako su u pitanju jedan ili više autora koji nisu živi, imena autora i godine smrti autora a ako je u pitanju autorsko delo anonimnog autora navod da je autorsko delo delo anonimnog autora: \n\n"))
			s += "   [NEMA]";

		paragrafi.add(s);


		s = "\n\n" + "9) Podatak da li je u pitanju autorsko delo stvoreno u radnom odnosu: " + a1.getDevet().getDaLiJeAutorskoDeloStvorenoURadnomOdnosu();
		paragrafi.add(s);

		s = "\n\n" + "10) Način korišćenja autorskog dela ili nameravani način korišćenja autorskog dela:" + "\n"+ "\n";
		try {
			if(a1.getDeset().getNacinKoriscenjaAutorskogDela() != null && !Objects.equals(a1.getDeset().getNacinKoriscenjaAutorskogDela(), "")) {
				s += "   Nacin Koriscenja Autorskog Dela: " + a1.getDeset().getNacinKoriscenjaAutorskogDela();
			}
			else if(a1.getDeset().getNameravaniNacinKoriscenjaAutorskogDela() != null && !Objects.equals(a1.getDeset().getNameravaniNacinKoriscenjaAutorskogDela(), "")) {
				s += "   Nameravani Nacin Koriscenja Autorskog Dela: " + a1.getDeset().getNameravaniNacinKoriscenjaAutorskogDela();
			}
			else{
				s += "   [NEMA]";
			}
		}catch (Exception e) {
			s += "   [NEMA]";
		}
		paragrafi.add(s);


		s = "\n\n11)\n" +
				"                                                                             " + a1.getJedanaest().getPotpis() + "\n" +
				"                                                                             " + "_________________________________\n" +
				"                                                                             " + "       Podnosilac prijave, nosilac prava\n" +
				"                                                                             " + "(mesto za potpis fizičkog lica, odnosno potpis\n" +
				"                                                                             " + "zastupnika pravnog lica ili ovlašćenog predstavnika\n" +
				"                                                                             " + "u pravnom licu)*";

		paragrafi.add(s);

		s = "\n\n12) Prilozi koji se podnose uz zahtev:\n\n" + a1.getDvanaest().getPriloziUzZahtev();
		paragrafi.add(s);



		s = "\n\n" + "Prilozi koji se podnose uz zahtev:" + "\n"+ "\n" +
				"   Prilozi: \n" + a1.getOpisAutorskogDela();
		;
		paragrafi.add(s);



		s ="\n\n" +  "\t                                                               POPUNjAVA ZAVOD" + "\n\n\n" +
				"	Prilozi uz prijavu:" + "\n" +

				"\n\n- opis autorskog dela (ako je delo podneto na optičkom disku);\n"+ a1.getOpisAutorskogDela() +
				"\n\n- primer autorskog dela (slika, video zapis, audio zapis);"+
				"\n" + "\n" + "\n" + "\n" + "\n" + "\n"+ "\n"+ "\n" ;



		s += "                                                           " +"                                                           " + "Broj Prijave:\n"+
				"                                                           " +"                                                           " + "A-" + a1.getBrojPrijace() + "\n"+
				"                                                           " +"                                                           " + "Datum Podnosenja:\n"+
				"                                                           " +"                                                           " + a1.getDatumPodnosenja();

		paragrafi.add(s);
		return paragrafi;
        /*return "ClassPojo [podneti_prilozi_zahtev = "+podneti_prilozi_zahtev+", datum_podnosenja = "+datum_podnosenja+
        		", podaci_o_zasnivanju = "+podaci_o_zasnivanju+", forma_zapisa_autorskog_dela = "+forma_zapisa_autorskog_dela+
        		", vrsti_autorskog_dela = "+vrsti_autorskog_dela+", broj_prijave = "+broj_prijave+", autor = "+autor
        		+", nacin_koriscenja_autorskog_dela = "+nacin_koriscenja_autorskog_dela+", naslov = "+naslov+
        		", da_li_je_delo_stvoreno_u_radnom_odnosu = "+da_li_je_delo_stvoreno_u_radnom_odnosu+
        		", telefon = "+telefon+", adresa = "+adresa+", obrazac = "+obrazac+", podnosioci = "
        		+podnosioci+", nosilac_prijave = "+nosilac_prijave+", zavod_za_intelektualnu_svoinu = "
        		+zavod_za_intelektualnu_svoinu+", podnosilac_firma = "+podnosilac_firma+", pseudonim = "
        		+pseudonim+", alternativni_naslov = "+alternativni_naslov+", email = "+email+"]";*/
	}

	private static String convertStringArrayToString(String[] strArr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr)
			sb.append(str).append(delimiter);
		return sb.substring(0, sb.length() - 1);
	}









	public boolean filtriraj_xml(String dokument, String filter, char znak) {
		try {
			String sadrzaj = getFromName(dokument).getContent().toString().toLowerCase();


			return ((znak == 'D' && sadrzaj.contains(filter.toLowerCase())) ||
					(znak == 'N' && (!sadrzaj.contains(filter.toLowerCase()))));


			}catch (Exception e){
			return true;
		}

	}

	public boolean filtriraj_xml_datum(String dokument, String datum1, String datum2) {
		try {
			String sadrzaj = getFromName(dokument).getContent().toString();

			String[] datumi = sadrzaj.split("</x:Datum_Podnosenja>")[0].split(">");
			String datum = datumi[datumi.length-1];

			String datumVeci = datum2;
			String datumManji = datum1;
			if(veci_datum(datum1, datum2)){
				datumVeci = datum1;
				datumManji = datum2;
			}

			return veci_datum(datum, datumManji) && veci_datum(datumVeci, datum);

		}catch (Exception e){
			return true;
		}

	}

	public ArrayList<String> unija(ArrayList<String> a, ArrayList<String> b) {
		a.addAll(b);
		return a;
	}

	public ArrayList<String> presek(ArrayList<String> a, ArrayList<String> b) {
		a.retainAll(b);
		return a;
	}

	public ArrayList<String> ekskluzivno(ArrayList<String> a, ArrayList<String> b) {
		ArrayList<String> isti = new ArrayList<>(a);
		isti.retainAll(b);
		a.addAll(b);
		a.removeAll(isti);
		return a;
	}

	public boolean veci_datum(String datum1, String datum2) {

		String[] datum1s = datum1.split("\\.");
		String[] datum2s = datum2.split("\\.");

		if( Integer.parseInt(datum1s[2]) == Integer.parseInt(datum2s[2])){
			if(Integer.parseInt(datum1s[1]) == Integer.parseInt(datum2s[1])){
				return  Integer.parseInt(datum1s[0]) > Integer.parseInt(datum2s[0]);
			}else {
				return  Integer.parseInt(datum1s[1]) > Integer.parseInt(datum2s[1]);
			}
		}else{
			return  Integer.parseInt(datum1s[2]) > Integer.parseInt(datum2s[2]);
		}

	}





























}
