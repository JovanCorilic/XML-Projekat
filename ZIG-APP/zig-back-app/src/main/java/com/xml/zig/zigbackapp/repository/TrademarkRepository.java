package com.xml.zig.zigbackapp.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.List;

import org.apache.jena.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import com.xml.zig.zigbackapp.exist.EntityManager;
import com.xml.zig.zigbackapp.jaxb.JaxB;
import com.xml.zig.zigbackapp.model.Trademark;

@Component
public class TrademarkRepository {

	@Autowired
	private JaxB jaxB;

//	@Autowired
//	private UserService us;

	@Autowired
	private EntityManager entityManager;

	public void saveTrademark(String text,String uuid) throws Exception {

		String collectionId = "/db/trademark/" ;

		entityManager.storeFromText(collectionId, uuid, text);
	}
	
	public void saveTrademark(String text, String username,String uuid) throws Exception {

		String collectionId = "/db/trademark/" + username;

		entityManager.storeFromText(collectionId, uuid, text);
	}

	public String loadTrademarkWithUsername(String username, String uuid) throws Exception {

		String collectionId = "/db/trademark/" + username;

		XMLResource res = entityManager.load(collectionId, uuid);

		String s = (String) res.getContent();

		return s;
	}
	
	public String loadTrademark( String uuid) throws Exception {
		
//		System.out.println(uuid + "TEKST");
		
		String collectionId = "/db/trademark";

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

	public List<String> searchAllTrademarksFromUser(String username, String text) {
		
		String collectionId = "/db/trademark/" + username;

		String xpath = "//*[text() ='" + text + "']/ancestor::trademark";
		/*
		 * 
		 * //*[text() = '"+ text + "']"
			"/trademark[text()=" + text + "]"
		 * 
		 */
		
		System.out.println("XPATH IS " + xpath);
		
		int documentsNumber = 0;
		
		ResourceSet rs = null;
		
		List<String> trademarks = new ArrayList<String>();
		
		try {
			rs = entityManager.retrieve(collectionId,xpath);
			
			ResourceIterator ri = rs.getIterator();
			
			String trademark = "";
			
			while(ri.hasMoreResources()) {
			
				documentsNumber++;
				
				Resource rsr  = ri.nextResource();
				
				trademark += rsr.getContent().toString();
				
				if(rsr.getContent().toString().contains("</trademark>")) {
					
					trademarks.add(trademark);
					
					trademark = "";
					
					
				}
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		return trademarks;
	}

}
