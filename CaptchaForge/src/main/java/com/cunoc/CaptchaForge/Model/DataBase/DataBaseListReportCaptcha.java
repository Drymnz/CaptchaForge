package com.cunoc.CaptchaForge.Model.DataBase;

import java.util.ArrayList;
import java.io.File;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerDataBaseReportCaptcha;
import com.cunoc.CaptchaForge.Model.Utility.ConstantSystem;
import com.cunoc.CaptchaForge.Model.Utility.Converter.ReportCaptchaToJisonConverter;
import com.cunoc.CaptchaForge.Model.Utility.FileManager.FileInput;
import com.cunoc.CaptchaForge.Model.Utility.FileManager.FileOutput;
import com.cunoc.CaptchaForge.Model.WebIdentities.ReportCaptcha;

public class DataBaseListReportCaptcha {

    private ArrayList<ReportCaptcha> listReportCaptcha = new ArrayList<>();
    private File fileDataBase = null;
    private AnalyzerDataBaseReportCaptcha analyzer;

    public DataBaseListReportCaptcha() {
        checkDataBase();
    }

    private void checkDataBase() {
        if (this.analyzer == null) {
            this.fileDataBase = new File(ConstantSystem.SYSTEM_DIR, ConstantSystem.NAME_FILE_DATA_BASE_REPORT_CAPTCHA);
            this.createFileIfNotExists(fileDataBase);
            String json = (new FileInput().cargarArchivoTexto(this.fileDataBase));
            this.analyzer = new AnalyzerDataBaseReportCaptcha(json);
            this.analyzer.analyzer();
            this.listReportCaptcha.addAll(this.analyzer.getListReportCaptcha());
        }
    }

    private void createFileIfNotExists(File fileDataBase) {
        // Verificar si el archivo existe
        if (!fileDataBase.exists()) {
            if ((new FileOutput()).aguardarTexto(fileDataBase, "")) {
                System.out.println("El archivo ya existe." + fileDataBase.getName());
            }
        } else {
            System.out.println("El archivo ya existe." + fileDataBase.getName());
        }
    }

    public boolean upDataBase() {
        if (this.fileDataBase == null) {
            this.checkDataBase();
        }
        String saveString = (new ReportCaptchaToJisonConverter()).convertToJsonString(this.listReportCaptcha);
        return (new FileOutput()).aguardarTexto(this.fileDataBase, saveString);
    }

    public ArrayList<ReportCaptcha> getListReportCaptcha(){
        return this.listReportCaptcha;
    }
}
