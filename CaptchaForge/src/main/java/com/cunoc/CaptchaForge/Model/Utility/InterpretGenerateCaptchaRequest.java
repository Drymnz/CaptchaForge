package com.cunoc.CaptchaForge.Model.Utility;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;
import com.cunoc.CaptchaForge.Model.WebIdentities.GenerarSolicitudCaptcha;

public class InterpretGenerateCaptchaRequest {
    private GenerarSolicitudCaptcha generarSolicitudCaptcha;

    public InterpretGenerateCaptchaRequest(GenerarSolicitudCaptcha generarSolicitudCaptcha) {
        this.generarSolicitudCaptcha = generarSolicitudCaptcha;
    }

    public GenerarSolicitudCaptcha analyzerGenerarSolicitudCaptcha(){
        AnalyzerCC analyzer = new AnalyzerCC(this.generarSolicitudCaptcha.getTextAnalyzer());
        analyzer.analyzer();
        return this.generarSolicitudCaptcha;
    }
}
