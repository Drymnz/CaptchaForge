package com.cunoc.CaptchaForge.Model.JflexAndCup;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Scripting.LexemaScripting;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Scripting.ParserScripting;
import java.util.ArrayList;

public class AnalyzerScripting {
    private LexemaScripting lexema;
    private ParserScripting parser;

    public AnalyzerScripting(String text) {
        this.lexema = new LexemaScripting(text);
        this.parser = new ParserScripting(this.lexema);
    }

    public void analyzer() {
        try {
            this.parser.parse();
        } catch (Error e) {
            System.err.println("Error capturado: " + e.getMessage());
            e.printStackTrace(); // Imprime el stack trace del error en la consola
        } catch (Exception e) {
            System.err.println("Excepción capturada: " + e.getMessage());
            e.printStackTrace(); // Imprime el stack trace de la excepción en la consola
        }
    }

    // return si hay errores
    public boolean isError() {
        return (this.lexema.getListError().size() > 0 || this.parser.getListError().size() > 0 || this.parser.getAnalyzerSemantico().getListError().size() > 0);
    }

    // Returnar el listado de errores
    public ArrayList<ReportErrorInterpreter> getListError() {
        ArrayList<ReportErrorInterpreter> returnListErro = new ArrayList<>();
        returnListErro.addAll(this.lexema.getListError());
        returnListErro.addAll(this.parser.getListError());
        returnListErro.addAll(this.parser.getAnalyzerSemantico().getListError());
        return returnListErro;
    }
}
