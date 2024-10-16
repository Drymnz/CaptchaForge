import { Injectable } from '@angular/core';
declare const parse: (input: string) => any;

@Injectable({
  providedIn: 'root'
})
export class JisonServiceService {

  constructor() { }

  parse(input: string): any {
    try {
      return parse(input);
    } catch (error) {
      console.error('Error al analizar la entrada:', error);
      throw error;
    }
  }
}
