package com.cunoc.CaptchaForge.Model.WebIdentities;

public class Captcha {
    private String id;
    private String HTML;
    private String scripting;

    public Captcha(String id, String HTML, String scripting) {
        this.id = id;
        this.HTML = HTML;
        this.scripting = scripting;
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

    public String getScripting() {
        return scripting;
    }

    public void setScripting(String scripting) {
        this.scripting = scripting;
    }

}
