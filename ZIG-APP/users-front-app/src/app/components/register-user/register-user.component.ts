import { RegisterServiceService } from './../../services/register-service.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {


  registerForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl(''),
  });


  constructor(private register_service : RegisterServiceService) { }

  ngOnInit(): void {
  }

  public register(){
    console.log(this.registerForm.value);

    let role = '';
    if(this.registerForm.value.role){
      role = '<role>CITIZEN</role>'
    }
    else{
      role = '<role>EMPLOYEE</role>'
    }


    let xml_register_user_text = '<user>'

    + '<username>'
    + this.registerForm.value.username
    + '</username>'

    + '<password>'
    + this.registerForm.value.password
    + '</password>'

    + role

    + '</user>';

    console.log(xml_register_user_text);

    this.register_service.register(xml_register_user_text).subscribe(
      res => {
        console.log(res);
      },
    )
    console.log('sent user');
  }



}
