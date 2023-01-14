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
			FusekiWriter.saveRDF("99aec977-de21-43e2-8b9d-2c132211e5b5", "type", "GuaranteeTrademark");
			FusekiWriter.saveRDF("99aec977-de21-43e2-8b9d-2c132211e5b5", "status", "ACCEPT");
			
			
			FusekiWriter.saveRDF("99aec977-de21-43e2-8b9d-2c132211e5b5", "ref", "32a423a7-0597-4bd5-bc30-dafdd0b4e4a4");
			
			
			//011552cd-6167-4515-a67f-db47e571639b
			FusekiWriter.saveRDF("011552cd-6167-4515-a67f-db47e571639b", "date", "1640991600000");
			FusekiWriter.saveRDF("011552cd-6167-4515-a67f-db47e571639b", "user", "apaci");
			FusekiWriter.saveRDF("011552cd-6167-4515-a67f-db47e571639b", "type", "IndividualTrademark");
			FusekiWriter.saveRDF("011552cd-6167-4515-a67f-db47e571639b", "status", "WAIT");
			
	
			//e9bd9721-3d4f-4d27-a05b-3d9e694ac00d
			FusekiWriter.saveRDF("e9bd9721-3d4f-4d27-a05b-3d9e694ac00d", "date", "1654380000000");
			FusekiWriter.saveRDF("e9bd9721-3d4f-4d27-a05b-3d9e694ac00d", "user", "pablo");
			FusekiWriter.saveRDF("e9bd9721-3d4f-4d27-a05b-3d9e694ac00d", "type", "IndividualTrademark");
			FusekiWriter.saveRDF("e9bd9721-3d4f-4d27-a05b-3d9e694ac00d", "status", "DECLINE");
			System.out.println("----------------------------------------------------");
			
//			MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getAllTriples());
//			MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getUserTriple("apaci",false));
//			MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getDateTriple(90000l,3665352820000l,false));
//			MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getDateTriple(90000l,1000000l,true));
//			MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getTypeTriple("Individual Trademark",false));
//			MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getStatusTriple("WAIT",false));
//			MyQueryExecutor.updateQuery(SparqlQueryConstants.deleteStatusWait("011552cd-6167-4515-a67f-db47e571639b"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
