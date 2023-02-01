import { XonomyRegistracija } from './../../SERVICE/xonomyRegistracija.service';
import { SecurityService } from './../../SERVICE/security.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
declare const Xonomy: any;
@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent {
  constructor(private securityService:SecurityService,
    private xonomyRegistracija:XonomyRegistracija,
    private router: Router
    ){}

  ngAfterViewInit(): void{
    let element = document.getElementById("editor");
    let xml =
      `<korisnik xmlns="http://www.ftn.uns.rs/KorisnikDTO">
        <korisnicko_ime></korisnicko_ime>
        <lozinka></lozinka>
        <uloga></uloga>
      </korisnik>`;
    
      let specification = this.xonomyRegistracija.RegistracijaSpecification;
      Xonomy.setMode("laic");
      Xonomy.render(xml,element,specification);
      Xonomy.refresh();
  }
  
  send(){
    let text = Xonomy.harvest();
    
    text = '<?xml version="1.0" encoding="UTF-8"?>'+text;
    this.securityService.registracija(text).subscribe(
      res=>{this.router.navigate(['']);}
    )
  }

  back(){
    this.router.navigate(['']);
  }
}
