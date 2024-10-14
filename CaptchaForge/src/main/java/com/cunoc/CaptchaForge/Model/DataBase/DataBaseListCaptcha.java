package com.cunoc.CaptchaForge.Model.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
                System.out.println("El archivo ya existe.");
            } 
        } else {
            System.out.println("El archivo ya existe.");
        }
    }

    private void addCaptcha(Captcha newCaptcha){
        this.listCaptcha.add(newCaptcha);
    }

    public boolean addWithoutRepeatingID(Captcha newCaptcha){
        for (Captcha iterable_element : listCaptcha) {
            String checkDataBase = iterable_element.getId();
            checkDataBase = checkDataBase.replaceAll("\\s+", "");
            if (checkDataBase.equals((newCaptcha.getId()))) {
                return false;
            }
        }
        addCaptcha(newCaptcha);
        return true;
    }
    
    public boolean upDataBase() {
        if (this.fileDataBase == null) {
            this.checkDataBase();
        }
        String saveString = (new CaptchaToStringDataBase()).getListCaptcha(listCaptcha);
        return (new FileOutput()).aguardarTexto(this.fileDataBase, saveString);
    }
}
