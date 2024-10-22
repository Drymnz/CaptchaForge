// Assuming ListTypeData is an enum, we'll define it first
enum ListTypeData {
    //VARIABLES
    INTEGER,STRING,DECIMAL,CHAR,BOOLEAN,
    NULL,
    //FUNCION
    VOID,
    ID
    
}

class DataValue {
    private value: string;
    private type: ListTypeData;

    constructor(value: string, type: ListTypeData) {
        this.value = value;
        this.type = type;
    }

    public setValue(value: string): void {
        this.value = value;
    }

    public setType(type: ListTypeData): void {
        this.type = type;
    }

    public getValue(): string {
        return this.value;
    }

    public getType(): ListTypeData {
        return this.type;
    }
}

class DataValueDebbuge extends DataValue {
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
}

export { ListTypeData, DataValue, DataValueDebbuge };