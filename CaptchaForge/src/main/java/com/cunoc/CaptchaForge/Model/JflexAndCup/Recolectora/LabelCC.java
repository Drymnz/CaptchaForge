package com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora;

import java.util.List;

public class LabelCC {

    private List<Proms> listProms;
    private int son;
    private ListTypeLabelCC type;
    private String data;

    public LabelCC(List<Proms> listProms, ListTypeLabelCC type, int son, String data) {
        this.listProms = listProms;
        this.type = type;
        this.son = son;
        this.data = data;
    }

    public List<Proms> getListProms() {
        return listProms;
    }

    public void setListProms(List<Proms> listProms) {
        this.listProms = listProms;
    }

    public ListTypeLabelCC getType() {
        return type;
    }

    public void setType(ListTypeLabelCC type) {
        this.type = type;
    }

    public int getSon() {
        return son;
    }

    public void setSon(int son) {
        this.son = son;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
