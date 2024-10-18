package com.cunoc.CaptchaForge.Model.JflexAndCup;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CC.*;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.LabelCC;

import java.util.ArrayList;

public class AnalyzerCC extends AnalyzerBase {
    private LexemaCC lexer;
    private ParserCC parser;

    public AnalyzerCC(String text) {
        this.lexer = new LexemaCC(text);
        this.parser = new ParserCC(lexer);
    }

    @Override
    protected void executeParse() throws Exception {
        parser.parse();
    }

    // return si hay errores
    @Override
    public boolean isError() {
        return !lexer.getListError().isEmpty() || !parser.getListError().isEmpty();
    }

    // Returnar el listado de errores
    @Override
    public ArrayList<ReportErrorInterpreter> getListError() {
        ArrayList<ReportErrorInterpreter> errorList = new ArrayList<>();
        errorList.addAll(lexer.getListError());
        errorList.addAll(parser.getListError());
        return errorList;
    }

    // Etiquetas
    public ArrayList<LabelCC> getListLabelCC() {
        return this.parser.getListLabelCC();
    }

}
