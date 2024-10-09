package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticOperationMultiplicationTests {
    @Test
    void operationMultiplicationWithInteger() {
        String nothingToAnalyze = "!! Integer en el lado izquierdo\n" + //
                "integer cad46 = 1 * 1;\n" + //
                "decimal cad47 = 1 * \"Hola\";  \n" + //
                "decimal cad48 = 1 * 2.5;\n" + //
                "integer cad49 = 1 * 'a';\n" + //
                "integer cad50 = 1 * true;\n" + //
                "\n" + //
                "!! Integer en el lado derecho\n" + //
                "integer cad51 = \"Hola\" * 1;  \n" + //
                "decimal cad52 = 2.5 * 1;\n" + //
                "integer cad53 = 'a' * 1;\n" + //
                "integer cad54 = true * 1;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithString() {
        String nothingToAnalyze = "!! String en el lado izquierdo\n" + //
                "string cad55 = \"Hola\" * 1;  \n" + //
                "string cad56 = \"Hola\" * \"Mundo\";  \n" + //
                "string cad57 = \"Hola\" * 2.5;  \n" + //
                "string cad58 = \"Hola\" * 'a';  \n" + //
                "string cad59 = \"Hola\" * true;  \n" + //
                "\n" + //
                "!! String en el lado derecho\n" + //
                "string cad60 = 1 * \"Hola\";  \n" + //
                "string cad61 = 2.5 * \"Hola\";  \n" + //
                "string cad62 = 'a' * \"Hola\";  \n" + //
                "string cad63 = true * \"Hola\";  ";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 9);
    }

    @Test
    void operationMultiplicationWithDecimal() {
        String nothingToAnalyze = "!! Decimal en el lado izquierdo\n" + //
                "decimal cad64 = 2.5 * 1;\n" + //
                "decimal cad65 = 2.5 * \"Hola\";  \n" + //
                "decimal cad66 = 2.5 * 2.5;\n" + //
                "decimal cad67 = 2.5 * 'a';\n" + //
                "decimal cad68 = 2.5 * true;\n" + //
                "\n" + //
                "!! Decimal en el lado derecho\n" + //
                "decimal cad69 = 1 * 2.5;\n" + //
                "decimal cad70 = \"Hola\" * 2.5;  \n" + //
                "decimal cad71 = 'a' * 2.5;\n" + //
                "decimal cad72 = true * 2.5;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithChar() {
        String nothingToAnalyze = "!! Char en el lado izquierdo\n" + //
                "integer cad73 = 'a' * 1;\n" + //
                "integer cad74 = 'a' * \"Hola\";  \n" + //
                "decimal cad75 = 'a' * 2.5;\n" + //
                "integer cad76 = 'a' * 'a';  \n" + //
                "integer cad77 = 'a' * true;\n" + //
                "\n" + //
                "!! Char en el lado derecho\n" + //
                "integer cad78 = 1 * 'a';\n" + //
                "integer cad79 = \"Hola\" * 'a';  \n" + //
                "decimal cad80 = 2.5 * 'a';\n" + //
                "integer cad81 = true * 'a';";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithBoolean() {
        String nothingToAnalyze = "!! Boolean en el lado izquierdo\n" + //
                "integer cad82 = true * 1;\n" + //
                "integer cad83 = true * \"Hola\";  \n" + //
                "integer cad84 = true * 2.5;\n" + //
                "integer cad85 = true * 'a';\n" + //
                "boolean cad86 = true * true;\n" + //
                "\n" + //
                "!! Boolean en el lado derecho\n" + //
                "integer cad87 = 1 * true;\n" + //
                "integer cad88 = \"Hola\" * true;  \n" + //
                "decimal cad89 = 2.5 * true;\n" + //
                "integer cad90 = 'a' * true;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }
}
