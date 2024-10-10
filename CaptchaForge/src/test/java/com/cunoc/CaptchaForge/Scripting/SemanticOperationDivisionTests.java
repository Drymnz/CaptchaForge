package com.cunoc.CaptchaForge.Scripting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticOperationDivisionTests {
    @Test
    void operationMultiplicationWithInteger() {
        String nothingToAnalyze = "!! Integer en el lado izquierdo\n" + //
                        "decimal cad136 = 1 / 1;\n" + //
                        "decimal cad137 = 1 / \"Hola\";  \n" + //
                        "decimal cad138 = 1 / 2.5;\n" + //
                        "decimal cad139 = 1 / 'a';\n" + //
                        "integer cad140 = 1 / true;  \n" + //
                        "\n" + //
                        "!! Integer en el lado derecho\n" + //
                        "decimal cad141 = \"Hola\" / 1;  \n" + //
                        "decimal cad142 = 2.5 / 1;\n" + //
                        "decimal cad143 = 'a' / 1;\n" + //
                        "decimal cad144 = true / 1;  ";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithString() {
        String nothingToAnalyze = "!! String en el lado izquierdo\n" + //
                        "decimal cad145 = \"Hola\" / 1;  \n" + //
                        "decimal cad146 = \"Hola\" / \"Mundo\";  \n" + //
                        "decimal cad147 = \"Hola\" / 2.5;  \n" + //
                        "decimal cad148 = \"Hola\" / 'a';  \n" + //
                        "decimal cad149 = \"Hola\" / true;  \n" + //
                        "\n" + //
                        "!! String en el lado derecho\n" + //
                        "decimal cad150 = 1 / \"Hola\";  \n" + //
                        "decimal cad151 = 2.5 / \"Hola\";  \n" + //
                        "decimal cad152 = 'a' / \"Hola\";  \n" + //
                        "decimal cad153 = true / \"Hola\"; ";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 9);
    }

    @Test
    void operationMultiplicationWithDecimal() {
        String nothingToAnalyze = "!! Decimal en el lado izquierdo\n" + //
                        "decimal cad154 = 2.5 / 1;\n" + //
                        "decimal cad155 = 2.5 / \"Hola\";  \n" + //
                        "decimal cad156 = 2.5 / 2.5;\n" + //
                        "decimal cad157 = 2.5 / 'a';\n" + //
                        "decimal cad158 = 2.5 / true;  \n" + //
                        "\n" + //
                        "!! Decimal en el lado derecho\n" + //
                        "decimal cad159 = 1 / 2.5;\n" + //
                        "decimal cad160 = \"Hola\" / 2.5;  \n" + //
                        "decimal cad161 = 'a' / 2.5;\n" + //
                        "decimal cad162 = true / 2.5;  ";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithChar() {
        String nothingToAnalyze = "!! Char en el lado izquierdo\n" + //
                        "decimal cad163 = 'a' / 1;\n" + //
                        "decimal cad164 = 'a' / \"Hola\";  \n" + //
                        "decimal cad165 = 'a' / 2.5;\n" + //
                        "decimal cad166 = 'a' / 'a';  \n" + //
                        "decimal cad167 = 'a' / true;  \n" + //
                        "\n" + //
                        "!! Char en el lado derecho\n" + //
                        "decimal cad168 = 1 / 'a';\n" + //
                        "decimal cad169 = \"Hola\" / 'a';  \n" + //
                        "decimal cad170 = 2.5 / 'a';\n" + //
                        "decimal cad171 = true / 'a'; ";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
    }

    @Test
    void operationMultiplicationWithBoolean() {
        String nothingToAnalyze = "!! Boolean en el lado izquierdo\n" + //
                        "decimal cad172 = true / 1;  \n" + //
                        "decimal cad173 = true / \"Hola\";  \n" + //
                        "decimal cad174 = true / 2.5;  \n" + //
                        "decimal cad175 = true / 'a';  \n" + //
                        "decimal cad176 = true / true;  \n" + //
                        "\n" + //
                        "!! Boolean en el lado derecho\n" + //
                        "integer cad177 = 1 / true;  \n" + //
                        "decimal cad178 = \"Hola\" / true;  \n" + //
                        "decimal cad179 = 2.5 / true;  \n" + //
                        "decimal cad180 = 'a' / true;  ";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 3);
    }
}
