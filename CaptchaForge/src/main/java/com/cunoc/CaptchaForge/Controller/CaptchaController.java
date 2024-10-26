package com.cunoc.CaptchaForge.Controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cunoc.CaptchaForge.Model.DataBase.ConnectionToCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.DataValueDebbuge;
import com.cunoc.CaptchaForge.Model.RequestManagerController.RequestManagerCaptchaController;
import com.cunoc.CaptchaForge.Model.WebIdentities.GenerarSolicitudCaptcha;
import com.cunoc.CaptchaForge.Model.WebIdentities.GenerarSolicitudDebbuge;
import com.cunoc.CaptchaForge.Model.WebIdentities.GenerarSolicitudReportCaptcha;
import com.cunoc.CaptchaForge.Model.WebIdentities.ReportCaptcha;


@RestController
// Direccion de ela api => http://localhost:8080/analyzer
//@RequestMapping("/analyzer") todas las rutas son de aqui
public class CaptchaController {
    // Permitir que los de esta direccion puedan dar petic
    //@CrossOrigin(origins = "http://localhost:4200") // Origen permitidoiones
    @PostMapping("/analyzer/generate-captcha")
    public ResponseEntity<GenerarSolicitudCaptcha> getReturnAnalyzerString(
            @RequestBody GenerarSolicitudCaptcha generarSolititudCaptCha) {
        return new ResponseEntity<>((new RequestManagerCaptchaController()).getRequestResults(generarSolititudCaptCha), HttpStatus.OK);
    }

    //Obtiene el listado de los captcha disponibles
    @GetMapping("/{id}")
    public String getReturnAnalyzerString(@PathVariable String id) {
        return (new GenerarSolicitudReportCaptcha().useCaptchaHTML(id));
    }

    //Obtiene el listado de los captcha dispon`ibles
    @GetMapping("scripting/{id}")
    public String getStringScripting(@PathVariable String id) {
        return (new ConnectionToCaptchaDataBase().getScriptingByID(id));
    }

    //Obtiene el listado de los captcha disponibles
    @GetMapping("tabla-simbolos/{id}")
    public ResponseEntity<ArrayList<DataValueDebbuge>> getSymbolTable(@PathVariable String id) {
        return new ResponseEntity<>((new GenerarSolicitudDebbuge()).getListDebuggeByIdCaptcha(id), HttpStatus.OK);
    }

    @GetMapping("/list-captcha")
    public String getCaptchaList() {
        return (new RequestManagerCaptchaController()).getListCaptchaDataBase();
    }

    @GetMapping("/list-report-captcha")
    public ResponseEntity<ArrayList<ReportCaptcha>> get() {
        return new ResponseEntity<>((new GenerarSolicitudReportCaptcha()).getListReportCaptcha(), HttpStatus.OK);
    }

}
