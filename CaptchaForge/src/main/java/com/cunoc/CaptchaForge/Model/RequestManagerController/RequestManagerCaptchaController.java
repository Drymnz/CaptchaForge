package com.cunoc.CaptchaForge.Model.RequestManagerController;

import com.cunoc.CaptchaForge.Model.Analyzer.ErrorTypeInTheInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.DataBase.ConnectionToCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;
import com.cunoc.CaptchaForge.Model.Utility.Converter.CaptchaToStringJISON;
import com.cunoc.CaptchaForge.Model.Utility.Converter.LabelCCToCaptchaConverter;
import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;
import com.cunoc.CaptchaForge.Model.WebIdentities.GenerarSolicitudCaptcha;

public class RequestManagerCaptchaController {
    private GenerarSolicitudCaptcha solicitud;
    private final String REPEATED_ID = "Id reptido";
    private ConnectionToCaptchaDataBase dataBaseCaptch;

    public RequestManagerCaptchaController() {
        this.dataBaseCaptch = new ConnectionToCaptchaDataBase();
    }

    public GenerarSolicitudCaptcha getRequestResults(GenerarSolicitudCaptcha solicitud) {
        // Analiza la parte de CC
        AnalyzerCC analyzer = new AnalyzerCC(solicitud.getTextAnalyzer());
        analyzer.analyzer();
        if (analyzer.isError()) {
            solicitud.getListError().addAll(analyzer.getListError());
        } else {
            // Convierte lo recolectado del analizer CC en captcha
            Captcha check = (new LabelCCToCaptchaConverter()).converterListLabelCCToCaptcha(analyzer.getListLabelCC());
            if (this.dataBaseCaptch.addWithoutRepeatingID(check)) {
                // Returnar el id del nuevo chaptcha
                solicitud.setId(check.getId());
                if (this.dataBaseCaptch.upDataBase()) {
                    // se actualizo la base de datos
                } else {
                    // no
                }
            } else {
                solicitud.getListError().add(new ReportErrorInterpreter(ErrorTypeInTheInterpreter.SEMANTIC,
                        new Token(0, 0, REPEATED_ID), REPEATED_ID));
            }
        }
        return solicitud;
    }

    public String getListCaptchaDataBase() {
        return (new CaptchaToStringJISON()).captchaListToString(this.dataBaseCaptch.getListCaptcha());
    }
}
