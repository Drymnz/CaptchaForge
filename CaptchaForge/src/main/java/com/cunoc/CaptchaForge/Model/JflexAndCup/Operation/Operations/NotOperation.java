package com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operations;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerSemantico;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.ListTypeOperations;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operation;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.DataValue;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeData;

public class NotOperation extends Operation {

    public NotOperation(AnalyzerSemantico table, ArrayList<ReportErrorInterpreter> listError) {
        super(table, listError);
        // TODO Auto-generated constructor stub
    }

    public DataValue operationNot(DataValue valueLeft, DataValue valueRight, Token token) {
        // BOOLEAN
        if (valueRight.getType() == ListTypeData.BOOLEAN) {
            boolean right = Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        } else {
            this.reportError(valueLeft, valueRight, token, ListTypeOperations.NOT);
            return new DataValue("", ListTypeData.NULL);
        }
    }
}
