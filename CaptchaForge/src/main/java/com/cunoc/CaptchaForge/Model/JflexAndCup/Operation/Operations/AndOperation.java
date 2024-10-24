package com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operations;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerSemantico;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.ListTypeOperations;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operation;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.DataValue;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeData;

public class AndOperation extends Operation {

    public AndOperation(AnalyzerSemantico table, ArrayList<ReportErrorInterpreter> listError) {
        super(table, listError);
        // TODO Auto-generated constructor stub
    }

    public DataValue operationAnd(DataValue valueLeft, DataValue valueRight, Token token) {
        // ============= BOOLEAN con otros tipos =============
        // BOOLEAN y BOOLEAN
        if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.BOOLEAN) {
            boolean left = Boolean.parseBoolean(valueLeft.getValue());
            boolean right = Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(left && right), ListTypeData.BOOLEAN);
        }
        else {
            this.reportError(valueLeft, valueRight,token,ListTypeOperations.AND);
            return new DataValue("", ListTypeData.NULL);
        }
    }

}
