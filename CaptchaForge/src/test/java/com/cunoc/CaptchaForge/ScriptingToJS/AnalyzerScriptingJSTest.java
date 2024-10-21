package com.cunoc.CaptchaForge.ScriptingToJS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScriptingToJS;

public class AnalyzerScriptingJSTest {
    private String nothingToAnalyze = "FUNCTION_calc() [\n" + //
                        "            !! Estas instrucciones no se ejecutan hasta llamar a FUNCTION_calc()\n" + //
                        "             integer @global contador_fallas = 5;\n" + //
                        "            string result_caja_texto = getElemenById ('entrada_1');\n" + //
                        "            string result = \"10 \";\n" + //
                        "            string mensaje_fallo = \"El captcha no fue validado intente otra vez \";\n" + //
                        "            string mensaje_acierto = \"El captcha fue validado \";\n" + //
                        "            string mensaje_final = \"El captcha no logró ser validado :( intente mas tarde\";\n" + //
                        "            !! Validacion del numero de oportunidades restantes\n" + //
                        "            IF (contador_fallas == 0) THEN\n" + //
                        "            INIT {:\n" + //
                        "            ALERT_INFO(mensaje_final);\n" + //
                        "            EXIT();\n" + //
                        "            :} END\n" + //
                        "            !! Validación de fallas y aciertos\n" + //
                        "            IF (result_caja_texto == result ) THEN\n" + //
                        "            !!si el resultado es correcto\n" + //
                        "            INIT {:\n" + //
                        "            ALERT_INFO(mensaje_acierto);\n" + //
                        "            REDIRECT(); !!puede usarse también EXIT() para redirigir\n" + //
                        "            :} END\n" + //
                        "            ELSE\n" + //
                        "            !!si el intento es incorrecto\n" + //
                        "            INIT {:\n" + //
                        "            ALERT_INFO(mensaje_fallo);\n" + //
                        "            contador_fallas = contador_fallas -1;\n" + //
                        "            :} END\n" + //
                        "        ]";

    @Test
    void complexFirstScripting() {
        AnalyzerScriptingToJS analyzer = new AnalyzerScriptingToJS(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void errorOne() {
        AnalyzerScriptingToJS analyzer = new AnalyzerScriptingToJS("""
             FUNCTION_seleccionar_imagen(integer indice) [
                                                                 REPEAT (integer i = 0) HUNTIL (4)
                                                                 INIT {:
                                                                 :} END
                                                             ]
            """);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void errorTwo() {
        AnalyzerScriptingToJS analyzer = new AnalyzerScriptingToJS("""
         !! Estas instrucciones no se ejecutan hasta llamar a
            FUNCTION_calc() [
            integer @global contador_fallas = 5;
            string result_caja_texto = getElemenById('entrada_1');
            string result = "10 ";
            string mensaje_fallo = "El captcha no fue validado intente otra vez ";
            string mensaje_acierto = "El captcha fue validado ";
            string mensaje_final = "El captcha no logró ser validado :( intente mas tarde";
            !! Validacion del numero de oportunidades restantes
            IF (contador_fallas == 0) THEN
            INIT {:
            ALERT_INFO(mensaje_final);
            EXIT();
            :} END
            !! Validación de fallas y aciertos
            IF (result_caja_texto == result ) THEN
            !!si el resultado es correcto
            INIT {:
            ALERT_INFO(mensaje_acierto);
            REDIRECT(); !!puede usarse también EXIT() para redirigir
            :} END
            ELSE
            !!si el intento es incorrecto
            INIT {:
            ALERT_INFO(mensaje_fallo);
            contador_fallas = contador_fallas -1;
            :} END

            ]
        """);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void errorThree() {
        AnalyzerScriptingToJS analyzer = new AnalyzerScriptingToJS("""
ON_LOAD() [
    integer @global intentos_restantes = 3;
    string @global palabra_objetivo = "";
    integer @global respuesta_matematica = 0;
    integer @global imagen_correcta = 0;                

    FUNCTION_generar_captcha() [
        <!-- Generar operaci\u00f3n matem\u00e1tica -->
        integer num1 = NUM_ALEATORIO() * 10;
        integer num2 = NUM_ALEATORIO() * 10;
        respuesta_matematica = num1 + num2;
        <!-- Generar palabra desordenada -->
        string palabra_desordenada = DESC(palabra_objetivo);
       REPEAT (integer i = 0) HUNTIL (4)
        INIT {:
        :} END
    ]   
    FUNCTION_generar_captcha();        
]
        """);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }
}
