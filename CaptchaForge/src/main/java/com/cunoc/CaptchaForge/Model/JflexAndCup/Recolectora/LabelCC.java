package com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora;

import java.util.List;

public class LabelCC {

    private List<Proms> listProms;
    private List<LabelCC> listSon;
    private ListTypeLabelCC type;
    private String data;

    public LabelCC(List<Proms> listProms, List<LabelCC> listSon, ListTypeLabelCC type, String data) {
        this.listProms = listProms;
        this.listSon = listSon;
        this.type = type;
        this.data = data;
    }

    public List<Proms> getListProms() {
        return listProms;
    }

    public void setListProms(List<Proms> listProms) {
        this.listProms = listProms;
    }

    public List<LabelCC> getListSon() {
        return listSon;
    }

    public void setListSon(List<LabelCC> listSon) {
        this.listSon = listSon;
    }

    public ListTypeLabelCC getType() {
        return type;
    }

    public void setType(ListTypeLabelCC type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
