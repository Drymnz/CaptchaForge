package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticOperationMultiplicationTests {
    @Test
	void operationSustractionWithInteger() {
		String nothingToAnalyze = "";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue( analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationSustractionWithString() {
		String nothingToAnalyze = "";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 9);
	}

    @Test
	void operationSustractionWithDecimal() {
		String nothingToAnalyze = "";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 2);
	}

    @Test
	void operationSustractionWithChar() {
		String nothingToAnalyze = "";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 4);
	}

    @Test
	void operationSustractionWithBoolean() {
		String nothingToAnalyze = "";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 5);
	}
}
