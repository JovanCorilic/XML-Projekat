package Patent.BackendPatent.service;

import Patent.BackendPatent.jaxb.JaxbParser;
import Patent.BackendPatent.jenafuseki.FusekiReader;
import Patent.BackendPatent.jenafuseki.FusekiWriter;
import Patent.BackendPatent.jenafuseki.MetadataExtractor;
import Patent.BackendPatent.model.resenjePatent.Resenje;
import Patent.BackendPatent.ostalo.KonverterDatum;
import Patent.BackendPatent.ostalo.ProveraResenje;
import Patent.BackendPatent.repository.ResenjeRepository;
import Patent.BackendPatent.xslt.PDFTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        if (ProveraResenje.DaLiJeDobroResenje(resenje))
            throw new Exception();
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
        if (ProveraResenje.DaLiJeDobroResenje(resenje))
            throw new Exception();
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

    public String[] getReferencuNaZahtev(String xml)throws Exception{
        Resenje resenje = jaxbParser.unmarshall(Resenje.class,xml);
        Map<String, String> params = new HashMap<>();
        params.put("brojPrijave", resenje.getReferencaNaZahtev());
        ArrayList<String>listaNatrag = FusekiReader.executeQueryPatent(params,"2");
        ArrayList<String>tempListaNatrag = new ArrayList<>();
        for (int i = 0;i<listaNatrag.size();i+=2){
            String[] tempLista = listaNatrag.get(i).split("/");
            tempListaNatrag.add(tempLista[tempLista.length-1]);

        }
        String[]natrag = new String[tempListaNatrag.size()];
        for (int i = 0;i<tempListaNatrag.size();i++)
            natrag[i] = tempListaNatrag.get(i);
        return natrag;
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

    public ByteArrayOutputStream downloadPDF(String temp1, String temp2) throws Exception {
        int brojPodnetihZahteva = 0;
        LocalDate pocetniDatum;
        LocalDate krajnjiDatum;
        try {
            pocetniDatum = KonverterDatum.konvertovanjeSamoDatumUDate(temp1);
            krajnjiDatum = KonverterDatum.konvertovanjeSamoDatumUDate(temp2);
        }catch (Exception e){
            return new ByteArrayOutputStream();
        }

        String sparqlQuery =
                "SELECT * FROM <http://localhost:8081/fuseki/Dataset/data/patentMetadata> where{\n" +
                        "    ?Dataset <http://www.ftn.uns.ac.rs/rdf/examples/predicate/priznatDatumPodnosenja> ?priznatDatumPodnosenja .\n" +
                        "}";

        ArrayList<String>listaPodnetihZahteva = FusekiReader.executeQuery(sparqlQuery);
        LocalDate localDatePodnetiZahtev;
        for (int i = 1;i<listaPodnetihZahteva.size();i+=2){
            try {
                localDatePodnetiZahtev = KonverterDatum.konvertovanjeSamoDatumUDate(listaPodnetihZahteva.get(i).split("\\^")[0].trim());
                if (pocetniDatum.isBefore(localDatePodnetiZahtev) && krajnjiDatum.isAfter(localDatePodnetiZahtev))
                    brojPodnetihZahteva++;
            }catch (Exception e) {
                //continue;
            }
        }

        int brojPrihvacenihZahteva = 0;
        int brojOdbijenihZahteva = 0;

        sparqlQuery =
                "SELECT * FROM <http://localhost:8081/fuseki/Dataset/data/resenjeMetadata> where{" +
                        " ?Dataset <http://www.ftn.uns.ac.rs/rdf/resenje/predicate/datumOdlukeOZahtevu> ?datumOdlukeOZahtevu ." +
                        "}";
        ArrayList<String>listaResenje = FusekiReader.executeQuery(sparqlQuery);
        LocalDate localDateOdlukaOZahtevu;
        for (int i = 0;i<listaResenje.size();i+=2){
            try {
                localDateOdlukaOZahtevu = KonverterDatum.konvertovanjeSamoDatumUDate(listaResenje.get(i+1).split("\\^")[0].trim());
                if (pocetniDatum.isBefore(localDateOdlukaOZahtevu) && krajnjiDatum.isAfter(localDateOdlukaOZahtevu)){
                    String[]tempLista = listaResenje.get(i).split("/");
                    String xml = resenjeRepository.findResenjeById(tempLista[tempLista.length-1]);
                    if (xml.contains("<sifra"))
                        brojPrihvacenihZahteva++;
                    else
                        brojOdbijenihZahteva++;
                }

            }catch (Exception e) {
                //continue;
            }
        }

        String izvestaj =
                "<izvestaj>\n" +
                        "    <datum_pocetka>"+temp1+"</datum_pocetka>\n" +
                        "    <datum_kraja>"+temp2+"</datum_kraja>\n" +
                        "    <broj_podnetih_prijava>"+brojPodnetihZahteva+"</broj_podnetih_prijava>\n" +
                        "    <broj_prihvacenih_zahteva>"+brojPrihvacenihZahteva+"</broj_prihvacenih_zahteva>\n" +
                        "    <broj_odbijenih_zahteva>"+brojOdbijenihZahteva+"</broj_odbijenih_zahteva>\n" +
                "</izvestaj>";

        izvestaj =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<?xml-stylesheet type=\"text/xsl\" href=\"src/main/resources/xslt/Izvestaj.xsl\"?>\n"
                +izvestaj;

        return PDFTransformer.generateAndDownloadPDFIzvestaj(izvestaj);
    }

}
