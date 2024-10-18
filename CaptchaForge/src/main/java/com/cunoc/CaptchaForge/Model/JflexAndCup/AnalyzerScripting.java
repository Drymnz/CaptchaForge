package com.cunoc.CaptchaForge.Model.JflexAndCup;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Scripting.LexemaScripting;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Scripting.ParserScripting;
import java.util.ArrayList;

public class AnalyzerScripting extends AnalyzerBase{
    private LexemaScripting lexema;
    private ParserScripting parser;

    public AnalyzerScripting(String text) {
        this.lexema = new LexemaScripting(text);
        this.parser = new ParserScripting(this.lexema);
    }

    @Override
    protected void executeParse() throws Exception {
        parser.parse();
    }

    // return si hay errores
    @Override
    public boolean isError() {
        return !lexema.getListError().isEmpty() || !parser.getListError().isEmpty()
        || !this.parser.getAnalyzerSemantico().getListError().isEmpty();
    }

    @Override
    public ArrayList<ReportErrorInterpreter> getListError() {
        ArrayList<ReportErrorInterpreter> errorList = new ArrayList<>();
        errorList.addAll(lexema.getListError());
        errorList.addAll(parser.getListError());
        errorList.addAll(parser.getAnalyzerSemantico().getListError());
        return errorList;
    }

    public AnalyzerSemantico getAnalyzerSemantico(){
        return this.parser.getAnalyzerSemantico();
    }
}
