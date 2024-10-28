package com.cunoc.CaptchaForge.Model.JflexAndCup;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaReportDataBase.LexemaCaptchaReportDataBase;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaReportDataBase.ParserCaptchaReportDataBase;
import com.cunoc.CaptchaForge.Model.WebIdentities.ReportCaptcha;

public class AnalyzerDataBaseReportCaptcha extends AnalyzerBase {

    private LexemaCaptchaReportDataBase lexema;
    private ParserCaptchaReportDataBase parser;

    public AnalyzerDataBaseReportCaptcha(String text) {
        this.lexema = new LexemaCaptchaReportDataBase(text);
        this.parser = new ParserCaptchaReportDataBase(lexema);
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

    @Override
    protected void executeParse() throws Exception {
        parser.parse();
    }

    public ArrayList<ReportCaptcha> getListReportCaptcha() {
        return this.parser.getListReportCaptcha();
    }
}
