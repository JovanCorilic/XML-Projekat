package com.xml.zig.zigbackapp.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xmldb.api.modules.XMLResource;

import com.xml.zig.zigbackapp.exist.EntityManager;
import com.xml.zig.zigbackapp.jaxb.JaxB;


@Component
public class TrademarkRepository {

	@Autowired
	private JaxB jaxB;

//	@Autowired
//	private UserService us;

	@Autowired
	private EntityManager entityManager;

	public void saveTrademark(String text, String username) throws Exception {

		String collectionId = "/db/trademark/" + username;

		UUID uuid = UUID.randomUUID();

		entityManager.storeFromText(collectionId, uuid.toString(), text);
	}

	public String loadTrademark(String username, String uuid) throws Exception {

		String collectionId = "/db/trademark/" + username;

		XMLResource res = entityManager.load(collectionId, uuid);

		String s = (String) res.getContent();

		return s;
	}

	public List<String> loadAllTrademarksAsFilesNames(String username) throws Exception {

		String collectionId = "/db/trademark/" + username;
		
		System.out.println(collectionId);
		
		String[] cols = entityManager.loadAllSubCollections(collectionId);
		
		System.out.println(cols.length);
		
		List<String> cols_list = Arrays.asList(cols);
		
		return cols_list;
	}

}
