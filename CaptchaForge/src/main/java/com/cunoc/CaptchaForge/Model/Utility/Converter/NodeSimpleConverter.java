package com.cunoc.CaptchaForge.Model.Utility.Converter;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.LabelCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.NodoSimple;

public class NodeSimpleConverter {
    public NodeSimpleConverter(){}
    public ArrayList<LabelCC> getListLabelCC(NodoSimple main){
        ArrayList<LabelCC> listLabelCC = new ArrayList();
        if (main!=null) {
            if (main.getValor()!=null && main.getValor() instanceof LabelCC) {
                LabelCC newLabel = (LabelCC) main.getValor();
                listLabelCC.add(newLabel);
            }
            NodoSimple mainUser = main.getRight();
            while (mainUser != null) {
                if (mainUser.getValor() instanceof LabelCC) {
                    LabelCC newLabel = (LabelCC) mainUser.getValor();
                    listLabelCC.add(newLabel);
                }
                mainUser = mainUser.getRight();
            }
        }
        return  listLabelCC;
    }
}
