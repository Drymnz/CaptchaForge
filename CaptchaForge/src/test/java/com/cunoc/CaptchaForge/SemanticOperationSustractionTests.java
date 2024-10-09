package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticOperationSustractionTests {
    @Test
	void operationSustractionWithInteger() {
		String nothingToAnalyze = "!! Integer en el lado izquierdo\n" + //
                        "integer cad91 = 1 - 1;\n" + //
                        "integer cad92 = 1 - \"Hola\"; \n" + //
                        "decimal cad93 = 1 - 2.5;\n" + //
                        "integer cad94 = 1 - 'a';\n" + //
                        "integer cad95 = 1 - true;\n" + //
                        "\n" + //
                        "!! Integer en el lado derecho\n" + //
                        "integer cad96 = \"Hola\" - 1; \n" + //
                        "decimal cad97 = 2.5 - 1;\n" + //
                        "integer cad98 = 'a' - 1;\n" + //
                        "integer cad99 = true - 1;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue( analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationSustractionWithString() {
		String nothingToAnalyze = "!! String en el lado izquierdo\n" + //
                        "string cad100 = \"Hola\" - 1; \n" + //
                        "string cad101 = \"Hola\" - \"Mundo\"; \n" + //
                        "string cad102 = \"Hola\" - 2.5; \n" + //
                        "string cad103 = \"Hola\" - 'a'; \n" + //
                        "string cad104 = \"Hola\" - true; \n" + //
                        "\n" + //
                        "!! String en el lado derecho\n" + //
                        "string cad105 = 1 - \"Hola\"; \n" + //
                        "string cad106 = 2.5 - \"Hola\"; \n" + //
                        "string cad107 = 'a' - \"Hola\"; \n" + //
                        "string cad108 = true - \"Hola\"; ";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 9);
	}

    @Test
	void operationSustractionWithDecimal() {
		String nothingToAnalyze = "!! Decimal en el lado izquierdo\n" + //
                        "decimal cad109 = 2.5 - 1;\n" + //
                        "decimal cad110 = 2.5 - \"Hola\"; \n" + //
                        "decimal cad111 = 2.5 - 2.5;\n" + //
                        "decimal cad112 = 2.5 - 'a';\n" + //
                        "decimal cad113 = 2.5 - true;\n" + //
                        "\n" + //
                        "!! Decimal en el lado derecho\n" + //
                        "decimal cad114 = 1 - 2.5;\n" + //
                        "decimal cad115 = \"Hola\" - 2.5; \n" + //
                        "decimal cad116 = 'a' - 2.5;\n" + //
                        "decimal cad117 = true - 2.5;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationSustractionWithChar() {
		String nothingToAnalyze = "!! Char en el lado izquierdo\n" + //
                        "integer cad118 = 'a' - 1;\n" + //
                        "integer cad119 = 'a' - \"Hola\"; \n" + //
                        "decimal cad120 = 'a' - 2.5;\n" + //
                        "integer cad121 = 'a' - 'a';\n" + //
                        "integer cad122 = 'a' - true;\n" + //
                        "\n" + //
                        "!! Char en el lado derecho\n" + //
                        "integer cad123 = 1 - 'a';\n" + //
                        "integer cad124 = \"Hola\" - 'a'; \n" + //
                        "decimal cad125 = 2.5 - 'a';\n" + //
                        "decimal cad126 = true - 'a';";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 4);
	}

    @Test
	void operationSustractionWithBoolean() {
		String nothingToAnalyze = "!! Boolean en el lado izquierdo\n" + //
                        "integer cad127 = true - 1;\n" + //
                        "integer cad128 = true - \"Hola\"; \n" + //
                        "decimal cad129 = true - 2.5;\n" + //
                        "decimal cad130 = true - 'a';\n" + //
                        "decimal cad131 = true - true;\n" + //
                        "\n" + //
                        "!! Boolean en el lado derecho\n" + //
                        "integer cad132 = 1 - true;\n" + //
                        "integer cad133 = \"Hola\" - true; \n" + //
                        "decimal cad134 = 2.5 - true;\n" + //
                        "decimal cad135 = 'a' - true;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 5);
	}
}
