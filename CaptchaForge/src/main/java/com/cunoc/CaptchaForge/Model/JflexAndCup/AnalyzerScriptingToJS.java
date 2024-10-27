package com.cunoc.CaptchaForge.Model.JflexAndCup;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.JflexAndCup.ScriptingToJS.LexemaScriptingToJS;
import com.cunoc.CaptchaForge.Model.JflexAndCup.ScriptingToJS.ParserScriptingToJS;

public class AnalyzerScriptingToJS extends AnalyzerBase{

    private LexemaScriptingToJS lexema;
    private ParserScriptingToJS parser;
    
    public AnalyzerScriptingToJS(String text){
        this.lexema = new LexemaScriptingToJS(text);
        this.parser = new ParserScriptingToJS(lexema);
    }

    @Override
    protected void executeParse() throws Exception {
        parser.parse();
    }

    // return si hay errores
    @Override
    public boolean isError() {
        return !lexema.getListError().isEmpty() || !parser.getListError().isEmpty();
    }

    // Returnar el listado de errores
    @Override
    public ArrayList<ReportErrorInterpreter> getListError() {
        ArrayList<ReportErrorInterpreter> errorList = new ArrayList<>();
        errorList.addAll(lexema.getListError());
        errorList.addAll(parser.getListError());
        return errorList;
    }

    public String getJavaScript(){
        return this.parser.getJavaScriptString();
    }

    public String getInsert(){
        return this.parser.getInserInsert();
    }
    
}
