package com.cunoc.CaptchaForge.Model.JflexAndCup;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaDataBase.LexemaCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaDataBase.ParserCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;

public class AnalyzerCaptchaDataBase {
    private LexemaCaptchaDataBase lexema;
    private ParserCaptchaDataBase parser;

    public AnalyzerCaptchaDataBase(String text){
        this.lexema = new LexemaCaptchaDataBase(text);
        this.parser = new ParserCaptchaDataBase(lexema);
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
        return (this.lexema.getListError().size() > 0 || this.parser.getListError().size() > 0);
    }

    // Returnar el listado de errores
    public ArrayList<ReportErrorInterpreter> getListError() {
        ArrayList<ReportErrorInterpreter> returnListErro = new ArrayList<>();
        returnListErro.addAll(this.lexema.getListError());
        returnListErro.addAll(this.parser.getListError());
        return returnListErro;
    }

    public ArrayList<Captcha> getListCaptcha(){
        return  this.parser.getListCaptcha();
    }
}
