package com.xml.users.usersapp.usersbackapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xmldb.api.modules.XMLResource;

import com.xml.users.usersapp.usersbackapp.exist.EntityManager;
import com.xml.users.usersapp.usersbackapp.jaxb.JaxB;

@Component
public class UserRepository {

	@Autowired
	private JaxB jaxB;

//	@Autowired
//	private UserService us;

	@Autowired
	private EntityManager entityManager;

	public void saveUser(String text, String username) throws Exception {

		String collectionId = "/db/users/";

		entityManager.storeFromText(collectionId, username, text);
	}

	public String loadUser(String username) throws Exception {

//		System.out.println(uuid + "TEKST");

		String collectionId = "/db/users/";

		XMLResource res = entityManager.load(collectionId, username);

		String s = (String) res.getContent();

		return s;
	}

}
