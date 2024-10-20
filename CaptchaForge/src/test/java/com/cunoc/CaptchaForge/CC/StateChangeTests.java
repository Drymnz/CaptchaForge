package com.cunoc.CaptchaForge.CC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;

public class StateChangeTests {
    @Test
	void structureTest() {
        String CCLanguageStructure = """
            <C_CC id="registro_captcha" name="Formulario de Registro con Captcha">
                <C_HEAD>
                  <C_TITLE>Registro de Usuario con Verificación Captcha</C_TITLE>
                  <C_LINK href="https://www.ejemplo.com/bienvenida"/>
                </C_HEAD>
               \s
                <C_BODY background="#e6f2ff">
                  <C_DIV class="column" text-align="center" background="#ffffff" color="#333333">
                    <C_H1 font-size="28px" font-family="Arial" color="#2c3e50">Registro de Usuario</C_H1>
                    <C_FORM>
                      <C_BUTTON id="submit_registro" background="#3498db" color="white" font-size="18px" font-family="Arial" onclick="'PROCESAR_REGISTRO()'">
                        Registrarse
                      </C_BUTTON>
                    </C_FORM>
                  </C_DIV>
                  <C_SCRIPTING > </ C_SCRIPTING>
                </C_BODY>
              </C_CC>""";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void contentTest() {
        String CCLanguageStructure = """
          !! Estas instrucciones no se ejecutan hasta llamar a
            FUNCTION_calc() [
            integer @global contador_fallas = 5;
            string result_caja_texto = getElemenById('entrada_1');
            string result = “10 ”;
            string mensaje_fallo = “El captcha no fue validado intente otra vez ”;
            string mensaje_acierto = “El captcha fue validado ”;
            string mensaje_final = “El captcha no logró ser validado :( intente mas tarde”;
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
            """;
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}
}
