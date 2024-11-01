package com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operations;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerSemantico;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.ListTypeOperations;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operation;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.DataValue;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeData;

public class NotTheSame extends Operation {

    public NotTheSame(AnalyzerSemantico table, ArrayList<ReportErrorInterpreter> listError) {
        super(table, listError);
        // TODO Auto-generated constructor stub
    }

    public DataValue operationNotTheSame(DataValue valueLeft, DataValue valueRight, Token token) {
        // ============= NÚMERO con otros tipos =============
        // NÚMERO y NÚMERO
        if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
            && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            double left = (double) Integer.parseInt(valueLeft.getValue().isEmpty()? "0" : valueLeft.getValue());
            double right = (double) Integer.parseInt(valueRight.getValue().isEmpty()? "0" : valueRight.getValue());
            return new DataValue(String.valueOf(left != right), ListTypeData.BOOLEAN);
        }
        // NÚMERO y STRING
        else if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
                && valueRight.getType() == ListTypeData.STRING) {
            double left = (double) Integer.parseInt(valueLeft.getValue().isEmpty()? "0" : valueLeft.getValue());
            String right = valueRight.getValue();
            return new DataValue(String.valueOf(!String.valueOf(left).equals(right)), ListTypeData.BOOLEAN);
        }
        // NÚMERO y CHAR
        else if ((valueLeft.getType() == ListTypeData.INTEGER || valueLeft.getType() == ListTypeData.DECIMAL) 
                && valueRight.getType() == ListTypeData.CHAR) {
            double left = (double) Integer.parseInt(valueLeft.getValue().isEmpty()? "0" : valueLeft.getValue());
            char right = valueRight.getValue().charAt(0);
            return new DataValue(String.valueOf(left != right), ListTypeData.BOOLEAN);
        }
        // ============= STRING con otros tipos =============
        // STRING y STRING
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.STRING) {
            String left = valueLeft.getValue();
            String right = valueRight.getValue();
            return new DataValue(String.valueOf(left != right), ListTypeData.BOOLEAN);
        }
        // STRING y NÚMERO
        else if (valueLeft.getType() == ListTypeData.STRING 
                && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            String left = valueLeft.getValue();
            double right = (double) Integer.parseInt(valueRight.getValue().isEmpty()? "0" : valueRight.getValue());
            return new DataValue(String.valueOf(!left.equals(String.valueOf(right))), ListTypeData.BOOLEAN);
        }
        // STRING y CHAR
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.CHAR) {
            String left = valueLeft.getValue();
            char right = valueRight.getValue().charAt(0);
            return new DataValue(String.valueOf(!left.equals(String.valueOf(right))), ListTypeData.BOOLEAN);
        }
        // STRING y BOOLEAN
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.BOOLEAN) {
            String left = valueLeft.getValue();
            boolean right = Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(!left.equals(String.valueOf(right))), ListTypeData.BOOLEAN);
        }
        // ============= CHAR con otros tipos =============
        // CHAR y CHAR
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.CHAR) {
            char left = valueLeft.getValue().charAt(0);
            char right = valueRight.getValue().charAt(0);
            return new DataValue(String.valueOf(left != right), ListTypeData.BOOLEAN);
        }
        // CHAR y NÚMERO
        else if (valueLeft.getType() == ListTypeData.CHAR 
                && (valueRight.getType() == ListTypeData.INTEGER || valueRight.getType() == ListTypeData.DECIMAL)) {
            char left = valueLeft.getValue().charAt(0);
            double right = (double) Integer.parseInt(valueRight.getValue().isEmpty()? "0" : valueRight.getValue());
            return new DataValue(String.valueOf(left != right), ListTypeData.BOOLEAN);
        }
        // CHAR y STRING
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.STRING) {
            char left = valueLeft.getValue().charAt(0);
            String right = valueRight.getValue();
            return new DataValue(String.valueOf(!String.valueOf(left).equals(right)), ListTypeData.BOOLEAN);
        }
        // ============= BOOLEAN con otros tipos =============
        // BOOLEAN y BOOLEAN
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.BOOLEAN) {
            boolean left = Boolean.parseBoolean(valueLeft.getValue());
            boolean right = Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(left != right), ListTypeData.BOOLEAN);
        }
        // BOOLEAN y STRING
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.STRING) {
            boolean left = Boolean.parseBoolean(valueLeft.getValue());            
            String right = valueRight.getValue();
            return new DataValue(String.valueOf(!String.valueOf(left).equals(right)), ListTypeData.BOOLEAN);
        }
        else {
            this.reportError(valueLeft, valueRight,token,ListTypeOperations.NOT_THE_SAME);
            return new DataValue("", ListTypeData.NULL);
        }
    }
}
