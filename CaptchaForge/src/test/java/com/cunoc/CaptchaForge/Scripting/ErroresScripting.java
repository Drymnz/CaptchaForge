package com.cunoc.CaptchaForge.Scripting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class ErroresScripting {
    @Test
    void firsError() {
        AnalyzerScripting analyzer = new AnalyzerScripting(ErroresLargos.ERROR_FIRST);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError());
    }
    @Test
    void secondError() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.ERROR_SECOND);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }
}
