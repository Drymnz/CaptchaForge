package com.cunoc.CaptchaForge.Model.Utility.Converter;

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

    private final String START_OF_SCRIPT_TAG = "\n<script>";
    private final String END_OF_SCRIPT_TAG = "\n</script>";

    

    private final String CC_GENERICO = """
        <style>
        *{box-sizing:border-box;margin:0;padding:0}body{font-family:Arial,sans-serif;background-color:#121212;color:#e0e0e0;min-height:100vh;display:flex;flex-direction:column;justify-content:center;align-items:center;padding:20px;gap:20px;text-align:center}div{max-width:800px;width:100%;background-color:#1e1e1e;box-shadow:0 4px 10px rgba(0,0,0,0.3);border-radius:10px;padding:20px;display:flex;flex-direction:column;gap:20px;align-items:center}h1{font-size:1.5rem;color:#bb86fc}span{font-size:1rem;color:#888}input{width:100%;max-width:400px;padding:10px;margin-top:5px;border:1px solid #03dac6;border-radius:5px;background-color:#1e1e1e;color:#e0e0e0;font-size:1rem}button{padding:12px;background-color:#03dac6;color:#121212;border:none;border-radius:5px;cursor:pointer;font-size:1rem;transition:background-color .3s}button:hover{background-color:#018786;color:#fff}p{font-size:1rem;color:#27ae60}.row{display:flex;align-items:center;gap:10px}.column{display:flex;flex-direction:column;gap:15px;align-items:center}img{max-width:100%;height:auto;border-radius:8px;box-shadow:0 2px 5px rgba(0,0,0,0.2)}table{width:90%;margin:20px auto;border-collapse:collapse;background-color:#1e1e1e;border:1px solid #bb86fc;box-shadow:0 4px 10px rgba(0,0,0,0.3);border-radius:10px;overflow:hidden}table thead th{padding:12px;background-color:#bb86fc;color:#121212;text-align:left;font-weight:bold}table tbody tr{transition:background-color .3s}table tbody tr:nth-child(even){background-color:#2a2a2a}table tbody tr:nth-child(odd){background-color:#1e1e1e}table td{padding:10px;border-bottom:1px solid #03dac6;color:#e0e0e0}table a{color:#03dac6;text-decoration:none;transition:color .3s}table a:hover{color:#018786}table tbody tr:hover{background-color:#333}
            </style>"""
            ;

    private String javaScript = "";
    private String scripting = "";


    public ListLabelCCToHTML() {

    }

    public String listLabelCCToStringHTML(ArrayList<LabelCC> listLabelCC, String javascript) {
        this.javaScript = javascript;
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
                return this.START_OF_HEAD_TAG + getStringSon(labelCC) + this.CC_GENERICO + this.END_OF_HEAD_TAG;
            case C_BODY:
                return this.START_OF_BODY_TAG + getStringSon(labelCC) + this.END_OF_BODY_TAG;
            case C_SPAM:
                return this.START_OF_SPAN_TAG + getStringProms(labelCC)+ labelCC.getData()  + this.END_OF_SPAN_TAG;
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
                this.scripting = labelCC.getData();
                return this.START_OF_SCRIPT_TAG + this.javaScript  +this.END_OF_SCRIPT_TAG;
            default:
                // Manejo por defecto
                break;
        }
        return returnString;
    }

    private String convertPromsToPromsHTML(Proms proms){
        return proms.getType().toString().toLowerCase() +"=" + proms.getData();
    }

    public String getScripting(){
        return this.scripting;
    }

}
