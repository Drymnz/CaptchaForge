package com.cunoc.CaptchaForge.Model.Utility;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.LabelCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.Proms;

public class ListLabelCCToHTML {

    private final String PRINCIPLE_OF_HTML = "<!DOCTYPE html>\n<html lang=\"es\">";
    private final String END_OF_HTML = "\n</html>";
    private final String START_OF_HEAD_TAG = """
                                             <head>
                                                 <meta charset="UTF-8">
                                                 <meta name="viewport" content="width=device-width, initial-scale=1.0">""";
    private final String END_OF_HEAD_TAG = "\n</head>";

    private final String START_OF_TITLE_TAG = "\n<title>";
    private final String END_OF_TITLE_TAG = "\n</title>";

    private final String START_OF_LINK_TAG = "\n<link ";

    private final String CLOSING_OF_PROMS = ">";

    private final String START_OF_BODY_TAG = "\n<body>";
    private final String END_OF_BODY_TAG = "\n</body>";

    private final String START_OF_SPAN_TAG = "\n<span";
    private final String END_OF_SPAN_TAG = "\n</span>";

    private final String START_OF_SELECT_TAG = "\n<select>";
    private final String END_OF_SELECT_TAG = "\n</select>";

    private final String START_OF_OPTION_TAG = "\n<option ";
    private final String END_OF_OPTION_TAG = "\n</option>";

    private final String START_OF_DIV_TAG = "\n<div";
    private final String END_OF_DIV_TAG = "\n</div>";

    private final String START_OF_BUTTON_TAG = "\n<button";
    private final String END_OF_BUTTON_TAG = "\n</button>";

    private final String START_OF_H1_TAG = "\n<h1";
    private final String END_OF_H1_TAG   = "\n</h1>";
    private final String START_OF_H2_TAG = "\n<h2";
    private final String END_OF_H2_TAG   = "\n</h2>";
    private final String START_OF_H3_TAG = "\n<h3";
    private final String END_OF_H3_TAG   = "\n</h3>";
    private final String START_OF_H4_TAG = "\n<h4";
    private final String END_OF_H4_TAG   = "\n</h4>";
    private final String START_OF_H5_TAG = "\n<h5";
    private final String END_OF_H5_TAG   = "\n</h5>";
    private final String START_OF_H6_TAG = "\n<h6";
    private final String END_OF_H6_TAG   = "\n</h6>";

    private final String START_OF_P_TAG = "\n<p";
    private final String END_OF_P_TAG = "\n</p>";

    private final String START_OF_FORM_TAG = "\n<form ";
    private final String END_OF_FORM_TAG = "\n</form>";

    private final String START_OF_INPUT_TAG = "\n<input ";
    private final String BR_TAG = "\n<br>";
    private final String START_OF_IMG_TAG = "\n<img ";

    private final String START_OF_TEXTAREA_TAG = "\n<textarea";
    private final String END_OF_TEXTAREA_TAG = "\n</textarea>";


    public ListLabelCCToHTML() {

    }

    public String listLabelCCToStringHTML(ArrayList<LabelCC> listLabelCC) {
        String returnString = "";
        for (LabelCC labelCC : listLabelCC) {
            returnString += convertCCTagToHTML(labelCC);
        }
        return returnString;
    }

    private String getStringSon(LabelCC labelCC) {
        String returnString = "";
        for (LabelCC sonLabelCC : labelCC.getListSon()) {
            returnString += convertCCTagToHTML(sonLabelCC);
        }
        return returnString;
    }

    private String getStringProms(LabelCC labelCC) {
        String returnString = " ";
        for (Proms sonLabelCC : labelCC.getListProms()) {
            returnString += convertPromsToPromsHTML(sonLabelCC) + " ";
        }
        return returnString + this.CLOSING_OF_PROMS;
    }

