import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FileData } from '../model/FileData';

@Injectable({
  providedIn: 'root'
})
export class DownloadServiceService {

  constructor(private http: HttpClient) {
  }

  download(file: string | undefined): Observable<Blob> {
    return this.http.get(`http://localhost:8080/api/files/${file}`, {
      responseType: 'blob'
    });
  }

  downloadXHTML(): Observable<Blob> {
    return this.http.get(`http://localhost:8080/api/files/A-1 XHTML Izlaz.xhtml`, {
      responseType: 'blob'
    });
  }

  downloadPDF(): Observable<Blob> {
    return this.http.get(`http://localhost:8080/api/files/A-1 PDF Izlaz.pdf`, {
      responseType: 'blob'
    });
  }

  downloadJSON(): Observable<Blob> {
    return this.http.get(`http://localhost:8080/api/files/A-1 Meta JSON Izlaz.json`, {
      responseType: 'blob'
    });
  }

  downloadRDF(): Observable<Blob> {
    return this.http.get(`http://localhost:8080/api/files/A-1 Meta RDF Izlaz.rdf`, {
      responseType: 'blob'
    });
  }

  downloadIzvestaj(): Observable<Blob> {
    return this.http.get(`http://localhost:8080/api/files/Izvestaj.pdf`, {
      responseType: 'blob'
    });
  }

  list(): Observable<FileData[]> {
    return this.http.get<FileData[]>(`http://localhost:8080/api/files`);
  }
}