package com.cunoc.CaptchaForge.Scripting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticOperationDivisionTests {
    @Test
    void operationMultiplicationWithInteger() {
        String nothingToAnalyze = """
            !! Integer en el lado izquierdo
            decimal cad136 = 1 / 1;
            decimal cad137 = 1 / "Hola"; \s
            decimal cad138 = 1 / 2.5;
            decimal cad139 = 1 / 'a';
            integer cad140 = 1 / true; \s
            
            !! Integer en el lado derecho
            decimal cad141 = "Hola" / 1; \s
            decimal cad142 = 2.5 / 1;
            decimal cad143 = 'a' / 1;
            decimal cad144 = true / 1; \s""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithString() {
        String nothingToAnalyze = """
            !! String en el lado izquierdo
            decimal cad145 = "Hola" / 1; \s
            decimal cad146 = "Hola" / "Mundo"; \s
            decimal cad147 = "Hola" / 2.5; \s
            decimal cad148 = "Hola" / 'a'; \s
            decimal cad149 = "Hola" / true; \s
            
            !! String en el lado derecho
            decimal cad150 = 1 / "Hola"; \s
            decimal cad151 = 2.5 / "Hola"; \s
            decimal cad152 = 'a' / "Hola"; \s
            decimal cad153 = true / "Hola";\s""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 9);
    }

    @Test
    void operationMultiplicationWithDecimal() {
        String nothingToAnalyze = """
            !! Decimal en el lado izquierdo
            decimal cad154 = 2.5 / 1;
            decimal cad155 = 2.5 / "Hola"; \s
            decimal cad156 = 2.5 / 2.5;
            decimal cad157 = 2.5 / 'a';
            decimal cad158 = 2.5 / true; \s
            
            !! Decimal en el lado derecho
            decimal cad159 = 1 / 2.5;
            decimal cad160 = "Hola" / 2.5; \s
            decimal cad161 = 'a' / 2.5;
            decimal cad162 = true / 2.5; \s""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithChar() {
        String nothingToAnalyze = """
            !! Char en el lado izquierdo
            decimal cad163 = 'a' / 1;
            decimal cad164 = 'a' / "Hola"; \s
            decimal cad165 = 'a' / 2.5;
            decimal cad166 = 'a' / 'a'; \s
            decimal cad167 = 'a' / true; \s
            
            !! Char en el lado derecho
            decimal cad168 = 1 / 'a';
            decimal cad169 = "Hola" / 'a'; \s
            decimal cad170 = 2.5 / 'a';
            decimal cad171 = true / 'a';\s""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithBoolean() {
        String nothingToAnalyze = """
            !! Boolean en el lado izquierdo
            decimal cad172 = true / 1; \s
            decimal cad173 = true / "Hola"; \s
            decimal cad174 = true / 2.5; \s
            decimal cad175 = true / 'a'; \s
            decimal cad176 = true / true; \s
            
            !! Boolean en el lado derecho
            integer cad177 = 1 / true; \s
            decimal cad178 = "Hola" / true; \s
            decimal cad179 = 2.5 / true; \s
            decimal cad180 = 'a' / true; \s""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 3);
    }
}
