package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class SematicFunctionTest {
    @Test
    void testFunctionASC() {
        String nothingToAnalyze = "string cad1 = ASC(\"Hola mundo a todos\");";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        String resturnString = analyzer.getAnalyzerSemantico().getTablaSimbolos().get("cad1").getValue();
        Assertions.assertTrue(!analyzer.isError() && resturnString.equals("   Haaddlmnoooostu"));
    }

    @Test
    void testFunctionDESC() {
        String nothingToAnalyze = "string cad1 = DESC(\"Hola mundo a todos\");";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        String resturnString = analyzer.getAnalyzerSemantico().getTablaSimbolos().get("cad1").getValue();
        Assertions.assertTrue(!analyzer.isError() && resturnString.equals("utsoooonmlddaaH   "));
    }

    @Test
    void testFunctionLETPAR_NUM() {
        String nothingToAnalyze = "string cad1 = LETPAR_NUM(\"Hola mundo a todos\");";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        String resturnString = analyzer.getAnalyzerSemantico().getTablaSimbolos().get("cad1").getValue();
        Assertions.assertTrue(!analyzer.isError() && resturnString.equals("72o108a32m117n100o32a32t111d111s"));
    }

    @Test
    void testFunctionLETIMPAR_NUM() {
        String nothingToAnalyze = "string cad1 = LETIMPAR_NUM(\"Hola mundo a todos\");";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        String resturnString = analyzer.getAnalyzerSemantico().getTablaSimbolos().get("cad1").getValue();
        Assertions.assertTrue(!analyzer.isError() && resturnString.equals("H111l97 109u110d111 97 116o100o115"));
    }

    @Test
    void testFunctionREVERSE() {
        String nothingToAnalyze = "string cad1 = REVERSE(\"Hola mundo a todos\");";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        String resturnString = analyzer.getAnalyzerSemantico().getTablaSimbolos().get("cad1").getValue();
        Assertions.assertTrue(!analyzer.isError() && resturnString.equals("sodot a odnum aloH"));
    }

    @Test
    void testFunctionCARACTER_ALEATORIO() {
        String nothingToAnalyze = "string cad1 = CARACTER_ALEATORIO();";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean resturnString = analyzer.getAnalyzerSemantico().getTablaSimbolos().get("cad1") != null;
        Assertions.assertTrue(!analyzer.isError() && resturnString);
    }

    @Test
    void testFunctionNUM_ALEATORIO() {
        String nothingToAnalyze = "string cad1 = NUM_ALEATORIO();";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean resturnString = analyzer.getAnalyzerSemantico().getTablaSimbolos().get("cad1") != null;
        Assertions.assertTrue(!analyzer.isError() && resturnString);
    }
}
