package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticComplexOperationTests {
    @Test
    void testUsingVariables() {
        String nothingToAnalyze = 
                        "string cad1 = \"hola\";\n" + //
                        "string cad2 = \"mundo\";\n" + //
                        "string cad3 = cad1 + cad2;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testAssignNewData() {
        String nothingToAnalyze = 
                        "string cad1 = \"hola\";\n" + //
                        "string cad2 = \"mundo\";\n" + //
                        "cad2 = \"mundo XD\";\n" + //
                        "string cad3 = cad1 + cad2;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testComplexOperation() {
        String nothingToAnalyze = 
                        "integer cad1 = ((3+5)*(12-4))+((9-3)*(8+2));" +
                        "integer cad2 = (((2.5+4)*(10-3.2))+((7.1-2)*(6+1.5)));"
                        ;
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }
}
