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

import java.io.*;
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

    //Operacije vezane za pravljenje i edit xml -----------------------------------------------------

    public void addPatentFromText(String text)throws Exception{
        text = text.replaceAll("xml:space='preserve'","");
        P1 p1 = jaxbParser.unmarshall(P1.class,text);
        String docId ;
        try{
            docId = dajMiID();
        }
        catch(Exception e){
            docId = "0";
        }
        p1.setId(docId);
        p1.getPopunjavaZavod().setAbout(p1.getPopunjavaZavod().getAbout()+"/"+docId);

        p1.getNazivPronalaska().setAbout(p1.getNazivPronalaska().getAbout()+"/"+docId);

        text=jaxbParser.marshallString(P1.class,p1);
        patentRepository.savePatentFromText(text,docId);
        //metadataExtractor.extractMetadataPatent(text);
        //FusekiWriter.saveRDFPatent();
        FusekiWriter.saveRDFPatentFromString(metadataExtractor.extractMetadataPatentInString(text));
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

    public void editPatentFromText(String text)throws Exception{
        text = text.replaceAll("xml:space='preserve'","");
        P1 p1 = jaxbParser.unmarshall(P1.class,text);
        String id = p1.getId();
        patentRepository.savePatentFromText(text,id);
        //metadataExtractor.extractMetadataPatent(text);
        //FusekiWriter.saveRDFPatent();
        FusekiWriter.saveRDFPatentFromString(metadataExtractor.extractMetadataPatentInString(text));
    }

    //Operacije vezane za dobijanje xml dokumenta ---------------------------------------------

    public String getPatentXMLDocument(String docId) throws Exception{
        return patentRepository.findPatentById(docId);
    }

    public String getPatentBySrpskiNaziv(String naziv)throws Exception{
        return patentRepository.findPatentByNaziv("<srpski_naziv property=\"pred:nazivPatentaSrpski\" datatype=\"xs:string\">"+naziv+"</srpski_naziv>");
    }

    public String getPatentByEngleskiNaziv(String naziv)throws Exception{
        return patentRepository.findPatentByNaziv("<engleski_naziv property=\"pred:nazivPatentaEngleski\" datatype=\"xs:string\">"+naziv+"</engleski_naziv>");
    }

    //Operacije za dobijanje liste xml-ova -----------------------------------------------------------

    public String[] getAll()throws Exception{
        String[]SviPatenti = patentRepository.getAll();
        ArrayList<String>lista = new ArrayList<>();
        for (String temp : SviPatenti){
            if (!patentRepository.findPatentById(temp).contains("<broj_prijave property=\"pred:brojPrijave\" datatype=\"xs:string\"/>"))
                lista.add(temp);
        }
        String[]lista2 = new String[lista.size()];
        for (int i = 0;i<lista.size();i++){
            lista2[i]=lista.get(i);
        }
        return lista2;
    }

    public String[] getAllNijeProsaoZavod()throws Exception {
        String[] SviPatenti = patentRepository.getAll();
        ArrayList<String> lista = new ArrayList<>();
        for (String temp : SviPatenti) {
            if (patentRepository.findPatentById(temp).contains("<broj_prijave property=\"pred:brojPrijave\" datatype=\"xs:string\"/>"))
                lista.add(temp);
        }
        String[] lista2 = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            lista2[i] = lista.get(i);
        }
        return lista2;
    }

    //Operacije za pretragu xml i metapodataka ----------------------------------------------------------

    public ArrayList<String> searchByMetadata(String odluka, String opcija) throws IOException {
        Map<String, String> params = new HashMap<>();
        if (opcija.equals("3"))
            params.put("nazivPatentaEngleski",odluka);
        else if(opcija.equals("2"))
            params.put("brojPrijave",odluka);
        else
            params.put("nazivPatentaSrpski",odluka);

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

    //Download html,pdf,... --------------------------------------------------------------------------

    public String downloadRDF(String id) throws Exception {
        return metadataExtractor.extractMetadataPatentInString(patentRepository.findPatentById(id));
    }

    public String downloadHTML(String id)throws Exception{
        return PDFTransformer.generateAndDownloadHTML(patentRepository.findPatentById(id));
    }

    public ByteArrayOutputStream downloadPDF(String id)throws Exception{
        return PDFTransformer.generateAndDownloadPDF(PDFTransformer.generateAndDownloadHTML(patentRepository.findPatentById(id)));
    }

    public String downloadJSON(String id)throws Exception{
        P1 p1 = jaxbParser.unmarshall(P1.class,patentRepository.findPatentById(id));
        String temp = "[\n" +
                "\t{\n" +
                "\t\t\"@id\": \""+p1.getNazivPronalaska().getAbout()+"\",\n" +
                "\t\t\"http://www.ftn.uns.ac.rs/rdf/examples/predicate/brojPrijave\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"@type\": \"string\",\n" +
                "\t\t\t\t\"@value\": \""+p1.getPopunjavaZavod().getBrojPrijave().getValue()+"\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"http://www.ftn.uns.ac.rs/rdf/examples/predicate/nazivPatentaEngleski\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"@type\": \"string\",\n" +
                "\t\t\t\t\"@value\": \""+p1.getNazivPronalaska().getEngleskiNaziv().getValue()+"\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"http://www.ftn.uns.ac.rs/rdf/examples/predicate/nazivPatentaSrpski\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"@type\": \"string\",\n" +
                "\t\t\t\t\"@value\": \""+p1.getNazivPronalaska().getSrpskiNaziv().getValue()+"\"\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "]";
        return temp;
    }

    //---------------------------------------------------------------------------------------------

    public String getOznakePatenta(String id)throws Exception{
        String xml = patentRepository.findPatentById(id);
        P1 p1 = jaxbParser.unmarshall(P1.class,xml);
        String natrag = "";
        natrag +="Broj prijave : "+p1.getPopunjavaZavod().getBrojPrijave().getValue()+
                " | Srpski naziv: "+p1.getNazivPronalaska().getSrpskiNaziv().getValue()+
                " | Engleski naziv: "+p1.getNazivPronalaska().getEngleskiNaziv().getValue();
        return natrag;
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

    public void deleteByNaziv(String naziv)throws Exception{
        if(!patentRepository.deleteByNaziv(naziv))
            throw new Exception();
    }

    public void generateXHTMLandPDF(String id) throws Exception {
        String xml = FindNaziv(id);
        PDFTransformer.generate(xml);
    }

}
