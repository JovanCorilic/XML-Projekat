import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DownloadServiceService } from 'src/app/download-service.service';
import { FileData } from 'src/model/FileData';
import { saveAs } from 'file-saver';
import { Router } from '@angular/router';
import { XonomyService } from '../xonomy.service';
import { Entity } from 'src/model/Entity';


@Component({
  selector: 'app-zvestaj',
  templateUrl: './zvestaj.component.html',
  styleUrls: ['./zvestaj.component.css']
})
export class ZvestajComponent implements OnInit {

  constructor(private downloadService: DownloadServiceService, private http: HttpClient) { }

  private path = "http://localhost:8080/getIzvestaj/";//Dokument naziv

  ngOnInit(): void {
    this.getDokument();
  }

  getDokument() {
    return this.http.get(this.path, { responseType: 'text' }).subscribe(data => {
      console.log("data");
      console.log(data);
      
      var sve = data.replace('<Logovi>','').replace('</Logovi>','').replace('</Log>','').split("<Log>");
      let stil = "style='font: bold 11px Arial;"+
      "text-decoration: none;"+
            "background-color: #EEEEEE;"+
            "color: #333333;"+
            "padding: 2px 6px 2px 6px;"+
            "border-top: 3px solid #CCCCCC;"+
            "border-right: 3px solid #333333;"+
            "border-left: 3px solid #333333;"+
            "border-bottom: 3px solid #333333;"+
            "text-align: center;"+
            "border-left: 3px solid #CCCCCC;'"
      let tag ='<td style=" border: 1px solid #dddddd; text-align: left; padding: 8px;">';

      let myContainer = document.getElementById('tabela-log-p') as HTMLInputElement;
      let myContainero = document.getElementById('tabela-log-o') as HTMLInputElement;

      myContainer.innerHTML = '<tr><td ' + stil +'>Stanje</td><td ' + stil +'>Datum Prihvatanja</td><td ' + stil +'>Sifra</td><td ' + stil +'>Ime</td><td ' + stil +'>Prezime</td><td ' + stil +'>Preuzmi</td></tr>';
      myContainero.innerHTML = '<tr><td ' + stil +'>Stanje</td><td ' + stil +'>Datum Prihvatanja</td><td ' + stil +'>Razlog Odbijanja</td><td ' + stil +'>Ime</td><td ' + stil +'>Prezime</td><td ' + stil +'>Preuzmi</td></tr>';
      for (let i = 1; i < sve.length; ++i) {
        if(sve[i].includes("</sifra>")){
          
        myContainer.innerHTML += sve[i].replace("<stanje>", '<tr style="background-color: #dddddd;">'+tag).replace(
          "</stanje>", "</td>").replace("<datum>", tag).replace("</datum>", "").replace("<razlog_odbijanja>", tag).replace("</razlog_odbijanja>", "").replace("<sifra>", tag).replace("</sifra>", "").replace(
            "<ime>", tag).replace("</prezime>", "").replace("<prezime>", tag).replace("<link>", 
            '<td style="width: 3%; border: 1px solid #dddddd; text-align: left; padding: 8px;"><a ' + stil + ' href="http://localhost:4200/PogledajDokument?Dokument=').replace("</link>", "\">Pogledaj</a></td></tr>")
            /*'<form action="http://localhost:4200/sluzbenikPrihvatiDokument?Dokument=' + sve[i].replace("</Fajl>","") + '">'+
              '<input type="submit" value=""/>'+
            '</form>'+*/
          }
          else{
            myContainero.innerHTML += sve[i].replace("<stanje>", '<tr style="background-color: #dddddd;">'+tag).replace(
              "</stanje>", "</td>").replace("<datum>", tag).replace("</datum>", "").replace("<razlog_odbijanja>", tag).replace("</razlog_odbijanja>", "").replace("<sifra>", tag).replace("</sifra>", "").replace(
                "<ime>", tag).replace("</prezime>", "").replace("<prezime>", tag).replace("<link>", 
                '<td style="width: 3%; border: 1px solid #dddddd; text-align: left; padding: 8px;"><a ' + stil + ' href="http://localhost:4200/PogledajDokument?Dokument=').replace("</link>", "\">Pogledaj</a></td></tr>")
                /*'<form action="http://localhost:4200/sluzbenikPrihvatiDokument?Dokument=' + sve[i].replace("</Fajl>","") + '">'+
                  '<input type="submit" value=""/>'+
                '</form>'+*/
          }
      }
    });
  }


  preuzmiIzvestajPDF(){
    this.downloadService
      .downloadIzvestaj()
      .subscribe(blob => saveAs(blob, "Izvestaj.pdf"));
    
  }

}
