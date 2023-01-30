package Patent.BackendPatent.service;

import Patent.BackendPatent.jaxb.JaxbParser;
import Patent.BackendPatent.jenafuseki.FusekiReader;
import Patent.BackendPatent.jenafuseki.FusekiWriter;
import Patent.BackendPatent.jenafuseki.MetadataExtractor;
import Patent.BackendPatent.model.resenjePatent.Resenje;
import Patent.BackendPatent.repository.ResenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ResenjeService {

    @Autowired
    private ResenjeRepository resenjeRepository;

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ResenjeService(JaxbParser jaxbParser, MetadataExtractor metadataExtractor) {
        this.jaxbParser = jaxbParser;
        this.metadataExtractor = metadataExtractor;
    }

    //Operacije dodavanja i edit -----------------------------------------------------------------------

    public void addResenjeFromText(String text)throws Exception{
        text = text.replaceAll("xml:space='preserve'","");
        Resenje resenje = jaxbParser.unmarshall(Resenje.class,text);
        String docId ;
        try{
            docId = dajMiID();
        }
        catch(Exception e){
            docId = "0";
        }
        resenje.setId(docId);
        resenje.getDatumOdlukeOZahtevu().setAbout(resenje.getDatumOdlukeOZahtevu().getAbout()+"/"+docId);

        resenje.getSluzbenik().setAbout(resenje.getSluzbenik().getAbout()+"/"+docId);
        text=jaxbParser.marshallStringResenje(Resenje.class,resenje);
        resenjeRepository.saveResenjeFromText(text,docId);
        FusekiWriter.saveRDFResenjeFromString(metadataExtractor.extractMetadataPatentInString(text));
    }

    public void editResenjeFromText(String text)throws Exception{
        text = text.replaceAll("xml:space='preserve'","");
        Resenje resenje = jaxbParser.unmarshall(Resenje.class,text);
        String id = resenje.getId();
        resenjeRepository.saveResenjeFromText(text,id);
        FusekiWriter.saveRDFResenjeFromString(metadataExtractor.extractMetadataPatentInString(text));
    }

    public String dajMiID() throws Exception {
        String[]lista = resenjeRepository.getAll();
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

    public String getResenjeXMLDocument(String docId) throws Exception{
        return resenjeRepository.findResenjeById(docId);
    }

    public String[] getAll()throws Exception{
        return resenjeRepository.getAll();
    }

    public String getOznakeResenja(String id)throws Exception{
        String xml = resenjeRepository.findResenjeById(id);
        Resenje resenje = jaxbParser.unmarshall(Resenje.class,xml);
        String natrag = "";

        natrag +="Datum kada je napravljeno resenje : "+resenje.getDatumOdlukeOZahtevu().getValue()+
                " | Broj prijave zahteva: "+resenje.getReferencaNaZahtev();
        return natrag;
    }

    public String[] searchByTextContent(String odluka) throws Exception {
        String[] lista = resenjeRepository.getAll();
        //String [] novaLista = new String[0];
        ArrayList<String> novaLista = new ArrayList<>();
        for(String i : lista){
            String temp = resenjeRepository.findResenjeById(i);
            if(temp.contains(odluka))
                novaLista.add(i);
        }
        String[] temp = new String[novaLista.size()];
        for (int i =0;i<novaLista.size();i++)
            temp[i]=novaLista.get(i);

        return temp;
    }

    public ArrayList<String> searchByMetadata(String odluka, String opcija) throws IOException {
        return FusekiReader.executeQueryResenje(odluka,opcija);
    }

    public ByteArrayOutputStream downloadPDF(String pocetniDatum, String krajnjiDatum){
        return new ByteArrayOutputStream();
    }

}
