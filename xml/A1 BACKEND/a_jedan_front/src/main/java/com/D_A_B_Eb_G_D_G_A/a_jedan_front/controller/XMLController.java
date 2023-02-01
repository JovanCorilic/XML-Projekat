package com.D_A_B_Eb_G_D_G_A.a_jedan_front.controller;


import java.io.*;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.modules.XMLResource;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import com.D_A_B_Eb_G_D_G_A.a_jedan_front.fuseki.FusekiReader;
import com.D_A_B_Eb_G_D_G_A.a_jedan_front.dto.XMLDto;
import com.D_A_B_Eb_G_D_G_A.a_jedan_front.service.XMLService;

@RestController
@CrossOrigin
public class XMLController {

	private XMLService service;

	public XMLController(XMLService service) {
		super();
		this.service = service;
	}

	@PostMapping("/PrvaKontrolnaTacka")
	public ResponseEntity<XMLDto> getChangedXMLJaxB(@RequestBody XMLDto dto) throws Exception{
		System.out.println("////Obrada fajla [XMLController:getChangedXMLJaxB]////////////////////////////////////////////////");
		System.out.println(dto.getText());
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////");

		String response = service.XMLMapperTest(dto);

		System.out.println("////Povratna vrednost [XMLController:getChangedXMLJaxB]////////////////////////////////////////////////");
		System.out.println(response);
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////");

		File f = new File("./src/main/resources/izlaz/A-1 Izlaz.xml");
		FileWriter fw = new FileWriter(f, true);
		fw.write(response);
		fw.flush();
		fw.close();

		return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
	}

