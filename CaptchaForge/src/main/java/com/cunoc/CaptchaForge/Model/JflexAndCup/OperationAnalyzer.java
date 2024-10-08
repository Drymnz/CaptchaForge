package com.cunoc.CaptchaForge.Model.JflexAndCup;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.*;
import java.util.ArrayList;

public class OperationAnalyzer {

    private Addition addition;
    private Sustraction sustraction;
    private Multiplication multiplication;
    private Division division;

    public final static String ERROR_CANNOT_OPERATE = "ERROR NO SE PUEDE OPERAR";
    

    public OperationAnalyzer(AnalyzerSemantico table,ArrayList<ReportErrorInterpreter> listError) {
        this.addition = new Addition(table,listError);
        this.sustraction = new Sustraction(table,listError);
        this.multiplication = new Multiplication(table,listError);
        this.division = new Division(table,listError);
    }

    public DataValue operations(DataValue valueLeft, DataValue valueRight, ListTypeOperations typeOperation, Token token) {
        switch (typeOperation) {
            case ListTypeOperations.MULTIPLICATION:
                return this.multiplication.operationMultiplication(valueLeft, valueRight,token);
            case ListTypeOperations.DIVISION:
                return this.division.operationDivision(valueLeft, valueRight,token);
            case ListTypeOperations.SUBTRACTION:
                return this.sustraction.operationSubtraction(valueLeft, valueRight,token);
            case ListTypeOperations.ADDITION:
                return this.addition.operationAddition(valueLeft, valueRight,token);
            case ListTypeOperations.AND:
                break;
            case ListTypeOperations.NOT:
                break;
            case ListTypeOperations.OR:
                break;
            case ListTypeOperations.GREATER_THAN_EQUAL:
                break;
            case ListTypeOperations.GREATER_THAN:
                break;
            case ListTypeOperations.LESS_THAN_EQUAL:
                break;
            case ListTypeOperations.LESS_THAN:
                break;
            case ListTypeOperations.NOT_THE_SAME:
                break;
            case ListTypeOperations.SAME_AS:
                break;
            default:
                break;
        }
        return null;
    }

}
