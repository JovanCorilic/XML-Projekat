package com.eadgbe.a_jedan.repository;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import com.eadgbe.a_jedan.tomcat.ExistManager;

@Repository
public class A1Repository {
	public String collectionId = "db/A1";
	
	@Autowired
	private ExistManager existManager;
	
	public void saveA1(String text) throws Exception {
		//long unixTime = Instant.now().getEpochSecond();
		existManager.storeFromText(collectionId, "A1-"+ "DrugaKonstolnaTacka", text);
		//existManager.storeFromText(collectionId, "A1-"+ Long.toString(unixTime), text);
	}
	
	public XMLResource getA1(String text) throws Exception {
		return existManager.load(collectionId, text);
		//existManager.storeFromText(collectionId, "A1-"+ Long.toString(unixTime), text);
	}

}
