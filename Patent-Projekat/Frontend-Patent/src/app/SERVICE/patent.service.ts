import { Korisnik } from './../MODEL/Korisnik';
import { PatentLista } from './../MODEL/PatentLista';

import { Patent } from './../MODEL/Patent';
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn:'root'
})
export class PatentService{
    constructor(private http: HttpClient){}
    //{ responseType: 'string' }
    private path = "http://localhost:8080/api/patent";
    private headers = new HttpHeaders().set('Content-Type', 'application/xml');
    HTTPOptions:Object = {

      headers: new HttpHeaders({
          'Content-Type': 'application/xml',
          'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Headers': "Access-Control-Allow-Headers, Access-Control-Allow-Origin, Access-Control-Request-Method"
      }),
      responseType: 'text'
   }

    //Pravljenje i edit xml-a -----------------------------------------------------------------------------

    sendXml(entity: string) {
        return this.http.post(this.path+'/xonomyCreate', entity,{headers: this.headers});
    }

    editXml(entity: string) {
      return this.http.put(this.path+'/xonomyEdit', entity,{headers: this.headers});
    }

    //Operacije prikaz svih xml-ova ---------------------------------------------------------------------

    sviPatentiNijeProsaoZavod():Observable<any>{
      return this.http.get<any>(this.path+'/getAllNijeProsaoZavod',this.HTTPOptions);
    }
      
    sviPatentiProsaoZavod():Observable<any>{
      return this.http.get<any>(this.path+'/getAll',this.HTTPOptions);
    }

    //Operacije dobijanje xml-a ---------------------------------------------------------------------------------

    getPatent(id:string):Observable<any>{
      return this.http.get<any>(this.path+'/getXMLDocument'+`/${id}`,this.HTTPOptions);
    }

    getPatentSrpskiEngleskiNaziv(id:string):Observable<any>{
      return this.http.get<any>(this.path+'/pretragaPoNazivu'+`/${id}`,this.HTTPOptions);
    }

    getOznakePatenta(id:string):Observable<any>{
      return this.http.get<any>(this.path+"/getOznakePatenta"+`/${id}`,this.HTTPOptions);
    }

    //Operacije pretraga xml-a i metapodataka -------------------------------------------------------------------------

    searchMetapodaci(odluka:string, opcija:string):Observable<any>{
      return this.http.get<any>(this.path+'/fusekiSearch'+`/${odluka}`+`/${opcija}`,this.HTTPOptions);
    }

    searchTekstualniSadrzaj(odluka:string):Observable<any>{
      return this.http.get<any>(this.path+'/pretragaPoTekstualnomSadrzaju'+`/${odluka}`,this.HTTPOptions);
    }

    //Operacije download raznih stvari ----------------------------------------------------------------------------------

    downloadRDF(id:string):Observable<any>{
      return this.http.get<any>(this.path+"/downloadRDF"+`/${id}`,this.HTTPOptions);
    }

    downloadHTML(id:string):Observable<any>{
      return this.http.get<any>(this.path+"/downloadHTML"+`/${id}`,this.HTTPOptions);
    }

    downloadPDF(id:string){
      window.location.href = this.path + "/downloadPDF"+`/${id}`;
      /*let HTTPOptions:Object = {
        headers : new HttpHeaders({
          'Content-Type': 'application/xml',
            'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
            
            'Accept': 'application/pdf'
        }),
        responseType: 'blob'
      }
      return this.http.get(this.path+"/downloadPDF"+`/${id}`, HTTPOptions);*/
      //return this.http.get<any>(this.path+"/downloadPDF"+`/${id}`,this.HTTPOptions);
    }

    downloadJSON(id:string){
      return this.http.get<any>(this.path+"/downloadJSON"+`/${id}`,this.HTTPOptions);
    }

    //Provera logina ------------------------------------------------------------------

    login(korisnik:Korisnik):Observable<any>{

      return this.http.post(this.path+"/login",korisnik)
      
    }

    logout():Observable<any>{
        return this.http.get(this.path+"/logout");
    }

    isLoggedIn():boolean{
      if(!localStorage.getItem('user')){
          return false;
      }
      return true;
  }
}