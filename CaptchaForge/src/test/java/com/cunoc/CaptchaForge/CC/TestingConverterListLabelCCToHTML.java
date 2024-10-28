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
                                   
                                    </C_scripting>
                                </C_BoDy>
                                </C_cC>
                                """;

    @Test
    void conversionHTML() {
        AnalyzerCC analyzer = new AnalyzerCC(firstLabel);
        analyzer.analyzer();
        ListLabelCCToHTML converter = new ListLabelCCToHTML();
        String verString = converter.listLabelCCToStringHTML(analyzer.getListLabelCC(), "");
        Assertions.assertTrue(!analyzer.isError() && !verString.isBlank());
    }

    @Test
    void conversionOneLabelHTML() {
        AnalyzerCC analyzer = new AnalyzerCC("<C_INPUT [type= \"text\"] [text-align= \"center\"] [id= \"entrada_1\"] ></C_INPUT>");
        analyzer.analyzer();
        ListLabelCCToHTML converter = new ListLabelCCToHTML();
        String verString = converter.listLabelCCToStringHTML(analyzer.getListLabelCC(), "");
        Assertions.assertTrue(!analyzer.isError() && !verString.isBlank());
    }

}
