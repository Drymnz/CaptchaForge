import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenerarSolicitudCaptcha } from '../../model/GenerarSolicitudCaptcha';

@Injectable({
  providedIn: 'root'
})
export class ApiAnalizerService {

  private urlApi = 'http://localhost:8080/';
  private urlGetListCaptcha = 'list-captcha';
  private urlPostGenerarSoliticudCaptcha = this.urlApi + 'analyzer/generate-captcha';

  // Cambia `hhtp` a `http`
  constructor(private http: HttpClient) { }

  public postSolititudCaptchaAnalyzer(generarSolititudCaptCha: GenerarSolicitudCaptcha): Observable<GenerarSolicitudCaptcha> {
    return this.http.post<GenerarSolicitudCaptcha>(this.urlPostGenerarSoliticudCaptcha,generarSolititudCaptCha);
  }


  public getListCaptcha(): Observable<String>{
    return this.http.get<String>(this.urlApi+this.urlGetListCaptcha);
  }
}
