package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticOperationAdditionTests {
    @Test
	void contextLoads() {
		String nothingToAnalyze = "integer contador = 3;\n" + //
                        "string cad4 = \"mundo\";\n" + //
                        "decimal contador2 = 0.45;\n" + //
                        "boolean  f1 = true;\n" + //
                        "char letra = 'A';";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void operationAdditionWithInteger() {
		String nothingToAnalyze = "!! Integer en el lado izquierdo\n" + //
                        "integer cad1 = 1 + 1;\n" + //
                        "string cad2 = 1 + \"Hola\";\n" + //
                        "decimal cad3 = 1 + 2.5;\n" + //
                        "integer cad4 = 1 + 'a';\n" + //
                        "integer cad5 = 1 + true;\n" + //
                        "\n" + //
                        "!! Integer en el lado derecho\n" + //
                        "string cad6 = \"Hola\" + 1;\n" + //
                        "decimal cad7 = 2.5 + 1;\n" + //
                        "integer cad8 = 'a' + 1;\n" + //
                        "integer cad9 = true + 1;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void operationAdditionWithString() {
		String nothingToAnalyze = "!! String en el lado izquierdo\n" + //
                        "string cad10 = \"Hola\" + 1;\n" + //
                        "string cad11 = \"Hola\" + \"Mundo\";\n" + //
                        "string cad12 = \"Hola\" + 2.5;\n" + //
                        "string cad13 = \"Hola\" + 'a';\n" + //
                        "string cad14 = \"Hola\" + true;\n" + //
                        "\n" + //
                        "!! String en el lado derecho\n" + //
                        "string cad15 = 1 + \"Hola\";\n" + //
                        "string cad16 = 2.5 + \"Hola\";\n" + //
                        "string cad17 = 'a' + \"Hola\";\n" + //
                        "string cad18 = true + \"Hola\";";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue( analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationAdditionWithDecimal() {
		String nothingToAnalyze = "!! Decimal en el lado izquierdo\n" + //
                        "decimal cad19 = 2.5 + 1;\n" + //
                        "string cad20 = 2.5 + \"Hola\";\n" + //
                        "decimal cad21 = 2.5 + 2.5;\n" + //
                        "decimal cad22 = 2.5 + 'a';\n" + //
                        "decimal cad23 = 2.5 + true;\n" + //
                        "\n" + //
                        "!! Decimal en el lado derecho\n" + //
                        "decimal cad24 = 1 + 2.5;\n" + //
                        "string cad25 = \"Hola\" + 2.5;\n" + //
                        "decimal cad26 = 'a' + 2.5;\n" + //
                        "decimal cad27 = true + 2.5;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void operationAdditionWithChar() {
		String nothingToAnalyze = "!! Char en el lado izquierdo\n" + //
                        "integer cad28 = 'a' + 1;\n" + //
                        "string cad29 = 'a' + \"Hola\";\n" + //
                        "decimal cad30 = 'a' + 2.5;\n" + //
                        "integer cad31 = 'a' + 'a';\n" + //
                        "integer cad32 = 'a' + true;\n" + //
                        "\n" + //
                        "!! Char en el lado derecho\n" + //
                        "integer cad33 = 1 + 'a';\n" + //
                        "string cad34 = \"Hola\" + 'a';\n" + //
                        "decimal cad35 = 2.5 + 'a';\n" + //
                        "integer cad36 = true + 'a';";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void operationAdditionWithBoolean() {
		String nothingToAnalyze = "!! Boolean en el lado izquierdo\n" + //
                        "integer cad37 = true + 1;\n" + //
                        "integer cad38 = true + \"Hola\";\n" + //
                        "decimal cad39 = true + 2.5;\n" + //
                        "integer cad40 = true + 'a';\n" + //
                        "boolean cad41 = true + true;\n" + //
                        "\n" + //
                        "!! Boolean en el lado derecho\n" + //
                        "integer cad42 = 1 + true;\n" + //
                        "integer cad43 = \"Hola\" + true;\n" + //
                        "decimal cad44 = 2.5 + true;\n" + //
                        "integer cad45 = 'a' + true;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue( analyzer.isError() && analyzer.getListError().size() == 2);
	}
    
}
