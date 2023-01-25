
import { Patent } from './../MODEL/Patent';
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn:'root'
})
export class PatentService{
    constructor(private http: HttpClient){}
    //{ responseType: 'string' }
    private path = "http://localhost:8080/api/patent"

    //Pravljenje i edit xml-a -----------------------------------------------------------------------------

    sendXml(entity: Patent) {
        return this.http.post(this.path+'/xonomyCreate', entity);
    }

    editXml(entity: Patent) {
      return this.http.put(this.path+'/xonomyEdit', entity);
    }

    //Operacije prikaz svih xml-ova ---------------------------------------------------------------------

    sviPatentiNijeProsaoZavod():Observable<string[]>{
      return this.http.get<string[]>(this.path+'/getAllNijeProsaoZavod');
    }
      
    sviPatentiProsaoZavod():Observable<string[]>{
      return this.http.get<string[]>(this.path+'/getAll');
    }

    //Operacije dobijanje xml-a ---------------------------------------------------------------------------------

    getPatent(id:string):Observable<Patent>{
      return this.http.post<Patent>(this.path+'/getXMLDocument',new Patent(id));
    }

    getPatentSrpskiEngleskiNaziv(id:string):Observable<Patent>{
      return this.http.get<Patent>(this.path+'/pretragaPoNazivu'+`/${id}`);
    }

    getOznakePatenta(id:string):Observable<Patent>{
      return this.http.get<Patent>(this.path+"/getOznakePatenta"+`/${id}`);
    }

    //Operacije pretraga xml-a i metapodataka -------------------------------------------------------------------------

    searchMetapodaci(odluka:string, opcija:string):Observable<Patent>{
      return this.http.get<Patent>(this.path+'/fusekiSearch'+`/${odluka}`+`/${opcija}`);
    }

    searchTekstualniSadrzaj(odluka:string):Observable<string[]>{
      return this.http.get<string[]>(this.path+'/pretragaPoTekstualnomSadrzaju'+`/${odluka}`);
    }

    //Operacije download raznih stvari ----------------------------------------------------------------------------------

    downloadRDF(id:string):Observable<Patent>{
      return this.http.get<Patent>(this.path+"/downloadRDF"+`/${id}`);
    }

    downloadHTML(id:string):Observable<Patent>{
      return this.http.get<Patent>(this.path+"/downloadHTML"+`/${id}`);
    }

    downloadPDF(id:string){
      window.location.href = this.path + "/downloadPDF"+`/${id}`;
      //return this.http.get<PatentPDF>(this.path+"/downloadPDF"+`/${id}`);
    }
}