import { ErrorTypeInTheInterpreter } from "./ErrorTypeInTheInterpreter";
import { Token } from "./Token";

export class ReportErrorInterpreter {
    private type: ErrorTypeInTheInterpreter;
    private toke: Token;
    private description: string;

    constructor(type: ErrorTypeInTheInterpreter, toke: Token, description: string) {
        this.type = type;
        this.toke = toke;
        this.description = description;
    }

    public getType(): ErrorTypeInTheInterpreter {
        return this.type;
    }

    public getToke(): Token {
        return this.toke;
    }

    public getDescription(): string {
        return this.description;
    }

    public toString(): string {
        return `- Tipo de error: ${this.type}\n - Token afectado: ${this.toke.toString()}\n - Descripción: ${this.description}`;
    }

    public static fromJSON(data: any): ReportErrorInterpreter {
        return new ReportErrorInterpreter(
            data.type || '',
            Token.fromJSON(data.toke),
            data.description || ''
        );
    }
}