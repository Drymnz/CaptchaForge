import { Injectable } from '@angular/core';

import * as Calculadora from'../../../assets/Calculadora.js';


@Injectable({
  providedIn: 'root'
})
export class JisonServiceService {

  constructor() { }

  parse(input: string): any {
    try {
      console.log(Calculadora.parser.parse("15+15"))
      console.log(input)
      return [];
    } catch (error) {
      console.error('Error al analizar la entrada:', error);
      throw error;
    }
  }
}
