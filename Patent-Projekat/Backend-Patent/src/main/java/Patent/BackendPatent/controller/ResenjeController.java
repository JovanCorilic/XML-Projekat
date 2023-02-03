package Patent.BackendPatent.controller;

import Patent.BackendPatent.dto.XMLDto;
import Patent.BackendPatent.dto.XMLListaDTO;
import org.apache.commons.compress.utils.IOUtils;
import Patent.BackendPatent.service.ResenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/resenje", produces = MediaType.APPLICATION_XML_VALUE,
        consumes = MediaType.APPLICATION_XML_VALUE)
@CrossOrigin
public class ResenjeController {

    @Autowired
    private ResenjeService resenjeService;

    //Operacije pravljenje i edit resenja ----------------------------------------------------------------------------

    @PostMapping("/xonomyCreateResenje")
    public ResponseEntity<Void>pravljenjeResenja(@RequestBody String entity) throws Exception {
        try {
            resenjeService.addResenjeFromText(entity);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/xonomyEditResenje")
    public ResponseEntity<Void>editResenja(@RequestBody String entity) throws Exception{
        try {
            resenjeService.editResenjeFromText(entity);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Operacije dobijanja svih resenja ----------------------------------------------------------------------------

    @GetMapping("/getAllResenja")
    public ResponseEntity<XMLListaDTO>getAllResenja() throws Exception{
        String[] listaResenja = resenjeService.getAll();
        return new ResponseEntity<>(new XMLListaDTO(listaResenja), HttpStatus.OK);
    }

    //Operacije dobijanja resenja ----------------------------------------------------------------------------

    @GetMapping("/getResenje/{id}")
    public ResponseEntity<String>getResenjeXML(@PathVariable("id")String id)throws Exception{
        String document = resenjeService.getResenjeXMLDocument(id);
        document = document.replaceAll("\n","");
        if(document.equals("")) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @GetMapping("/getReferencuNaZahtev/{id}")
    public ResponseEntity<XMLListaDTO>getReferencuNaDokument(@PathVariable("id")String id)throws Exception{
        String document = resenjeService.getResenjeXMLDocument(id);
        String[] tempLista = resenjeService.getReferencuNaZahtev(document);
        return new ResponseEntity<>(new XMLListaDTO(tempLista),HttpStatus.OK);
    }

    @GetMapping(value = "/getOznakeResenja/{id}")
    public ResponseEntity<XMLDto> getOznakePatenta(@PathVariable("id") String id) throws Exception {
        String temp = resenjeService.getOznakeResenja(id);
        return new ResponseEntity<>(new XMLDto(temp),HttpStatus.OK);
    }

    //Operacije pretrage ----------------------------------------------------------------------------

    @GetMapping("fusekiSearchResenje/{odluka}/{opcija}")
    public ResponseEntity<XMLDto> searchFromRDF(@PathVariable("odluka") String odluka, @PathVariable("opcija") String opcija) throws IOException {
        ArrayList<String> result = resenjeService.searchByMetadata(odluka, opcija);
        String output = "";
        for (String r : result) {
            output += "\n" + r;
        }
        //System.out.println("OUTPUT: " + output);
        return new ResponseEntity<>(new XMLDto(output), HttpStatus.OK);
    }

    @GetMapping("pretragaPoTekstualnomSadrzajuResenje/{odluka}")
    public ResponseEntity<XMLListaDTO> searchFromXMLTextContent(@PathVariable("odluka") String odluka) throws Exception {
        String[] result = resenjeService.searchByTextContent(odluka);
        return new ResponseEntity<>(new XMLListaDTO(result), HttpStatus.OK);
    }

    //Izvestaj ----------------------------------------------------------------------------

    @GetMapping(value = "downloadPDF/{pocetniDatum}/{krajnjiDatum}", produces = MediaType.ALL_VALUE, consumes = MediaType.ALL_VALUE)
    public void downloadPDF(HttpServletResponse response, @PathVariable("pocetniDatum")String pocetniDatum, @PathVariable("krajnjiDatum")String krajnjiDatum) throws Exception {
        ByteArrayOutputStream result = resenjeService.downloadPDF(pocetniDatum,krajnjiDatum);
        ByteArrayInputStream temp = new ByteArrayInputStream(result.toByteArray());
        IOUtils.copy(temp, response.getOutputStream());
        response.flushBuffer();
    }

}
