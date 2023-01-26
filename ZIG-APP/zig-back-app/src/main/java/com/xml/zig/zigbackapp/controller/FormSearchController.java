package com.xml.zig.zigbackapp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.zig.zigbackapp.dto.request.MetadataDTO;
import com.xml.zig.zigbackapp.dto.request.TrademarkTableDTO;
import com.xml.zig.zigbackapp.service.TreadmarkSearchService;

@RestController
@RequestMapping(
		value  = "/trademark/search",
		consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
)
public class FormSearchController {

	@Autowired
	private TreadmarkSearchService tss;
	
	@PostMapping(value = "metadata")
	public ResponseEntity<List<TrademarkTableDTO>> getAllDocumentsByMetadata(@RequestBody MetadataDTO metadata) {
		
		List<TrademarkTableDTO> trademarks = tss.getAllDocumentsByMetadata(metadata);
		
		
		return new ResponseEntity<List<TrademarkTableDTO>>(trademarks, HttpStatus.OK);
	}
	
}
