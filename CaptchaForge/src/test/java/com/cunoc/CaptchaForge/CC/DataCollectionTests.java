package com.cunoc.CaptchaForge.CC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;

public class DataCollectionTests {
    @Test
	void CCWithPromsBody() {
		String firstLabel = "<!-- Archivo de prueba complejo.cc\n" + //
                        "     Este archivo demuestra el uso de todas las etiquetas y funcionalidades\n" + //
                        "     del lenguaje CC y CLC para crear un CAPTCHA complejo -->\n" + //
                        "\n" + //
                        "<C_cC id=\"captcha_complejo\" name=\"CAPTCHA Multitarea\">\n" + //
                        "<C_HeAD>\n" + //
                        "    <c_LiNk href=\"https://www.ejemplo.com/pagina-destino\"/>\n" + //
                        "    <C_tItLe>CAPTCHA Multitarea Avanzado</C_tItLe>\n" + //
                        "</C_HeAD>\n" + //
                        "\n" + //
                        "<C_BoDy background=\"#f0f0f0\">\n" + //
                        "    <c_H1 id=\"titulo_principal\">\n" + //
                        "        CAPTCHA Multitarea: ¡Demuestra que eres humano!\n" + //
                        "    </c_H1>\n" + //
                        "\n" + //
                        "    <C_diV id=\"contenedor_principal\" class=\"column\">\n" + //
                        "        <C_spAm id=\"instrucciones\">\n" + //
                        "            Complete las siguientes tareas para verificar que es humano:\n" + //
                        "        </C_spAm>\n" + //
                        "\n" + //
                        "        <C_br/>\n" + //
                        "\n" + //
                        "        <!-- Tarea 1: Operación matemática -->\n" + //
                        "        <C_diV id=\"tarea_matematica\" class=\"row\">\n" + //
                        "            <C_h1 id=\"titulo_tarea1\">Tarea 1: Resuelve la operación</C_h1>\n" + //
                        "            <C_spAm id=\"pregunta_matematica\"></C_spAm>\n" + //
                        "            <C_inPuT type=\"number\" id=\"respuesta_matematica\"/>\n" + //
                        "        </C_diV>\n" + //
                        "\n" + //
                        "        <C_br/>\n" + //
                        "\n" + //
                        "        <!-- Tarea 2: Ordenar palabra -->\n" + //
                        "        <C_diV id=\"tarea_ordenar\" class=\"row\">\n" + //
                        "            <C_h1 id=\"titulo_tarea2\">Tarea 2: Ordena la palabra</C_h1>\n" + //
                        "            <C_spAm id=\"palabra_desordenada\"></C_spAm>\n" + //
                        "            <C_inPuT type=\"text\" id=\"respuesta_ordenar\"/>\n" + //
                        "        </C_diV>\n" + //
                        "\n" + //
                        "        <C_br/>\n" + //
                        "\n" + //
                        "        <!-- Tarea 3: Seleccionar imagen -->\n" + //
                        "        <C_diV id=\"tarea_imagen\" class=\"row\">\n" + //
                        "            <C_h1 id=\"titulo_tarea3\">Tarea 3: Selecciona la imagen correcta</C_h1>\n" + //
                        "            <C_spAm id=\"pregunta_imagen\"></C_spAm>\n" + //
                        "            <C_br/>\n" + //
                        "            <C_diV id=\"opciones_imagen\" class=\"row\">\n" + //
                        "                <!-- Las imágenes se insertarán dinámicamente -->\n" + //
                        "            </C_diV>\n" + //
                        "        </C_diV>\n" + //
                        "\n" + //
                        "        <C_br/>\n" + //
                        "\n" + //
                        "        <C_button id=\"boton_verificar\" onclick=\"FUNCTION_verificar()\">\n" + //
                        "            Verificar CAPTCHA\n" + //
                        "        </C_button>\n" + //
                        "\n" + //
                        "        <C_p id=\"mensaje_resultado\"></C_p>\n" + //
                        "    </C_diV>\n" + //
                        "\n" + //
                        "    <C_scripting>\n" + //
                        "    ON_LOAD() {\n" + //
                        "        integer @global intentos_restantes = 3;\n" + //
                        "        string @global palabra_objetivo = \"\";\n" + //
                        "        integer @global respuesta_matematica = 0;\n" + //
                        "        integer @global imagen_correcta = 0;\n" + //
                        "\n" + //
                        "        FUNCTION_generar_captcha() {\n" + //
                        "            <!-- Generar operación matemática -->\n" + //
                        "            integer num1 = NUM_ALEATORIO() * 10;\n" + //
                        "            integer num2 = NUM_ALEATORIO() * 10;\n" + //
                        "            respuesta_matematica = num1 + num2;\n" + //
                        "            INSERT('<C_spAm id=\"pregunta_matematica\">¿Cuánto es ', num1, ' + ', num2, '?</C_spAm>');\n" + //
                        "\n" + //
                        "            <!-- Generar palabra desordenada -->\n" + //
                        "            string[] palabras = [\"CAPTCHA\", \"SEGURIDAD\", \"VERIFICACION\", \"HUMANO\", \"ROBOT\"];\n" + //
                        "            integer indice_palabra = NUM_ALEATORIO() % 5;\n" + //
                        "            palabra_objetivo = palabras[indice_palabra];\n" + //
                        "            string palabra_desordenada = DESC(palabra_objetivo);\n" + //
                        "            INSERT('<C_spAm id=\"palabra_desordenada\">Ordena esta palabra: ', palabra_desordenada, '</C_spAm>');\n" + //
                        "\n" + //
                        "            <!-- Generar selección de imagen -->\n" + //
                        "            string[] opciones_imagen = [\"gato\", \"perro\", \"pájaro\", \"pez\"];\n" + //
                        "            imagen_correcta = NUM_ALEATORIO() % 4;\n" + //
                        "            INSERT('<C_spAm id=\"pregunta_imagen\">Selecciona la imagen del ', opciones_imagen[imagen_correcta], '</C_spAm>');\n" + //
                        "\n" + //
                        "            REPEAT (integer i = 0) HUNTIL (4)\n" + //
                        "            INIT {\n" + //
                        "                INSERT('<C_iMg src=\"/api/placeholder/100/100\" alt=\"', opciones_imagen[i], '\" id=\"img_', i, '\" onclick=\"FUNCTION_seleccionar_imagen(', i, ')\">');\n" + //
                        "            } END\n" + //
                        "        }\n" + //
                        "\n" + //
                        "        FUNCTION_generar_captcha();\n" + //
                        "    }\n" + //
                        "\n" + //
                        "    FUNCTION_seleccionar_imagen(integer indice) {\n" + //
                        "        REPEAT (integer i = 0) HUNTIL (4)\n" + //
                        "        INIT {\n" + //
                        "            INSERT('document.getElementById(\"img_', i, '\").style.border = \"none\";');\n" + //
                        "        } END\n" + //
                        "        INSERT('document.getElementById(\"img_', indice, '\").style.border = \"2px solid blue\";');\n" + //
                        "    }\n" + //
                        "\n" + //
                        "    FUNCTION_verificar() {\n" + //
                        "        boolean tarea1_correcta = false;\n" + //
                        "        boolean tarea2_correcta = false;\n" + //
                        "        boolean tarea3_correcta = false;\n" + //
                        "\n" + //
                        "        <!-- Verificar tarea matemática -->\n" + //
                        "        string resp_mat = getElemenById('respuesta_matematica');\n" + //
                        "        IF (integer(resp_mat) == respuesta_matematica) THEN\n" + //
                        "            tarea1_correcta = true;\n" + //
                        "        \n" + //
                        "        <!-- Verificar tarea de ordenar palabra -->\n" + //
                        "        string resp_ord = getElemenById('respuesta_ordenar');\n" + //
                        "        IF (ASC(resp_ord) == palabra_objetivo) THEN\n" + //
                        "            tarea2_correcta = true;\n" + //
                        "        \n" + //
                        "        <!-- Verificar tarea de selección de imagen -->\n" + //
                        "        integer imagen_seleccionada = -1;\n" + //
                        "        REPEAT (integer i = 0) HUNTIL (4)\n" + //
                        "        INIT {\n" + //
                        "            IF (getElemenById('img_' + i).style.border != \"none\") THEN\n" + //
                        "                imagen_seleccionada = i;\n" + //
                        "        } END\n" + //
                        "        \n" + //
                        "        IF (imagen_seleccionada == imagen_correcta) THEN\n" + //
                        "            tarea3_correcta = true;\n" + //
                        "\n" + //
                        "        IF (tarea1_correcta && tarea2_correcta && tarea3_correcta) THEN\n" + //
                        "            INIT {\n" + //
                        "                ALERT_INFO(\"¡CAPTCHA verificado correctamente! Redirigiendo...\");\n" + //
                        "                REDIRECT();\n" + //
                        "            } END\n" + //
                        "        ELSE\n" + //
                        "            INIT {\n" + //
                        "                intentos_restantes = intentos_restantes - 1;\n" + //
                        "                IF (intentos_restantes > 0) THEN\n" + //
                        "                    INIT {\n" + //
                        "                        ALERT_INFO(\"Verificación fallida. Intentos restantes: \" + intentos_restantes);\n" + //
                        "                        FUNCTION_generar_captcha();\n" + //
                        "                    } END\n" + //
                        "                ELSE\n" + //
                        "                    INIT {\n" + //
                        "                        ALERT_INFO(\"Se han agotado los intentos. Por favor, inténtelo más tarde.\");\n" + //
                        "                        EXIT();\n" + //
                        "                    } END\n" + //
                        "            } END\n" + //
                        "    }\n" + //
                        "    </C_scripting>\n" + //
                        "</C_BoDy>\n" + //
                        "</C_cC>\n" + //
                        "";
		AnalyzerCC analyzer = new AnalyzerCC(firstLabel);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}
}
