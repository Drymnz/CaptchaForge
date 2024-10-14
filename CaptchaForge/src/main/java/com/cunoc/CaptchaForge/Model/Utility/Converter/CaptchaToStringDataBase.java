package com.cunoc.CaptchaForge.Model.Utility.Converter;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;

public class CaptchaToStringDataBase {
    public CaptchaToStringDataBase(){}
    private final String STAR_CAPTCHA = " \nCapTcha\n";
    private final String OUT_CAPTCHA = " \nFinCapTcha\n ";

    private final String TOKEN_ID = " \nID ";
    private final String TOKEN_HTML = " \nHTML";
    private final String TOKEN_EQUAL = " = ";

    private final String TOKEN_START_HARVESTING = " {_-=> ";
    private final String TOKEN_OUT_HARVESTING = " <=-_} ";


    public String getListCaptcha(ArrayList<Captcha> listCaptcha){
        String returnString = "";
        for (Captcha element : listCaptcha) {
            returnString+= this.ConverterString(element);
        }
        return returnString;
    }

    public String ConverterString(Captcha convert){
        String returnString = this.STAR_CAPTCHA;
        returnString+= getStringId(convert);
        returnString+= getStringHTML(convert);
        return returnString + this.OUT_CAPTCHA;
    }

    private String getStringHTML(Captcha convert){
        return this.TOKEN_HTML + this.TOKEN_EQUAL +  between(convert.getHTML());
    }

    private String getStringId(Captcha convert){
        return this.TOKEN_ID + this.TOKEN_EQUAL +  between(convert.getId());
    }

    private String between(String stringBetween){
        return this.TOKEN_START_HARVESTING + stringBetween + this.TOKEN_OUT_HARVESTING;
    }
}
