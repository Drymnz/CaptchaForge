package com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaReportDataBase.Data;

import java.util.ArrayList;

public class RequestReportCaptcha {
    
    private ArrayList<DataReportCaptch> list;

    public RequestReportCaptcha(ArrayList<DataReportCaptch> list) {
        this.list = list;
    }

    public ArrayList<DataReportCaptch> getList() {
        return list;
    }

    public void setList(ArrayList<DataReportCaptch> list) {
        this.list = list;
    }

}
