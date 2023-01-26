import { Component } from '@angular/core';
//import {xml2js} from 'xml-js' 
declare const Xonomy: any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Frontend-Patent';

  /*ngOnInit():void{
    let xml = `<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <element>
      <temp>Nesto</temp>
      <temp>kurac</temp>
      <temp>Nesto</temp>
    </element>`;
    const object = xml2js(xml);
    console.log(object.elements[0].elements[1].elements[0].text);
    console.log(object.elements[0].elements.length);
    
  }*/
  
}

