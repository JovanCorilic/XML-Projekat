package com.xml.zig.zigbackapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.zig.zigbackapp.dto.request.trademark_save_dto.TrademarkSaveDTO;
import com.xml.zig.zigbackapp.jaxb.JaxB;
import com.xml.zig.zigbackapp.model.Trademark;
import com.xml.zig.zigbackapp.repository.TrademarkRepository;

;

@Service
public class TrademarkService {

	@Autowired
	private JaxB jaxB;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TrademarkRepository tr;

	public boolean saveTrademark(TrademarkSaveDTO ts , String username) {

//		Trademark tm = jaxB.unmarshall(Trademark.class, trademark);

//		Optional<User> u = ur.findByJmbg(ins.getJmbg());

//		String username = u.get().getUsername();

//		String interXML = jaxB.marshall(Interesovanje.class, in);

//		System.out.println(in);

//		mex.extractMetadata(in);

//		FusekiWriter.saveRDF();

		Trademark tm = modelMapper.map(ts, Trademark.class);
		
		
		
//		tm.setApplicant(ts.getApplicant());
		
		String trademark_text="";
		try {
			trademark_text = jaxB.marshall(Trademark.class, tm);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			tr.saveTrademark(trademark_text, username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

	public Trademark loadTrademark(String username, String uuid){

		String s="";
		try {
			s = tr.loadTrademark(username, uuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Trademark tm = null;
		try {
			tm = jaxB.unmarshall(Trademark.class, s);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tm;
		
	}

	public List<String> loadAllTrademarksFromUser(String username) {
		
		List<String> trademarks = new ArrayList<String>();
		try {
			trademarks = tr.loadAllTrademarksAsFilesNames(username);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return trademarks;
	}
	

}
