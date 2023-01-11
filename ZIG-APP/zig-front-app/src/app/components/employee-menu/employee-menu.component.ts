import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-menu',
  templateUrl: './employee-menu.component.html',
  styleUrls: ['./employee-menu.component.scss']
})
export class EmployeeMenuComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  public logout() {
    localStorage.clear();
  }
}
