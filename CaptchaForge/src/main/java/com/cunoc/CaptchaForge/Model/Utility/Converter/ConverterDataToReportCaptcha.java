package com.cunoc.CaptchaForge.Model.Utility.Converter;

import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaReportDataBase.Data.DataReportCaptch;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaReportDataBase.Data.RequestReportCaptcha;
import com.cunoc.CaptchaForge.Model.WebIdentities.ReportCaptcha;

public class ConverterDataToReportCaptcha {
    public ConverterDataToReportCaptcha() {
    }

    public ReportCaptcha DataToReportCaptcha(RequestReportCaptcha listRequest) {

        String id = "";
        int numberHits = 0;
        int numberFaill = 0;
        String lastData = "";

        for (DataReportCaptch element : listRequest.getList()) {
            switch (element.getType()) {
                case ID:
                    id = element.getData().replace("\"", "");
                    break;
                case LAST_DATA:
                    lastData = element.getData().replace("\"", "");
                    break;
                case NUMBER_FAILL:
                    numberFaill = (int) Double.parseDouble(element.getData().replace("\"", ""));
                    break;
                case NUMBER_HITS:
                    numberHits = (int) Double.parseDouble(element.getData().replace("\"", ""));
                    break;
                default:
                    break;
            }
        }
        return new ReportCaptcha(id, numberHits, numberFaill, lastData);
    }
}
