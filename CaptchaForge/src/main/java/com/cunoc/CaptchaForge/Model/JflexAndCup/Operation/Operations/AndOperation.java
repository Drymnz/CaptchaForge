package com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operations;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerSemantico;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operation;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.DataValue;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeData;

public class AndOperation extends Operation {

    public AndOperation(AnalyzerSemantico table, ArrayList<ReportErrorInterpreter> listError) {
        super(table, listError);
        // TODO Auto-generated constructor stub
    }

    public DataValue operationAnd(DataValue valueLeft, DataValue valueRight, Token token) {
        // ============= NÚMERO con otros tipos =============
        // NÚMERO y NÚMERO
        if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
            && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            double left = (double) Integer.parseInt(valueLeft.getValue());
            double right = (double) Integer.parseInt(valueRight.getValue());
        }
        // NÚMERO y STRING
        else if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
                && valueRight.getType() == ListTypeData.STRING) {
            double left = (double) Integer.parseInt(valueLeft.getValue());
            String right = valueRight.getValue();
        }
        // NÚMERO y CHAR
        else if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
                && valueRight.getType() == ListTypeData.CHAR) {
            double left = (double) Integer.parseInt(valueLeft.getValue());
            char right = valueRight.getValue().charAt(0);
        }
        // NÚMERO y BOOLEAN
        else if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
                && valueRight.getType() == ListTypeData.BOOLEAN) {
            double left = (double) Integer.parseInt(valueLeft.getValue());
            boolean right = Boolean.parseBoolean(valueRight.getValue());
        }
    
        // ============= STRING con otros tipos =============
        // STRING y STRING
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.STRING) {
            String left = valueLeft.getValue();
            String right = valueRight.getValue();
        }
        // STRING y NÚMERO
        else if (valueLeft.getType() == ListTypeData.STRING 
                && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            String left = valueLeft.getValue();
            double right = (double) Integer.parseInt(valueRight.getValue());
        }
        // STRING y CHAR
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.CHAR) {
            String left = valueLeft.getValue();
            char right = valueRight.getValue().charAt(0);
        }
        // STRING y BOOLEAN
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.BOOLEAN) {
            String left = valueLeft.getValue();
            boolean right = Boolean.parseBoolean(valueRight.getValue());
        }
    
        // ============= CHAR con otros tipos =============
        // CHAR y CHAR
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.CHAR) {
            char left = valueLeft.getValue().charAt(0);
            char right = valueRight.getValue().charAt(0);
        }
        // CHAR y NÚMERO
        else if (valueLeft.getType() == ListTypeData.CHAR 
                && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            char left = valueLeft.getValue().charAt(0);
            double right = (double) Integer.parseInt(valueRight.getValue());
        }
        // CHAR y STRING
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.STRING) {
            char left = valueLeft.getValue().charAt(0);
            String right = valueRight.getValue();
        }
        // CHAR y BOOLEAN
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.BOOLEAN) {
            char left = valueLeft.getValue().charAt(0);
            boolean right = Boolean.parseBoolean(valueRight.getValue());
        }
    
        // ============= BOOLEAN con otros tipos =============
        // BOOLEAN y BOOLEAN
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.BOOLEAN) {
            boolean left = Boolean.parseBoolean(valueLeft.getValue());
            boolean right = Boolean.parseBoolean(valueRight.getValue());
        }
        // BOOLEAN y NÚMERO
        else if (valueLeft.getType() == ListTypeData.BOOLEAN 
                && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            boolean left = Boolean.parseBoolean(valueLeft.getValue());
            double right = (double) Integer.parseInt(valueRight.getValue());
        }
        // BOOLEAN y STRING
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.STRING) {
            boolean left = Boolean.parseBoolean(valueLeft.getValue());
            String right = valueRight.getValue();
        }
        // BOOLEAN y CHAR
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.CHAR) {
            boolean left = Boolean.parseBoolean(valueLeft.getValue());
            char right = valueRight.getValue().charAt(0);
        }
        
        return null;
    }

}
