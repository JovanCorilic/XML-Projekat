package com.xml.zig.zigbackapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.zig.zigbackapp.dto.request.SolutionDTO;
import com.xml.zig.zigbackapp.dto.request.trademark_save_dto.TrademarkSaveDTO;
import com.xml.zig.zigbackapp.service.SolutionService;
import com.xml.zig.zigbackapp.service.TrademarkService;

@RestController
@RequestMapping(
		value  = "/trademark/solution",
		consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
)
public class SolutionController {

	@Autowired
	private SolutionService ss;
	
	@PostMapping(value = "save")
	public boolean saveSolution(@RequestBody SolutionDTO ssdto) {
		
		boolean answer = ss.saveSolution(ssdto);
		
		return true;
	}
}
