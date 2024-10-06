FUNCTION_calc() [
    !! Estas instrucciones no se ejecutan hasta llamar a
    FUNCTION_calc() integer @global contador_fallas = 5;
    string result_caja_texto = getElemenById(‘entrada_1’);
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