package com.cunoc.CaptchaForge.Model.WebIdentities;

import java.util.List;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;

public class GenerarSolicitudCaptcha {
    private String textAnalyzer;
    private List<ReportErrorInterpreter> listError;

    public GenerarSolicitudCaptcha(String textAnalyzer, List<ReportErrorInterpreter> listError) {
        this.textAnalyzer = textAnalyzer;
        this.listError = listError;
    }

    public String getTextAnalyzer() {
        return textAnalyzer;
    }

    public List<ReportErrorInterpreter> getListError() {
        return listError;
    }

    public void setTextAnalyzer(String textAnalyzer) {
        this.textAnalyzer = textAnalyzer;
    }

}
