package com.xml.zig.zigbackapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;
import com.xml.zig.zigbackapp.dto.request.TrademarkTableDTO;
import com.xml.zig.zigbackapp.dto.request.trademark_save_dto.TrademarkSaveDTO;
import com.xml.zig.zigbackapp.fuseki.FusekiWriter;
import com.xml.zig.zigbackapp.jaxb.JaxB;
import com.xml.zig.zigbackapp.model.Institution;
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

	public boolean saveTrademark(TrademarkSaveDTO ts) {

		UUID uuid = UUID.randomUUID();
		
		Trademark tm = modelMapper.map(ts, Trademark.class);
		
		// url + "/" + uuid.toString();
		String full_url = uuid.toString();

		tm.setTrademark_id(full_url);

		tm.setInstitution(new Institution());

		try {
			FusekiWriter.saveRDF(tm.getTrademark_id(),"date", (new Date()).getTime()+"");
			FusekiWriter.saveRDF(tm.getTrademark_id(),"status","WAIT");
			FusekiWriter.saveRDF(tm.getTrademark_id(),"user", ts.getUsername());
			FusekiWriter.saveRDF(tm.getTrademark_id(),"type", ts.getTrademark_info().getTrademark_type()+"");
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
			
		}


		String trademark_text = "";
		try {
//			System.out.println("MARSAL");
			trademark_text = jaxB.marshall(Trademark.class, tm);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			tr.saveTrademark(trademark_text, uuid.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public boolean saveTrademark(TrademarkSaveDTO ts, String username) {

//		Trademark tm = jaxB.unmarshall(Trademark.class, trademark);

//		Optional<User> u = ur.findByJmbg(ins.getJmbg());

//		String username = u.get().getUsername();

//		String interXML = jaxB.marshall(Interesovanje.class, in);

//		System.out.println(in);

//		mex.extractMetadata(in);

//		FusekiWriter.saveRDF();

		UUID uuid = UUID.randomUUID();

		Trademark tm = modelMapper.map(ts, Trademark.class);

		String full_url = url + "/" + uuid.toString();

		tm.setTrademark_id(full_url);

//		GENERATE QRCODE FROM URL
//		tm.setQrCode(qrGenerator.getQRCodeAsByteArray(full_url));

//		tm.setApplicant(ts.getApplicant());

		String trademark_text = "";
		try {
			trademark_text = jaxB.marshall(Trademark.class, tm);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			tr.saveTrademark(trademark_text, username, uuid.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public Trademark loadTrademark(String username, String uuid) {

		String s = "";
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

	public List<TrademarkTableDTO> searchAllTrademarksFromUser(String text,String role) {

		List<Trademark> trademarks = new ArrayList<Trademark>();
		try {
			List<String> trademarksString = tr.searchAllTrademarksFromUser(text);
			
			trademarks = trademarksString.stream().map(

					trademarkString -> {
						try {
							return jaxB.unmarshall(Trademark.class, trademarkString);
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
		
		List<TrademarkTableDTO> lttdto = trademarks.stream()
				.map(e -> new TrademarkTableDTO(e.getTrademark_id(), "TRADEMARK")).collect(Collectors.toList());
		
		lttdto.stream().forEach(e -> e.setStatus(TreadmarkSearchService.getStatusForTrademark(e.getDocumentid())));
		if(role.equals("CITIZEN")) {
			List<TrademarkTableDTO> lttdto2 = lttdto.stream().filter(e-> e.getStatus().equals("ACCEPT")).collect(Collectors.toList());
			List<TrademarkTableDTO> lttdto_with_solutions = TreadmarkSearchService.getFullTrademarkSearchList(lttdto2);

			return lttdto_with_solutions;

		}
		
		List<TrademarkTableDTO> lttdto_with_solutions = TreadmarkSearchService.getFullTrademarkSearchList(lttdto);

		return lttdto_with_solutions;

		// TODO Auto-generated method stub
//		return lttdto;

	}

	public void loadAllDocTrademark(String uuid) {
		// TODO Auto-generated method stub
		String s = "";
		try {
			s = tr.loadTrademark(uuid);

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
		System.out.println(tm.getDocuments().size());
	}

	public List<String> loadAllDocumentImages(String uuid) {
		// TODO Auto-generated method stub
		String s = "";
		try {
			s = tr.loadTrademark(uuid);

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
//		System.out.println(tm.getDocuments().size());
		List<String> l = new ArrayList<String>();
		if(tm.getDocuments() != null) {
			l = tm.getDocuments().stream().map(d-> d.getDocument()).collect(Collectors.toList());
			
		}
		return l;
	}

}
