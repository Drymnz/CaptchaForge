package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;

public class TestingWithCCContex {
    @Test
	void contextLoads() {
				String CCLanguageStructure = "<C_CC>\n" + //
						"  <C_HEAD>\n" + //
						"    <C_TITLE>Jsajfljsadfljsdaf fsdaf asfdjfasdf\nasfdsadf                        sdfjsafas</C_TITLE>\n" + //
						"    <C_LINK/>\n" + //
						"  </C_HEAD>\n" + //
						"  <C_BODY>\n" + //
						"    \n" + //
						"  </C_BODY>\n" + //
						"</C_CC>";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void allContent() {
				String CCLanguageStructure = "<C_CC id=\"captcha_ejemplo\" name=\"Ejemplo Captcha\">\n" + //
                                        "  <C_HEAD>\n" + //
                                        "    <C_TITLE>Ejemplo de Captcha CC</C_TITLE>\n" + //
                                        "    <C_LINK href=\"https://www.ejemplo.com/destino-despues-captcha\"/>\n" + //
                                        "  </C_HEAD>\n" + //
                                        "  \n" + //
                                        "  <C_BODY background=\"#f0f0f0\">\n" + //
                                        "    <C_DIV class=\"row\" text-align=\"center\">\n" + //
                                        "      <C_H1 color=\"#333333\" font-size=\"24px\" font-family=\"Arial\">Verificación de Captcha</C_H1>\n" + //
                                        "      \n" + //
                                        "      <C_IMG src=\"https://ejemplo.com/imagen-captcha.jpg\" width=\"200px\" height=\"80px\" alt=\"Imagen Captcha\"/>\n" + //
                                        "      \n" + //
                                        "      <C_P color=\"#666666\" font-size=\"16px\" font-family=\"Verdana\">\n" + //
                                        "        Por favor, ingrese los caracteres que ve en la imagen:\n" + //
                                        "      </C_P>\n" + //
                                        "      \n" + //
                                        "      <C_INPUT type=\"text\" id=\"captcha_input\" font-size=\"18px\" font-family=\"Courier\"/>\n" + //
                                        "      \n" + //
                                        "      <C_BR/>\n" + //
                                        "      \n" + //
                                        "      <C_BUTTON id=\"submit_captcha\" background=\"#4CAF50\" color=\"white\" font-size=\"16px\" onclick=\"'VERIFICAR_CAPTCHA()'\">\n" + //
                                        "        Verificar\n" + //
                                        "      </C_BUTTON>\n" + //
                                        "    </C_DIV>\n" + //
                                        "  </C_BODY>\n" + //
                                        "</C_CC>";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void complexCC() {
				String CCLanguageStructure = "<C_CC id=\"registro_captcha\" name=\"Formulario de Registro con Captcha\">\n" + //
                                        "    <C_HEAD>\n" + //
                                        "      <C_TITLE>Registro de Usuario con Verificación Captcha</C_TITLE>\n" + //
                                        "      <C_LINK href=\"https://www.ejemplo.com/bienvenida\"/>\n" + //
                                        "    </C_HEAD>\n" + //
                                        "    \n" + //
                                        "    <C_BODY background=\"#e6f2ff\">\n" + //
                                        "      <C_DIV class=\"column\" text-align=\"center\" background=\"#ffffff\" color=\"#333333\">\n" + //
                                        "        <C_H1 font-size=\"28px\" font-family=\"Arial\" color=\"#2c3e50\">Registro de Usuario</C_H1>\n" + //
                                        "        \n" + //
                                        "        <C_FORM>\n" + //
                                        "          <C_DIV class=\"row\">\n" + //
                                        "            <C_SPAM font-size=\"16px\" font-family=\"Verdana\">Nombre:</C_SPAM>\n" + //
                                        "            <C_INPUT type=\"text\" id=\"nombre\" font-size=\"14px\" font-family=\"Arial\"/>\n" + //
                                        "          </C_DIV>\n" + //
                                        "          \n" + //
                                        "          <C_DIV class=\"row\">\n" + //
                                        "            <C_SPAM font-size=\"16px\" font-family=\"Verdana\">Correo electrónico:</C_SPAM>\n" + //
                                        "            <C_INPUT type=\"text\" id=\"email\" font-size=\"14px\" font-family=\"Arial\"/>\n" + //
                                        "          </C_DIV>\n" + //
                                        "          \n" + //
                                        "          <C_DIV class=\"row\">\n" + //
                                        "            <C_SPAM font-size=\"16px\" font-family=\"Verdana\">Contraseña:</C_SPAM>\n" + //
                                        "            <C_INPUT type=\"text\" id=\"password\" font-size=\"14px\" font-family=\"Arial\"/>\n" + //
                                        "          </C_DIV>\n" + //
                                        "          \n" + //
                                        "          <C_DIV class=\"row\">\n" + //
                                        "            <C_SPAM font-size=\"16px\" font-family=\"Verdana\">Género:</C_SPAM>\n" + //
                                        "            <C_SELECT id=\"genero\" font-size=\"14px\" font-family=\"Arial\">\n" + //
                                        "              <C_OPTION>Masculino</C_OPTION>\n" + //
                                        "              <C_OPTION>Femenino</C_OPTION>\n" + //
                                        "              <C_OPTION>Otro</C_OPTION>\n" + //
                                        "            </C_SELECT>\n" + //
                                        "          </C_DIV>\n" + //
                                        "          \n" + //
                                        "          <C_DIV class=\"row\">\n" + //
                                        "            <C_SPAM font-size=\"16px\" font-family=\"Verdana\">Intereses:</C_SPAM>\n" + //
                                        "            <C_INPUT type=\"checkbox\" id=\"deportes\"> Deportes </C_INPUT>\n" + //
                                        "            <C_INPUT type=\"checkbox\" id=\"musica\"> Música </C_INPUT>\n" + //
                                        "            <C_INPUT type=\"checkbox\" id=\"tecnologia\"> Tecnología </C_INPUT>\n" + //
                                        "          </C_DIV>\n" + //
                                        "          \n" + //
                                        "          <C_DIV class=\"row\">\n" + //
                                        "            <C_SPAM font-size=\"16px\" font-family=\"Verdana\">Comentarios:</C_SPAM>\n" + //
                                        "            <C_TEXTAREA id=\"comentarios\" font-size=\"14px\" font-family=\"Arial\" cols=\"30\" rows=\"4\"/>\n" + //
                                        "          </C_DIV>\n" + //
                                        "          \n" + //
                                        "          <C_DIV class=\"column\" background=\"#f0f0f0\" color=\"#333333\">\n" + //
                                        "            <C_H1 font-size=\"20px\" font-family=\"Arial\">Verificación Captcha</C_H1>\n" + //
                                        "            \n" + //
                                        "            <C_IMG src=\"https://ejemplo.com/imagen-captcha-compleja.jpg\" width=\"250px\" height=\"100px\" alt=\"Imagen Captcha\"/>\n" + //
                                        "            \n" + //
                                        "            <C_P font-size=\"14px\" font-family=\"Verdana\">\n" + //
                                        "              Por favor, ingrese los caracteres que ve en la imagen de arriba:\n" + //
                                        "            </C_P>\n" + //
                                        "            \n" + //
                                        "            <C_INPUT type=\"text\" id=\"captcha_input\" font-size=\"16px\" font-family=\"Courier\"/>\n" + //
                                        "          </C_DIV>\n" + //
                                        "          \n" + //
                                        "          <C_BR/>\n" + //
                                        "          \n" + //
                                        "          <C_BUTTON id=\"submit_registro\" background=\"#3498db\" color=\"white\" font-size=\"18px\" font-family=\"Arial\" onclick=\"'PROCESAR_REGISTRO()'\">\n" + //
                                        "            Registrarse\n" + //
                                        "          </C_BUTTON>\n" + //
                                        "        </C_FORM>\n" + //
                                        "      </C_DIV>\n" + //
                                        "    </C_BODY>\n" + //
                                        "  </C_CC>";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

}
