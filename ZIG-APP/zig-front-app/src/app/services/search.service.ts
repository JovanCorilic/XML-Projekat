import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Doc } from '../model/search';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private path = "http://localhost:8888/trademark/";

  private download = "http://localhost:8888/all/document/"

  private headers = new HttpHeaders().set('Content-Type', 'application/xml');

  constructor(private http: HttpClient) { }

  textSearch(role:string,text: string): Observable<Doc[]> {
    return this.http.get<Doc[]>(this.path + 'search/' + role + '/' + text, { headers: this.headers });
  }

  metadataSearch(metadata: string): Observable<Doc[]> {
    return this.http.post<Doc[]>(this.path + 'search/metadata', metadata , { headers: this.headers });
  }

  generateHTML(uuid: string){
    window.location.href = this.download + 'html/' + uuid;
    // return this.http.get(this.download + 'html/' + uuid, { headers: this.headers });
  }

  generatePDF(uuid: string){
    window.location.href = this.download + 'pdf/' + uuid;
    // return this.http.get(this.download + 'pdf/' + uuid, { headers: this.headers });
  }

  generateRDF(uuid: string){
    // console.log('URL: ' + this.download + 'rdf/' + uuid);
    window.location.href = this.download + 'rdf/' + uuid;
    // return this.http.get(this.download + 'rdf/' + uuid, { headers: this.headers });
  }

  generateJSON(uuid: string){
    window.location.href = this.download + 'json/' + uuid;
    // return this.http.get(this.download + 'json/' + uuid, { headers: this.headers });
  }

  generateSolutionHTML(uuid: string){
    window.location.href = this.download + 'solution/html/' + uuid;
    // return this.http.get(this.download + 'solution/html/' + uuid, { headers: this.headers });
  }

  generateSolutionPDF(uuid: string){
    window.location.href = this.download + 'solution/pdf/' + uuid;
    // return this.http.get(this.download + 'solution/pdf/' + uuid, { headers: this.headers });
  }

  generateReportPDF(start: string,end:string){
    window.location.href = this.download + 'report/pdf/' + start + '/' + end;
    // return this.http.get(this.download + 'report/pdf/' + start + '/' + end, { headers: this.headers });
  }

  error(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}
