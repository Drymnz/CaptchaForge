import { ReportErrorInterpreter } from "./Analyzer/ReportErrorInterpreter";

export class GenerarSolicitudCaptcha {
    private textAnalyzer: string;
    private id: string;
    private listError: ReportErrorInterpreter[];

    constructor(textAnalyzer: string, id: string, listError: ReportErrorInterpreter[]) {
        this.textAnalyzer = textAnalyzer;
        this.id = id;
        this.listError = listError;
    }

    public static fromJSON(data: any): GenerarSolicitudCaptcha {
        return new GenerarSolicitudCaptcha(
            data.textAnalyzer || '',
            data.id || '',
            data.listError || []
        );
    }

    public getTextAnalyzer(): string {
        return this.textAnalyzer;
    }

    public getListError(): ReportErrorInterpreter[] {
        return this.listError;
    }

    public getId(): string {
        return this.id;
    }
}
