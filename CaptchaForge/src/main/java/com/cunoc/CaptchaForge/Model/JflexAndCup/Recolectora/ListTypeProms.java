package com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora;

public class ListTypeProms {

    private String dope;
    private ListTypeProms type;

    public ListTypeProms(String dope, ListTypeProms type) {
        this.dope = dope;
        this.type = type;
    }

    public String getDope() {
        return dope;
    }

    public void setDope(String dope) {
        this.dope = dope;
    }

    public ListTypeProms getType() {
        return type;
    }

    public void setType(ListTypeProms type) {
        this.type = type;
    }

}
