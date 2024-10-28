package com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operations;

import java.util.ArrayList;

import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerSemantico;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.ListTypeOperations;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Operation.Operation;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.DataValue;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora.ListTypeData;

public class Sustraction extends Operation{

    public Sustraction(AnalyzerSemantico table,ArrayList<ReportErrorInterpreter> listError) {
        super(table, listError);
    }

    public DataValue operationSubtraction(DataValue valueLeft, DataValue valueRight, Token token) {
        // Resta de dos integers: resultado es integer
        if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.INTEGER) {
            int result = Integer.parseInt(valueLeft.getValue()) - Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Resta de integer y decimal: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.DECIMAL
                || valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.INTEGER) {
            double result = Double.parseDouble(valueLeft.getValue()) - Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Resta de dos decimals: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.DECIMAL) {
            double result = Double.parseDouble(valueLeft.getValue()) - Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Resta de integer y char: resultado es integer (char convertido a ASCII)
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.CHAR
                || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.INTEGER
                || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.CHAR) {
            int intValue = (valueLeft.getType() == ListTypeData.INTEGER)
                    ? Integer.parseInt(valueLeft.getValue())
                    : (valueLeft.getValue().length() > 0) ? valueLeft.getValue().charAt(0) : 0;
            int charValue = (valueRight.getType() == ListTypeData.CHAR)
                    ? (valueRight.getValue().length() > 0) ? valueRight.getValue().charAt(0) : 0
                    : Integer.parseInt(valueRight.getValue());
            int result = intValue - charValue;
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Resta de decimal y char: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.CHAR
                || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.DECIMAL) {
            double decimalValue = (valueLeft.getType() == ListTypeData.DECIMAL)
                    ? Double.parseDouble(valueLeft.getValue())
                    : (valueLeft.getValue().length() > 0) ? valueLeft.getValue().charAt(0) : 0;
            double charValue = (valueRight.getType() == ListTypeData.CHAR)
                    ? (valueRight.getValue().length() > 0) ? valueRight.getValue().charAt(0) : 0
                    : Double.parseDouble(valueRight.getValue());
            double result = decimalValue - charValue;
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Resta de integer y boolean: boolean convertido a 0 o 1, resultado es integer
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.BOOLEAN) {
            int result = Integer.parseInt(valueLeft.getValue()) - (Boolean.parseBoolean(valueRight.getValue()) ? 1 : 0);
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Resta de decimal y boolean: boolean convertido a 0 o 1, resultado es integer
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.BOOLEAN) {
            double result = Double.parseDouble(valueLeft.getValue())
                    - (Boolean.parseBoolean(valueRight.getValue()) ? 1 : 0);
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Resta de boolean y decimal: boolean convertido a 0 o 1, resultado es decimal
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.DECIMAL) {
            double result = (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0)
                    - Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Resta de boolean y decimal: boolean convertido a 0 o 1, resultado es decimal
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.INTEGER) {
            double result = (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0)
                    - Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Para cualquier otra combinación (incluyendo operaciones con string), reportar
        // error
        else {
            this.reportError(valueLeft, valueRight,token,ListTypeOperations.SUBTRACTION);
            return new DataValue("", ListTypeData.NULL);
        }
    }


}
