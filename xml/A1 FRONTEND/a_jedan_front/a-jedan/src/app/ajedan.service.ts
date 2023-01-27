import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Entity } from 'src/model/Entity';

@Injectable({
  providedIn: 'root'
})
export class AjedanService {

  constructor(private http: HttpClient) { }
  private path = "http://localhost:8080/api/xml/novi-dokument"

  sendXml(entity: Entity) {
    return this.http.post(this.path, entity).subscribe();
  }
}
