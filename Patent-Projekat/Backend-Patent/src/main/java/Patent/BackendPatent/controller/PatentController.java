package Patent.BackendPatent.controller;

import Patent.BackendPatent.dto.XMLDto;
import Patent.BackendPatent.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/patent", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PatentController {
    @Autowired
    private PatentService patentService;

    @PostMapping(value = "/xonomyCreate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addPatentFrontEnd(@RequestBody XMLDto entitet) throws Exception{
        patentService.addPatentFromText(entitet.getText());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/getXMLDocument", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<XMLDto> getPatentXMLDocument(@RequestBody XMLDto xmlDto) throws Exception {
        String document = patentService.getPatentXMLDocument(xmlDto.getText());
        document = document.replaceAll("\n","");
        if(document.equals("")) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new XMLDto(document), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<String[]> getAllResenja() throws Exception {
        String[] listaResenja = patentService.getAll();

        return new ResponseEntity<>(listaResenja, HttpStatus.OK);
    }

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

    @GetMapping("downloadRDF/{id}")
    public ResponseEntity<XMLDto> downloadRDF(@PathVariable("id") String id) throws Exception {
        String result = patentService.downloadRDF(id);
        return new ResponseEntity<>(new XMLDto(result), HttpStatus.OK);
    }

    @PostMapping(value = "/addText", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addPatentText(@RequestBody String text) throws Exception {
        patentService.addPatentFromText(text);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }
}
