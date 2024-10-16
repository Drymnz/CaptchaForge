import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ReportErrorInterpreter } from '../../model/Analyzer/ReportErrorInterpreter';

@Injectable({
  providedIn: 'root'
})
export class ListErrorsService {
  private listErrors = new BehaviorSubject<ReportErrorInterpreter[]>([]);

  upDataErrores(errores:ReportErrorInterpreter[]){
    this.listErrors.next(errores);
  }

  getListErroresObservable(){
    return this.listErrors.asObservable();
  }

  constructor() { }
}
