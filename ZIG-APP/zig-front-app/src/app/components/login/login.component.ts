import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Token } from 'src/app/model/token';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  registerForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });


  constructor(private login_serivce: LoginService,private router: Router) {}

  ngOnInit(): void {
  }

  public login(){
    console.log(this.registerForm.value);

    let xml_login_user_text = '<user>'

    + '<username>'
    + this.registerForm.value.username
    + '</username>'

    + '<password>'
    + this.registerForm.value.password
    + '</password>'

    + '</user>';

    this.login_serivce.login(xml_login_user_text).subscribe(
      (tkn: Token) => {
        localStorage.setItem('user_token',tkn.accessToken)

        console.log(tkn.accessToken);

        let my_roles = JSON.parse(atob(tkn.accessToken.split('.')[1]))['roles'].split(',');

        if (my_roles.includes('CITIZEN')) { //ROLE CITIZEN
          this.router.navigate(['/', 'citizen-home']);

        }

        if (my_roles.includes('EMPLOYEE')) { //ROLE EMPLOYEE
          this.router.navigate(['/', 'employee-home']);

        }



      },
    )

  }

}
