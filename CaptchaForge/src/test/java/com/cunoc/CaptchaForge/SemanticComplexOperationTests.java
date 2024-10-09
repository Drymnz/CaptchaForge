package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SemanticComplexOperationTests {
    @Test
    void testUsingVariables() {
        String nothingToAnalyze = """
                                  string cad1 = "hola";
                                  string cad2 = "mundo";
                                  string cad3 = cad1 + cad2;""" //
        ;
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testAssignNewData() {
        String nothingToAnalyze = 
                        """
                        string cad1 = "hola";
                        string cad2 = "mundo";
                        cad2 = "mundo XD";
                        string cad3 = cad1 + cad2;""" //
        //
        //
        ;
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testComplexOperation() {
        String nothingToAnalyze = 
                        // valor 82.449
                        "integer cad1 = ((3+5)*(12-4))+((9-3)*(8+2));" +
                        // valor 124
                        "integer cad2 = (((2.5+4)*(10-3.2))+((7.1-2)*(6+1.5)));"+
                        // valor 30
                        "integer cad3 = ((-6+3)*(-8-4))-((7-9)*(-5+2));"
                        ;
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }
}
