import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-citizen-menu',
  templateUrl: './citizen-menu.component.html',
  styleUrls: ['./citizen-menu.component.scss']
})
export class CitizenMenuComponent implements OnInit {

  active = 1;

  constructor() { }

  ngOnInit(): void {
  }

  public logout() {
    localStorage.clear();
  }

}
