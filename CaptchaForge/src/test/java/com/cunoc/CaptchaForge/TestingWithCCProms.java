package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;

public class TestingWithCCProms {

    @Test
	void firstLabelWithProms() {
		String firstLabel = " <C_CC id=\"captcha_ejemplo\" name=\"Ejemplo Captcha\"> < / C_CC > ";
		AnalyzerCC analyzer = new AnalyzerCC(firstLabel);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void CCWithPromsHead() {
		String firstLabel = "<C_CC id=\"captcha_ejemplo\" name=\"Ejemplo Captcha\"> <C_HEAD>\n" + //
                        "      <C_TITLE></C_TITLE>\n" + //
                        "      <C_LINK href=\"https://www.ejemplo.com/destino-despues-captcha\"/>\n" + //
                        "    </C_HEAD>< / C_CC >";
		AnalyzerCC analyzer = new AnalyzerCC(firstLabel);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void CCWithPromsBody() {
		String firstLabel = "<C_CC id=\"captcha_ejemplo\" name=\"Ejemplo Captcha\">\n" + //
                        "    <C_HEAD>\n" + //
                        "      <C_TITLE></C_TITLE>\n" + //
                        "      <C_LINK href=\"https://www.ejemplo.com/destino-despues-captcha\"/>\n" + //
                        "    </C_HEAD>\n" + //
                        "    <C_BODY background=\"#f0f0f0\">\n" + //
                        "      <C_DIV class=\"row\" text-align=\"center\">\n" + //
                        "        <C_H1 color=\"#333333\" font-size=\"24px\" font-family=\"Arial\"></C_H1>\n" + //
                        "        \n" + //
                        "        <C_IMG src=\"https://ejemplo.com/imagen-captcha.jpg\" width=\"200px\" height=\"80px\" alt=\"Imagen Captcha\"/>\n" + //
                        "        \n" + //
                        "        <C_P color=\"#666666\" font-size=\"16px\" font-family=\"Verdana\">\n" + //
                        "         \n" + //
                        "        </C_P>\n" + //
                        "        \n" + //
                        "        <C_INPUT type=\"text\" id=\"captcha_input\" font-size=\"18px\" font-family=\"Courier\"/>\n" + //
                        "        \n" + //
                        "        <C_BR/>\n" + //
                        "        \n" + //
                        "        <C_BUTTON id=\"submit_captcha\" background=\"#4CAF50\" color=\"white\" font-size=\"16px\" onclick=\"'VERIFICAR_CAPTCHA()'\">\n" + //
                        "          \n" + //
                        "        </C_BUTTON>\n" + //
                        "      </C_DIV>\n" + //
                        "    </C_BODY>\n" + //
                        "  </C_CC>";
		AnalyzerCC analyzer = new AnalyzerCC(firstLabel);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

}
