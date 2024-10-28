package com.cunoc.CaptchaForge;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.LabelCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeLabelCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.NodoSimple;
import com.cunoc.CaptchaForge.Model.Utility.Converter.NodeSimpleConverter;

public class NodoTest {
    	@Test
	void contextLoads() {
        LabelCC newLayout = new LabelCC(null, null, ListTypeLabelCC.C_BODY, "");
        LabelCC newLayout1 = new LabelCC(null, null, ListTypeLabelCC.C_HEAD, "");
        LabelCC newLayout2 = new LabelCC(null, null, ListTypeLabelCC.C_DIV, "");
        NodoSimple nodoOne = new NodoSimple(newLayout);
        NodoSimple nodoTwo = new NodoSimple(newLayout1);
        NodoSimple nodoThree = new NodoSimple(newLayout2);
        nodoOne.setRight(nodoTwo);
        nodoTwo.setRight(nodoThree);
        ArrayList<LabelCC> listLabelCC = new NodeSimpleConverter().getListLabelCC(nodoOne);
		Assertions.assertTrue(listLabelCC.size() == 3);
	}
}
