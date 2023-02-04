import { XonomyLogin } from './../../SERVICE/xonomyLogin.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SecurityService } from 'src/app/SERVICE/security.service';
import { XonomyRegistracija } from 'src/app/SERVICE/xonomyRegistracija.service';
import { JwtHelperService } from '@auth0/angular-jwt';
declare const Xonomy: any;
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private securityService:SecurityService,
    private xonomyLogin:XonomyLogin,
    private router: Router){}

  ngAfterViewInit(): void{
    let element = document.getElementById("editor");
    let xml =
      `<korisnik xmlns="http://www.ftn.uns.rs/KorisnikDTO">
        <korisnicko_ime></korisnicko_ime>
        <lozinka></lozinka>
        <uloga></uloga>
      </korisnik>`;
    
      let specification = this.xonomyLogin.LoginSpecification;
      Xonomy.setMode("laic");
      Xonomy.render(xml,element,specification);
      Xonomy.refresh();
  }
  
  send(){
    let text = Xonomy.harvest();
    
    text = '<?xml version="1.0" encoding="UTF-8"?>'+text;
    this.securityService.login(text).subscribe(
      res=>{
        localStorage.setItem('user', JSON.stringify(res));
        const item = localStorage.getItem('user');
        const decodedItem = JSON.parse(item!);
        localStorage.setItem('accessToken', decodedItem.accessToken);
        const jwt: JwtHelperService = new JwtHelperService();
        const info = jwt.decodeToken(decodedItem.accessToken);
        localStorage.setItem('roles', info['roles']);
        console.log(localStorage.getItem('accessToken'));
        this.router.navigate(['']);
      },
      error=>{
        alert("Nije moguć login sa unetim podacima!");
      }
    )
  }

  back(){
    this.router.navigate(['']);
  }
}
