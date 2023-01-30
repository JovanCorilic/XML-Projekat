package Patent.BackendPatent.repository;

import Patent.BackendPatent.existdb.ExistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResenjeRepository {
    @Autowired
    ExistManager existManager;

    private final String collectionId="/db/resenje";

    public void saveResenjeFromText(String text, String id) throws Exception {
        existManager.storeFromText(collectionId, id , text);
    }

    public String findResenjeById(String id) throws Exception {
        return existManager.loadString(collectionId, id);
    }

    public String findResenjeByNaziv(String naziv)throws Exception{
        return existManager.findByNaziv(collectionId,naziv);
    }

    public String[] getAll() throws Exception{
        return existManager.loadAll(collectionId);
    }

    public boolean deleteByNaziv(String naziv)throws Exception{
        return existManager.DeleteByNaziv(collectionId,naziv);
    }
}
