package com.D_A_B_Eb_G_D_G_A.a_jedan_front.repository;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import com.D_A_B_Eb_G_D_G_A.a_jedan_front.tomcat.ExistManager;

@Repository
public class A1Repository {
	public String collectionId = "db/A1";
	
	@Autowired
	private ExistManager existManager;
	
	public String saveA1(String text) throws Exception {
		//long unixTime = Instant.now().getEpochSecond();
		String naslovi[] = text.split("</x:Naslov>")[0].split(">");
		String datumi[] = text.split("</x:Datum_Podnosenja>")[0].split(">");
		String ime = "A1-"+ ocistiNaziv(naslovi[naslovi.length-1]) + "-" + ocistiNaziv(datumi[datumi.length-1]);
		existManager.storeFromText(collectionId, ime, text);
		return ime;
		//existManager.storeFromText(collectionId, "A1-"+ unixTime), text);
	}

	public void UpdateA1(String text, String naziv) throws Exception {

		existManager.update(0, collectionId, naziv, null,null);
		//existManager.storeFromText(collectionId, "A1-"+ unixTime), text);
	}

	public static String ocistiNaziv(String ulaz){
		String ss = ulaz.replace(" ", "-").replace("/", "-").replace("%","")
				.replace("?","").replace("=","").replace("<","").replace(">","");
		return (!(ss.trim().equals(""))) ? ss : "Neimenovani-Dokument-" + Long.toString(Instant.now().getEpochSecond());
	}
	
	public XMLResource getA1(String text) throws Exception {
		return existManager.load(collectionId, text);
		//existManager.storeFromText(collectionId, "A1-"+ Long.toString(unixTime), text);
	}

	public String[] getAll() throws Exception {
		return existManager.getAllA1(collectionId);
		//existManager.storeFromText(collectionId, "A1-"+ Long.toString(unixTime), text);
	}

}
