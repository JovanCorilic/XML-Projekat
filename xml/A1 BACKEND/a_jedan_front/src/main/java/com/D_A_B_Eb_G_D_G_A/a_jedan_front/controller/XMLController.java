package com.D_A_B_Eb_G_D_G_A.a_jedan_front.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.modules.XMLResource;

import java.io.IOException;
import java.util.ArrayList;

import com.D_A_B_Eb_G_D_G_A.a_jedan_front.fuseki.FusekiReader;
import com.D_A_B_Eb_G_D_G_A.a_jedan_front.dto.XMLDto;
import com.D_A_B_Eb_G_D_G_A.a_jedan_front.service.XMLService;

@RestController
@RequestMapping(value = "api/xml", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
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

	@GetMapping("/sacuvajKaoPDF/{broj_prijave}")
	public ResponseEntity<String> sacuvajKaoPDF(@PathVariable("broj_prijave") String broj_prijave) throws Exception{
		String s = service.getFromName(broj_prijave).getContent().toString();
		String pdf = service.convertToPDF(s);
		return new ResponseEntity<>(pdf, HttpStatus.OK);
	}

	@GetMapping("/sacuvajKaoXHTML/{broj_prijave}")
	public ResponseEntity<String> sacuvajKaoXHTML(@PathVariable("broj_prijave") String broj_prijave) throws Exception{
		String s = service.getFromName(broj_prijave).getContent().toString();
		String xhtml = service.convertToXHTML(s);
		return new ResponseEntity<>(xhtml, HttpStatus.OK);
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
}
