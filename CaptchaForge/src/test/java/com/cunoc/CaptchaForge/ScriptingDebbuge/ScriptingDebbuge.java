package com.cunoc.CaptchaForge.ScriptingDebbuge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerScripting;

public class ScriptingDebbuge {
    	@Test
	void firtsError() {
        String nothingToAnalyze = "FUNCTION_verificar() [\n" + //
                                "    string respuesta1 = getElemenById('respuesta_matematica');\n" + //
                                "    string respuesta2 = getElemenById('respuesta_ordenar');\n" + //
                                "    IF (respuesta1 == \"7\") THEN\n" + //
                                "      IF (respuesta2 == ASC(\"palabra\")) THEN\n" + //
                                "        ALERT_INFO('¡CAPTCHA completado con éxito!');\n" + //
                                "      ELSE \n" + //
                                "        ALERT_INFO('Tarea 2 incorrecta, intenta de nuevo.');\n" + //
                                "    ELSE\n" + //
                                "      ALERT_INFO('Tarea 1 incorrecta, intenta de nuevo.');\n" + //
                                "]";
        AnalyzerScripting analyzer = new AnalyzerScripting(nothingToAnalyze);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError() && analyzer.getListError().size() == 4);
	}
}
