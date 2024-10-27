package com.cunoc.CaptchaForge.Scripting;

public class ErroresLargos {
    public final static String ERROR_SECOND = "<!-- Mi primer captcha \n" + //
                "en el curso de Organización de Lenguajes y Compiladores 1 \n" + //
                "--> \n" + //
                "<C_CC [id= \"captcha_matematico_1\"] [name= \"Captcha Matemático 1\"]> !! El encabezado de la página que tendrá mi captcha \n" + //
                "    <C_HEAD> \n" + //
                "        <C_LINK \n" + //
                "        !! El link al que redirige mi captcha \n" + //
                "        [href= \"https://www.mclibre.org/consultar/htmlcss/html/html-etiquetas.html\"]> </C_LINK> \n" + //
                "        !! El título de mi página \n" + //
                "        <C_TITLE> Mi primer Captcha Matemático</C_TITLE> \n" + //
                "    </C_HEAD> \n" + //
                "        !! El cuerpo de la página \n" + //
                "    <C_BODY [background= \"#e5e6ea\"] > \n" + //
                "        !! un título simple estilizado \n" + //
                "        <C_H1 [id= \"title_1\"] [text-align= \"center\"] [color= \"#7eff33\"] > Mi primer Captcha Matemático \n" + //
                "        </C_H1> \n" + //
                "        !! Un salto normal \n" + //
                "        <c_br> \n" + //
                "        !! Información de la operación a resolver en el captcha \n" + //
                "        <C_SPAM [id= \"mostrar_1\"] [text-align= \"center\"] [color= \"#3366ff\"] > ¿ Qué resultado genera la operación siguiente: 5+5 ? \n" + //
                "        </C_SPAM> \n" + //
                "        !! Input para la Respuesta del usuario generado con un scripting \n" + //
                "        <C_SCRIPTING> \n" + //
                "            ON_LOAD () [ \n" + //
                "                !!Estas instrucciones se ejecutan media vez se entra al scripting !! Insertamos el input con sus parámetros con la instrucción INSERT\n" + //
                "                INSERT('<C_INPUT [type= \"text\"] [text-align= \"center\"] [id= \"entrada_1\"] >'); \n" + //
                "                INSERT('</C_INPUT>'); \n" + //
                "            ] \n" + //
                "        </C_SCRIPTING>\n" + //
                "        !! Boton que llama a la funcionalidad calc \n" + //
                "        <C_BUTTON [id= \"boton_1\"] [onclick= \"FUNCTION_calc()\"] [background=\"green\"]> Procesar... \n" + //
                "        </C_BUTTON> \n" + //
                "        !! Scripting para la función calc \n" + //
                "        <C_SCRIPTING> \n" + //
                "            FUNCTION_calc() [ \n" + //
                "                !! Estas instrucciones no se ejecutan hasta llamar a FUNCTION_calc()\n" + //
                "                integer @global contador_fallas = 5; \n" + //
                "                string result_caja_texto = getElemenById('entrada_1'); \n" + //
                "                string result = \"10 \"; \n" + //
                "                string mensaje_fallo = \"El captcha no fue validado intente otra vez \"; \n" + //
                "                string mensaje_acierto = \"El captcha fue validado \"; \n" + //
                "                string mensaje_final = \"El captcha no logró ser validado :( intente mas tarde\"; \n" + //
                "                !! Validacion del numero de oportunidades restantes \n" + //
                "                IF (contador_fallas == 0) THEN \n" + //
                "                    INIT {: \n" + //
                "                        ALERT_INFO(mensaje_final); \n" + //
                "                        EXIT(); \n" + //
                "                    :} END \n" + //
                "                !! Validación de fallas y aciertos \n" + //
                "                IF (result_caja_texto == result ) THEN \n" + //
                "                    !!si el resultado es correcto \n" + //
                "                    INIT {: \n" + //
                "                        ALERT_INFO(mensaje_acierto); \n" + //
                "                        REDIRECT(); \n" + //
                "                        !!puede usarALERT_INFO(mensaje_acierto);se también EXIT() para redirigir \n" + //
                "                    :} END \n" + //
                "                ELSE \n" + //
                "                    !!si el intento es incorrecto \n" + //
                "                    INIT {: \n" + //
                "                        ALERT_INFO(mensaje_fallo); \n" + //
                "                        contador_fallas = contador_fallas - 1; \n" + //
                "                    :} END \n" + //
                "            ] \n" + //
                "        </C_SCRIPTING> \n" + //
                "    </C_BODY> \n" + //
                "</C_CC>\n" + //
                "!! Fin de estructura CC \n" + //
                "";
    public final static String ERROR_FIRST = "FUNCTION_calc() [ \n" + //
                "                !! Estas instrucciones no se ejecutan hasta llamar a FUNCTION_calc()\n" + //
                "                integer @global contador_fallas = 5; \n" + //
                "                string result_caja_texto = getElemenById('entrada_1'); \n" + //
                "                string result = \"10 \"; \n" + //
                "                string mensaje_fallo = \"El captcha no fue validado intente otra vez \"; \n" + //
                "                string mensaje_acierto = \"El captcha fue validado \"; \n" + //
                "                string mensaje_final = \"El captcha no logró ser validado :( intente mas tarde\"; \n" + //
                "                !! Validacion del numero de oportunidades restantes \n" + //
                "                IF (contador_fallas == 0) THEN \n" + //
                "                    INIT {: \n" + //
                "                        ALERT_INFO(mensaje_final); \n" + //
                "                        EXIT(); \n" + //
                "                    :} END \n" + //
                "                !! Validación de fallas y aciertos \n" + //
                "                IF (result_caja_texto == result ) THEN \n" + //
                "                    !!si el resultado es correcto \n" + //
                "                    INIT {: \n" + //
                "                        ALERT_INFO(mensaje_acierto); \n" + //
                "                        REDIRECT(); \n" + //
                "                        !!puede usarALERT_INFO(mensaje_acierto);se también EXIT() para redirigir \n" + //
                "                    :} END \n" + //
                "                ELSE \n" + //
                "                    !!si el intento es incorrecto \n" + //
                "                    INIT {: \n" + //
                "                        ALERT_INFO(mensaje_fallo); \n" + //
                "                        contador_fallas = contador_fallas - 1; \n" + //
                "                    :} END \n" + //
                "            ] ";
}
