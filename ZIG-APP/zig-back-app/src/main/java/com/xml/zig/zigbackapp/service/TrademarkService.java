package com.xml.zig.zigbackapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;
import com.xml.zig.zigbackapp.dto.request.trademark_save_dto.TrademarkSaveDTO;
import com.xml.zig.zigbackapp.fuseki.FusekiWriter;
import com.xml.zig.zigbackapp.jaxb.JaxB;
import com.xml.zig.zigbackapp.model.Trademark;
import com.xml.zig.zigbackapp.qrcode.QRCodeGenerator;
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
	
	@Autowired
	private QRCodeGenerator qrGenerator;
	
	@Value("${trademark-url}")
	private String url;

	
	public boolean saveTrademark(TrademarkSaveDTO ts ){


		UUID uuid = UUID.randomUUID();
		
		Trademark tm = modelMapper.map(ts, Trademark.class);
		//url + "/" + uuid.toString();
		String full_url = uuid.toString();
		
		tm.setTrademark_id(full_url);
		
		try {
			
			FusekiWriter.saveRDF(tm.getTrademark_id(),"created", tm.getDate()+"");
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
			
		}
		
//		GENERATE QRCODE FROM URL
//		tm.setQrCode(qrGenerator.getQRCodeAsByteArray(full_url));
		
//		tm.setApplicant(ts.getApplicant());
		
		String trademark_text="";
		try {
			trademark_text = jaxB.marshall(Trademark.class, tm);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			tr.saveTrademark(trademark_text,uuid.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	public boolean saveTrademark(TrademarkSaveDTO ts , String username){

//		Trademark tm = jaxB.unmarshall(Trademark.class, trademark);

//		Optional<User> u = ur.findByJmbg(ins.getJmbg());

//		String username = u.get().getUsername();

//		String interXML = jaxB.marshall(Interesovanje.class, in);

//		System.out.println(in);

//		mex.extractMetadata(in);

//		FusekiWriter.saveRDF();

		UUID uuid = UUID.randomUUID();
		
		Trademark tm = modelMapper.map(ts, Trademark.class);
		
		String full_url = url + "/" +uuid.toString();
		
		tm.setTrademark_id(full_url);
		
//		GENERATE QRCODE FROM URL
//		tm.setQrCode(qrGenerator.getQRCodeAsByteArray(full_url));
		
//		tm.setApplicant(ts.getApplicant());
		
		String trademark_text="";
		try {
			trademark_text = jaxB.marshall(Trademark.class, tm);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			tr.saveTrademark(trademark_text, username,uuid.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

	public Trademark loadTrademark(String username, String uuid){

		String s="";
		try {
			s = tr.loadTrademarkWithUsername(username, uuid);
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

	public List<Trademark> searchAllTrademarksFromUser(String username, String text) {
		
		
		List<Trademark> trademarks = new ArrayList<Trademark>();
		try {
			List<String> trademarksString = tr.searchAllTrademarksFromUser(username,text);
			
			trademarks = trademarksString.stream().map(
					
					trademarkString -> {
						try {
							return jaxB.unmarshall(Trademark.class , trademarkString);
						} catch (JAXBException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}
					
					).collect(Collectors.toList());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return trademarks;
	}
	

}
