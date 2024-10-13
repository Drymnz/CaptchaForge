package com.cunoc.CaptchaForge.DataBase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.CC.TestingConverterListLabelCCToHTML;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;
import com.cunoc.CaptchaForge.Model.Utility.Converter.LabelCCToCaptchaConverter;
import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;

public class SaveTheDataBase {

	private String textDataBase = """
                                      C@pTch@
                                          Id ===> {_-=>$cpturador<=-_}
                                          HTML ===> {_-=><!DOCTYPE html>
                                      <html lang="es">
                                      <head>
                                          <meta charset="UTF-8">
                                          <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                          <title>Cuestionario</title>
                                          <link rel="stylesheet" href="styles.css">
                                          <style>*{box-sizing:border-box;margin:0;padding:0}body{font-family:Arial,sans-serif;background-color:#f0f2f5;display:flex;justify-content:center;align-items:center;min-height:100vh;padding:20px}div{max-width:800px;width:100%;background-color:#fff;box-shadow:0 4px 10px rgba(0,0,0,0.1);border-radius:10px;padding:20px;display:flex;flex-direction:column;gap:20px}h1{font-size:1.5rem;color:#2c3e50;margin-bottom:10px;text-align:center}span{display:block;font-size:1rem;color:#555;margin-bottom:10px}input{width:100%;padding:10px;margin-top:5px;border:1px solid #ccc;border-radius:5px;font-size:1rem}button{padding:12px;background-color:#3498db;color:white;border:none;border-radius:5px;cursor:pointer;font-size:1rem;transition:background-color .3s}button:hover{background-color:#2980b9}p{font-size:1rem;text-align:center;color:#27ae60}.row{display:flex;align-items:center;gap:10px}.column{display:flex;flex-direction:column;gap:15px}img{max-width:100%;height:auto;border-radius:8px;box-shadow:0 2px 5px rgba(0,0,0,0.1)}
                                          </style>
                                      </head>
                                      <body>
                                          <div>
                                              <h1>Cuestionario de Opini\u00f3n</h1>
                                              <form>
                                                  <h3>1. \u00bfCu\u00e1l es tu lenguaje favorito?</h3>
                                                  <input type="text" placeholder="Escribe tu respuesta aqu\u00ed...">
                                                  
                                                  <h3>2. \u00bfQu\u00e9 motor de juegos prefieres?</h3>
                                                  <select>
                                                      <option value="unity">Unity</option>
                                                      <option value="unreal">Unreal Engine</option>
                                                      <option value="godot">Godot</option>
                                                      <option value="otro">Otro</option>
                                                  </select>
                                                  
                                                  <h3>3. D\u00e9janos tus comentarios</h3>
                                                  <textarea placeholder="Escribe aqu\u00ed tus comentarios..."></textarea>
                                                  
                                                  <button type="submit">Enviar</button>
                                              </form>
                                          </div>
                                      </body>
                                      </html>
                                      <=-_}
                                      FinC@pTch@""";
    	@Test
	void CaptchaConversionTest() {
		AnalyzerCC analyzer = new AnalyzerCC(TestingConverterListLabelCCToHTML.firstLabel);
        analyzer.analyzer();
        Captcha check = (new LabelCCToCaptchaConverter()).converterListLabelCCToCaptcha(analyzer.getListLabelCC());
        Assertions.assertTrue(!analyzer.isError()&& check.getId().equals("captcha_complejo"));
	}
}
