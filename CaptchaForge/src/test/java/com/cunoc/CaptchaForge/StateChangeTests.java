package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;

public class StateChangeTests {
    @Test
	void structureTest() {
        String CCLanguageStructure = "<C_CC id=\"registro_captcha\" name=\"Formulario de Registro con Captcha\">\n" + //
                        "    <C_HEAD>\n" + //
                        "      <C_TITLE>Registro de Usuario con Verificación Captcha</C_TITLE>\n" + //
                        "      <C_LINK href=\"https://www.ejemplo.com/bienvenida\"/>\n" + //
                        "    </C_HEAD>\n" + //
                        "    \n" + //
                        "    <C_BODY background=\"#e6f2ff\">\n" + //
                        "      <C_DIV class=\"column\" text-align=\"center\" background=\"#ffffff\" color=\"#333333\">\n" + //
                        "        <C_H1 font-size=\"28px\" font-family=\"Arial\" color=\"#2c3e50\">Registro de Usuario</C_H1>\n" + //
                        "        <C_FORM>\n" + //
                        "          <C_BUTTON id=\"submit_registro\" background=\"#3498db\" color=\"white\" font-size=\"18px\" font-family=\"Arial\" onclick=\"'PROCESAR_REGISTRO()'\">\n" + //
                        "            Registrarse\n" + //
                        "          </C_BUTTON>\n" + //
                        "        </C_FORM>\n" + //
                        "      </C_DIV>\n" + //
                        "      <C_SCRIPTING > </ C_SCRIPTING>\n" + //
                        "    </C_BODY>\n" + //
                        "  </C_CC>";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void contentTest() {
        String CCLanguageStructure = "<C_CC id=\"registro_captcha\" name=\"Formulario de Registro con Captcha\">\n" + //
                        "    <C_HEAD>\n" + //
                        "      <C_TITLE>Registro de Usuario con Verificación Captcha</C_TITLE>\n" + //
                        "      <C_LINK href=\"https://www.ejemplo.com/bienvenida\"/>\n" + //
                        "    </C_HEAD>\n" + //
                        "    \n" + //
                        "    <C_BODY background=\"#e6f2ff\">\n" + //
                        "      <C_DIV class=\"column\" text-align=\"center\" background=\"#ffffff\" color=\"#333333\">\n" + //
                        "        <C_H1 font-size=\"28px\" font-family=\"Arial\" color=\"#2c3e50\">Registro de Usuario</C_H1>\n" + //
                        "        <C_FORM>\n" + //
                        "          <C_BUTTON id=\"submit_registro\" background=\"#3498db\" color=\"white\" font-size=\"18px\" font-family=\"Arial\" onclick=\"'PROCESAR_REGISTRO()'\">\n" + //
                        "            Registrarse\n" + //
                        "          </C_BUTTON>\n" + //
                        "        </C_FORM>\n" + //
                        "      </C_DIV>\n" + //
                        "      <C_SCRIPTING > !! Estas instrucciones no se ejecutan hasta llamar a\n" + //
                                                        "FUNCTION_calc() integer @global contador_fallas = 5;\n" + //
                                                        "string result_caja_texto = getElemenById(‘entrada_1’);\n" + //
                                                        "string result = “10 ”;\n" + //
                                                        "string mensaje_fallo = “El captcha no fue validado intente otra vez ”;\n" + //
                                                        "string mensaje_acierto = “El captcha fue validado ”;\n" + //
                                                        "string mensaje_final = “El captcha no logró ser validado :( intente mas tarde”;\n" + //
                                                        "!! Validacion del numero de oportunidades restantes\n" + //
                                                        "IF (contador_fallas == 0) THEN\n" + //
                                                        "INIT {:\n" + //
                                                        "ALERT_INFO(mensaje_final);\n" + //
                                                        "EXIT();\n" + //
                                                        ":} END\n" + //
                                                        "!! Validación de fallas y aciertos\n" + //
                                                        "IF (result_caja_texto == result ) THEN\n" + //
                                                        "!!si el resultado es correcto\n" + //
                                                        "INIT {:\n" + //
                                                        "ALERT_INFO(mensaje_acierto);\n" + //
                                                        "REDIRECT(); !!puede usarse también EXIT() para redirigir\n" + //
                                                        ":} END\n" + //
                                                        "ELSE\n" + //
                                                        "!!si el intento es incorrecto\n" + //
                                                        "INIT {:\n" + //
                                                        "ALERT_INFO(mensaje_fallo);\n" + //
                                                        "contador_fallas = contador_fallas -1;\n" + //
                                                        ":} END <  /  C_SCRIPTING>\n" + //
                        "    </C_BODY>\n" + //
                        "  </C_CC>";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}
}
