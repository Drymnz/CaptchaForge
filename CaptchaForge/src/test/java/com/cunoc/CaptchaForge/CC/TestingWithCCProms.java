package com.cunoc.CaptchaForge.CC;

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
		String firstLabel = """
            <C_CC id="captcha_ejemplo" name="Ejemplo Captcha"> <C_HEAD>
                  <C_TITLE></C_TITLE>
                  <C_LINK href="https://www.ejemplo.com/destino-despues-captcha"/>
                </C_HEAD>< / C_CC >""";
		AnalyzerCC analyzer = new AnalyzerCC(firstLabel);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void CCWithPromsBody() {
		String firstLabel = """
            <C_CC id="captcha_ejemplo" name="Ejemplo Captcha">
                <C_HEAD>
                  <C_TITLE></C_TITLE>
                  <C_LINK href="https://www.ejemplo.com/destino-despues-captcha"/>
                </C_HEAD>
                <C_BODY background="#f0f0f0">
                  <C_DIV class="row" text-align="center">
                    <C_H1 color="#333333" font-size="24px" font-family="Arial"></C_H1>
                   \s
                    <C_IMG src="https://ejemplo.com/imagen-captcha.jpg" width="200px" height="80px" alt="Imagen Captcha"/>
                   \s
                    <C_P color="#666666" font-size="16px" font-family="Verdana">
                    \s
                    </C_P>
                   \s
                    <C_INPUT type="text" id="captcha_input" font-size="18px" font-family="Courier"/>
                   \s
                    <C_BR/>
                   \s
                    <C_BUTTON id="submit_captcha" background="#4CAF50" color="white" font-size="16px" onclick="'VERIFICAR_CAPTCHA()'">
                     \s
                    </C_BUTTON>
                  </C_DIV>
                </C_BODY>
              </C_CC>""";
		AnalyzerCC analyzer = new AnalyzerCC(firstLabel);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

}
