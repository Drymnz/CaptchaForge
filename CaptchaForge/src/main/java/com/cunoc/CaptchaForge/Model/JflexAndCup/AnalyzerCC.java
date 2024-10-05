package com.cunoc.CaptchaForge.Model.JflexAndCup;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CC.*;
import java.util.ArrayList;

public class AnalyzerCC {
    private LexemaCC lexer;
    private ParserCC parser;

    public AnalyzerCC(String text) {
        this.lexer = new LexemaCC(text);
        this.parser = new ParserCC(lexer);
    }

    public void analyzer() {
        try {
            this.parser.parse();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //return si hay errores
    public boolean isError(){
        return (this.lexer.getListError().size() > 0 || this.parser.getListError().size() > 0);
    }

    //Returnar el listado de errores
    public ArrayList<ReportErrorInterpreter> getListError() {
        ArrayList<ReportErrorInterpreter> returnListErro = new ArrayList<>();
        returnListErro.addAll(this.lexer.getListError());
        returnListErro.addAll(this.parser.getListError());
        return returnListErro;
    }

}
