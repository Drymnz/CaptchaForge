package com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora;

import java.util.List;

public class LabelCC {

    private List<Proms> listProms;
    private ListTypeLabelCC type;
    private boolean son;
    private String data;

    public LabelCC(ListTypeLabelCC type, boolean son, String data) {
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

    public boolean isSon() {
        return son;
    }

    public void setSon(boolean son) {
        this.son = son;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
