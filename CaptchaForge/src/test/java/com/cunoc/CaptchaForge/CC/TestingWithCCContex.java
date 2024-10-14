package com.cunoc.CaptchaForge.CC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;

public class TestingWithCCContex {
    @Test
	void contextLoads() {
				String CCLanguageStructure = """
                    <C_CC>
                      <C_HEAD>
                        <C_TITLE>Jsajfljsadfljsdaf fsdaf asfdjfasdf
                    asfdsadf                        sdfjsafas</C_TITLE>
                        <C_LINK/>
                      </C_HEAD>
                      <C_BODY>
                       \s
                      </C_BODY>
                    </C_CC>""";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void allContent() {
				String CCLanguageStructure = """
                    <C_CC id="captcha_ejemplo" name="Ejemplo Captcha">
                      <C_HEAD>
                        <C_TITLE>Ejemplo de Captcha CC</C_TITLE>
                        <C_LINK href="https://www.ejemplo.com/destino-despues-captcha"/>
                      </C_HEAD>
                     \s
                      <C_BODY background="#f0f0f0">
                        <C_DIV class="row" text-align="center">
                          <C_H1 color="#333333" font-size="24px" font-family="Arial">Verificación de Captcha</C_H1>
                         \s
                          <C_IMG src="https://ejemplo.com/imagen-captcha.jpg" width="200px" height="80px" alt="Imagen Captcha"/>
                         \s
                          <C_P color="#666666" font-size="16px" font-family="Verdana">
                            Por favor, ingrese los caracteres que ve en la imagen:
                          </C_P>
                         \s
                          <C_INPUT type="text" id="captcha_input" font-size="18px" font-family="Courier"/>
                         \s
                          <C_BR/>
                         \s
                          <C_BUTTON id="submit_captcha" background="#4CAF50" color="white" font-size="16px" onclick="'VERIFICAR_CAPTCHA()'">
                            Verificar
                          </C_BUTTON>
                        </C_DIV>
                      </C_BODY>
                    </C_CC>""";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

    @Test
	void complexCC() {
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
                           \s
                            <C_FORM>
                              <C_DIV class="row">
                                <C_SPAM font-size="16px" font-family="Verdana">Nombre:</C_SPAM>
                                <C_INPUT type="text" id="nombre" font-size="14px" font-family="Arial"/>
                              </C_DIV>
                             \s
                              <C_DIV class="row">
                                <C_SPAM font-size="16px" font-family="Verdana">Correo electrónico:</C_SPAM>
                                <C_INPUT type="text" id="email" font-size="14px" font-family="Arial"/>
                              </C_DIV>
                             \s
                              <C_DIV class="row">
                                <C_SPAM font-size="16px" font-family="Verdana">Contraseña:</C_SPAM>
                                <C_INPUT type="text" id="password" font-size="14px" font-family="Arial"/>
                              </C_DIV>
                             \s
                              <C_DIV class="row">
                                <C_SPAM font-size="16px" font-family="Verdana">Género:</C_SPAM>
                                <C_SELECT id="genero" font-size="14px" font-family="Arial">
                                  <C_OPTION>Masculino</C_OPTION>
                                  <C_OPTION>Femenino</C_OPTION>
                                  <C_OPTION>Otro</C_OPTION>
                                </C_SELECT>
                              </C_DIV>
                             \s
                              <C_DIV class="row">
                                <C_SPAM font-size="16px" font-family="Verdana">Intereses:</C_SPAM>
                                <C_INPUT type="checkbox" id="deportes"> Deportes </C_INPUT>
                                <C_INPUT type="checkbox" id="musica"> Música </C_INPUT>
                                <C_INPUT type="checkbox" id="tecnologia"> Tecnología </C_INPUT>
                              </C_DIV>
                             \s
                              <C_DIV class="row">
                                <C_SPAM font-size="16px" font-family="Verdana">Comentarios:</C_SPAM>
                                <C_TEXTAREA id="comentarios" font-size="14px" font-family="Arial" cols="30" rows="4"/>
                              </C_DIV>
                             \s
                              <C_DIV class="column" background="#f0f0f0" color="#333333">
                                <C_H1 font-size="20px" font-family="Arial">Verificación Captcha</C_H1>
                               \s
                                <C_IMG src="https://ejemplo.com/imagen-captcha-compleja.jpg" width="250px" height="100px" alt="Imagen Captcha"/>
                               \s
                                <C_P font-size="14px" font-family="Verdana">
                                  Por favor, ingrese los caracteres que ve en la imagen de arriba:
                                </C_P>
                               \s
                                <C_INPUT type="text" id="captcha_input" font-size="16px" font-family="Courier"/>
                              </C_DIV>
                             \s
                              <C_BR/>
                             \s
                              <C_BUTTON id="submit_registro" background="#3498db" color="white" font-size="18px" font-family="Arial" onclick="'PROCESAR_REGISTRO()'">
                                Registrarse
                              </C_BUTTON>
                            </C_FORM>
                          </C_DIV>
                        </C_BODY>
                      </C_CC>""";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

}


