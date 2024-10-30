package com.cunoc.CaptchaForge.Scripting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class AnalyzerSintactico {
    String ifOperation = """
                                  integer @global num1 = 1;
                                          
                                  
                                              IF ( num1 < 5 ) THEN
                                              INIT {:
                                                  num1 = num1 + 1;
                                                  :} END
                                              ELSE
                                              INIT {:
                                                  string operation = "-";
                                                  :} END
                                          """ 
        ;

    @Test
    void complexFirstScripting() {
        AnalyzerScripting analyzer = new AnalyzerScripting(ifOperation);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    String errorOnew = """
                                 ON_LOAD () [ 
                                                                        INSERT('<C_INPUT [type= "text"] [text-align= "center"] [id= "entrada_1"] >'); 
                        INSERT('</C_INPUT>'); 
                    ] 
                 
                    FUNCTION_calc() [ 
                                                integer @global contador_fallas = 5; 
                        string result_caja_texto = getElementById('entrada_1'); 
                        string result = "10 "; 
                        string mensaje_fallo = "El captcha no fue validado intente otra vez "; 
                        string mensaje_acierto = "El captcha fue validado "; 
                        string mensaje_final = "El captcha no logró ser validado :( intente mas tarde"; 
                                                IF (contador_fallas == 0) THEN 
                            INIT {: 
                                ALERT_INFO(mensaje_final); 
                                EXIT(); 
                            :} END 
                                                IF (result_caja_texto == result ) THEN 
                                                        INIT {: 
                                ALERT_INFO(mensaje_acierto); 
                                REDIRECT(); 
                            :} END 
                        ELSE 
                                                        INIT {: 
                                ALERT_INFO(mensaje_fallo); 
                                contador_fallas = contador_fallas - 1; 
                            :} END 
                    ] 
                                          """ 
        ;

    @Test
    void errorOne() {
        AnalyzerScripting analyzer = new AnalyzerScripting(errorOnew);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError());
    }
}
