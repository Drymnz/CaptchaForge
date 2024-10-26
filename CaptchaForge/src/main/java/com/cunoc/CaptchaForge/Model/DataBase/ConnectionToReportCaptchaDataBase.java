package com.cunoc.CaptchaForge.Model.DataBase;

import com.cunoc.CaptchaForge.Model.WebIdentities.ReportCaptcha;

public class ConnectionToReportCaptchaDataBase {

    private DataBaseListReportCaptcha dataBase;

    public ConnectionToReportCaptchaDataBase() {
        this.dataBase = new DataBaseListReportCaptcha();
    }

    public ReportCaptcha getCaptchaBasedOnYourID(String id) {
        for (ReportCaptcha iterable_element : this.dataBase.getListReportCaptcha()) {
            String checkDataBase = iterable_element.getId();
            checkDataBase = checkDataBase.replaceAll("\\s+", "");
            if (checkDataBase.equals((id))) {
                return iterable_element;
            }
        }
        return null;
    }

}
