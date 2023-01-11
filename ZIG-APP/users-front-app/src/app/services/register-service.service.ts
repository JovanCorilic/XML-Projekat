import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterServiceService {

  private path = "http://localhost:9090/register"

  private headers = new HttpHeaders().set('Content-Type', 'application/xml');

  constructor(private http: HttpClient) { }

  register(entity: any) {
    console.log('request send')
    return this.http.post(this.path, entity, { headers: this.headers });
  }
}
