package com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operations;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerSemantico;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operation;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.DataValue;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeData;

public class NotOperation extends Operation {

    public NotOperation(AnalyzerSemantico table, ArrayList<ReportErrorInterpreter> listError) {
        super(table, listError);
        // TODO Auto-generated constructor stub
    }

    public DataValue operationNot(DataValue valueLeft, DataValue valueRight, Token token) {
        // ============= NÚMERO con otros tipos =============
        // NÚMERO y NÚMERO
        if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
            && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            double right = (double) Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // NÚMERO y STRING
        else if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
                && valueRight.getType() == ListTypeData.STRING) {
            String right = valueRight.getValue();
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // NÚMERO y CHAR
        else if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
                && valueRight.getType() == ListTypeData.CHAR) {
            char right = valueRight.getValue().charAt(0);
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // NÚMERO y BOOLEAN
        else if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
                && valueRight.getType() == ListTypeData.BOOLEAN) {
            boolean right = Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
    
        // ============= STRING con otros tipos =============
        // STRING y STRING
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.STRING) {
            String right = valueRight.getValue();
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // STRING y NÚMERO
        else if (valueLeft.getType() == ListTypeData.STRING 
                && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            double right = (double) Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // STRING y CHAR
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.CHAR) {
            char right = valueRight.getValue().charAt(0);
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // STRING y BOOLEAN
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.BOOLEAN) {
            boolean right = Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
    
        // ============= CHAR con otros tipos =============
        // CHAR y CHAR
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.CHAR) {
            char right = valueRight.getValue().charAt(0);
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // CHAR y NÚMERO
        else if (valueLeft.getType() == ListTypeData.CHAR 
                && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            double right = (double) Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // CHAR y STRING
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.STRING) {
            String right = valueRight.getValue();
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // CHAR y BOOLEAN
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.BOOLEAN) {
            boolean right = Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
    
        // ============= BOOLEAN con otros tipos =============
        // BOOLEAN y BOOLEAN
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.BOOLEAN) {
            boolean right = Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // BOOLEAN y NÚMERO
        else if (valueLeft.getType() == ListTypeData.BOOLEAN 
                && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            double right = (double) Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // BOOLEAN y STRING
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.STRING) {
            String right = valueRight.getValue();
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        // BOOLEAN y CHAR
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.CHAR) {
            char right = valueRight.getValue().charAt(0);
            return new DataValue(String.valueOf(!right), ListTypeData.BOOLEAN);
        }
        return null;
    }
}
