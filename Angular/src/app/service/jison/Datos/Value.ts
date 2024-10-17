import { Token } from "../../../model/Analyzer/Token";
import { ListTypeData } from "./ListTypeData";

export class Value extends Token{

    valor: any;
    tipo:ListTypeData;

    constructor(
        line: number,
        column: number,
        lexeme: string,
        valor: any,
        tipo:ListTypeData
      ) {
        super(line, column,lexeme);
        this.valor = valor ;
        this.tipo = tipo ;
      }

      getValorString():String{
        return this.valor as String;
      }

      getType():ListTypeData{
        return this.tipo;
      }
}