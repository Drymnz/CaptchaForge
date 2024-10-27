export class ReportCaptcha {
    constructor(
        private id: string,
        private numberHits: number,
        private numberFaill: number,
        private lastData: string
    ) {}

    // Getters
    public getId(): string {
        return this.id;
    }

    public getNumberHits(): number {
        return this.numberHits;
    }

    public getNumberFaill(): number {
        return this.numberFaill;
    }

    public getLastData(): string {
        return this.lastData;
    }

    // Setters
    public setId(id: string): void {
        this.id = id;
    }

    public setNumberHits(numberHits: number): void {
        this.numberHits = numberHits;
    }

    public setNumberFaill(numberFaill: number): void {
        this.numberFaill = numberFaill;
    }

    public setLastData(lastData: string): void {
        this.lastData = lastData;
    }

    // Método para crear una instancia desde un objeto JSON
    public static fromJSON(data: any): ReportCaptcha {
        return new ReportCaptcha(
            data.id || '',
            data.numberHits || 0,
            data.numberFaill || 0,
            data.lastData || ''
        );
    }
}