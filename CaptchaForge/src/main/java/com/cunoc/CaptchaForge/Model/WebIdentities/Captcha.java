package com.cunoc.CaptchaForge.Model.WebIdentities;

public class Captcha {
    private String id;
    private String HTML;
    
    public Captcha(String id, String hTML) {
        this.id = id;
        HTML = hTML;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHTML() {
        return HTML;
    }

    public void setHTML(String hTML) {
        HTML = hTML;
    }

    
}
