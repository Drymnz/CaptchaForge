import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable, retry, throwError } from 'rxjs';
import { GenerarSolicitudCaptcha } from '../../model/GenerarSolicitudCaptcha';
import { DataValueDebbuge } from '../../model/SymbolTable/DataValueDebbuge';

@Injectable({
  providedIn: 'root',
})
export class ApiAnalizerService {
  private urlApi = 'http://localhost:8080/';
  private urlGetListCaptcha = this.urlApi + 'list-captcha';
  private urlPostGenerarSoliticudCaptcha =
    this.urlApi + 'analyzer/generate-captcha';
  private urlGetSymbo = this.urlApi + 'tabla-simbolos/';
  private urlGetScripting = this.urlApi + 'scripting/';

  // Cambia `hhtp` a `http`
  constructor(private http: HttpClient) {}

  public postSolititudCaptchaAnalyzer(
    generarSolititudCaptCha: GenerarSolicitudCaptcha
  ): Observable<GenerarSolicitudCaptcha> {
    return this.http
      .post<GenerarSolicitudCaptcha>(
        this.urlPostGenerarSoliticudCaptcha,
        generarSolititudCaptCha
      )
      .pipe(
        retry(2), // Opción 1: Reintentar la solicitud 2 veces en caso de error
        catchError(this.handleError) // Opción 2: Manejar el error
      );
  }

  public getListCaptcha(): Observable<String> {
    return this.http.get<String>(this.urlGetListCaptcha).pipe(
      catchError(this.handleError) // Opción 2: Manejar el error
    );
  }

  public getSymbolTable(id: String): Observable<DataValueDebbuge[]> {
    return this.http.get<DataValueDebbuge[]>(this.urlGetSymbo + id).pipe(
      catchError(this.handleError) // Manejar el error
    );
  }

  public getStringScripting(id: String): Observable<String> {
    return this.http
      .get(this.urlGetScripting + id, { responseType: 'text' })
      .pipe(
        map((response) => response || 'Respuesta vacía'), // Manejar respuesta vacía
        catchError(this.handleError) // Manejar el error
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
