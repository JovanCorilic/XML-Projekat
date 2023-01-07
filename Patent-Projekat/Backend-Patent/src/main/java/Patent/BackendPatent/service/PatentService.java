package Patent.BackendPatent.service;

import Patent.BackendPatent.jaxb.JaxbParser;
import Patent.BackendPatent.jenafuseki.FusekiReader;
import Patent.BackendPatent.jenafuseki.FusekiWriter;
import Patent.BackendPatent.jenafuseki.MetadataExtractor;
import Patent.BackendPatent.model.P1;
import Patent.BackendPatent.repository.PatentRepository;
import Patent.BackendPatent.xslt.PDFTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PatentService {
    @Autowired
    private PatentRepository patentRepository;

    private  JaxbParser jaxbParser;
    private  MetadataExtractor metadataExtractor;

    public PatentService(JaxbParser jaxbParser, MetadataExtractor metadataExtractor) {
        this.jaxbParser = jaxbParser;
        this.metadataExtractor = metadataExtractor;
    }

    public void addPatentFromText(String text)throws Exception{
        P1 p1 = jaxbParser.unmarshall(P1.class,text);
        String docId = p1.getNazivPronalaska().getSrpskiNaziv().getValue();
        patentRepository.savePatentFromText(text,docId);
        metadataExtractor.extractMetadataPatent(text);
        FusekiWriter.saveRDFPatent();
    }

    public String getPatentXMLDocument(String docId) throws Exception{
        return patentRepository.findPatentById(docId);
    }

    public String[] getAll()throws Exception{
        return patentRepository.getAll();
    }

    public ArrayList<String> searchByMetadata(String odluka, String opcija) throws IOException {
        Map<String, String> params = new HashMap<>();
        if (opcija.equals("3"))
            params.put("EngleskiNaziv",odluka);
        else if(opcija.equals("2"))
            params.put("BrojPrijave",odluka);
        else
            params.put("SrpskiNaziv",odluka);

        return FusekiReader.executeQueryPatent(params,opcija);
    }

    public String[] searchByTextContent(String odluka) throws Exception {
        String[] lista = patentRepository.getAll();
        //String [] novaLista = new String[0];
        ArrayList<String> novaLista = new ArrayList<>();
        for(String i : lista){
            String temp = patentRepository.findPatentById(i);
            if(temp.contains(odluka))
                novaLista.add(i);
        }
        String[] temp = new String[novaLista.size()];
        for (int i =0;i<novaLista.size();i++)
            temp[i]=novaLista.get(i);

        return temp;
    }

    public String downloadRDF(String id) throws Exception {
        String text = patentRepository.findPatentById(id);
        metadataExtractor.extractMetadataPatent(text);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/rdf/rdfPatentOutput.rdf"));
        String rezultat="";
        String temp;
        while ((temp=bufferedReader.readLine())!=null){
            rezultat=rezultat+temp + "\n";
        }

        return rezultat;
    }

    public void generateXHTMLandPDF(String id) throws Exception {
        String xml = patentRepository.findPatentById(id);
        PDFTransformer.generate(xml);
    }
}
