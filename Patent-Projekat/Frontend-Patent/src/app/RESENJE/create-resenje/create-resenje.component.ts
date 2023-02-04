import { ResenjeService } from './../../SERVICE/resenje.service';
import { XonomyResenjeCreateService } from '../../SERVICE/xonomyResenjeCreateService.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

declare const Xonomy: any;
@Component({
  selector: 'app-create-resenje',
  templateUrl: './create-resenje.component.html',
  styleUrls: ['./create-resenje.component.css']
})
export class CreateResenjeComponent {
  constructor(private xonomyResenjeService: XonomyResenjeCreateService,
    private router: Router,
    private resenjeService: ResenjeService){}

  ngAfterViewInit(): void{
    let element = document.getElementById("editor");
    let xml = 
    `<resenje xmlns="http://www.ftn.uns.rs/ResenjePatent"
     id="" xmlns:pred="http://www.ftn.uns.ac.rs/rdf/resenje/predicate/">
      <datum_odluke_o_zahtevu about="http://www.ftn.uns.ac.rs/rdf/resenjePatent" property="pred:datumOdlukeOZahtevu" datatype="xs:string"></datum_odluke_o_zahtevu>
      <da_li_je_prosao>
      </da_li_je_prosao>
      <sluzbenik about="http://www.ftn.uns.ac.rs/rdf/resenjePatent">
          <ime property="pred:ime" datatype="xs:string"></ime>
          <prezime property="pred:prezime" datatype="xs:string"></prezime>
      </sluzbenik>
      <referenca_na_zahtev></referenca_na_zahtev>
    </resenje>`
    
    let specification = this.xonomyResenjeService.resenjeSpecification;
    Xonomy.setMode("laic");
    Xonomy.render(xml,element,specification);
    Xonomy.refresh();
  }

  send(){
    let text = Xonomy.harvest();
    
    text = '<?xml version="1.0" encoding="UTF-8"?>'+text;
    this.resenjeService.sendResenje(text).subscribe(
      res=>{this.router.navigate(['']);},
      error=>{
        alert("Podaci nisu pravilni")
      }
    )
  }

  back(){
    this.router.navigate(['']);
  }
}
