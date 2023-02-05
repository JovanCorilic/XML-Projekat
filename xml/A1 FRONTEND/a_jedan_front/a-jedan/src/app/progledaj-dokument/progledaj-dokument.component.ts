import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';
import { XonomyService } from '../xonomy.service';
import { Entity } from 'src/model/Entity';
import { DownloadServiceService } from 'src/app/download-service.service';
import { FileData } from 'src/model/FileData';
import { saveAs } from 'file-saver';

declare const Xonomy: any

@Component({
  selector: 'app-progledaj-dokument',
  templateUrl: './progledaj-dokument.component.html',
  styleUrls: ['./progledaj-dokument.component.css']
})
export class ProgledajDokumentComponent implements OnInit {
  public href: string = "";
  fileList?: FileData[];
  constructor(private xonomyService: XonomyService, private router: Router, private http: HttpClient, private downloadService: DownloadServiceService) { }
  private path = "http://localhost:8080/getAJedan/";//Dokument naziv

  ngOnInit(): void {
    this.href = this.router.url;//sluzbenikPrihvatiDokument?Dokument=A1-DrugaKonstolnaTacka
    this.getDokument(this.path + this.router.url.substring(this.router.url.length - ((this.router.url.length) -( this.router.url.indexOf('=')+1))));
  }


  getDokument(link:string) {
    console.log(link);
    return this.http.get(link, { responseType: 'text' }).subscribe(data => {
      let element = document.getElementById("editor");
      let specification = this.xonomyService.A1Specification;
      let xmlString = data;
      console.log(data);
      Xonomy.render(xmlString, element, specification);
    })
  }

  preuzmixhtml(){
    console.log("XHTML");
    let url_o = "http://localhost:8080/sacuvajKaoXHTML/" + this.router.url.substring(this.router.url.length - ((this.router.url.length) -( this.router.url.indexOf('=')+1)));

    this.http.get(url_o).subscribe();//console.log(data),

    this.downloadService
      .downloadXHTML()
      .subscribe(blob => saveAs(blob, "A-1.xhtml"));
  
  }

  preuzmipdf(){
    console.log("PDF");
    let url_p = "http://localhost:8080/sacuvajKaoPDF/" + this.router.url.substring(this.router.url.length - ((this.router.url.length) -( this.router.url.indexOf('=')+1)));

    this.http.get(url_p).subscribe();//console.log(data),

    this.downloadService
      .downloadPDF()
      .subscribe(blob => saveAs(blob, "A-1.pdf"));
  }

  delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
  }
}
