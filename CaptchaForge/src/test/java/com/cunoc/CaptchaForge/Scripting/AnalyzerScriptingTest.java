package com.cunoc.CaptchaForge.Scripting;

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
        String nothingToAnalyze = """
            decimal contador2, contador3 = 30.55 + 0.45;
            boolean f2, f1 = true && false;
            string cad4 = "Hola" + "mundo";
            char letra = 'A';
            contador = 1;
            estado = true;
            cad1 = "hola";
            cad2 = "mundo";
            cad3 = cad1 + cad2;""";
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
    void IFelseControlSentencesScripting() {
        String nothingToAnalyze = """
                                  IF (condicion) THEN
                                  !!bloque de instrucciones 1
                                  INIT {:
                                  :} END
                                  ELSE
                                  !!bloque de instrucciones 2
                                  INIT {:
                                  :} END
                                  """ 
        
        ;
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
        String nothingToAnalyze = """
                                  IF (condicion) THEN
                                  INIT {:
                                  :} END ELSE IF (condicion) THEN
                                  !!un bloque de instrucciones
                                  INIT {:
                                  :} END 
                                  ELSE IF (condicion) THEN 
                                  INIT {:
                                  :} END ELSE
                                  !!otro bloque de instrucciones
                                  INIT {:
                                  :} END""" 
        
        ;
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
        String nothingToAnalyze = """
                                  REPEAT (integer i=0 ) HUNTIL ((5*4)/2)
                                  !! bloque de instrucciones
                                  
                                  INIT {:
                                  
                                  :} END
                                  
                                  REPEAT (a=0) HUNTIL (var_limit)
                                  !! bloque de instrucciones
                                  
                                  INIT {:
                                      
                                  :} END""" 
        
        ;
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
        String nothingToAnalyze = """
                                  WHILE (CONDICION) THENWHILE
                                  !! bloque de instrucciones o sola una instrucci\u00f3n
                                  INIT {:
                                  :} END
                                  
                                  WHILE (true) THENWHILE
                                  
                                  INIT {:
                                      :} END""" 
        
        ;
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
        String nothingToAnalyze = """
                                  integer @global num1, num2, correct_answer;
                                          string operation;
                                  
                                              num1 = NUM_ALEATORIO() * 10;
                                              num2 = NUM_ALEATORIO() * 10;
                                              integer op = NUM_ALEATORIO();
                                  
                                              IF (op < 5) THEN
                                              INIT {:
                                                  operation = "+";
                                                  correct_answer = num1 + num2;
                                                  :} END
                                              ELSE
                                              INIT {:
                                                  operation = "-";
                                                  correct_answer = num1 - num2;
                                                  :} END
                                              string problem = num1 + " " + operation + " " + num2 + " = ?";
                                              !!getElementById('problem').innerHTML = problem;
                                  
                                          check_answer() [
                                              string user_input = getElementById('user_answer');
                                              integer user_answer = PARSE_INT(user_input);
                                              IF (user_answer == correct_answer) THEN
                                              INIT {:
                                                  !!getElementById('result').innerHTML = "Correct! Redirecting...";
                                                  ALERT_INFO("Congratulations! You solved the captcha.");
                                                  REDIRECT();
                                  
                                                  :} END
                                              ELSE
                                              INIT {:
                                                  !!getElementById('result').innerHTML = "Incorrect. Try again.";
                                                  num1 = NUM_ALEATORIO() * 10;
                                                  num2 = NUM_ALEATORIO() * 10;
                                                  integer op = NUM_ALEATORIO();
                                  
                                                  IF (op < 5) THEN
                                                  INIT {:
                                                      operation = "+";
                                                      correct_answer = num1 + num2;
                                                      :} END
                                                  ELSE
                                                  INIT {:
                                                      operation = "-";
                                                      correct_answer = num1 - num2;
                                                       :} END
                                  
                                                  !!string problem = num1 + " " + operation + " " + num2 + " = ?";
                                                  !!getElementById('problem').innerHTML = problem;
                                                  !!getElementById('user_answer').value = "";
                                              :} END
                                          ]""" 
        ;
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
