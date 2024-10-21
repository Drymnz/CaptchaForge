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

}
