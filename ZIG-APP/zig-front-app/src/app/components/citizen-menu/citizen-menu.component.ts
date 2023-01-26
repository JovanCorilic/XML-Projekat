import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-citizen-menu',
  templateUrl: './citizen-menu.component.html',
  styleUrls: ['./citizen-menu.component.scss']
})
export class CitizenMenuComponent implements OnInit {


  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  public logout() {
    localStorage.clear();
  }

}
