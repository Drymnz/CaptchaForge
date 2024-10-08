package com.cunoc.CaptchaForge.Model.JflexAndCup;

import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.*;

public class OperationAnalyzer {

    private Addition addition;
    private Sustraction sustraction;
    private Multiplication multiplication;
    private Division division;

    public OperationAnalyzer(AnalyzerSemantico table) {
        this.addition = new Addition(table);
        this.sustraction = new Sustraction(table);
        this.multiplication = new Multiplication(table);
        this.division = new Division(table);
    }

    public DataValue operations(DataValue valueLeft, DataValue valueRight, ListTypeOperations typeOperation) {
        switch (typeOperation) {
            case ListTypeOperations.MULTIPLICATION:
                return this.multiplication.operationMultiplication(valueLeft, valueRight);
            case ListTypeOperations.DIVISION:
                return this.division.operationDivision(valueLeft, valueRight);
            case ListTypeOperations.SUBTRACTION:
                return this.sustraction.operationSubtraction(valueLeft, valueRight);
            case ListTypeOperations.ADDITION:
                return this.addition.operationAddition(valueLeft, valueRight);
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
