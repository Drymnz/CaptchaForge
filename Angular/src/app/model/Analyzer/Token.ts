export class Token {
  private line: number;
  private columna: number;
  private lexeme: string;

  constructor(line: number, columna: number, lexeme: string) {
    this.line = line;
    this.columna = columna;
    this.lexeme = lexeme;
  }

  public getLine(): number {
    return this.line;
  }

  public getColumna(): number {
    return this.columna;
  }

  public getLexeme(): string {
    return this.lexeme;
  }

  public toString(): string {
    return `-line:${this.line}-columna:${this.columna}-lexeme:${this.lexeme}`;
  }

  public static fromJSON(data: any): Token {
    return new Token(
        data?.line || 0,
        data?.columna || 0,
        data?.lexeme || ''
    );
}
}
