package com.cunoc.CaptchaForge.Model.WebIdentities;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.DataBase.ConnectionToCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.DataValueDebbuge;

public class GenerarSolicitudDebbuge {
    public GenerarSolicitudDebbuge() {
    }

    public ArrayList<DataValueDebbuge> getListDebuggeByIdCaptcha(String id) {
        ArrayList<DataValueDebbuge> listValue = new ArrayList<>();
        String scriptitString  = new ConnectionToCaptchaDataBase().getScriptingByID(id);
        AnalyzerScripting analyzer = new AnalyzerScripting(scriptitString);
        analyzer.analyzer();
        listValue.addAll(analyzer.getListDebbuge());
        return listValue;
    }
}
