package com.xml.zig.zigbackapp.service;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.zig.zigbackapp.dto.request.SolutionDTO;
import com.xml.zig.zigbackapp.dto.request.trademark_save_dto.TrademarkSaveDTO;
import com.xml.zig.zigbackapp.fuseki.FusekiWriter;
import com.xml.zig.zigbackapp.fuseki.MyQueryExecutor;
import com.xml.zig.zigbackapp.fuseki.SparqlQueryConstants;
import com.xml.zig.zigbackapp.jaxb.JaxB;
import com.xml.zig.zigbackapp.model.Institution;
import com.xml.zig.zigbackapp.model.Solution;
import com.xml.zig.zigbackapp.model.Trademark;
import com.xml.zig.zigbackapp.repository.SolutionRepository;
import com.xml.zig.zigbackapp.repository.TrademarkRepository;

@Service
public class SolutionService {
	
	@Autowired
	private JaxB jaxB;
	
	@Autowired
	private SolutionRepository sr;
	
	@Autowired
	private TrademarkRepository tr;
	
	@Autowired
	private ModelMapper mm;
	
	public boolean saveSolution(SolutionDTO sdto ){


		UUID uuid = UUID.randomUUID();
		
		String tm = "";
		try {
			tm = tr.loadTrademark(sdto.getTrademark_id());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Trademark trm = new Trademark();
		
		
		try {
			trm = jaxB.unmarshall(Trademark.class, tm);
			Institution i = mm.map( sdto.getInstitution(),Institution.class);
			
			trm.setInstitution(i);
			trm.setDate(sdto.getDate());
			trm.setTrademark_number(sdto.getTrademark_number());
			
			String trdm = jaxB.marshall(Trademark.class,trm );
			tr.saveTrademark(trdm, trm.getTrademark_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Solution s =new Solution(uuid.toString() , new Date().getTime() ,trm.getTrademark_number() , sdto.getUsername() , sdto.getTrademark_id(),sdto.getDescription() );
		
		try {
			
			FusekiWriter.saveRDF(s.getTrademark_id(),"ref", s.getId());
			MyQueryExecutor.updateQuery(SparqlQueryConstants.deleteStatusWait(s.getTrademark_id()));
			MyQueryExecutor.updateQuery(SparqlQueryConstants.deleteStatusAccept(s.getTrademark_id()));
			MyQueryExecutor.updateQuery(SparqlQueryConstants.deleteStatusDecline(s.getTrademark_id()));
			
			if(sdto.getStatus().equals("ACCEPT")) {
				
				FusekiWriter.saveRDF(s.getTrademark_id(),"status","ACCEPT");
			}else {
				FusekiWriter.saveRDF(s.getTrademark_id(),"status","DECLINE");
			}
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
			
		}
		
		String solution_text="";
		try {
			solution_text = jaxB.marshall(Solution.class, s);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			sr.saveSolution(solution_text,uuid.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	
}
