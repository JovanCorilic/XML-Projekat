import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Entity } from 'src/model/Entity';

@Injectable({
  providedIn: 'root'
})
export class AjedanService {

  constructor(private http: HttpClient) { }
  private path = "http://localhost:8080/novi-dokument"

  sendXml(entity: Entity) {
    return this.http.post(this.path, entity).subscribe(data => {
      console.log(data);
      if(data == "<Odgovor>Uspeh</Odgovor>"){
        console.log("Uspelo");
        alert("Uspesno ste Dodali dokument u bazu")
      }else if(data == "<Odgovor>Vec Postoji</Odgovor>"){
        console.log("Dokument vec postoji");
        alert("Dokument sa tim imenom vec postoji")
      }else{
        console.log("Nije uspelo");
        alert("Doslo je do greske pri prihvatanju zahteva, molimo vas proverite da li ste povezani na internet")
      }
    })
  }
}
