package com.cunoc.CaptchaForge.DataBase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cunoc.CaptchaForge.CC.TestingConverterListLabelCCToHTML;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerCC;
import com.cunoc.CaptchaForge.Model.Utility.Converter.LabelCCToCaptchaConverter;
import com.cunoc.CaptchaForge.Model.WebIdentities.Captcha;

public class SaveTheDataBase {
    	@Test
	void CaptchaConversionTest() {
		AnalyzerCC analyzer = new AnalyzerCC(TestingConverterListLabelCCToHTML.firstLabel);
        analyzer.analyzer();
        Captcha check = (new LabelCCToCaptchaConverter()).converterListLabelCCToCaptcha(analyzer.getListLabelCC());
        Assertions.assertTrue(!analyzer.isError()&& check.getId().equals("captcha_complejo"));
	}
}