	@PostMapping("/novi-dokument")
	public ResponseEntity<Void> dodajNoviDokument(@RequestBody XMLDto dto) throws Exception{
		System.out.println("////Obrada fajla [XMLController:dodajNoviDokument]////////////////////////////////////////////////");
		System.out.println(dto.getText());
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////");

		service.saveFromString(dto.getText());

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/getAJedan/{broj_prijave}")
	public ResponseEntity<String> getAJedan(@PathVariable("broj_prijave") String broj_prijave) throws Exception{
		String s = service.getFromName(broj_prijave).getContent().toString();
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/getAllAJedan")
	public ResponseEntity<String> getAllAJedan() throws Exception {
		String odgovor = "<Fajlovi>";
		for (String sss:service.getAll()) {
			odgovor += "<Fajl>" + sss + "</Fajl>";
		}

		return new ResponseEntity<>(odgovor + "</Fajlovi>", HttpStatus.OK);
	}

	@GetMapping("/getAllAJedanXMLFilter/{znak}/{filter}")
	public ResponseEntity<String> getAllAJedanXMLFilter(@PathVariable("znak") String znak,@PathVariable("filter") String filter) throws Exception {
		String odgovor = "<Fajlovi>";

		String[] filteri = filter.split("\\|");

		ArrayList<String> upitnaslov = new ArrayList<>();
		ArrayList<String> upitnaslov1 = new ArrayList<>();
		ArrayList<String> upitnaslov2 = new ArrayList<>();

		ArrayList<String> upitsadrzaj = new ArrayList<>();
		ArrayList<String> upitsadrzaj1 = new ArrayList<>();
		ArrayList<String> upitsadrzaj2 = new ArrayList<>();
		ArrayList<String> upitsadrzaj3 = new ArrayList<>();
		ArrayList<String> upitdatum = new ArrayList<>();

		//naslovi 1 i 2
		for (String element:service.getAll()) {

			if((znak.charAt(0) == 'D' && (element.toLowerCase().contains(filteri[0].toLowerCase()) || filteri[0].equals("0PRAZAN0")) ) || (znak.charAt(0) == 'N' && ((!element.toLowerCase().contains(filteri[0].toLowerCase()) || filteri[0].equals("0PRAZAN0")) ))){
				upitnaslov.add(element);
			}//else{upitnaslov.add(element);}

			if((znak.charAt(2) == 'D' && (element.toLowerCase().contains(filteri[1].toLowerCase()) || filteri[1].equals("0PRAZAN0")) ) || (znak.charAt(2) == 'N' && ((!element.toLowerCase().contains(filteri[1].toLowerCase()) || filteri[1].equals("0PRAZAN0")) ))){
				upitnaslov1.add(element);
			}//else{upitnaslov1.add(element);}

			if((znak.charAt(4) == 'D' && (element.toLowerCase().contains(filteri[2].toLowerCase()) || filteri[2].equals("0PRAZAN0")) ) || (znak.charAt(4) == 'N' && ((!element.toLowerCase().contains(filteri[2].toLowerCase()) || filteri[2].equals("0PRAZAN0")) ))){
				upitnaslov2.add(element);
			}//else{upitnaslov2.add(element);}

			// sadrzaj

			if(service.filtriraj_xml(element, filteri[3].toLowerCase(), znak.charAt(5)) || filteri[3].equals("0PRAZAN0")){
				upitsadrzaj.add(element);
			}//else{upitsadrzaj.add(element);}

			if(service.filtriraj_xml(element, filteri[4].toLowerCase(), znak.charAt(7)) || filteri[4].equals("0PRAZAN0")){
				upitsadrzaj1.add(element);
			}//else{upitsadrzaj1.add(element);}

			if(service.filtriraj_xml(element, filteri[5].toLowerCase(), znak.charAt(9)) || filteri[5].equals("0PRAZAN0")){
				upitsadrzaj2.add(element);
			}//else{upitsadrzaj2.add(element);}

			if(service.filtriraj_xml(element, filteri[6].toLowerCase(), znak.charAt(11)) || filteri[6].equals("0PRAZAN0")){
				upitsadrzaj3.add(element);
			}//else{upitsadrzaj3.add(element);}
			//////// i ili V V V V V V V V V V V ///////////////////
			/*if(znak.charAt(6) == 'I'){
				upitsadrzaj.retainAll(upitsadrzaj1);
			}else {
				upitsadrzaj=service.presek(upitsadrzaj, upitsadrzaj1);
			}*/
			//////// i ili  /\ /\ /\ /\ /\ /\  ///////////////////
			try{
				if (service.filtriraj_xml_datum(element, filteri[7].toLowerCase(), filteri[8].toLowerCase())){
					upitdatum.add(element);
				}
			}catch (Exception e){
				upitdatum.add(element);
			}
		}

		//upitnaslov1.retainAll(upitnaslov2);// za i
		//upitnaslov=service.presek(upitnaslov, upitnaslov2);// za ili

		if(znak.charAt(1) == 'I'){
			upitnaslov=service.presek(upitnaslov, upitnaslov1);
		}else {
			upitnaslov=service.unija(upitnaslov, upitnaslov1);
		}

		if(znak.charAt(3) == 'I'){
			upitnaslov=service.presek(upitnaslov, upitnaslov2);
		}else {
			upitnaslov=service.unija(upitnaslov, upitnaslov2);
		}

		if(znak.charAt(6) == 'I'){
			upitsadrzaj=service.presek(upitsadrzaj, upitsadrzaj1);
		}else {
			upitsadrzaj=service.unija(upitsadrzaj, upitsadrzaj1);
		}

		if(znak.charAt(10) == 'I'){
			upitsadrzaj2=service.presek(upitsadrzaj2, upitsadrzaj3);
		}else {
			upitsadrzaj2=service.unija(upitsadrzaj2, upitsadrzaj3);
		}

		if(znak.charAt(8) == 'I'){
			upitsadrzaj=service.presek(upitsadrzaj2, upitsadrzaj);
		}else {
			upitsadrzaj=service.unija(upitsadrzaj2, upitsadrzaj);
		}

		upitnaslov=service.presek(upitnaslov, upitsadrzaj);
		upitnaslov=service.presek(upitnaslov, upitdatum);

		Set<String> set = new LinkedHashSet<>(upitnaslov);
		for (String sss:set) {
			odgovor += "<Fajl>" + sss + "</Fajl>";
		}

		return new ResponseEntity<>(odgovor + "</Fajlovi>", HttpStatus.OK);
	}

	@GetMapping("/getAllNeprihvacene")
	public ResponseEntity<String> getAllNeprihvacene() throws Exception {
		String odgovor = "<Fajlovi>";
		for (String sss:service.getAll()) {
			System.out.println(sss + " je " +  service.getStanje(sss));
			if(service.getStanje(sss).equals("N"))
				odgovor += "<Fajl>" + sss + "</Fajl>";
		}

		return new ResponseEntity<>(odgovor + "</Fajlovi>", HttpStatus.OK);
	}

	@GetMapping(value = "/sacuvajKaoPDF/{broj_prijave}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<byte[]>  sacuvajKaoPDF(@PathVariable("broj_prijave") String broj_prijave) throws Exception{
		String s = service.getFromName(broj_prijave).getContent().toString();
		String pdf = service.convertToPDF(s);

		File file = new File("./src/main/resources/izlaz/A-1 PDF Izlaz.pdf");
		byte[] contents = Files.readAllBytes(file.toPath());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);

		String filename = broj_prijave.toString() + ".pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		return new ResponseEntity<>(contents, headers, HttpStatus.OK);
	}

	@GetMapping(value = "/sacuvajKaoXHTML/{broj_prijave}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<byte[]> sacuvajKaoXHTML(@PathVariable("broj_prijave") String broj_prijave) throws Exception{
		String s = service.getFromName(broj_prijave).getContent().toString();
		String xhtml = service.convertToXHTML(s);

		File file = new File("./src/main/resources/izlaz/A-1 XHTML Izlaz.xhtml");
		byte[] contents = Files.readAllBytes(file.toPath());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XHTML_XML);

		String filename = broj_prijave.toString() + ".xhtml";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		return new ResponseEntity<>(contents, headers, HttpStatus.OK);
	}

	@GetMapping("fusekiSearch/{naslov}/{broj_prijave}")
	public ResponseEntity<String> searchFromRDF(@PathVariable("naslov") String naslov, @PathVariable("broj_prijave") String broj_prijave) throws IOException {
		System.out.println("Pretraga za naslov:" + naslov + " i broj_prijave: " + broj_prijave);
		ArrayList<String> result = service.searchByMetadata(naslov, broj_prijave);
		String output = "";
		for (String r : result) {
			output += "\n" + r;
		}
		System.out.println("OUTPUT: " + output);
		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	@GetMapping("/prihvati/{broj_prijave}")
	public ResponseEntity<String> Prihvati(@PathVariable("broj_prijave") String broj_prijave) throws Exception {
		try {
			service.postaviStanje(broj_prijave, "P");
			return new ResponseEntity<>("<Odgovor>Uspeh</Odgovor>", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>("<Odgovor>Doslo je do greske</Odgovor>", HttpStatus.OK);
		}
	}

	@GetMapping("/odbi/{broj_prijave}")
	public ResponseEntity<String> Odbi(@PathVariable("broj_prijave") String broj_prijave) throws Exception {
		try {
			service.postaviStanje(broj_prijave, "O");
			return new ResponseEntity<>("<Odgovor>Uspeh</Odgovor>", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>("<Odgovor>Doslo je do greske</Odgovor>", HttpStatus.OK);
		}
	}
}
