package com.cunoc.CaptchaForge.Model.Utility.Converter;

import java.util.ArrayList;
import java.util.List;

import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.LabelCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeLabelCC;
import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;

public class LabelCCToCaptchaConverter {

    private ListLabelCCToHTML converterLabelCcTohtml = new ListLabelCCToHTML();

    public LabelCCToCaptchaConverter(){

    }

    public Captcha converterListLabelCCToCaptcha(ArrayList<LabelCC> listLabelCC, String javascript){
        String id = getTheId(listLabelCC);
        String HTML = this.converterLabelCcTohtml.listLabelCCToStringHTML(listLabelCC,javascript);
        String scripting = this.converterLabelCcTohtml.getScripting();
        return new Captcha(id,HTML,scripting);
    }

    private String getTheId(List<LabelCC> listLabelCC){
        for (LabelCC element : listLabelCC) {
            if (element.getType() == ListTypeLabelCC.C_CC) {
                return this.converterLabelCcTohtml.getPromID(element.getListProms());
            } else {
                return getTheId(element.getListSon());
            }
        }
        return  "";
    }
}
