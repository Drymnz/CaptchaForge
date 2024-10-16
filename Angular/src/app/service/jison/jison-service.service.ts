import { Injectable } from '@angular/core';

import * as Calculadora from'../../../assets/Calculadora.js';

@Injectable({
  providedIn: 'root'
})
export class JisonServiceService {

  constructor() { }

  parse(input: string): any {
    try {
      return Calculadora.parser.parse(input);
    } catch (error) {
      console.error('Error al analizar la entrada:', error);
      throw error;
    }
  }
}
