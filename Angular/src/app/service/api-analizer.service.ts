import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiAnalizerService {

  private urlApi = 'http://localhost:8080/analizer/cc/';

  // Cambia `hhtp` a `http`
  constructor(private http: HttpClient) { }

  public getData(text: string): Observable<String[]> {
    return this.http.get<String[]>(this.urlApi + text);
  }
}
