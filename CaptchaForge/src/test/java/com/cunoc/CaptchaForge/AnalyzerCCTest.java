package com.cunoc.CaptchaForge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;

public class AnalyzerCCTest {
    
	//NOTA manejar diferente el string vacio
    @Test
	void nothingToAnalyze() {
		String nothingToAnalyze = "";
		AnalyzerCC analyzer = new AnalyzerCC(nothingToAnalyze);
        analyzer.analyzer();
		Assertions.assertTrue(analyzer.isError());
	}

	@Test
	void firstLabel() {
		String firstLabel = " < C_CC > < / C_CC > ";
		AnalyzerCC analyzer = new AnalyzerCC(firstLabel);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

	@Test
	void CCHead() {
		String CCLanguageStructure = "<C_CC>\n" + //
						"  <C_HEAD>\n" + //
						"    <C_TITLE></C_TITLE>\n" + //
						"    <C_LINK/>\n" + //
						"  </C_HEAD>\n" + //
						"</C_CC>\n" + //
						"";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

	@Test
	void CCBodyChildless() {
		String CCLanguageStructure = "<C_CC>\n" + //
						"  <C_HEAD>\n" + //
						"    <C_TITLE></C_TITLE>\n" + //
						"    <C_LINK/>\n" + //
						"  </C_HEAD>\n" + //
						"  <C_BODY>\n" + //
						"    \n" + //
						"  </C_BODY>\n" + //
						"</C_CC>";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

	@Test
	void CCBodyWithDiv() {
		String CCLanguageStructure = "<C_CC>\n" + //
						"  <C_HEAD>\n" + //
						"    <C_TITLE></C_TITLE>\n" + //
						"    <C_LINK/>\n" + //
						"  </C_HEAD>\n" + //
						"  <C_BODY>\n" + //
						"    <C_DIV>\n" + //
						"    </C_DIV>\n" + //
						"  </C_BODY>\n" + //
						"</C_CC>";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

	@Test
	void CCBodyWithTwoDiv() {
		String CCLanguageStructure = "<C_CC>\n" + //
						"  <C_HEAD>\n" + //
						"    <C_TITLE></C_TITLE>\n" + //
						"    <C_LINK/>\n" + //
						"  </C_HEAD>\n" + //
						"  <C_BODY>\n" + //
						"    <C_DIV>\n" + //
						"      \n" + //
						"    </C_DIV>\n" + //
						"    <C_DIV>\n" + //
						"      \n" + //
						"    </C_DIV>\n" + //
						"    <C_DIV>\n" + //
						"      \n" + //
						"    </C_DIV>\n" + //
						"  </C_BODY>\n" + //
						"</C_CC>\n" + //
						"";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}

	@Test
	void CCBodywithAnObjectInsideTheDiv() {
		String CCLanguageStructure = "<C_CC>\n" + //
						"  <C_HEAD>\n" + //
						"    <C_TITLE></C_TITLE>\n" + //
						"    <C_LINK/>\n" + //
						"  </C_HEAD>\n" + //
						"  <C_BODY>\n" + //
						"    <C_DIV>\n" + //
						"      <C_H1></C_H1>\n" + //
						"    </C_DIV>\n" + //
						"    <C_DIV>\n" + //
						"      <C_H1></C_H1>\n" + //
						"    </C_DIV>\n" + //
						"    <C_DIV>\n" + //
						"    </C_DIV>\n" + //
						"  </C_BODY>\n" + //
						"</C_CC>\n" + //
						"";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}
	@Test
	void CCBodyInternalThingsInTheDiv() {
		String CCLanguageStructure = "<C_CC>\n" + //
						"  <C_HEAD>\n" + //
						"    <C_TITLE></C_TITLE>\n" + //
						"    <C_LINK/>\n" + //
						"  </C_HEAD>\n" + //
						"  <C_BODY>\n" + //
						"    <C_DIV>\n" + //
						"      <C_H1></C_H1>\n" + //
						"      <C_P></C_P>\n" + //
						"      <C_P></C_P>\n" + //
						"      <C_P></C_P>\n" + //
						"    </C_DIV>\n" + //
						"  </C_BODY>\n" + //
						"</C_CC>\n" + //
						"";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}
	@Test
	void CCInternal() {
		String CCLanguageStructure = "<C_CC>\n" + //
						"  <C_HEAD>\n" + //
						"    <C_TITLE></C_TITLE>\n" + //
						"    <C_LINK/>\n" + //
						"  </C_HEAD>\n" + //
						"  <C_BODY>\n" + //
						"    <C_DIV>\n" + //
						"      <C_H1></C_H1>\n" + //
						"      <C_P></C_P>\n" + //
						"      <C_SPAM></C_SPAM>\n" + //
						"      <C_BR/>\n" + //
						"      <C_IMG/>\n" + //
						"      <C_DIV>\n" + //
						"        <C_INPUT/>\n" + //
						"        <C_BR/>\n" + //
						"        <C_TEXTAREA></C_TEXTAREA>\n" + //
						"        <C_BR/>\n" + //
						"        <C_SELECT>\n" + //
						"          <C_OPTION></C_OPTION>\n" + //
						"          <C_OPTION></C_OPTION>\n" + //
						"          <C_OPTION></C_OPTION>\n" + //
						"        </C_SELECT>\n" + //
						"      </C_DIV>\n" + //
						"      <C_DIV>\n" + //
						"        <C_BUTTON></C_BUTTON>\n" + //
						"        <C_BR/>\n" + //
						"        <C_INPUT/>\n" + //
						"        <C_BR/>\n" + //
						"        <C_IMG/>\n" + //
						"      </C_DIV>\n" + //
						"    </C_DIV>\n" + //
						"    <C_DIV>\n" + //
						"      <C_H1></C_H1>\n" + //
						"      <C_P></C_P>\n" + //
						"      <C_SPAM></C_SPAM>\n" + //
						"      <C_BR/>\n" + //
						"      <C_DIV>\n" + //
						"        <C_SELECT>\n" + //
						"          <C_OPTION></C_OPTION>\n" + //
						"          <C_OPTION></C_OPTION>\n" + //
						"        </C_SELECT>\n" + //
						"        <C_BR/>\n" + //
						"        <C_TEXTAREA></C_TEXTAREA>\n" + //
						"      </C_DIV>\n" + //
						"      <C_DIV>\n" + //
						"        <C_INPUT/>\n" + //
						"        <C_BR/>\n" + //
						"        <C_BUTTON></C_BUTTON>\n" + //
						"        <C_BR/>\n" + //
						"        <C_IMG/>\n" + //
						"      </C_DIV>\n" + //
						"    </C_DIV>\n" + //
						"  </C_BODY>\n" + //
						"</C_CC>\n" + //
						"";
		AnalyzerCC analyzer = new AnalyzerCC(CCLanguageStructure);
        analyzer.analyzer();
		Assertions.assertTrue(!analyzer.isError());
	}
}
