package Patent.BackendPatent.ostalo;

import Patent.BackendPatent.jenafuseki.FusekiReader;
import Patent.BackendPatent.model.patent.P1;
import Patent.BackendPatent.model.patent.TipPopunjavaZavod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProveraPodataka {
    public static boolean DaLiSuPravilnoUnetiPodaciOdKorisnika(P1 p1)throws Exception{
        if (DaLiVecPostojiSrpskiNazivKorisnik(p1.getNazivPronalaska().getSrpskiNaziv().getValue()))
            return true;
        if (DaLiVecPostojiEngleskiNazivKorisnik(p1.getNazivPronalaska().getEngleskiNaziv().getValue()))
            return true;
        if (p1.ProveraP1())
            return true;
        return false;
    }

    public static boolean DaLiVecPostojiSrpskiNazivKorisnik(String naziv) throws IOException {
        Map<String,String>mapa = new HashMap<>();
        mapa.put("nazivPatentaSrpski", naziv);
        ArrayList<String>listaSrpskiNaziv = FusekiReader.executeQueryPatent(mapa,"1");
        if (listaSrpskiNaziv.size()>0)
            return true;
        else
            return false;
    }

    public static boolean DaLiVecPostojiEngleskiNazivKorisnik(String naziv) throws IOException {
        Map<String,String>mapa = new HashMap<>();
        mapa.put("nazivPatentaEngleski", naziv);
        ArrayList<String>listaSrpskiNaziv = FusekiReader.executeQueryPatent(mapa,"3");
        if (listaSrpskiNaziv.size()>0)
            return true;
        else
            return false;
    }

    public static boolean DaLiSuPravilnoUnetiPodaciOdZavoda(P1 p1)throws Exception{
        if (DaLiVecPostojiSrpskiNazivZavod(p1.getNazivPronalaska().getSrpskiNaziv().getValue()))
            return true;
        if (DaLiVecPostojiEngleskiNazivZavod(p1.getNazivPronalaska().getEngleskiNaziv().getValue()))
            return true;
        if (p1.ProveraP1())
            return true;
        if (ProveraUnetoZavod(p1.getPopunjavaZavod()))
            return true;
        return false;
    }

    public static boolean ProveraUnetoZavod(TipPopunjavaZavod tipPopunjavaZavod){
        try {
            KonverterDatum.konvertovanjeSamoDatumUDate(tipPopunjavaZavod.getDatumPrijema());
            KonverterDatum.konvertovanjeSamoDatumUDate(tipPopunjavaZavod.getPriznatiDatumPodnosenja().getValue());
        }catch (Exception e){
            return true;
        }
        return false;
    }

    public static boolean DaLiVecPostojiBrojPrijave(String broj)throws IOException{
        Map<String,String>mapa = new HashMap<>();
        mapa.put("brojPrijave", broj);
        ArrayList<String>listaSrpskiNaziv = FusekiReader.executeQueryPatent(mapa,"2");
        if (listaSrpskiNaziv.size()>2)
            return true;
        else
            return false;
    }

    public static boolean DaLiVecPostojiBrojPrijavePrviPut(String broj)throws IOException{
        Map<String,String>mapa = new HashMap<>();
        mapa.put("brojPrijave", broj);
        ArrayList<String>listaSrpskiNaziv = FusekiReader.executeQueryPatent(mapa,"2");
        if (listaSrpskiNaziv.size()>0)
            return true;
        else
            return false;
    }

    public static boolean DaLiVecPostojiSrpskiNazivZavod(String naziv) throws IOException {
        Map<String,String>mapa = new HashMap<>();
        mapa.put("nazivPatentaSrpski", naziv);
        ArrayList<String>listaSrpskiNaziv = FusekiReader.executeQueryPatent(mapa,"1");
        if (listaSrpskiNaziv.size()>2)
            return true;
        else
            return false;
    }

    public static boolean DaLiVecPostojiEngleskiNazivZavod(String naziv) throws IOException {
        Map<String,String>mapa = new HashMap<>();
        mapa.put("nazivPatentaEngleski", naziv);
        ArrayList<String>listaSrpskiNaziv = FusekiReader.executeQueryPatent(mapa,"3");
        if (listaSrpskiNaziv.size()>2)
            return true;
        else
            return false;
    }
}
