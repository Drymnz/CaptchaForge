package com.cunoc.CaptchaForge.Model.JflexAndCup.Operation;

import com.cunoc.CaptchaForge.Model.JflexAndCup.AnalyzerSemantico;
import com.cunoc.CaptchaForge.Model.JflexAndCup.DataValue;
import com.cunoc.CaptchaForge.Model.JflexAndCup.ListTypeData;

public class Division {
    private AnalyzerSemantico table;

    public Division(AnalyzerSemantico table) {
        this.table = table;
    }

    public DataValue operationDivision(DataValue valueLeft, DataValue valueRight) {
        // Verificar división por cero
        if (isZero(valueRight)) {
            // "División por cero (boolean false)"
            this.reportError(valueLeft, valueRight);
            return null;
        }

        // División de dos integers: resultado es decimal
        if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.INTEGER) {
            double result = (double) Integer.parseInt(valueLeft.getValue()) / Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // División de integer y decimal o decimal y integer: resultado es decimal
        else if ((valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.DECIMAL)
                || (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.INTEGER)) {
            double result = Double.parseDouble(valueLeft.getValue()) / Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // División de dos decimals: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.DECIMAL) {
            double result = Double.parseDouble(valueLeft.getValue()) / Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // División de integer y char: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.CHAR
                || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.INTEGER) {
            double intValue = (valueLeft.getType() == ListTypeData.INTEGER)
                    ? Integer.parseInt(valueLeft.getValue())
                    : (valueLeft.getValue().length() > 0) ? valueLeft.getValue().charAt(0) : 0;
            double charValue = (valueRight.getType() == ListTypeData.CHAR)
                    ? (valueRight.getValue().length() > 0) ? valueRight.getValue().charAt(0) : 1
                    : Integer.parseInt(valueRight.getValue());
            double result = intValue / charValue;
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // División de decimal y char: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.CHAR
                || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.DECIMAL) {
            double decimalValue = (valueLeft.getType() == ListTypeData.DECIMAL)
                    ? Double.parseDouble(valueLeft.getValue())
                    : (valueLeft.getValue().length() > 0) ? valueLeft.getValue().charAt(0) : 0;
            double charValue = (valueRight.getType() == ListTypeData.CHAR)
                    ? (valueRight.getValue().length() > 0) ? valueRight.getValue().charAt(0) : 1
                    : Double.parseDouble(valueRight.getValue());
            double result = decimalValue / charValue;
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // División de integer y boolean: boolean convertido a 0 o 1, resultado es
        // integer
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.BOOLEAN
                || valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.BOOLEAN) {
            if (Boolean.parseBoolean(valueRight.getValue())) {
                return new DataValue(valueLeft.getValue(),
                        (valueLeft.getType() == ListTypeData.INTEGER) ? ListTypeData.INTEGER : ListTypeData.DECIMAL);
            } else {
                // "División por cero (boolean false)"
                this.reportError(valueLeft, valueRight);
                return null;
            }
        }
        // División de boolean y decimal: boolean convertido a 0 o 1, resultado es
        // decimal
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.DECIMAL
                || valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.INTEGER) {
            double result = (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0)
                    / Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // División de integer y char: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.CHAR
                || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.BOOLEAN) {
            double intValue = (valueLeft.getType() == ListTypeData.BOOLEAN)
                    ? (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0)
                    : (valueLeft.getValue().length() > 0) ? valueLeft.getValue().charAt(0) : 0;

            double charValue = (valueRight.getType() == ListTypeData.CHAR)
                    ? (valueRight.getValue().length() > 0) ? valueRight.getValue().charAt(0) : 1
                    : (Boolean.parseBoolean(valueRight.getValue()) ? 1 : 0);
            if (charValue == 0)
                return null;
            double result = intValue / charValue;
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Para cualquier otra combinación (incluyendo operaciones con string), reportar
        // error
        else {
            this.reportError(valueLeft, valueRight);
            return null;
        }
    }

    // Método auxiliar para verificar si un valor es cero
    private boolean isZero(DataValue value) {
        switch (value.getType()) {
            case INTEGER:
                return Integer.parseInt(value.getValue()) == 0;
            case DECIMAL:
                return Double.parseDouble(value.getValue()) == 0.0;
            case CHAR:
                return (value.getValue().length() > 0 ? value.getValue().charAt(0) == '0' : true);
            case BOOLEAN:
                return !Boolean.parseBoolean(value.getValue());
            default:
                return false;
        }
    }

    private void reportError(DataValue valueLeft, DataValue valueRight) {

    }
}
