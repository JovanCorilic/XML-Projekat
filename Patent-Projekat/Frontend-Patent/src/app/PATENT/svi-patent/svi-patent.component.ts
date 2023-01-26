import { PatentService } from 'src/app/SERVICE/patent.service';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup  } from '@angular/forms';
import { Router } from '@angular/router';

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

  constructor(
    private patentService:PatentService,
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
   }

  get form():{ [key: string]: AbstractControl; }
  {
      return this.resForm.controls;
  }

  ngOnInit(): void {
    this.patentService.sviPatenti().subscribe(
      res=>{
        this.listaPatenta=res;
      }
    )
  }

  idiNaEditPatenta(patent:string){
    this.router.navigate(['/edit-patent/'+patent]);
  }

  pretraziPrekoMetapodatak(){
    if (this.resForm.value["odluka"]==""){
      alert("Polje za unos metapodataka mora biti popunjeno!");
    }else{
      this.opcija = this.resForm.value["opcija"];
      this.patentService.searchMetapodaci(this.resForm.value["odluka"], this.resForm.value["opcija"]).subscribe(
        res=>{
          this.rezultat = res.text;
          
          if (this.opcija == "1"){
            
            let test:string[] = [];
            
            this.rezultat.split('\n').forEach(function(value){
              
              if(value!=""){
                let temp:string = value.split('^')[0].trim()
                test.push(temp+"%20")
              }
            });
            this.listaPatenta2=test;
          }
        }
      )
    }
  }

  pretraziPoTekstualnomSadrzaju(){
    if (this.res2Form.value["odluka2"]==""){
      alert("Polje unos za pretragu tekstualnog sadrzaja mora biti popunjeno!");
    }else{
      this.patentService.searchTekstualniSadrzaj(this.res2Form.value["odluka2"]).subscribe(
        res=>{
          this.opcija="1";
          this.listaPatenta2=res;
        }
      )
    }
  }
}
