package Patent.BackendPatent.controller;


import Patent.BackendPatent.dto.XMLDto;
import Patent.BackendPatent.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.apache.commons.compress.utils.IOUtils;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/patent", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PatentController {
    @Autowired
    private PatentService patentService;

    //Operacije pravljenje i edit xml-a ----------------------------------------------------------------

    @PostMapping(value = "/xonomyCreate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addPatentFrontend(@RequestBody XMLDto entitet) throws Exception{
        patentService.addPatentFromText(entitet.getText());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/xonomyEdit",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>editPatentFrontend(@RequestBody XMLDto entitet)throws Exception{
        patentService.editPatentFromText(entitet.getText());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Operacije dobijanja xml-a ----------------------------------------------------------------------

    @PostMapping(value = "/getXMLDocument", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<XMLDto> getPatentXMLDocument(@RequestBody XMLDto xmlDto) throws Exception {
        String document = patentService.getPatentXMLDocument(xmlDto.getText());
        document = document.replaceAll("\n","");
        if(document.equals("")) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new XMLDto(document), HttpStatus.OK);
    }

    @GetMapping(value = "/getOznakePatenta/{id}")
    public ResponseEntity<XMLDto> getOznakePatenta(@PathVariable("id") String id) throws Exception {
        String temp = patentService.getOznakePatenta(id);
        return new ResponseEntity<>(new XMLDto(temp),HttpStatus.OK);
    }

    @GetMapping("pretragaPoNazivu/{naziv}")
    public ResponseEntity<XMLDto>pretragaPoSrpskomEngleskomNazivu(@PathVariable("naziv") String naziv) throws Exception{
        try {
            String document = patentService.FindNaziv(naziv);
            return new ResponseEntity<>(new XMLDto(document),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Operacije get lista XML-a --------------------------------------------------------------------

    @GetMapping(value = "/getAll")
    public ResponseEntity<String[]> getAllPatenteProsaoZavod() throws Exception {
        String[] listaPatenta = patentService.getAll();
        return new ResponseEntity<>(listaPatenta, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllNijeProsaoZavod")
    public ResponseEntity<String[]> getAllPatenteNijeProsaoZavod() throws Exception {
        String[] listaPatenta = patentService.getAllNijeProsaoZavod();
        return new ResponseEntity<>(listaPatenta, HttpStatus.OK);
    }

    //Operacije pretraga po xml i metapodacima --------------------------------------------------------------

    @GetMapping("fusekiSearch/{odluka}/{opcija}")
    public ResponseEntity<XMLDto> searchFromRDF(@PathVariable("odluka") String odluka, @PathVariable("opcija") String opcija) throws IOException {
        ArrayList<String> result = patentService.searchByMetadata(odluka, opcija);
        String output = "";
        for (String r : result) {
            output += "\n" + r;
        }
        System.out.println("OUTPUT: " + output);
        return new ResponseEntity<>(new XMLDto(output), HttpStatus.OK);
    }

    @GetMapping("pretragaPoTekstualnomSadrzaju/{odluka}")
    public ResponseEntity<String[]> searchFromXMLTextContent(@PathVariable("odluka") String odluka) throws Exception {
        String[] result = patentService.searchByTextContent(odluka);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //Operacija download raznih delova ----------------------------------------------------------------

    @GetMapping("downloadRDF/{id}")
    public ResponseEntity<XMLDto> downloadRDF(@PathVariable("id") String id) throws Exception {
        try {
            String result = patentService.downloadRDF(id);
            return new ResponseEntity<>(new XMLDto(result), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("downloadHTML/{id}")
    public ResponseEntity<XMLDto>downloadHTML(@PathVariable("id")String id)throws Exception{
        try {
            String result = patentService.downloadHTML(id);
            return new ResponseEntity<>(new XMLDto(result), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("downloadPDF/{id}")
    public void downloadPDF(HttpServletResponse response, @PathVariable("id")String id) throws Exception {
        ByteArrayOutputStream result = patentService.downloadPDF(id);
        ByteArrayInputStream temp = new ByteArrayInputStream(result.toByteArray());
        IOUtils.copy(temp, response.getOutputStream());
        response.flushBuffer();
    }
    /*@ResponseBody
    @GetMapping("downloadPDF/{id}")
    public ResponseEntity<PatentPDF>downloadPDF(@PathVariable("id")String id)throws Exception{
        try {
            ByteArrayOutputStream result = patentService.downloadPDF(id);

            return new ResponseEntity<>(new PatentPDF(result.toByteArray()), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    //Operacije slanje xml sa xml formatom ------------------------------------------------------------

    @PostMapping(value = "/addText", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> addPatentText(@RequestBody String text) throws Exception {
        patentService.addPatentFromText(text);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @PutMapping(value = "/TextEdit",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Void>editPatentText(@RequestBody String text)throws Exception{
        patentService.editPatentFromText(text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Operacija brisanja ------------------------------------------------------------------------------

    @DeleteMapping("deletePoNazivu/{naziv}")
    public ResponseEntity<Void>deletePoNazivu(@PathVariable("naziv")String naziv)throws Exception{
        try {
            patentService.deleteByNaziv(naziv);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //-------------------------------------------------------------------------------------------

    @PostMapping(value = "/generateXHTMLandPDF/{id}")
    public ResponseEntity<Void> generateXHTMLandPDF(@PathVariable("id") String id)throws Exception{
        try {
            patentService.generateXHTMLandPDF(id);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
