package com.cunoc.CaptchaForge.Scripting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticOperationAdditionTests {
    @Test
	void contextLoads() {
		String nothingToAnalyze = """
            integer contador = 3;
            string cad4 = "mundo";
            decimal contador2 = 0.45;
            boolean  f1 = true;
            char letra = 'A';""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void operationAdditionWithInteger() {
		String nothingToAnalyze = """
            !! Integer en el lado izquierdo
            integer cad1 = 1 + 1;
            string cad2 = 1 + "Hola";
            decimal cad3 = 1 + 2.5;
            integer cad4 = 1 + 'a';
            integer cad5 = 1 + true;
            
            !! Integer en el lado derecho
            string cad6 = "Hola" + 1;
            decimal cad7 = 2.5 + 1;
            integer cad8 = 'a' + 1;
            integer cad9 = true + 1;""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void operationAdditionWithString() {
		String nothingToAnalyze = """
            !! String en el lado izquierdo
            string cad10 = "Hola" + 1;
            string cad11 = "Hola" + "Mundo";
            string cad12 = "Hola" + 2.5;
            string cad13 = "Hola" + 'a';
            string cad14 = "Hola" + true;
            
            !! String en el lado derecho
            string cad15 = 1 + "Hola";
            string cad16 = 2.5 + "Hola";
            string cad17 = 'a' + "Hola";
            string cad18 = true + "Hola";""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue( analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationAdditionWithDecimal() {
		String nothingToAnalyze = """
            !! Decimal en el lado izquierdo
            decimal cad19 = 2.5 + 1;
            string cad20 = 2.5 + "Hola";
            decimal cad21 = 2.5 + 2.5;
            decimal cad22 = 2.5 + 'a';
            decimal cad23 = 2.5 + true;
            
            !! Decimal en el lado derecho
            decimal cad24 = 1 + 2.5;
            string cad25 = "Hola" + 2.5;
            decimal cad26 = 'a' + 2.5;
            decimal cad27 = true + 2.5;""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void operationAdditionWithChar() {
		String nothingToAnalyze = """
            !! Char en el lado izquierdo
            integer cad28 = 'a' + 1;
            string cad29 = 'a' + "Hola";
            decimal cad30 = 'a' + 2.5;
            integer cad31 = 'a' + 'a';
            integer cad32 = 'a' + true;
            
            !! Char en el lado derecho
            integer cad33 = 1 + 'a';
            string cad34 = "Hola" + 'a';
            decimal cad35 = 2.5 + 'a';
            integer cad36 = true + 'a';""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void operationAdditionWithBoolean() {
		String nothingToAnalyze = """
            !! Boolean en el lado izquierdo
            integer cad37 = true + 1;
            integer cad38 = true + "Hola";
            decimal cad39 = true + 2.5;
            integer cad40 = true + 'a';
            boolean cad41 = true + true;
            
            !! Boolean en el lado derecho
            integer cad42 = 1 + true;
            integer cad43 = "Hola" + true;
            decimal cad44 = 2.5 + true;
            integer cad45 = 'a' + true;""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue( analyzer.isError() && analyzer.getListError().size() == 2);
	}
    
}
