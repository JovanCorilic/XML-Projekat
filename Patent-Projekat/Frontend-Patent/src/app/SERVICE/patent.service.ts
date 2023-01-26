import { Patent } from './../MODEL/Patent';
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn:'root'
})
export class PatentService{
    constructor(private http: HttpClient){}

    private path = "http://localhost:8080/api/patent"

    sendXml(entity: Patent) {
        return this.http.post(this.path+'/xonomyCreate', entity);
      }
      
    sviPatenti():Observable<string[]>{
      return this.http.get<string[]>(this.path+'/getAll');
    }

    getPatent(id:string):Observable<Patent>{
      return this.http.post<Patent>(this.path+'/getXMLDocument',new Patent(id));
    }

    searchMetapodaci(odluka:string, opcija:string):Observable<Patent>{
      return this.http.get<Patent>(this.path+'/fusekiSearch'+`/${odluka}`+`/${opcija}`);
    }

    searchTekstualniSadrzaj(odluka:string):Observable<string[]>{
      return this.http.get<string[]>(this.path+'/pretragaPoTekstualnomSadrzaju'+`/${odluka}`);
    }

    downloadRDF(id:string):Observable<Patent>{
      return this.http.get<Patent>(this.path+"/downloadRDF"+`/${id}`);
    }
}