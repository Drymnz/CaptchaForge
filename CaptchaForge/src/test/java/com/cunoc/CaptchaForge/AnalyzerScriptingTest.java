package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class AnalyzerScriptingTest {

    @Test
    void firstScripting() {
        String nothingToAnalyze = "!! Estas instrucciones no se ejecutan hasta llamar a\n";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void functionScripting() {
        String nothingToAnalyze = "FUNCTION_calc() [ ]";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void statementScripting() {
        String nothingToAnalyze = "boolean estado; integer @global contador; string cad1, cad2, cad3;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }
    
    @Test
    void assignScripting() {
        String nothingToAnalyze = "decimal contador2, contador3 = 30.55 + 0.45;"+
        "boolean f2, f1 = true && false;" + 
        "string cad4 = \"Hola\" + \"mundo\";"+
        "char letra = 'A';"+
        "contador = 1;"+
        "estado = true;\n" + //
                        "cad1 = \"hola\";\n" + //
                        "cad2 = \"mundo\";\n" + //
                        "cad3 = cad1 + cad2;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }
}
