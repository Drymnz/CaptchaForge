package com.cunoc.CaptchaForge.Model.JflexAndCup.Operation;

import com.cunoc.CaptchaForge.Model.Analyzer.ErrorTypeInTheInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerSemantico;
import com.cunoc.CaptchaForge.Model.JflexAndCup.DataValue;
import com.cunoc.CaptchaForge.Model.JflexAndCup.ListTypeOperations;
import com.cunoc.CaptchaForge.Model.JflexAndCup.OperationAnalyzer;

import java.util.ArrayList;

public class Operation {
    private AnalyzerSemantico table;
    private ArrayList<ReportErrorInterpreter> listError;
    private final String SEPARATOR = " <=> ";

    public Operation(AnalyzerSemantico table, ArrayList<ReportErrorInterpreter> listError) {
        this.table = table;
        this.listError = listError;
    }

    protected void reportError(DataValue valueLeft, DataValue valueRight, Token token, ListTypeOperations type) {
        this.listError.add(new ReportErrorInterpreter(ErrorTypeInTheInterpreter.SEMANTIC, token,
                OperationAnalyzer.ERROR_CANNOT_OPERATE + this.errorDescription(valueLeft, valueRight, type)));
    }

    private String errorDescription(DataValue valueLeft, DataValue valueRight, ListTypeOperations type) {
        return this.SEPARATOR + valueLeft.getValue() + this.SEPARATOR + valueRight.getValue() + this.SEPARATOR + type;
    }

    public AnalyzerSemantico getTable() {
        return table;
    }

    public ArrayList<ReportErrorInterpreter> getListError() {
        return listError;
    }

    public String getSEPARATOR() {
        return SEPARATOR;
    }

}
