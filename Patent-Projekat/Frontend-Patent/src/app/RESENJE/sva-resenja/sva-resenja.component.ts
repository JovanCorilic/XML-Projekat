import { ResenjeService } from './../../SERVICE/resenje.service';
import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Konverzija } from 'src/app/SERVICE/konverzija.service';
import { PatentService } from 'src/app/SERVICE/patent.service';

@Component({
  selector: 'app-sva-resenja',
  templateUrl: './sva-resenja.component.html',
  styleUrls: ['./sva-resenja.component.css']
})
export class SvaResenjaComponent {
  listaResenja:string[]|undefined;
  listaResenja2:string[]=[];
  odluka=<string>{}
  odluka2=<string>{}
  resForm:FormGroup;
  res2Form:FormGroup;
  res3Form:FormGroup;
  opcija=<string>{}
  rezultat = <string>{}
  prodjeno:boolean=false;
  mapa:Map<string,string>;
  mapaMetaPodaci:Map<string,string>;

  constructor(
    private resenjeService:ResenjeService,
    private router:Router,
    private fBuilder:FormBuilder
  ) {
    this.resForm = this.fBuilder.group({
      opcija:["1"],
      odluka:""
    });
    this.res2Form=this.fBuilder.group({
      odluka2:""
    });
    this.res3Form = this.fBuilder.group({
      pocetniDatum:"",
      krajnjiDatum:""
    });
    this.mapa= new Map();
    this.mapaMetaPodaci = new Map();

   }

  get form():{ [key: string]: AbstractControl; }
  {
      return this.resForm.controls;
  }

  ngOnInit(): void {
    this.listaResenja;
    this.resenjeService.svaResenja().subscribe(
      res=>{
        this.listaResenja = Konverzija.uzimanjePodatakaXMLDtoLista(res);
        this.listaResenja.forEach(element => {
          this.prikazOznakaPatenta(element,this.mapa);
        });
      }
    );
  
  }

  generisanjeIzvestaja(){
    let pocetniDatum = this.res3Form.value["pocetniDatum"];
    let krajnjiDatum = this.res3Form.value["krajnjiDatum"];

    this.resenjeService.downloadPDF(pocetniDatum,krajnjiDatum);

  }

  idiNaEditResenje(resenje:string){
    this.router.navigate(['/editResenja/'+resenje]);
  }

  prikazOznakaPatenta(id:string,Mapa:Map<string,string>){
    this.resenjeService.getOznakeResenja(id).subscribe(
      res=>{
        Mapa.set(id,Konverzija.uzimanjePodatakaXMLDto(res));
      }
    );

  }

  pretraziPoTekstualnomSadrzaju(){
    if (this.res2Form.value["odluka2"]==""){
      alert("Polje unos za pretragu tekstualnog sadrzaja mora biti popunjeno!");
    }else{
      this.resenjeService.searchTekstualniSadrzajResenje(this.res2Form.value["odluka2"]).subscribe(
        res=>{
          this.opcija="1";
          this.listaResenja2=Konverzija.uzimanjePodatakaXMLDtoLista(res);
          this.listaResenja2.forEach(element => {
            this.prikazOznakaPatenta(element,this.mapaMetaPodaci);
          });
        }
      )
    }
  }


  pretraziPrekoMetapodatak(){
    if (this.resForm.value["odluka"]==""){
      alert("Polje za unos metapodataka mora biti popunjeno!");
    }else{
      this.opcija = this.resForm.value["opcija"];
      this.resenjeService.searchMetapodaciResenje(this.resForm.value["odluka"], this.resForm.value["opcija"]).subscribe(
        res=>{
          this.rezultat = Konverzija.uzimanjePodatakaXMLDto(res);

          let test:string[] = [];
          
          let lista = this.rezultat.split('\n');
          
          for(let i = 0;i<lista.length;i++){
            if(!lista[i].includes("http://www.ftn.uns.ac.rs/rdf/resenjePatent"))
              continue;
            let tempLista = lista[i].split("/");
            test.push(tempLista[tempLista.length-1]);
          }
          this.listaResenja2=test;
          this.listaResenja2.forEach(element => {
            this.prikazOznakaPatenta(element,this.mapaMetaPodaci);
          });
        }
      )
    }
  }
}
