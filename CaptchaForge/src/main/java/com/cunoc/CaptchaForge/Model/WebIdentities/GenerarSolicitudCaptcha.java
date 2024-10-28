package com.cunoc.CaptchaForge.Model.WebIdentities;

import java.util.List;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;

public class GenerarSolicitudCaptcha {
    private String textAnalyzer;
    private String id;
    private List<ReportErrorInterpreter> listError;

    public GenerarSolicitudCaptcha(String textAnalyzer,String id, List<ReportErrorInterpreter> listError) {
        this.textAnalyzer = textAnalyzer;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setListError(List<ReportErrorInterpreter> listError) {
        this.listError = listError;
    }

    
}
