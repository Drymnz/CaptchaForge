package com.cunoc.CaptchaForge.Model.WebIdentities;

public class ReportCaptcha {
    
    private String id;
    private int numberHits;
    private int numberFaill;
    private String lastData;

    public ReportCaptcha(String id, int numberHits, int numberFaill, String lastData) {
        this.id = id;
        this.numberHits = numberHits;
        this.numberFaill = numberFaill;
        this.lastData = lastData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberHits() {
        return numberHits;
    }

    public void setNumberHits(int numberHits) {
        this.numberHits = numberHits;
    }

    public int getNumberFaill() {
        return numberFaill;
    }

    public void setNumberFaill(int numberFaill) {
        this.numberFaill = numberFaill;
    }

    public String getLastData() {
        return lastData;
    }

    public void setLastData(String lastData) {
        this.lastData = lastData;
    }

}
