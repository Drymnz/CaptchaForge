package com.cunoc.CaptchaForge.Scripting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticOperationSustractionTests {
    @Test
	void operationSustractionWithInteger() {
		String nothingToAnalyze = """
            !! Integer en el lado izquierdo
            integer cad91 = 1 - 1;
            integer cad92 = 1 - "Hola";\s
            decimal cad93 = 1 - 2.5;
            integer cad94 = 1 - 'a';
            integer cad95 = 1 - true;
            
            !! Integer en el lado derecho
            integer cad96 = "Hola" - 1;\s
            decimal cad97 = 2.5 - 1;
            integer cad98 = 'a' - 1;
            integer cad99 = true - 1;""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue( analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationSustractionWithString() {
		String nothingToAnalyze = """
            !! String en el lado izquierdo
            string cad100 = "Hola" - 1;\s
            string cad101 = "Hola" - "Mundo";\s
            string cad102 = "Hola" - 2.5;\s
            string cad103 = "Hola" - 'a';\s
            string cad104 = "Hola" - true;\s
            
            !! String en el lado derecho
            string cad105 = 1 - "Hola";\s
            string cad106 = 2.5 - "Hola";\s
            string cad107 = 'a' - "Hola";\s
            string cad108 = true - "Hola";\s""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 9);
	}

    @Test
	void operationSustractionWithDecimal() {
		String nothingToAnalyze = """
            !! Decimal en el lado izquierdo
            decimal cad109 = 2.5 - 1;
            decimal cad110 = 2.5 - "Hola";\s
            decimal cad111 = 2.5 - 2.5;
            decimal cad112 = 2.5 - 'a';
            decimal cad113 = 2.5 - true;
            
            !! Decimal en el lado derecho
            decimal cad114 = 1 - 2.5;
            decimal cad115 = "Hola" - 2.5;\s
            decimal cad116 = 'a' - 2.5;
            decimal cad117 = true - 2.5;""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationSustractionWithChar() {
		String nothingToAnalyze = """
            !! Char en el lado izquierdo
            integer cad118 = 'a' - 1;
            integer cad119 = 'a' - "Hola";\s
            decimal cad120 = 'a' - 2.5;
            integer cad121 = 'a' - 'a';
            integer cad122 = 'a' - true;
            
            !! Char en el lado derecho
            integer cad123 = 1 - 'a';
            integer cad124 = "Hola" - 'a';\s
            decimal cad125 = 2.5 - 'a';
            decimal cad126 = true - 'a';""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 4);
	}

    @Test
	void operationSustractionWithBoolean() {
		String nothingToAnalyze = """
            !! Boolean en el lado izquierdo
            integer cad127 = true - 1;
            integer cad128 = true - "Hola";\s
            decimal cad129 = true - 2.5;
            decimal cad130 = true - 'a';
            decimal cad131 = true - true;
            
            !! Boolean en el lado derecho
            integer cad132 = 1 - true;
            integer cad133 = "Hola" - true;\s
            decimal cad134 = 2.5 - true;
            decimal cad135 = 'a' - true;""";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 5);
	}
}
