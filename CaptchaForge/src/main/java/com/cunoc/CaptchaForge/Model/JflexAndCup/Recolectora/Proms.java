package com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora;

public class Proms {

    private String data;
    private ListTypeProms type;

    public Proms(String data, ListTypeProms type) {
        this.data = data;
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ListTypeProms getType() {
        return type;
    }

    public void setType(ListTypeProms type) {
        this.type = type;
    }

}
