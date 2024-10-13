package com.cunoc.CaptchaForge.CC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;
import com.cunoc.CaptchaForge.Model.Utility.Converter.ListLabelCCToHTML;

public class TestingConverterListLabelCCToHTML {

    public final static  String firstLabel = """
                                <!-- Archivo de prueba complejo.cc
                                     Este archivo demuestra el uso de todas las etiquetas y funcionalidades
                                     del lenguaje CC y CLC para crear un CAPTCHA complejo -->
                                
                                <C_cC id="captcha_complejo" name="CAPTCHA Multitarea">
                                <C_HeAD>
                                    <c_LiNk href="https://www.ejemplo.com/pagina-destino"/>
                                    <C_tItLe>CAPTCHA Multitarea Avanzado</C_tItLe>
                                </C_HeAD>
                                
                                <C_BoDy background="#f0f0f0">
                                    <c_H1 id="titulo_principal">
                                        CAPTCHA Multitarea: \u00a1Demuestra que eres humano!
                                    </c_H1>
                                
                                    <C_diV id="contenedor_principal" class="column">
                                        <C_spAm id="instrucciones">
                                            Complete las siguientes tareas para verificar que es humano:
                                        </C_spAm>
                                
                                        <C_br/>
                                
                                        <!-- Tarea 1: Operaci\u00f3n matem\u00e1tica -->
                                        <C_diV id="tarea_matematica" class="row">
                                            <C_h1 id="titulo_tarea1">Tarea 1: Resuelve la operaci\u00f3n</C_h1>
                                            <C_spAm id="pregunta_matematica"></C_spAm>
                                            <C_inPuT type="number" id="respuesta_matematica"/>
                                        </C_diV>
                                
                                        <C_br/>
                                
                                        <!-- Tarea 2: Ordenar palabra -->
                                        <C_diV id="tarea_ordenar" class="row">
                                            <C_h1 id="titulo_tarea2">Tarea 2: Ordena la palabra</C_h1>
                                            <C_spAm id="palabra_desordenada"></C_spAm>
                                            <C_inPuT type="text" id="respuesta_ordenar"/>
                                        </C_diV>
                                
                                        <C_br/>
                                
                                        <!-- Tarea 3: Seleccionar imagen -->
                                        <C_diV id="tarea_imagen" class="row">
                                            <C_h1 id="titulo_tarea3">Tarea 3: Selecciona la imagen correcta</C_h1>
                                            <C_spAm id="pregunta_imagen"></C_spAm>
                                            <C_br/>
                                            <C_diV id="opciones_imagen" class="row">
                                                <!-- Las im\u00e1genes se insertar\u00e1n din\u00e1micamente -->
                                            </C_diV>
                                        </C_diV>
                                
                                        <C_br/>
                                
                                        <C_button id="boton_verificar" onclick="FUNCTION_verificar()">
                                            Verificar CAPTCHA
                                        </C_button>
                                
                                        <C_p id="mensaje_resultado"></C_p>
                                    </C_diV>
                                
                                    <C_scripting>
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
                                    </C_scripting>
                                </C_BoDy>
                                </C_cC>
                                """;

    @Test
    void conversionHTML() {
        AnalyzerCC analyzer = new AnalyzerCC(this.firstLabel);
        analyzer.analyzer();
        ListLabelCCToHTML converter = new ListLabelCCToHTML();
        String verString = converter.listLabelCCToStringHTML(analyzer.getListLabelCC());
        Assertions.assertTrue(!analyzer.isError());
    }

}
