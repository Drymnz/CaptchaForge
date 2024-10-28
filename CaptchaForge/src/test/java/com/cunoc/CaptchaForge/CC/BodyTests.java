package com.cunoc.CaptchaForge.CC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;
import com.cunoc.CaptchaForge.Scripting.ErroresLargos;

class BodyTests {

    @Test
    void testCSpamSinHijos() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_SPAM_SIN_HIJOS);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testCSelectConHijos() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_SELECT_CON_HIJOS);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testCOptionSinHijos() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_OPTION_SIN_HIJOS);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testCDivConContenido() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_DIV_CON_CONTENIDO);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testCFormConHijos() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_FORM_CON_HIJOS);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testCH1ConContenido() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_H1_CON_CONTENIDO);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testCButtonConHijos() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_BUTTON_CON_HIJOS);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testCInputAutoCerrado() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_INPUT_AUTO_CERRADO);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testCImgAutoCerrado() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_IMG_AUTO_CERRADO);
        analyzer.analyzer();
        Assertions.assertTrue(!analyzer.isError());
    }

    @Test
    void testErrorEnCSelectConError() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_SELECT_CON_ERROR);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError());
    }

    @Test
    void testErrorEnCOptionConError() {
        AnalyzerCC analyzer = new AnalyzerCC(ErroresLargos.C_OPTION_CON_ERROR);
        analyzer.analyzer();
        Assertions.assertTrue(analyzer.isError());
    }

    // Agregar más pruebas según sea necesario
}
