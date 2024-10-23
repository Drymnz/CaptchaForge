package com.cunoc.CaptchaForge.Model.DataBase;

import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;
import java.util.ArrayList;

public class ConnectionToCaptchaDataBase {
    private DataBaseListCaptcha dataBase;

    public ConnectionToCaptchaDataBase(){
        this.dataBase = new DataBaseListCaptcha();
    }

    public boolean addWithoutRepeatingID(Captcha newCaptcha){
        Captcha CaptchaDataBase = this.getCaptchaBasedOnYourID(newCaptcha.getId());
        if(CaptchaDataBase!=null) return false;
        this.dataBase.getListCaptcha().add(newCaptcha);
        return true;
    }

    public String getHTMLByID(String id){
        Captcha captchaDataBase = this.getCaptchaBasedOnYourID(id);
        if(captchaDataBase==null) return "";
        return captchaDataBase.getHTML();
    }

    public String getScriptingByID(String id){
        Captcha captchaDataBase = this.getCaptchaBasedOnYourID(id);
        if(captchaDataBase==null) return "";
        return captchaDataBase.getScripting();
    }

    public boolean upDataBase(){
        return this.dataBase.upDataBase();
    }

    private Captcha getCaptchaBasedOnYourID(String id){
        for (Captcha iterable_element : this.dataBase.getListCaptcha()) {
            String checkDataBase = iterable_element.getId();
            checkDataBase = checkDataBase.replaceAll("\\s+", "");
            if (checkDataBase.equals((id))) {
                return iterable_element;
            }
        }
        return null;
    }

    public ArrayList<Captcha> getListCaptcha(){
       return this.dataBase.getListCaptcha();
    }
}
