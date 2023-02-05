import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DownloadServiceService } from 'src/app/download-service.service';
import { FileData } from 'src/model/FileData';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-pretrazi-metadata',
  templateUrl: './pretrazi-metadata.component.html',
  styleUrls: ['./pretrazi-metadata.component.css']
})
export class PretraziMetadataComponent implements OnInit {
  private path = "http://localhost:8080/fusekiGetAllMetadata"
  constructor(private http: HttpClient,  private downloadService: DownloadServiceService) { }

  ngOnInit(): void {
    this.sendXml()

    }
  
    sendXml() {
      return this.http.get(this.path, { responseType: 'text' }).subscribe(data => {
        console.log("data");
        console.log(data);
        let myContainer = document.getElementById('tabela-prihvati') as HTMLInputElement;
        var sve = data.replace('<Metapodaci>','').replace('</Metapodaci>','').split(">");
        let stil = "style='font: bold 11px Arial;"+
        "text-decoration: none;"+
              "background-color: #EEEEEE;"+
              "color: #333333;"+
              "padding: 2px 6px 2px 6px;"+
              "border-top: 3px solid #CCCCCC;"+
              "border-right: 3px solid #333333;"+
              "border-bottom: 3px solid #333333;"+
              "border-left: 3px solid #CCCCCC;'"
  
        for (let i = 0; i < sve.length/7; ++i) {
          myContainer.innerHTML += 
          '<tr style="background-color: #dddddd;">'+
            '<th style="width: 24%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 2].split('<')[0] + '</th>'+
            '<th style="width: 18%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 4].split('<')[0] + '</th>'+
            '<th style="width: 15%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 6].split('<')[0] + '</th>'+
            '<th style="width: 15%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 8].split('<')[0] + '</th>'+
            '<th style="width: 18%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 10].split('<')[0] + '</th>'+
            '<td style="width: 10%; border: 1px solid #dddddd; text-align: center; padding: 8px;">'+
              '<a ' + stil + 'href="http://localhost:4200/PogledajDokument?Dokument=' + sve[(i*12)].replace("<","") +'">Pogledaj</a>'+
            '</td>'+
          '</tr>';
        }
      });
    }


  filtriraj(meta1:string, meta2:string, meta3:string, meta4:string, vrednost1:string, vrednost2:string, vrednost3:string, vrednost4:string, datum1:string, datum2:string, i_ili1:string, i_ili2:string, i_ili3:string, ne1:boolean, ne2:boolean, ne3:boolean, ne4:boolean){
    let znak = "";
    let filter = "";

    znak += meta1;
    if(ne1)
      {znak += "N";}
    else
      {znak += "D";}
    znak += i_ili1;

    znak += meta2;
    if(ne2)
      {znak += "N";}
    else
      {znak += "D";}
    znak += i_ili2;

    znak += meta3;
    if(ne3)
      {znak += "N";}
    else
      {znak += "D";}
    znak += i_ili3;

    znak += meta4;
    if(ne4)
      {znak += "N";}
    else
      {znak += "D";}

  

    if(vrednost1 != null && vrednost1 != "")
      {filter += vrednost1 + "|";}
    else
      {filter += "0PRAZAN0" + "|";}

    if(vrednost2 != null && vrednost2 != "")
      {filter += vrednost2 + "|";}
    else
      {filter += "0PRAZAN0" + "|";}

    if(vrednost3 != null && vrednost3 != "")
      {filter += vrednost3 + "|";}
    else
      {filter += "0PRAZAN0" + "|";}

    if(vrednost4 != null && vrednost4 != "")
      {filter += vrednost4 + "|";}
    else
      {filter += "0PRAZAN0" + "|";}

    ////////////////////////////////// datum

    if(datum1 != null && datum1 != "")
      {filter += datum1 + "|";}
    else
      {filter += "0PRAZAN0" + "|";}

    if(datum2 != null && datum2 != "")
      {filter += datum2;}
    else
      {filter += "0PRAZAN0";}
  

    console.log("filter = " + filter);
    console.log("znak = " + znak);

    let ppth = "http://localhost:8080/getAllAJedanMetadataFilter/" + znak + "/" + filter;
    return this.http.get(ppth, { responseType: 'text' }).subscribe(data => {
      console.log("data");
      console.log(data);
      let myContainer = document.getElementById('tabela-prihvati') as HTMLInputElement;
      myContainer.innerHTML = "";  
      var sve = data.replace('<Metapodaci>','').replace('</Metapodaci>','').split(">");
      let stil = "style='font: bold 11px Arial;"+
      "text-decoration: none;"+
            "background-color: #EEEEEE;"+
            "color: #333333;"+
            "padding: 2px 6px 2px 6px;"+
            "border-top: 3px solid #CCCCCC;"+
            "border-right: 3px solid #333333;"+
            "border-bottom: 3px solid #333333;"+
            "border-left: 3px solid #CCCCCC;'"
      for (let i = 0; i < (sve.length/14); ++i) {
        myContainer.innerHTML += 
        '<tr style="background-color: #dddddd;">'+
          '<th style="width: 24%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 2].split('<')[0] + '</th>'+
          '<th style="width: 18%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 4].split('<')[0] + '</th>'+
          '<th style="width: 15%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 6].split('<')[0] + '</th>'+
          '<th style="width: 15%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 8].split('<')[0] + '</th>'+
          '<th style="width: 18%; border: 1px solid #dddddd; text-align: center; padding: 8px;">' + sve[(i*12) + 10].split('<')[0] + '</th>'+
          '<td style="width: 10%; border: 1px solid #dddddd; text-align: center; padding: 8px;">'+
            '<a ' + stil + 'href="http://localhost:4200/PogledajDokument?Dokument=' + sve[(i*12)].replace("<","") +'">Pogledaj</a>'+
          '</td>'+
        '</tr>';
      }
    });
  }

  preuzmiJSON(){
    this.downloadService
    .downloadJSON()
    .subscribe(blob => saveAs(blob, "A-1.json"));
  }
  preuzmiRDF(){
    this.downloadService
      .downloadRDF()
      .subscribe(blob => saveAs(blob, "A-1.rdf"));
  }

}
