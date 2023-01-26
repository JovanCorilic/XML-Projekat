import { Konverzija } from './../../SERVICE/konverzija.service';
import { PatentService } from 'src/app/SERVICE/patent.service';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup  } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-svi-patent',
  templateUrl: './svi-patent.component.html',
  styleUrls: ['./svi-patent.component.css']
})
export class SviPatentComponent implements OnInit{
  listaPatenta:string[]|undefined;
  listaPatenta2:string[]=[];
  odluka=<string>{}
  odluka2=<string>{}
  resForm:FormGroup;
  res2Form:FormGroup;
  opcija=<string>{}
  rezultat = <string>{}
  prodjeno:boolean=false;
  temp:string|null;
  mapa:Map<string,string>;
  mapaMetaPodaci:Map<string,string>;

  constructor(
    private patentService:PatentService,
    private router:Router,
    private route:ActivatedRoute,
    private fBuilder:FormBuilder
  ) {
    this.resForm = this.fBuilder.group({
      opcija:["1"],
      odluka:""
    });
    this.res2Form=this.fBuilder.group({
      odluka2:""
    });
   
    this.temp=this.route.snapshot.paramMap.get('prodjeno');
      if(this.temp != null)
        this.prodjeno = this.convertToBoolean(this.temp);
      else
        this.prodjeno = false;
    this.mapa= new Map();
    this.mapaMetaPodaci = new Map();

   }

  convertToBoolean(input: string): boolean {
    try {
        return JSON.parse(input.toLowerCase());
    }
    catch (e) {
        return false;
    }
  }

  get form():{ [key: string]: AbstractControl; }
  {
      return this.resForm.controls;
  }

  ngOnInit(): void {
   this.listaPatenta;
    if(this.prodjeno)
      this.patentService.sviPatentiProsaoZavod().subscribe(
        res=>{
          this.listaPatenta = Konverzija.uzimanjePodatakaXMLDtoLista(res);
          this.listaPatenta.forEach(element => {
            this.prikazOznakaPatenta(element,this.mapa);
          });
        }
      );
    else if(!this.prodjeno)
        this.patentService.sviPatentiNijeProsaoZavod().subscribe(
          res=>{
            
            this.listaPatenta = Konverzija.uzimanjePodatakaXMLDtoLista(res);
            this.listaPatenta.forEach(element => {
              this.prikazOznakaPatenta(element,this.mapa);
            });
          }
        );
  }

  idiNaEditPatenta(patent:string){
    this.router.navigate(['/edit-patent/'+patent+'/'+this.prodjeno]);
  }

  prikazOznakaPatenta(id:string,Mapa:Map<string,string>){
    this.patentService.getOznakePatenta(id).subscribe(
      res=>{
        Mapa.set(id,Konverzija.uzimanjePodatakaXMLDto(res));
      }
    );

  }

  pretraziPoTekstualnomSadrzaju(){
    if (this.res2Form.value["odluka2"]==""){
      alert("Polje unos za pretragu tekstualnog sadrzaja mora biti popunjeno!");
    }else{
      this.patentService.searchTekstualniSadrzaj(this.res2Form.value["odluka2"]).subscribe(
        res=>{
          this.opcija="1";
          this.listaPatenta2=Konverzija.uzimanjePodatakaXMLDtoLista(res);
        }
      )
    }
  }

  pretraziPrekoMetapodatak(){
    if (this.resForm.value["odluka"]==""){
      alert("Polje za unos metapodataka mora biti popunjeno!");
    }else{
      this.opcija = this.resForm.value["opcija"];
      this.patentService.searchMetapodaci(this.resForm.value["odluka"], this.resForm.value["opcija"]).subscribe(
        res=>{
          this.rezultat = Konverzija.uzimanjePodatakaXMLDto(res);
          
          
            
          let test:string[] = [];
          
          let lista = this.rezultat.split('\n');
          
          for(let i = 0;i<lista.length;i++){
            if(!lista[i].includes("http://www.ftn.uns.ac.rs/rdf/patent"))
              continue;
            let tempLista = lista[i].split("/");
            test.push(tempLista[tempLista.length-1]);
          }
          this.listaPatenta2=test;
          this.listaPatenta2.forEach(element => {
            this.prikazOznakaPatenta(element,this.mapaMetaPodaci);
          });
        }
      )
    }
  }

}
