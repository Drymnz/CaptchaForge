package com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaReportDataBase.Data;

import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeData;

public class DataReportCaptch {
     private Token token;
    private ListTypeDataReportCaptcha type;
    private String data;
    
    public DataReportCaptch(Token token, ListTypeDataReportCaptcha type, String data) {
        this.token = token;
        this.type = type;
        this.data = data;
    }

    public Token getToken() {
        return token;
    }

    public ListTypeDataReportCaptcha getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return  " token "+token.toString()+
        " type: "+type.toString()+
        " data: "+data;
    }
}
