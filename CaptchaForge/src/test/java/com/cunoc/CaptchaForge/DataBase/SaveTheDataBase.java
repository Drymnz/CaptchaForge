package com.cunoc.CaptchaForge.DataBase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.CC.TestingConverterListLabelCCToHTML;
import com.cunoc.CaptchaForge.Model.DataBase.DataBaseListCaptcha;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.Utility.Converter.LabelCCToCaptchaConverter;
import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;

public class SaveTheDataBase {

    @Test
    void Save() {
		AnalyzerCC analyzer = new AnalyzerCC(TestingConverterListLabelCCToHTML.firstLabel);
        analyzer.analyzer();
        Captcha check = (new LabelCCToCaptchaConverter()).converterListLabelCCToCaptcha(analyzer.getListLabelCC());
        DataBaseListCaptcha dataBaseCaptch = new DataBaseListCaptcha();
        boolean checkRepeating = dataBaseCaptch.addWithoutRepeatingID(check);
        Assertions.assertThat(!analyzer.isError()&& dataBaseCaptch.upDataBase());
	}

	private String textDataBase = "CapTcha\n" + //
                "    ID = {_-=>$cpturador<=-_}\n" + //
                "    HTML = {_-=>dsfsdf af sadf<=-_}\n" + //
                "FinCapTcha";
    	@Test
	void CaptchaConversionTest() {
		AnalyzerCC analyzer = new AnalyzerCC(TestingConverterListLabelCCToHTML.firstLabel);
        analyzer.analyzer();
        Captcha check = (new LabelCCToCaptchaConverter()).converterListLabelCCToCaptcha(analyzer.getListLabelCC());
        Assertions.assertThat(!analyzer.isError()&& check.getId().equals("captcha_complejo"));
	}

    @Test
	void DatabaseStructureToCaptcha() {
		AnalyzerCaptchaDataBase analyzer = new AnalyzerCaptchaDataBase(textDataBase);
        analyzer.analyzer();
        Captcha check = analyzer.getListCaptcha().get(0);
        Assertions.assertThat(!analyzer.isError()&& check.getId().equals("captcha_complejo"));
	}

    @Test
	void DatabaseStructureToCaptchaComplex() {
		AnalyzerCaptchaDataBase analyzer = new AnalyzerCaptchaDataBase("CapTcha    ID = {_-=>$cpturador<=-_}    HTML = {_-=> <!DOCTYPE html>\n" + //
                        "<html lang=\"es\">\n" + //
                        "<head>\n" + //
                        "    <meta charset=\"UTF-8\">\n" + //
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + //
                        "    <title>Cuestionario</title>\n" + //
                        "    <style>*{box-sizing:border-box;margin:0;padding:0}body{font-family:Arial,sans-serif;background-color:#f0f2f5;display:flex;justify-content:center;align-items:center;min-height:100vh;padding:20px}div{max-width:800px;width:100%;background-color:#fff;box-shadow:0 4px 10px rgba(0,0,0,0.1);border-radius:10px;padding:20px;display:flex;flex-direction:column;gap:20px}h1{font-size:1.5rem;color:#2c3e50;margin-bottom:10px;text-align:center}span{display:block;font-size:1rem;color:#555;margin-bottom:10px}input{width:100%;padding:10px;margin-top:5px;border:1px solid #ccc;border-radius:5px;font-size:1rem}button{padding:12px;background-color:#3498db;color:white;border:none;border-radius:5px;cursor:pointer;font-size:1rem;transition:background-color .3s}button:hover{background-color:#2980b9}p{font-size:1rem;text-align:center;color:#27ae60}.row{display:flex;align-items:center;gap:10px}.column{display:flex;flex-direction:column;gap:15px}img{max-width:100%;height:auto;border-radius:8px;box-shadow:0 2px 5px rgba(0,0,0,0.1)}\n" + //
                        "    </style>\n" + //
                        "</head>\n" + //
                        "<body>\n" + //
                        "    <div>\n" + //
                        "        <h1>Cuestionario de Opinión</h1>\n" + //
                        "        <form>\n" + //
                        "            <h3>1. ¿Cuál es tu lenguaje favorito?</h3>\n" + //
                        "            <input type=\"text\" placeholder=\"Escribe tu respuesta aquí...\">\n" + //
                        "            \n" + //
                        "            <h3>2. ¿Qué motor de juegos prefieres?</h3>\n" + //
                        "            <select>\n" + //
                        "                <option value=\"unity\">Unity</option>\n" + //
                        "                <option value=\"unreal\">Unreal Engine</option>\n" + //
                        "                <option value=\"godot\">Godot</option>\n" + //
                        "                <option value=\"otro\">Otro</option>\n" + //
                        "            </select>\n" + //
                        "            \n" + //
                        "            <h3>3. Déjanos tus comentarios</h3>\n" + //
                        "            <textarea placeholder=\"Escribe aquí tus comentarios...\"></textarea>\n" + //
                        "            \n" + //
                        "            <button type=\"submit\">Enviar</button>\n" + //
                        "        </form>\n" + //
                        "    </div>\n" + //
                        "</body>\n" + //
                        "</html>\n" + //
                        " <=-_}FinCapTcha");
        analyzer.analyzer();
        Captcha check = analyzer.getListCaptcha().get(0);
        Assertions.assertThat(!analyzer.isError()&& check.getId().equals("captcha_complejo"));
	}
}
