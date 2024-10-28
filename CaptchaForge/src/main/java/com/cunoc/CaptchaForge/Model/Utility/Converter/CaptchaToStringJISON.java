package com.cunoc.CaptchaForge.Model.Utility.Converter;

import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;
import java.util.ArrayList;

public class CaptchaToStringJISON {
    private final String START_OF_LISTING = "[\n";
    private final String OUT_OF_LISTING = "]\n";

    private final String START_OF_OBJET = "{\n";
    private final String OUT_OF_OBJET = "}";

    private final String ID_ATTRIBUTE = "\"id\"";
    private final String LINK_ATTRIBUTE = "\"link\"";

    private final String EQUAL = " : ";
    private final String SINGLE_QUOTATION_MARKS = "\"";
    private final String SEPARATOR = " , ";

    private final String URL = "http://localhost:8080/";

    public CaptchaToStringJISON() {
    }

    public String captchaListToString(ArrayList<Captcha> list) {
        String stringReturn = this.START_OF_LISTING;
        for (int i = 0; i < list.size(); i++) {
            String useSeparator = (((list.size() > 1)) && ((list.size()-1 > i)))? this.SEPARATOR : "";
            stringReturn += this.stringCaptchat(list.get(i)) + useSeparator + "\n";
        }
        return stringReturn + this.OUT_OF_LISTING;
    }

    private String stringCaptchat(Captcha element) {
        String stringReturn = this.START_OF_OBJET;
        stringReturn += this.ID_ATTRIBUTE + this.EQUAL + this.addSingleQuotes(element.getId()) + this.SEPARATOR + "\n";
        stringReturn += this.LINK_ATTRIBUTE + this.EQUAL + this.addSingleQuotes(this.URL+element.getId());
        return stringReturn + this.OUT_OF_OBJET;
    }

    private String addSingleQuotes(String string){
        return this.SINGLE_QUOTATION_MARKS+ string +this.SINGLE_QUOTATION_MARKS;
    }
}
