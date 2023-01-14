package com.xml.zig.zigbackapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.xml.zig.zigbackapp.dto.request.MetadataDTO;
import com.xml.zig.zigbackapp.dto.request.TrademarkTableDTO;
import com.xml.zig.zigbackapp.fuseki.MyQueryExecutor;
import com.xml.zig.zigbackapp.fuseki.SparqlQueryConstants;

@Service
public class TreadmarkSearchService {

	public void getAllDocumentsByText() {

	}

	public List<TrademarkTableDTO> getAllDocumentsByMetadata(MetadataDTO md) {

		Set<String> documents = new HashSet<String>();

		// ROLE CITIZEN
		Set<String> status = new HashSet<String>();

		Set<String> username = new HashSet<String>();

		Set<String> type = new HashSet<String>();

		Set<String> date = new HashSet<String>();

		try {

			status = MyQueryExecutor
					.executeAllQuery(SparqlQueryConstants.getStatusTriple(md.getStatus(), md.getStatusnot()));

			System.out.println("STATUS SIZE: "+status.size());
			username = MyQueryExecutor
					.executeAllQuery(SparqlQueryConstants.getUserTriple(md.getUsrname(), md.getUsernamenot()));

			type = MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getTypeTriple(md.getTypa(), md.getTypenot()));

			date = MyQueryExecutor.executeAllQuery(
					SparqlQueryConstants.getDateTriple(md.getDatestart(), md.getDateend(), md.getDatenot()));

			if (md.getFirstop() && !md.getUsrname().equals("") && !md.getTypa().equals("")) {
				username.retainAll(type);
			} else {
				username.addAll(type);
			}
			if (md.getSecondop() && !md.getUsrname().equals("") && !md.getDatestart().equals(0)) {
				username.retainAll(date);
			} else {
				username.addAll(date);
			}
			if (md.getThirdop() && !md.getUsrname().equals("") && !md.getStatus().equals("")) {
				username.retainAll(status);
			} else {
				username.addAll(status);
			}

			if (md.getRole().equals("CITIZEN")) {
				status = MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getStatusTriple("ACCEPT", false));
				username.retainAll(status);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		documents = username.stream().map(e -> e.split("::")[1].trim()).collect(Collectors.toSet());

		List<TrademarkTableDTO> lttdto = documents.stream()
				.map(e -> new TrademarkTableDTO(e.split("/")[e.split("/").length - 1], "TRADEMARK"))
				.collect(Collectors.toList());

		lttdto.stream().forEach(e -> e.setStatus(getStatusForTrademark(e.getDocumentid())));

		List<TrademarkTableDTO> lttdto_with_solutions = getFullTrademarkSearchList(lttdto);

		return lttdto_with_solutions;

	}

	public static List<TrademarkTableDTO> getFullTrademarkSearchList(List<TrademarkTableDTO> lttdto) {
		List<TrademarkTableDTO> lttdto_with_solutions = new ArrayList<TrademarkTableDTO>();

		for (TrademarkTableDTO l : lttdto) {
			lttdto_with_solutions.add(l);
			try {
				Set<String> solution = MyQueryExecutor
						.executeAllQuery(SparqlQueryConstants.getSolutionForTrademark(l.getDocumentid()));
				if(solution.size() == 0) {
					System.out.println("USO");
					continue;
				}
				String sl = solution.iterator().next().split("::")[1].trim();
				TrademarkTableDTO ttdto = new TrademarkTableDTO();
				ttdto.setDocumentid(sl);
				ttdto.setDocumenttype("SOLUTION");
				ttdto.setStatus("NONE");
				lttdto_with_solutions.add(ttdto);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return lttdto_with_solutions;
	}

	public static String getStatusForTrademark(String uuid) {
		String st = "";
		try {
			Set<String> status = MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getStatusForTrademark(uuid));
			st = status.iterator().next().split("::")[1].trim();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	public Set<String> getAllDocumentsByMetadataCitizen(MetadataDTO md) {
		Set<String> documents = new HashSet<String>();

		try {
			Set<String> data = MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getStatusTriple("ACCEPT", false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documents;

	}

	public Set<String> getAllDocumentsByMetadataEmployee(MetadataDTO md) {
		Set<String> documents = new HashSet<String>();

		try {
			MyQueryExecutor.executeAllQuery(SparqlQueryConstants.getUserTriple("apaci", false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return documents;

	}

}
