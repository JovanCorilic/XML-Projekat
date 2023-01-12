package com.xml.zig.zigbackapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xmldb.api.modules.XMLResource;

import com.xml.zig.zigbackapp.exist.EntityManager;
import com.xml.zig.zigbackapp.jaxb.JaxB;

@Component
public class SolutionRepository {
	@Autowired
	private JaxB jaxB;

	@Autowired
	private EntityManager entityManager;

	public void saveSolution(String text, String uuid) throws Exception {

		String collectionId = "/db/solution/";

		entityManager.storeFromText(collectionId, uuid, text);
	}

	public String loadSolution(String uuid) throws Exception {

//		System.out.println(uuid + "TEKST");

		String collectionId = "/db/solution";

		XMLResource res = entityManager.load(collectionId, uuid);

		String s = (String) res.getContent();

		return s;
	}

}
