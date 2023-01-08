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
import java.util.Arrays;
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
        String docId = dajMiID();
        p1.setId(docId);
        text=jaxbParser.marshallString(P1.class,p1);
        patentRepository.savePatentFromText(text,docId);
        metadataExtractor.extractMetadataPatent(text);
        FusekiWriter.saveRDFPatent();
    }

    public void editPatentFromText(String text)throws Exception{
        P1 p1 = jaxbParser.unmarshall(P1.class,text);
        String id = p1.getId();
        patentRepository.savePatentFromText(text,id);
        metadataExtractor.extractMetadataPatent(text);
        FusekiWriter.saveRDFPatent();
    }

    public String getPatentXMLDocument(String docId) throws Exception{
        return patentRepository.findPatentById(docId);
    }

    public String getPatentBySrpskiNaziv(String naziv)throws Exception{
        return patentRepository.findPatentByNaziv("<srpski_naziv property=\"pred:nazivPatentaSrpski\" datatype=\"xs:string\">"+naziv+"</srpski_naziv>");
    }

    public String getPatentByEngleskiNaziv(String naziv)throws Exception{
        return patentRepository.findPatentByNaziv("<engleski_naziv property=\"pred:nazivPatentaEngleski\" datatype=\"xs:string\">"+naziv+"</engleski_naziv>");
    }

    public String[] getAll()throws Exception{
        return patentRepository.getAllSrpskeNazive();
    }

    public void deleteByNaziv(String naziv)throws Exception{
        if(!patentRepository.deleteByNaziv(naziv))
            throw new Exception();
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
        //String text = patentRepository.findPatentById(id);
        String xml = FindNaziv(id);
        metadataExtractor.extractMetadataPatent(xml);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/rdf/rdfPatentOutput.rdf"));
        String rezultat="";
        String temp;
        while ((temp=bufferedReader.readLine())!=null){
            rezultat=rezultat+temp + "\n";
        }

        return rezultat;
    }

    public void generateXHTMLandPDF(String id) throws Exception {
        String xml = FindNaziv(id);
        PDFTransformer.generate(xml);
    }

    public String FindNaziv(String id) throws Exception {
        String xml = getPatentBySrpskiNaziv(id);
        if (xml.equals("")) {
            xml = getPatentByEngleskiNaziv(id);
            if (xml.equals("")) {
                throw new Exception();
            }
        }
        return xml;
    }

    public String dajMiID() throws Exception {
        String[]lista = patentRepository.getAll();
        int max = -1;
        for (String temp : lista){
            if (max<Integer.parseInt(temp))
                max=Integer.parseInt(temp);
        }
        String text;
        for (int i = 0;i<max;i++){
            text = ""+i;
            if(!Arrays.asList(lista).contains(text))
                return text;
        }
        return ""+(max+1);
    }
}
