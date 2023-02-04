import { SecurityService } from './../SERVICE/security.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css', './navbar.component.scss']
})
export class NavbarComponent {

  constructor(
    private router: Router,
    private securityService:SecurityService
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

  goToCreateResenje(){
    this.router.navigate(['/createResenja']);
  }

  goToSvaResenja(){
    this.router.navigate(['/svaResenja']);
  }

  goToRegister(){
    this.router.navigate(['/registracija']);
  }

  goToLogin(){
    this.router.navigate(['/login']);
    //window.location.reload();
  }

  goToLogOut(){
    this.securityService.logout().subscribe(
      res=>{
        localStorage.removeItem('user');
        localStorage.removeItem('accessToken');
       
        this.router.navigate(['']);
      }
    )
  }
}
