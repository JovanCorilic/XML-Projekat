package Patent.BackendPatent.repository;

import Patent.BackendPatent.existdb.ExistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatentRepository {
    @Autowired
    ExistManager existManager;

    private final String collectionId="/db/patent";

    public void savePatentFromText(String text, String id) throws Exception {
        existManager.storeFromText(collectionId, id , text);
    }

    public String findPatentById(String id) throws Exception {
        return existManager.loadString(collectionId, id);
    }

    public String[] getAll() throws Exception{
        return existManager.loadAll(collectionId);
    }
}
