package com.eadgbe.a_jedan.service;


import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eadgbe.a_jedan.dto.XMLDto;
import com.eadgbe.a_jedan.mapper.XMLMapper;
import com.eadgbe.a_jedan.model.A1;
import com.eadgbe.a_jedan.model.Adresa;

@Service
public class XMLService {
	@Autowired
	private final XMLMapper XMLMapper;

	public XMLService(XMLMapper XMLMapper) {
		this.XMLMapper = XMLMapper;
	}
/*
	public String playWithXML(XMLDto dto) throws Exception {
		Document document = domParser.buildDocumentFromText(dto.getText());
		NodeList profesori = document.getElementsByTagName("profesor");

		for (int i = 0; i < profesori.getLength(); i++) {
			Element profesor = (Element) profesori.item(i);
			profesor.setAttribute("id", "prof" + i);

			Element titula = document.createElement("Titila");
			titula.appendChild(document.createTextNode("Profesor"));
			profesor.appendChild(titula);
		}

		return domParser.getDocumentAsString(document);

	}
*/

	public String XMLMapperTest(XMLDto dto) throws Exception {
		A1 A1 = (A1) XMLMapper.unmarshall(A1.class, dto.getText());
		Adresa temp = A1.getAdresa();
		temp.setNaziv_ulice("Topolska");
		temp.setBroj_ulice("18");
		A1.setAdresa(temp);
		A1.setTelefon("035/0365-035-30");
		System.out.println(A1.toString());
		
		return XMLMapper.marshall(A1.class, A1);
	}

}
