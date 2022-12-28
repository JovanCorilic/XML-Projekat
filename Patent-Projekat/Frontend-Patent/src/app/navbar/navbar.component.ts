import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css', './navbar.component.scss']
})
export class NavbarComponent {

  constructor(
    private router: Router
  ){}

  goToHome() {
    this.router.navigate(['']);
  }

  goToPatentCreate(){
    this.router.navigate(['/patent-create']);
  }

  goToSviPatenti(){
    this.router.navigate(['/svi-patent'])
  }

  goToLogOut(){}
}
