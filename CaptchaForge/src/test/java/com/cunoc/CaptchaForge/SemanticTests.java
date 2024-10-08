package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticTests {
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
	void operationSume() {
		String nothingToAnalyze = "integer contador = 3+1;\n";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
	}
}
