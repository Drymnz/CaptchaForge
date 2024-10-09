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
        Assertions.assertTrue( analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationMultiplicationWithString() {
		String nothingToAnalyze = "";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 9);
	}

    @Test
	void operationMultiplicationWithDecimal() {
		String nothingToAnalyze = "";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationMultiplicationWithChar() {
		String nothingToAnalyze = "";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 4);
	}

    @Test
	void operationMultiplicationWithBoolean() {
		String nothingToAnalyze = "";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 5);
	}
}
