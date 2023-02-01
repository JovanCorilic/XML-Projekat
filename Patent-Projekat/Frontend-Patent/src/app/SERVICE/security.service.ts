import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class SecurityService{
    constructor(private http: HttpClient){}
    //{ responseType: 'string' }
    private path = "http://localhost:8080/api/security";
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

   login(text:string):Observable<any>{

    return this.http.post(this.path+"/login",text,{headers: this.headers})
  }

  registracija(text:string):Observable<any>{

    return this.http.post(this.path+"/register",text,this.HTTPOptions)
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