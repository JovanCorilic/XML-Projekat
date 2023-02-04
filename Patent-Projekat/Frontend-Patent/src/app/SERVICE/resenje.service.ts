import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class ResenjeService{
    constructor(private http: HttpClient){}
    //{ responseType: 'string' }
    private path = "http://localhost:9195/api/resenje";
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

   //Pravljenje, editovanje resenja  ----------------------------------------------------------------------------------------------

    sendResenje(entity: string) {
    return this.http.post(this.path+'/xonomyCreateResenje', entity,{headers: this.headers});
    }

    editResenje(entity: string) {
        return this.http.put(this.path+'/xonomyEditResenje', entity,{headers: this.headers});
    }

    //Lista resenja  ----------------------------------------------------------------------------------------------

    svaResenja():Observable<any>{
        return this.http.get<any>(this.path+'/getAllResenja',this.HTTPOptions);
    }

    //Operacije dobijanja resenja  ----------------------------------------------------------------------------------------------

    getResenje(id:string):Observable<any>{
        return this.http.get<any>(this.path+'/getResenje'+`/${id}`,this.HTTPOptions);
    }

    getReferencuNaZahtev(id:string):Observable<any>{
        return this.http.get<any>(this.path+'/getReferencuNaZahtev'+`/${id}`,this.HTTPOptions);
    }

    getOznakeResenja(id:string):Observable<any>{
        return this.http.get<any>(this.path+"/getOznakeResenja"+`/${id}`,this.HTTPOptions);
    }

    //Operacije pretrage ----------------------------------------------------------------------------------------------
  
    searchTekstualniSadrzajResenje(odluka:string):Observable<any>{
    return this.http.get<any>(this.path+'/pretragaPoTekstualnomSadrzajuResenje'+`/${odluka}`,this.HTTPOptions);
    }

    searchMetapodaciResenje(odluka:string, opcija:string):Observable<any>{
        return this.http.get<any>(this.path+'/fusekiSearchResenje'+`/${odluka}`+`/${opcija}`,this.HTTPOptions);
    }

    //Operacija skidanja pdf izvestaja  ----------------------------------------------------------------------------------------------

    downloadPDF(pocetniDatum:string, krajnjiDatum:string){
        window.location.href = this.path + "/downloadPDF"+`/${pocetniDatum}`+`/${krajnjiDatum}`;
    }
  
}