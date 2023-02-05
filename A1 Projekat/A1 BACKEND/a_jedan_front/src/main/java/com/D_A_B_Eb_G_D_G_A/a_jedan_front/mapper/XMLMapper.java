package com.D_A_B_Eb_G_D_G_A.a_jedan_front.mapper;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

@Component
public class XMLMapper {
	public <T> T unmarshall(Class genericClass, String text) throws JAXBException {
		text =text.replace("xmlns=\"https://www.D_A_B_F#_G_D_G_A.com\"", "").replace("x:", "");
		System.out.println("////[XMLMapper:unmarshall]////////////////////////////////////////////////////////////////////////");
		System.out.println(text);
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////");
		JAXBContext context = JAXBContext.newInstance(genericClass);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		T createdObject = (T) unmarshaller.unmarshal(new StringReader(text));
		return createdObject;
	}
	
	public <T> String marshall(Class genericClass,T objecToMarshall) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(genericClass);
		Marshaller marshaller = context.createMarshaller();
		StringWriter sw = new StringWriter();
		marshaller.marshal(objecToMarshall, sw);
		return sw.toString();
	}
}
