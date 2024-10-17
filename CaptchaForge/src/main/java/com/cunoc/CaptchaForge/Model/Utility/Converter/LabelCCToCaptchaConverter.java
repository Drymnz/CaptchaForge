package com.cunoc.CaptchaForge.Model.Utility.Converter;

import java.util.ArrayList;
import java.util.List;

import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.LabelCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeLabelCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeProms;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.Proms;
import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;

public class LabelCCToCaptchaConverter {

    private ListLabelCCToHTML converterLabelCcTohtml = new ListLabelCCToHTML();

    public LabelCCToCaptchaConverter(){

    }

    public Captcha converterListLabelCCToCaptcha(ArrayList<LabelCC> listLabelCC){
        String id = getTheId(listLabelCC);
        String HTML = this.converterLabelCcTohtml.listLabelCCToStringHTML(listLabelCC);
        String scripting = this.converterLabelCcTohtml.getScripting();
        return new Captcha(id,HTML,scripting);
    }

    private String getTheId(List<LabelCC> listLabelCC){
        for (LabelCC element : listLabelCC) {
            if (element.getType() == ListTypeLabelCC.C_CC) {
                return getPromID(element.getListProms());
            } else {
                return getTheId(element.getListSon());
            }
        }
        return  "";
    }

    private String getPromID(List<Proms> listProms){
        for (Proms proms : listProms) {
            if (proms.getType() == ListTypeProms.ID) {
                return proms.getData().replaceAll("\"", "");
            } 
        }
        return "";
    }
}
