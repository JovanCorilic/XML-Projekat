package com.xml.zig.zigbackapp.fuseki;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FusekiInitializator {

//	@Autowired
//	private FusekiWriter fw;
	
	@PostConstruct
	public void initializeFuseki() {
		System.out.println("INITIALIZATION FUSEKI DATABASE");
		try {
			//99aec977-de21-43e2-8b9d-2c132211e5b5
			FusekiWriter.saveRDF("99aec977-de21-43e2-8b9d-2c132211e5b5", "date", "1665352800000");
			FusekiWriter.saveRDF("99aec977-de21-43e2-8b9d-2c132211e5b5", "user", "apaci");
			FusekiWriter.saveRDF("99aec977-de21-43e2-8b9d-2c132211e5b5", "type", "Guarantee Trademark");
			FusekiWriter.saveRDF("99aec977-de21-43e2-8b9d-2c132211e5b5", "status", "ACCEPT");
			
			//011552cd-6167-4515-a67f-db47e571639b
			FusekiWriter.saveRDF("011552cd-6167-4515-a67f-db47e571639b", "date", "1640991600000");
			FusekiWriter.saveRDF("011552cd-6167-4515-a67f-db47e571639b", "user", "apaci");
			FusekiWriter.saveRDF("011552cd-6167-4515-a67f-db47e571639b", "type", "Individual Trademark");
			FusekiWriter.saveRDF("011552cd-6167-4515-a67f-db47e571639b", "status", "WAIT");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
