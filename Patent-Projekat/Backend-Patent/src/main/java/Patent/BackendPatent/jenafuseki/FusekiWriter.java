package Patent.BackendPatent.jenafuseki;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FusekiWriter {

    private static final String RDF_FILEPATH_PATENT = "src/main/resources/rdf/rdfPatentOutput.rdf";
    private static final String GRAPH_URI_PATENT = "patentMetadata";

    public static void saveRDFPatent() throws IOException {

        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();

        Model model = ModelFactory.createDefaultModel();
        model.read(RDF_FILEPATH_PATENT);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        model.write(out, SparqlUtil.NTRIPLES);

        model.write(System.out, SparqlUtil.RDF_XML);

        UpdateRequest request = UpdateFactory.create();
        UpdateProcessor processor = UpdateExecutionFactory.createRemote(request,conn.updateEndpoint);
        processor.execute();

        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + "/"+ GRAPH_URI_PATENT,
                new String(out.toByteArray()));


        UpdateRequest update = UpdateFactory.create(sparqlUpdate);
        processor = UpdateExecutionFactory.createRemote(update,conn.updateEndpoint);
        processor.execute();

    }
}
