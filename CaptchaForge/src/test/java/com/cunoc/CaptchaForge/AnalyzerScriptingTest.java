package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.Analyzer.ErrorTypeInTheInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class AnalyzerScriptingTest {

    @Test
    void firstScripting() {
        String nothingToAnalyze = "!! Estas instrucciones no se ejecutan hasta llamar a\n";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void functionScripting() {
        String nothingToAnalyze = "FUNCTION_calc() [ ]";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void statementScripting() {
        String nothingToAnalyze = "boolean estado; integer @global contador; string cad1, cad2, cad3;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }
    
    @Test
    void assignScripting() {
        String nothingToAnalyze = "decimal contador2, contador3 = 30.55 + 0.45;"+
        "boolean f2, f1 = true && false;" + 
        "string cad4 = \"Hola\" + \"mundo\";"+
        "char letra = 'A';"+
        "contador = 1;"+
        "estado = true;\n" + //
                        "cad1 = \"hola\";\n" + //
                        "cad2 = \"mundo\";\n" + //
                        "cad3 = cad1 + cad2;";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean errorAnalyzer = false;
        for (ReportErrorInterpreter element : analyzer.getListError()) {
            if (element.getType() == ErrorTypeInTheInterpreter.LEXICON 
             || element.getType() == ErrorTypeInTheInterpreter.SYNTACTIC) {
                errorAnalyzer = true;
                break;
            }
        }
        Assertions.assertTrue(!errorAnalyzer);
    }

    @Test
    void assignWithFunctionScripting() {
        String nothingToAnalyze = "string caja_texto = getElemenById('entrada_1');";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean errorAnalyzer = false;
        for (ReportErrorInterpreter element : analyzer.getListError()) {
            if (element.getType() == ErrorTypeInTheInterpreter.LEXICON 
             || element.getType() == ErrorTypeInTheInterpreter.SYNTACTIC) {
                errorAnalyzer = true;
                break;
            }
        }
        Assertions.assertTrue(!errorAnalyzer);
    }

    @Test
    void IFControlSentencesScripting() {
        String nothingToAnalyze = "IF (condicion) THEN\n" + //
                        "INIT {:\n" + //
                        ":} END";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean errorAnalyzer = false;
        for (ReportErrorInterpreter element : analyzer.getListError()) {
            if (element.getType() == ErrorTypeInTheInterpreter.LEXICON 
             || element.getType() == ErrorTypeInTheInterpreter.SYNTACTIC) {
                errorAnalyzer = true;
                break;
            }
        }
        Assertions.assertTrue(!errorAnalyzer);
    }

    @Test
    void IFelseControlSentencesScripting() {
        String nothingToAnalyze = "IF (condicion) THEN\n" + //
                        "!!bloque de instrucciones 1\n" + //
                        "INIT {:\n" + //
                        ":} END\n" + //
                        "ELSE\n" + //
                        "!!bloque de instrucciones 2\n" + //
                        "INIT {:\n" + //
                        ":} END";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean errorAnalyzer = false;
        for (ReportErrorInterpreter element : analyzer.getListError()) {
            if (element.getType() == ErrorTypeInTheInterpreter.LEXICON 
             || element.getType() == ErrorTypeInTheInterpreter.SYNTACTIC) {
                errorAnalyzer = true;
                break;
            }
        }
        Assertions.assertTrue(!errorAnalyzer);
    }

    @Test
    void IFelseIfControlSentencesScripting() {
        String nothingToAnalyze = "IF (condicion) THEN\n" + //
                        "INIT {:\n" + //
                                                        ":} END "+
                                                        "ELSE IF (condicion) THEN\n" + //
                                                        "!!un bloque de instrucciones\n" + //
                                                        "INIT {:\n" + //
                                                        ":} END \n" + //
                                                        "ELSE IF (condicion) THEN \n" + //
                                                        "INIT {:\n" + //
                                                        ":} END" + //
                                                        " ELSE\n" + //
                                                        "!!otro bloque de instrucciones\n" + //
                                                        "INIT {:\n" + //
                                                        ":} END";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean errorAnalyzer = false;
        for (ReportErrorInterpreter element : analyzer.getListError()) {
            if (element.getType() == ErrorTypeInTheInterpreter.LEXICON 
             || element.getType() == ErrorTypeInTheInterpreter.SYNTACTIC) {
                errorAnalyzer = true;
                break;
            }
        }
        Assertions.assertTrue(!errorAnalyzer);
    }

    @Test
    void repeatScripting() {
        String nothingToAnalyze = "REPEAT (integer i=0 ) HUNTIL ((5*4)/2)\n" + //
                        "!! bloque de instrucciones\n" + //
                        "\n" + //
                        "INIT {:\n" + //
                        "\n" + //
                        ":} END\n" + //
                        "\n" + //
                        "REPEAT (a=0) HUNTIL (var_limit)\n" + //
                        "!! bloque de instrucciones\n" + //
                        "\n" + //
                        "INIT {:\n" + //
                        "    \n" + //
                        ":} END";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean errorAnalyzer = false;
        for (ReportErrorInterpreter element : analyzer.getListError()) {
            if (element.getType() == ErrorTypeInTheInterpreter.LEXICON 
             || element.getType() == ErrorTypeInTheInterpreter.SYNTACTIC) {
                errorAnalyzer = true;
                break;
            }
        }
        Assertions.assertTrue(!errorAnalyzer);
    }

    @Test
    void whileScripting() {
        String nothingToAnalyze = "WHILE (CONDICION) THENWHILE\n" + //
                        "!! bloque de instrucciones o sola una instrucción\n" + //
                        "INIT {:\n" + //
                        ":} END\n" + //
                        "\n" + //
                        "WHILE (true) THENWHILE\n" + //
                        "\n" + //
                        "INIT {:\n" + //
                        "    :} END";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean errorAnalyzer = false;
        for (ReportErrorInterpreter element : analyzer.getListError()) {
            if (element.getType() == ErrorTypeInTheInterpreter.LEXICON 
             || element.getType() == ErrorTypeInTheInterpreter.SYNTACTIC) {
                errorAnalyzer = true;
                break;
            }
        }
        Assertions.assertTrue(!errorAnalyzer);
    }

    @Test
    void complexFirstScripting() {
        String nothingToAnalyze = "integer @global num1, num2, correct_answer;\n" + //
                        "        string operation;\n" + //
                        "\n" + //
                        "        INIT {:\n" + //
                        "            num1 = NUM_ALEATORIO() * 10;\n" + //
                        "            num2 = NUM_ALEATORIO() * 10;\n" + //
                        "            integer op = NUM_ALEATORIO();\n" + //
                        "\n" + //
                        "            IF (op < 5) THEN\n" + //
                        "            INIT {:\n" + //
                        "                operation = \"+\";\n" + //
                        "                correct_answer = num1 + num2;\n" + //
                        "                :} END\n" + //
                        "            ELSE\n" + //
                        "            INIT {:\n" + //
                        "                operation = \"-\";\n" + //
                        "                correct_answer = num1 - num2;\n" + //
                        "                :} END\n" + //
                        "            string problem = num1 + \" \" + operation + \" \" + num2 + \" = ?\";\n" + //
                        "            !!getElementById('problem').innerHTML = problem;\n" + //
                        "        :} END\n" + //
                        "\n" + //
                        "        check_answer() [\n" + //
                        "            string user_input = getElementById('user_answer');\n" + //
                        "            integer user_answer = PARSE_INT(user_input);\n" + //
                        "            IF (user_answer == correct_answer) THEN\n" + //
                        "            INIT {:\n" + //
                        "                !!getElementById('result').innerHTML = \"Correct! Redirecting...\";\n" + //
                        "                ALERT_INFO(\"Congratulations! You solved the captcha.\");\n" + //
                        "                REDIRECT();\n" + //
                        "\n" + //
                        "                :} END\n" + //
                        "            ELSE\n" + //
                        "            INIT {:\n" + //
                        "                !!getElementById('result').innerHTML = \"Incorrect. Try again.\";\n" + //
                        "                num1 = NUM_ALEATORIO() * 10;\n" + //
                        "                num2 = NUM_ALEATORIO() * 10;\n" + //
                        "                integer op = NUM_ALEATORIO();\n" + //
                        "\n" + //
                        "                IF (op < 5) THEN\n" + //
                        "                INIT {:\n" + //
                        "                    operation = \"+\";\n" + //
                        "                    correct_answer = num1 + num2;\n" + //
                        "                    :} END\n" + //
                        "                ELSE\n" + //
                        "                INIT {:\n" + //
                        "                    operation = \"-\";\n" + //
                        "                    correct_answer = num1 - num2;\n" + //
                        "                     :} END\n" + //
                        "\n" + //
                        "                !!string problem = num1 + \" \" + operation + \" \" + num2 + \" = ?\";\n" + //
                        "                !!getElementById('problem').innerHTML = problem;\n" + //
                        "                !!getElementById('user_answer').value = \"\";\n" + //
                        "            :} END\n" + //
                        "        ]";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        boolean errorAnalyzer = false;
        for (ReportErrorInterpreter element : analyzer.getListError()) {
            if (element.getType() == ErrorTypeInTheInterpreter.LEXICON 
             || element.getType() == ErrorTypeInTheInterpreter.SYNTACTIC) {
                errorAnalyzer = true;
                break;
            }
        }
        Assertions.assertTrue(!errorAnalyzer);
    }
}
