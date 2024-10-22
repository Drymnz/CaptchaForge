import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
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
    return this.http.post<GenerarSolicitudCaptcha>(this.urlPostGenerarSoliticudCaptcha,generarSolititudCaptCha).pipe(
      retry(2), // Opción 1: Reintentar la solicitud 2 veces en caso de error
      catchError(this.handleError) // Opción 2: Manejar el error
    );
  }


  public getListCaptcha(): Observable<String>{
    return this.http.get<String>(this.urlApi+this.urlGetListCaptcha).pipe(
      catchError(this.handleError) // Opción 2: Manejar el error
    );
  }

   // Manejo centralizado de errores
   private handleError(error: HttpErrorResponse): Observable<never> {
    let errorMsg: string;

    if (error.error instanceof ErrorEvent) {
      // Error del lado del cliente
      errorMsg = `Error del cliente: ${error.error.message}`;
    } else {
      // Error del lado del servidor
      errorMsg = `Error del servidor: Código ${error.status}, ${error.message}`;
    }

    console.error(errorMsg); // Opción 3: Loguear el error en la consola
    return throwError(() => new Error(errorMsg)); // Opción 4: Lanzar un error observable
  }
}
