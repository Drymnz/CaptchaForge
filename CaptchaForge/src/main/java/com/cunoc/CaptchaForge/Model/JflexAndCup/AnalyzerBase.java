package com.cunoc.CaptchaForge.Model.JflexAndCup;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import java.util.ArrayList;

public abstract class AnalyzerBase {

    // Método que ejecuta el análisis. Implementación delegada a la subclase.
    public void analyzer() {
        try {
            executeParse();
        } catch (Error e) {
            System.err.println("Error capturado: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Excepción capturada: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Métodos abstractos que las subclases deben implementar.
    protected abstract void executeParse() throws Exception;

    public abstract boolean isError();

    public abstract ArrayList<ReportErrorInterpreter> getListError();
}
