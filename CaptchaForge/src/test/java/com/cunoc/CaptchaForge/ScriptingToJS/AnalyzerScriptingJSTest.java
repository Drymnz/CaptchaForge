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
            ON_LOAD() {
                                        integer @global intentos_restantes = 3;
                                        string @global palabra_objetivo = "";
                                        integer @global respuesta_matematica = 0;
                                        integer @global imagen_correcta = 0;
                                
                                        FUNCTION_generar_captcha() {
                                            <!-- Generar operaci\u00f3n matem\u00e1tica -->
                                            integer num1 = NUM_ALEATORIO() * 10;
                                            integer num2 = NUM_ALEATORIO() * 10;
                                            respuesta_matematica = num1 + num2;
                                            INSERT('<C_spAm id="pregunta_matematica">\u00bfCu\u00e1nto es ', num1, ' + ', num2, '?</C_spAm>');
                                
                                            <!-- Generar palabra desordenada -->
                                            string[] palabras = ["CAPTCHA", "SEGURIDAD", "VERIFICACION", "HUMANO", "ROBOT"];
                                            integer indice_palabra = NUM_ALEATORIO() % 5;
                                            palabra_objetivo = palabras[indice_palabra];
                                            string palabra_desordenada = DESC(palabra_objetivo);
                                            INSERT('<C_spAm id="palabra_desordenada">Ordena esta palabra: ', palabra_desordenada, '</C_spAm>');
                                
                                            <!-- Generar selecci\u00f3n de imagen -->
                                            string[] opciones_imagen = ["gato", "perro", "p\u00e1jaro", "pez"];
                                            imagen_correcta = NUM_ALEATORIO() % 4;
                                            INSERT('<C_spAm id="pregunta_imagen">Selecciona la imagen del ', opciones_imagen[imagen_correcta], '</C_spAm>');
                                
                                            REPEAT (integer i = 0) HUNTIL (4)
                                            INIT {
                                                INSERT('<C_iMg src="/api/placeholder/100/100" alt="', opciones_imagen[i], '" id="img_', i, '" onclick="FUNCTION_seleccionar_imagen(', i, ')">');
                                            } END
                                        }
                                
                                        FUNCTION_generar_captcha();
                                    }
                                
                                    FUNCTION_seleccionar_imagen(integer indice) {
                                        REPEAT (integer i = 0) HUNTIL (4)
                                        INIT {
                                            INSERT('document.getElementById("img_', i, '").style.border = "none";');
                                        } END
                                        INSERT('document.getElementById("img_', indice, '").style.border = "2px solid blue";');
                                    }
                                
                                    FUNCTION_verificar() {
                                        boolean tarea1_correcta = false;
                                        boolean tarea2_correcta = false;
                                        boolean tarea3_correcta = false;
                                
                                        <!-- Verificar tarea matem\u00e1tica -->
                                        string resp_mat = getElemenById('respuesta_matematica');
                                        IF (integer(resp_mat) == respuesta_matematica) THEN
                                            tarea1_correcta = true;
                                        
                                        <!-- Verificar tarea de ordenar palabra -->
                                        string resp_ord = getElemenById('respuesta_ordenar');
                                        IF (ASC(resp_ord) == palabra_objetivo) THEN
                                            tarea2_correcta = true;
                                        
                                        <!-- Verificar tarea de selecci\u00f3n de imagen -->
                                        integer imagen_seleccionada = -1;
                                        REPEAT (integer i = 0) HUNTIL (4)
                                        INIT {
                                            IF (getElemenById('img_' + i).style.border != "none") THEN
                                                imagen_seleccionada = i;
                                        } END
                                        
                                        IF (imagen_seleccionada == imagen_correcta) THEN
                                            tarea3_correcta = true;
                                
                                        IF (tarea1_correcta && tarea2_correcta && tarea3_correcta) THEN
                                            INIT {
                                                ALERT_INFO("\u00a1CAPTCHA verificado correctamente! Redirigiendo...");
                                                REDIRECT();
                                            } END
                                        ELSE
                                            INIT {
                                                intentos_restantes = intentos_restantes - 1;
                                                IF (intentos_restantes > 0) THEN
                                                    INIT {
                                                        ALERT_INFO("Verificaci\u00f3n fallida. Intentos restantes: " + intentos_restantes);
                                                        FUNCTION_generar_captcha();
                                                    } END
                                                ELSE
                                                    INIT {
                                                        ALERT_INFO("Se han agotado los intentos. Por favor, int\u00e9ntelo m\u00e1s tarde.");
                                                        EXIT();
                                                    } END
                                            } END
                                    }
        """);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }
}
