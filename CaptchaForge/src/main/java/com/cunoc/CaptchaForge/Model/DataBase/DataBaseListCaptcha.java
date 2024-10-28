package com.cunoc.CaptchaForge.Model.DataBase;

import java.io.File;
import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.Utility.ConstantSystem;
import com.cunoc.CaptchaForge.Model.Utility.Converter.CaptchaToStringDataBase;
import com.cunoc.CaptchaForge.Model.Utility.FileManager.FileInput;
import com.cunoc.CaptchaForge.Model.Utility.FileManager.FileOutput;
import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;

public class DataBaseListCaptcha {

    private ArrayList<Captcha> listCaptcha = new ArrayList<>();
    private File fileDataBase = null;
    private AnalyzerCaptchaDataBase analyzer;

    public DataBaseListCaptcha() {
        checkDataBase();
    }

    private void checkDataBase() {
        if (this.analyzer == null) {
            this.fileDataBase = new File(ConstantSystem.SYSTEM_DIR,ConstantSystem.NAME_FILE_DATA_BASE_CAPTCHA);
            this.createFileIfNotExists(fileDataBase);
            String json = (new FileInput().cargarArchivoTexto(this.fileDataBase));
            this.analyzer = new AnalyzerCaptchaDataBase(json);
            this.analyzer.analyzer();
            this.listCaptcha.addAll(this.analyzer.getListCaptcha());
        } 
    }

    private void createFileIfNotExists(File fileDataBase) {
        // Verificar si el archivo existe
        if (!fileDataBase.exists()) {
            if ((new FileOutput()).aguardarTexto(fileDataBase, "")) {
                System.out.println("El archivo ya existe." + fileDataBase.getName());
            } 
        } else {
            System.out.println("El archivo ya existe." + fileDataBase.getName() );
        }
    }

    public ArrayList<Captcha> getListCaptcha(){
        return this.listCaptcha;
    }
    
    public boolean upDataBase() {
        if (this.fileDataBase == null) {
            this.checkDataBase();
        }
        String saveString = (new CaptchaToStringDataBase()).getListCaptcha(listCaptcha);
        return (new FileOutput()).aguardarTexto(this.fileDataBase, saveString);
    }

}
