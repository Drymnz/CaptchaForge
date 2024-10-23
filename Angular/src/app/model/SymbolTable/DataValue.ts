import { ListTypeData } from "./ListTypeData";

export class DataValue {
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