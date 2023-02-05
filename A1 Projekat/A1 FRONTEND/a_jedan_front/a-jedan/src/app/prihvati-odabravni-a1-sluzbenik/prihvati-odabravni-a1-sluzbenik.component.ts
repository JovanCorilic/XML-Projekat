import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';
import { XonomyService } from '../xonomy.service';
import { Entity } from 'src/model/Entity';

declare const Xonomy: any
@Component({
  selector: 'app-prihvati-odabravni-a1-sluzbenik',
  templateUrl: './prihvati-odabravni-a1-sluzbenik.component.html',
  styleUrls: ['./prihvati-odabravni-a1-sluzbenik.component.css']
})
export class PrihvatiOdabravniA1SluzbenikComponent implements OnInit {
  public href: string = "";

  constructor(private xonomyService: XonomyService, private router: Router, private http: HttpClient) { }
  private path = "http://localhost:8080/getAJedan/";//Dokument naziv

  ngOnInit(): void {
    this.href = this.router.url;//sluzbenikPrihvatiDokument?Dokument=A1-DrugaKonstolnaTacka
    this.getDokument(this.path + this.router.url.substring(this.router.url.length - ((this.router.url.length) -( this.router.url.indexOf('=')+1))));
  }

  getDokument(link:string) {
    console.log(link);
    return this.http.get(link, { responseType: 'text' }).subscribe(data => {
      let element = document.getElementById("editor");
      let specification = this.xonomyService.A1Specification;
      let xmlString = data;
      console.log(data);
      Xonomy.render(xmlString, element, specification);
    })
  }

  prihvati(){
    console.log("Poslat zahtev za prihvatanje");

    (<HTMLInputElement>document.getElementById('d1')).setAttribute('disabled', '');
    (<HTMLInputElement>document.getElementById('d2')).setAttribute('disabled', '');

    let url_p = "http://localhost:8080/prihvati/" + this.router.url.substring(this.router.url.length - ((this.router.url.length) -( this.router.url.indexOf('=')+1)));
    return this.http.get(url_p, { responseType: 'text' }).subscribe(data => {
      console.log(data);
      if(data == "<Odgovor>Uspeh</Odgovor>"){
        console.log("Uspelo");
        this.router.navigate(['/sluzbenikPrihvati'])
      }else{
        console.log("Nije uspelo");
        alert("Doslo je do greske pri prihvatanju zahteva, molimo vas proverite da li ste povezani na internet")
      }
    })
  }

  odbi(){
    console.log("Poslat zahtev za odbijanje");
    let vrednot = (<HTMLInputElement>document.getElementById('razlog')).value;
    let duzina = vrednot.length;

    if(duzina == undefined || duzina < 3){
      alert("Molimo vas da navedete razlog odbihjanja");
      return;
    }

    (<HTMLInputElement>document.getElementById('d1')).setAttribute('disabled', '');
    (<HTMLInputElement>document.getElementById('d2')).setAttribute('disabled', '');

    let url_o = "http://localhost:8080/odbi/" + this.router.url.substring(this.router.url.length - ((this.router.url.length) -( this.router.url.indexOf('=')+1))) + "/" + vrednot;
    return this.http.get(url_o, { responseType: 'text' }).subscribe(data => {
      console.log(data);
      if(data == "<Odgovor>Uspeh</Odgovor>"){
        console.log("Uspelo");
        this.router.navigate(['/sluzbenikPrihvati'])
      }
      else{
      console.log("Nije uspelo");
      alert("Doslo je do greske pri odbijanju zahteva, molimo vas proverite da li ste povezani na internet")
      }
    })
  }
}
