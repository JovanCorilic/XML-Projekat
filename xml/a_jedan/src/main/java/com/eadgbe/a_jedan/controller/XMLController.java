package com.eadgbe.a_jedan.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eadgbe.a_jedan.dto.XMLDto;
import com.eadgbe.a_jedan.service.XMLService;

@RestController
@RequestMapping(value = "api/xml", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
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
}
