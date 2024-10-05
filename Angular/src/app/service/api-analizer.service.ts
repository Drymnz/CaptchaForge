import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenerarSolicitudCaptcha } from '../model/GenerarSolicitudCaptcha';

@Injectable({
  providedIn: 'root'
})
export class ApiAnalizerService {

  private urlApi = 'http://localhost:8080/analyzer';
  private urlPostGenerarSoliticudCaptcha = this.urlApi + '/generate-captcha';

  // Cambia `hhtp` a `http`
  constructor(private http: HttpClient) { }

  public getData(generarSolititudCaptCha: GenerarSolicitudCaptcha): Observable<GenerarSolicitudCaptcha> {
    return this.http.post<GenerarSolicitudCaptcha>(this.urlPostGenerarSoliticudCaptcha,generarSolititudCaptCha);
  }
}
