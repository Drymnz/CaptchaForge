package com.cunoc.CaptchaForge.Model.WebIdentities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cunoc.CaptchaForge.Model.DataBase.ConnectionToCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.DataBase.ConnectionToReportCaptchaDataBase;

public class GenerarSolicitudReportCaptcha {
    private ConnectionToReportCaptchaDataBase dataBase;

    public GenerarSolicitudReportCaptcha() {
        this.dataBase = new ConnectionToReportCaptchaDataBase();
    }

    public String useCaptchaHTML(String id){
        Captcha dataBaseCaptcha = (new ConnectionToCaptchaDataBase().getCaptchaBasedOnYourID(id));
        if (dataBaseCaptcha == null) {
            return "";
        }else{
            ReportCaptcha newReportCaptcha = this.dataBase.getCaptchaBasedOnYourID(id);
            if (newReportCaptcha != null) {
                newReportCaptcha.setLastData(this.getDataToday());
                newReportCaptcha.setNumberFaill(newReportCaptcha.getNumberFaill() + 1);
            } else {
                newReportCaptcha = new ReportCaptcha(dataBaseCaptcha.getId(), 0, 1, this.getDataToday());
                this.dataBase.addReportCaptcha(newReportCaptcha);
            }
            dataBase.upDataBase();
            return dataBaseCaptcha.getHTML();
        }
    }

    public String getDataToday() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = new Date();
        return formato.format(fecha);
    }
}