    private String convertCCTagToHTML(LabelCC labelCC) {
        String returnString = "";
        switch (labelCC.getType()) {
            case C_CC:
                return this.PRINCIPLE_OF_HTML + getStringSon(labelCC) + this.END_OF_HTML;
            case C_TITLE:
                return this.START_OF_TITLE_TAG + labelCC.getData() + this.END_OF_TITLE_TAG;
            case C_LINK:
                return this.START_OF_LINK_TAG + getStringProms(labelCC);
            case C_HEAD:
                return this.START_OF_HEAD_TAG + getStringSon(labelCC) + this.END_OF_HEAD_TAG;
            case C_BODY:
                return this.START_OF_BODY_TAG + getStringSon(labelCC) + this.END_OF_BODY_TAG;
            case C_SPAM:
                return this.START_OF_SPAN_TAG + getStringProms(labelCC) + this.END_OF_SPAN_TAG;
            case C_SELECT:
                return this.START_OF_SELECT_TAG + getStringProms(labelCC) + getStringSon(labelCC) +this.END_OF_SELECT_TAG;
            case C_OPTION:
                return this.START_OF_OPTION_TAG + getStringProms(labelCC) + labelCC.getData() +this.END_OF_OPTION_TAG;
            case C_DIV:
                return this.START_OF_DIV_TAG + getStringProms(labelCC) + getStringSon(labelCC)  +this.END_OF_DIV_TAG;
            case C_BUTTON:
                return this.START_OF_BUTTON_TAG + getStringProms(labelCC) + labelCC.getData()  +this.END_OF_BUTTON_TAG;
            case C_H1:
                return this.START_OF_H1_TAG + getStringProms(labelCC) + labelCC.getData()  +this.END_OF_H1_TAG;
            case C_H2:
                return this.START_OF_H2_TAG + getStringProms(labelCC) + labelCC.getData()  +this.END_OF_H2_TAG;
            case C_H3:
                return this.START_OF_H3_TAG + getStringProms(labelCC) + labelCC.getData()  +this.END_OF_H3_TAG;
            case C_H4:
                return this.START_OF_H4_TAG + getStringProms(labelCC) + labelCC.getData()  +this.END_OF_H4_TAG;
            case C_H5:
                return this.START_OF_H5_TAG + getStringProms(labelCC) + labelCC.getData()  +this.END_OF_H5_TAG;
            case C_H6:
                return this.START_OF_H6_TAG + getStringProms(labelCC) + labelCC.getData()  +this.END_OF_H6_TAG;
            case C_P:
                return this.START_OF_P_TAG + getStringProms(labelCC) + labelCC.getData()  +this.END_OF_P_TAG;
            case C_FORM:
                return this.START_OF_FORM_TAG + getStringProms(labelCC) + getStringSon(labelCC)  +this.END_OF_FORM_TAG;
            case C_INPUT:
                return this.START_OF_INPUT_TAG + getStringProms(labelCC) ;
            case C_BR:
                return this.BR_TAG;
            case C_IMG:
                return this.START_OF_IMG_TAG + getStringProms(labelCC) ;
            case C_TEXTAREA:
                return this.START_OF_TEXTAREA_TAG + getStringProms(labelCC) + getStringSon(labelCC)  +this.END_OF_TEXTAREA_TAG;
            case C_SCRIPTING:
                //return this.START_OF_FORM_TAG + getStringProms(labelCC) + getStringSon(labelCC)  +this.END_OF_FORM_TAG;
                break;
            default:
                // Manejo por defecto
                break;
        }
        return returnString;
    }

    private String convertPromsToPromsHTML(Proms proms){
        String returnString = proms.getType().toString().toLowerCase() +"=" + proms.getData();
        switch (proms.getType()) {
            case HREF:
                // Manejar HREF
                break;
            case BACKGROUND:
                // Manejar BACKGROUND
                break;
            case COLOR:
                // Manejar COLOR
                break;
            case FONT_SIZE:
                // Manejar FONT_SIZE
                break;
            case FONT_FAMILY:
                // Manejar FONT_FAMILY
                break;
            case FONT_ALIG:
                // Manejar FONT_ALIG
                break;
            case TYPE:
                // Manejar TYPE
                break;
            case ID:
                // Manejar ID
                break;
            case NAME:
                // Manejar NAME
                break;
            case COLS:
                // Manejar COLS
                break;
            case ROWS:
                // Manejar ROWS
                break;
            case CLASS:
                // Manejar CLASS
                break;
            case SRC:
                // Manejar SRC
                break;
            case WIDTH:
                // Manejar WIDTH
                break;
            case HEIGHT:
                // Manejar HEIGHT
                break;
            case ALT:
                // Manejar ALT
                break;
            case ONCLICK:
                // Manejar ONCLICK
                break;
            default:
                // Manejar tipo desconocido
                break;
        }
        return returnString;
    }

}
