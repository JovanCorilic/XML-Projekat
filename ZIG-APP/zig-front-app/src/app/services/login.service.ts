import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Token } from '../model/token';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public apiUrl: string = "http://localhost:8888/auth/login";

  headers = new HttpHeaders().set('Content-Type', 'application/xml');

  constructor(private http: HttpClient) { }

  public login(token: any): Observable<Token> {

    return this.http.post<Token>(`${this.apiUrl}`, token, { headers: this.headers });
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
