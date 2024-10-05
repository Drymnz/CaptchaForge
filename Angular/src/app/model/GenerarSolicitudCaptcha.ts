import { ReportErrorInterpreter } from "./Analyzer/ReportErrorInterpreter";

export class GenerarSolicitudCaptcha {
    private textAnalyzer: string;
    private listError: ReportErrorInterpreter[];

    constructor(textAnalyzer: string, listError: ReportErrorInterpreter[]) {
        this.textAnalyzer = textAnalyzer;
        this.listError = listError;
    }

    public getTextAnalyzer(): string {
        return this.textAnalyzer;
    }

    public getListError(): ReportErrorInterpreter[] {
        return this.listError;
    }

    public setTextAnalyzer(textAnalyzer: string): void {
        this.textAnalyzer = textAnalyzer;
    }
}