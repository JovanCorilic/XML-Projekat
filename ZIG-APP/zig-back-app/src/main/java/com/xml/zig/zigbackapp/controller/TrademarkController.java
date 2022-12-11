package com.xml.zig.zigbackapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.zig.zigbackapp.dto.request.trademark_save_dto.TrademarkSaveDTO;
import com.xml.zig.zigbackapp.model.Trademark;
import com.xml.zig.zigbackapp.service.TrademarkService;

@RestController
@RequestMapping(
		value  = "/trademark",
		consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
)
public class TrademarkController {

	@Autowired
	private TrademarkService ts;
	
	@GetMapping(value = "bol")
	public boolean getBol(){
		
		return true;
	}
	
	@PostMapping(value = "save/{username}")
	public boolean saveTrademark(@PathVariable("username") String username,@RequestBody TrademarkSaveDTO trademarkSaveDTO) {
		
		boolean answer = ts.saveTrademark(trademarkSaveDTO, username);
		
		return true;
	}
	
	@GetMapping(value = "get/{username}/{uuid}")
	public ResponseEntity<Trademark> getTrademark(@PathVariable("username") String username,@PathVariable("uuid") String uuid) {
		
		Trademark trademark = ts.loadTrademark(username, uuid);
		
		return new ResponseEntity<Trademark>(trademark, HttpStatus.OK);
	}
	
	@GetMapping(value = "get/{username}")
	public ResponseEntity<List<String>> getAllTrademarksFromUser(@PathVariable("username") String username) {
		
		List<String> trademarks = ts.loadAllTrademarksFromUser(username);
		
		return new ResponseEntity<List<String>>(trademarks, HttpStatus.OK);
	}
}
