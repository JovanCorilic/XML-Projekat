import { PatentService } from 'src/app/SERVICE/patent.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Korisnik } from '../MODEL/Korisnik';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css', './navbar.component.scss']
})
export class NavbarComponent {

  constructor(
    private router: Router,
    private patentService:PatentService
  ){}

  getRole():string{
    const item = localStorage.getItem('user');

    if(!item){
      return "";
    }

    const jwt:JwtHelperService = new JwtHelperService();
    const decodedItem = JSON.parse(item!);
    const info = jwt.decodeToken(decodedItem.accessToken);
    return info['roles'];
  }

  goToHome() {
    this.router.navigate(['']);
  }

  goToPatentCreate(){
    this.router.navigate(['/patent-create']);
  }

  goToSviPatentiNijeProsaoZavod(){
    
    this.router.navigate(['/svi-patent-neprodjeni/false']);
    
  }

  goToSviPatentiProsaoZavod(){
    
    this.router.navigate(['/svi-patent/true']);
   
  }

  goToRegister(){

  }

  goToLogin(){
    this.patentService.login(new Korisnik("1","1")).subscribe(
      res=>{
        localStorage.setItem('user', JSON.stringify(res));
        const item = localStorage.getItem('user');
        const decodedItem = JSON.parse(item!);
        localStorage.setItem('accessToken', decodedItem.accessToken);
        const jwt: JwtHelperService = new JwtHelperService();
        const info = jwt.decodeToken(decodedItem.accessToken);
        localStorage.setItem('roles', info['roles']);
        this.router.navigate(['']);
      }
    )
    //window.location.reload();
  }

  goToLogOut(){
    this.patentService.logout().subscribe(
      res=>{
        localStorage.removeItem('user');
        localStorage.removeItem('accessToken');
       
        this.router.navigate(['']);
      }
    )
  }
}
