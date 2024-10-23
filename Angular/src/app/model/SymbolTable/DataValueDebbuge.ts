import { DataValue } from "./DataValue";
import { ListTypeData } from "./ListTypeData";

export class DataValueDebbuge extends DataValue {
    private modo: boolean;
    private procedure: string;
    private id: string;
    private line: number;

    constructor(
        value: string, 
        type: ListTypeData, 
        modo: boolean, 
        procedure: string, 
        id: string, 
        line: number
    ) {
        super(value, type);
        this.modo = modo;
        this.procedure = procedure;
        this.id = id;
        this.line = line;
    }

    public isModo(): boolean {
        return this.modo;
    }

    public setModo(modo: boolean): void {
        this.modo = modo;
    }

    public getProcedure(): string {
        return this.procedure;
    }

    public setProcedure(procedure: string): void {
        this.procedure = procedure;
    }

    public getId(): string {
        return this.id;
    }

    public setId(id: string): void {
        this.id = id;
    }

    public getLine(): number {
        return this.line;
    }

    public setLine(line: number): void {
        this.line = line;
    }

    public static fromJSON(data: any): DataValueDebbuge {
        return new DataValueDebbuge(
            data.value || '',
            data.type || '',
            data.modo || false,
            data.procedure || '',
            data.id || '',
            data.line || 0
        );
    }
}
