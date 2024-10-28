package com.cunoc.CaptchaForge.Model.JflexAndCup;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaDataBase.LexemaCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaDataBase.ParserCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;

public class AnalyzerCaptchaDataBase extends AnalyzerBase{
    private LexemaCaptchaDataBase lexema;
    private ParserCaptchaDataBase parser;

    public AnalyzerCaptchaDataBase(String text){
        this.lexema = new LexemaCaptchaDataBase(text);
        this.parser = new ParserCaptchaDataBase(lexema);
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

    public ArrayList<Captcha> getListCaptcha(){
        return  this.parser.getListCaptcha();
    }
}
