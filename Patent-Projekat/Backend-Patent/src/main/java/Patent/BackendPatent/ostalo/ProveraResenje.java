package Patent.BackendPatent.ostalo;

import Patent.BackendPatent.jenafuseki.FusekiReader;
import Patent.BackendPatent.model.resenjePatent.Resenje;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProveraResenje {
    public static boolean DaLiJeDobroResenje(Resenje resenje) throws IOException {
        try {
            KonverterDatum.konvertovanjeSamoDatumUDate(resenje.getDatumOdlukeOZahtevu().getValue());
        }catch (Exception e){
            return true;
        }
        if (
                resenje.getSluzbenik().getIme().getValue().equals("") ||
                        resenje.getSluzbenik().getPrezime().getValue().equals("")
        )return true;
        if (ProveraReference(resenje.getReferencaNaZahtev()))
            return true;

        return false;
    }

    public static boolean ProveraReference(String referenca) throws IOException {
        Map<String,String> mapa = new HashMap<>();
        mapa.put("brojPrijave", referenca);
        ArrayList<String> listaSrpskiNaziv = FusekiReader.executeQueryPatent(mapa,"2");
        if (listaSrpskiNaziv.size()==0)
            return true;
        else
            return false;
    }
}
