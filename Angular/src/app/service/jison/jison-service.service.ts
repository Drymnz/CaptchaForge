import { Injectable } from '@angular/core';
import * as Analyzer from'../../model/jison/Analyzer.js';
import { CaptchaLink } from '../../model/CaptchaLink.js';
import { Value } from './Datos/Value.js';
import { ListTypeData } from './Datos/ListTypeData.js';
import { Token } from '../../model/Analyzer/Token.js';

@Injectable({
  providedIn: 'root'
})
export class JisonServiceService {

  private analyzer = Analyzer.parser
  

  constructor() {
  }

  parse(input: string): any {
    try {
      if (input != null) {
        this.analyzer.yy.CaptchaLink = CaptchaLink;
      this.analyzer.yy.Value = Value;
      this.analyzer.yy.ListTypeData = ListTypeData;
      this.analyzer.yy.Token = Token;
      return this.analyzer.parse(input);
      }
      else{
        return "";
      }
    } catch (error) {
      console.error('Error al analizar la entrada:', error);
      throw error;
    }
  }
}
