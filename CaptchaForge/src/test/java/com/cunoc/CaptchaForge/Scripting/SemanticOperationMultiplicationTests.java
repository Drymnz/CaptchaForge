package com.cunoc.CaptchaForge.Scripting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticOperationMultiplicationTests {
    @Test
    void operationMultiplicationWithInteger() {
        String nothingToAnalyze = """
            !! Integer en el lado izquierdo
            integer cad46 = 1 * 1;
            decimal cad47 = 1 * "Hola"; \s
            decimal cad48 = 1 * 2.5;
            integer cad49 = 1 * 'a';
            integer cad50 = 1 * true;
            
            !! Integer en el lado derecho
            integer cad51 = "Hola" * 1; \s
            decimal cad52 = 2.5 * 1;
            integer cad53 = 'a' * 1;
            integer cad54 = true * 1;""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithString() {
        String nothingToAnalyze = """
            !! String en el lado izquierdo
            string cad55 = "Hola" * 1; \s
            string cad56 = "Hola" * "Mundo"; \s
            string cad57 = "Hola" * 2.5; \s
            string cad58 = "Hola" * 'a'; \s
            string cad59 = "Hola" * true; \s
            
            !! String en el lado derecho
            string cad60 = 1 * "Hola"; \s
            string cad61 = 2.5 * "Hola"; \s
            string cad62 = 'a' * "Hola"; \s
            string cad63 = true * "Hola"; \s""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 9);
    }

    @Test
    void operationMultiplicationWithDecimal() {
        String nothingToAnalyze = """
            !! Decimal en el lado izquierdo
            decimal cad64 = 2.5 * 1;
            decimal cad65 = 2.5 * "Hola"; \s
            decimal cad66 = 2.5 * 2.5;
            decimal cad67 = 2.5 * 'a';
            decimal cad68 = 2.5 * true;
            
            !! Decimal en el lado derecho
            decimal cad69 = 1 * 2.5;
            decimal cad70 = "Hola" * 2.5; \s
            decimal cad71 = 'a' * 2.5;
            decimal cad72 = true * 2.5;""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithChar() {
        String nothingToAnalyze = """
            !! Char en el lado izquierdo
            integer cad73 = 'a' * 1;
            integer cad74 = 'a' * "Hola"; \s
            decimal cad75 = 'a' * 2.5;
            integer cad76 = 'a' * 'a'; \s
            integer cad77 = 'a' * true;
            
            !! Char en el lado derecho
            integer cad78 = 1 * 'a';
            integer cad79 = "Hola" * 'a'; \s
            decimal cad80 = 2.5 * 'a';
            integer cad81 = true * 'a';""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithBoolean() {
        String nothingToAnalyze = """
            !! Boolean en el lado izquierdo
            integer cad82 = true * 1;
            integer cad83 = true * "Hola"; \s
            integer cad84 = true * 2.5;
            integer cad85 = true * 'a';
            boolean cad86 = true * true;
            
            !! Boolean en el lado derecho
            integer cad87 = 1 * true;
            integer cad88 = "Hola" * true; \s
            decimal cad89 = 2.5 * true;
            integer cad90 = 'a' * true;""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }
}
