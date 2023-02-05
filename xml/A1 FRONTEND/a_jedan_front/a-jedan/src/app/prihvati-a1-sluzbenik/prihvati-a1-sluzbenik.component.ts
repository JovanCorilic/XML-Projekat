import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Entity } from 'src/model/Entity';

@Component({
  selector: 'app-prihvati-a1-sluzbenik',
  templateUrl: './prihvati-a1-sluzbenik.component.html',
  styleUrls: ['./prihvati-a1-sluzbenik.component.css']
})
export class PrihvatiA1SluzbenikComponent implements OnInit {

  constructor(private http: HttpClient) { }
  private path = "http://localhost:8080/getAllNeprihvacene"

  ngOnInit(): void {
  this.sendXml()
    /*niz.forEach(element => {
      
    });*/

  }

  sendXml() {
    return this.http.get(this.path, { responseType: 'text' }).subscribe(data => {
      console.log("data");
      console.log(data);
      let myContainer = document.getElementById('tabela-prihvati') as HTMLInputElement;
      var sve = data.replace('<Fajlovi>','').replace('</Fajlovi>','').replace('</Fajl>','').split("<Fajl>");
      let stil = "style='font: bold 11px Arial;"+
      "text-decoration: none;"+
            "background-color: #EEEEEE;"+
            "color: #333333;"+
            "padding: 2px 6px 2px 6px;"+
            "border-top: 3px solid #CCCCCC;"+
            "border-right: 3px solid #333333;"+
            "border-bottom: 3px solid #333333;"+
            "border-left: 3px solid #CCCCCC;'"

      for (let i = 1; i < sve.length; ++i) {
        myContainer.innerHTML += 
        '<tr style="background-color: #dddddd;">'+
          '<td style="width: 90%; border: 1px solid #dddddd; text-align: left; padding: 8px;">' + sve[i] + '</td>'+
          '<td style="width: 10%; border: 1px solid #dddddd; text-align: left; padding: 8px;">'+
            /*'<form action="http://localhost:4200/sluzbenikPrihvatiDokument?Dokument=' + sve[i].replace("</Fajl>","") + '">'+
              '<input type="submit" value=""/>'+
            '</form>'+*/
            '<a ' + stil + 'href="http://localhost:4200/sluzbenikPrihvatiDokument?Dokument=' + sve[i].replace("</Fajl>","") +'">Odaberi</a>'+
          '</td>'+
        '</tr>';
      }
    });
  }
}
