import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-pregled-a1-sluzbenik',
  templateUrl: './pregled-a1-sluzbenik.component.html',
  styleUrls: ['./pregled-a1-sluzbenik.component.css']
})
export class PregledA1SluzbenikComponent implements OnInit {
  
  private path = "http://localhost:8080/getAllAJedan"

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.sendXml()

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
              '<a ' + stil + 'href="http://localhost:4200/PogledajDokument?Dokument=' + sve[i].replace("</Fajl>","") +'">Pogledaj</a>'+
            '</td>'+
          '</tr>';
        }
      });
    }

    filtriraj(naslov1:string, naslov2:string, naslov3:string, sadrzaj1:string, sadrzaj2:string, sadrzaj3:string, sadrzaj4:string, datum1:string, datum2:string, i_ili1:string, i_ili2:string, i_ili3:string, i_ili4:string, i_ili5:string, ne1:boolean, ne2:boolean, ne3:boolean, ne4:boolean, ne5:boolean, ne6:boolean, ne7:boolean){
      let znak = "";
      let filter = "";

      if(ne1)
        {znak += "N";}
      else
        {znak += "D";}

      znak += i_ili1;

      if(ne2)
        {znak += "N";}
      else
        {znak += "D";}

      znak += i_ili2;

      if(ne3)
        {znak += "N";}
      else
        {znak += "D";}

      if(ne4)
        {znak += "N";}
      else
        {znak += "D";}

      znak += i_ili3;

      if(ne5)
        {znak += "N";}
      else
        {znak += "D";}

      znak += i_ili4;

      if(ne6)
        {znak += "N";}
      else
        {znak += "D";}

      znak += i_ili5;

      if(ne7)
        {znak += "N";}
      else
        {znak += "D";}

    

      if(naslov1 != null && naslov1 != "")
        {filter += naslov1 + "|";}
      else
        {filter += "0PRAZAN0" + "|";}

      if(naslov2 != null && naslov2 != "")
        {filter += naslov2 + "|";}
      else
        {filter += "0PRAZAN0" + "|";}

      if(naslov3 != null && naslov3 != "")
        {filter += naslov3 + "|";}
      else
        {filter += "0PRAZAN0" + "|";}

      if(sadrzaj1 != null && sadrzaj1 != "")
        {filter += sadrzaj1 + "|";}
      else
        {filter += "0PRAZAN0" + "|";}

      if(sadrzaj2 != null && sadrzaj2 != "")
        {filter += sadrzaj2 + "|";}
      else
        {filter += "0PRAZAN0" + "|";}

      if(sadrzaj3 != null && sadrzaj3 != "")
        {filter += sadrzaj3 + "|";}
      else
        {filter += "0PRAZAN0" + "|";}

      if(sadrzaj4 != null && sadrzaj4 != "")
        {filter += sadrzaj4 + "|";}
      else
        {filter += "0PRAZAN0" + "|";}

      if(datum1 != null && datum1 != "")
        {filter += datum1 + "|";}
      else
        {filter += "0PRAZAN0" + "|";}

      if(datum2 != null && datum2 != "")
        {filter += datum2;}
      else
        {filter += "0PRAZAN0";}
    
/*
      let temp = document.getElementById("i_ili1")?
      console.log(document.getElementById("i_ili1")?.getAttribute('value'));

      for(let i = 1 ; i < 4 ; ++i){
        temp = document.getElementById('naslov' + i)?.getAttribute('value');
        if(temp != "")
          filter += temp + "|";
        else{
          filter += "0PRAZAN0" + "|";
        }
      }

      for(let i = 1 ; i < 5 ; ++i){
        temp = document.getElementById('sadrzaj' + i)?.getAttribute('value');
        console.log(document.getElementById(('sadrzaj' + i))?.getAttribute('value'));
        if(true || temp != "" && temp != null )
          filter += temp + "|";
        else{
          filter += "0PRAZAN0" + "|";
        }
      }

      for(let i = 1 ; i < 3 ; ++i){
        temp = document.getElementById('datum' + i)?.getAttribute('value');
        if(temp != "")
          filter += temp + "|";
        else{
          filter += "0PRAZAN0" + "|";
        }
      }
*/
      console.log("filter = " + filter);
      console.log("znak = " + znak);

      let ppth = "http://localhost:8080/getAllAJedanXMLFilter/" + znak + "/" + filter;
      return this.http.get(ppth, { responseType: 'text' }).subscribe(data => {
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
  

        myContainer.innerHTML = "";
        for (let i = 1; i < sve.length; ++i) {
          myContainer.innerHTML += 
          '<tr style="background-color: #dddddd;">'+
            '<td style="width: 90%; border: 1px solid #dddddd; text-align: left; padding: 8px;">' + sve[i] + '</td>'+
            '<td style="width: 10%; border: 1px solid #dddddd; text-align: left; padding: 8px;">'+
              /*'<form action="http://localhost:4200/sluzbenikPrihvatiDokument?Dokument=' + sve[i].replace("</Fajl>","") + '">'+
                '<input type="submit" value=""/>'+
              '</form>'+*/
              '<a ' + stil + 'href="http://localhost:4200/PogledajDokument?Dokument=' + sve[i].replace("</Fajl>","") +'">Pogledaj</a>'+
            '</td>'+
          '</tr>';
        }
      });
    }

}
