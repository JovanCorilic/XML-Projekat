import { FormBuilder, FormGroup } from '@angular/forms';
import { Konverzija } from './../../SERVICE/konverzija.service';
import { XonomyViseMetapodatakaService } from './../../SERVICE/xonomyViseMetapodataka.service';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatentService } from 'src/app/SERVICE/patent.service';

declare const Xonomy: any;
@Component({
  selector: 'app-pretraga-vise-metapodataka',
  templateUrl: './pretraga-vise-metapodataka.component.html',
  styleUrls: ['./pretraga-vise-metapodataka.component.css']
})
export class PretragaViseMetapodatakaComponent {

  temp:string|null;
  prodjeno:boolean=false;
  lista:string[] = [];
  mapaMetaPodaci:Map<string,string>;
  odlukaForm:FormGroup;

  constructor(private xonomyViseMetapodatakaService: XonomyViseMetapodatakaService,
    private router: Router,
    private route:ActivatedRoute,
    private patentService: PatentService,
    private fBuilder:FormBuilder){
      this.temp=this.route.snapshot.paramMap.get('prodjeno');
      this.mapaMetaPodaci = new Map();
      this.odlukaForm = this.fBuilder.group({
        odluka:""
      });
    }

    ngAfterViewInit(): void{
      let element = document.getElementById("editor");

      let xml = 
      `<metapodaci xmlns="http://www.ftn.uns.rs/Metapodaci">
          <broj_prijave></broj_prijave>
          <priznati_datum_podnosenja></priznati_datum_podnosenja>
          <srpski_naziv></srpski_naziv>
          <engleski_naziv></engleski_naziv>
      </metapodaci>`
      
      let specification = this.xonomyViseMetapodatakaService.ViseMetapodatakaSpecification;
      Xonomy.setMode("laic");
      Xonomy.render(xml,element,specification);
      Xonomy.refresh();
      
    }
  
    send(){
      let text = Xonomy.harvest();
      text = '<?xml version="1.0" encoding="UTF-8"?>'+text;
      let opcija = this.odlukaForm.value['opcija'];
      this.patentService.searchViseMetapodataka(text,opcija).subscribe(
        res=>{
          let rezultat = Konverzija.uzimanjePodatakaXMLDto(res);
          let test:string[] = [];
          
          let tempLista = rezultat.split('\n');
          
          for(let i = 0;i<tempLista.length;i++){
            if(!tempLista[i].includes("http://www.ftn.uns.ac.rs/rdf/patent"))
              continue;
            let tempLista2 = tempLista[i].split("/");
            test.push(tempLista2[tempLista2.length-1]);
          }
          this.lista=test;
          this.lista.forEach(element => {
            this.prikazOznakaPatenta(element,this.mapaMetaPodaci);
          });
        }
      )
    }

    prikazOznakaPatenta(id:string,Mapa:Map<string,string>){
      this.patentService.getOznakePatenta(id).subscribe(
        res=>{
          Mapa.set(id,Konverzija.uzimanjePodatakaXMLDto(res));
        }
      );
  
    }

    idiNaEditPatenta(patent:string){
      this.router.navigate(['/edit-patent/'+patent+'/'+this.prodjeno]);
    }
  
    back(){
      if(this.temp != null)
        this.prodjeno = this.convertToBoolean(this.temp);
      if(this.prodjeno)
        this.router.navigate(['/svi-patent/true']);
      else
        this.router.navigate(['/svi-patent-neprodjeni/false']);
    }

    convertToBoolean(input: string): boolean {
      try {
          return JSON.parse(input.toLowerCase());
      }
      catch (e) {
          return false;
      }
    }
}


