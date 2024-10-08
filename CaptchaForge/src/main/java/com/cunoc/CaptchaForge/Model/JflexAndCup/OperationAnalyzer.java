package com.cunoc.CaptchaForge.Model.JflexAndCup;

public class OperationAnalyzer {

    private AnalyzerSemantico table;

    public OperationAnalyzer(AnalyzerSemantico table) {
        this.table = table;
    }

    public DataValue operations(DataValue valueLeft, DataValue valueRight, ListTypeOperations typeOperation) {
        switch (typeOperation) {
            case ListTypeOperations.MULTIPLICATION:
                return this.operationMultiplication(valueLeft, valueRight);
            case ListTypeOperations.DIVISION:
                return this.operationDivision(valueLeft, valueRight);
            case ListTypeOperations.SUBTRACTION:
                return this.operationSubtraction(valueLeft, valueRight);
            case ListTypeOperations.ADDITION:
                return this.operationAddition(valueLeft, valueRight);
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

    private DataValue operationAddition(DataValue valueLeft, DataValue valueRight) {
        // Suma de dos strings: resultado es la concatenación
        if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.STRING
        // Suma de strings y  integers : resultado es string
        || valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.INTEGER
        // Suma de integer y  string : resultado es string
        || valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.STRING
        // Suma de string y  decimal : resultado es string
        || valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.DECIMAL
        // Suma de string y  char : resultado es string
        || valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.CHAR
        // Suma de decimal y  string : resultado es string
        || valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.STRING
        // Suma de decimal y  string : resultado es string
        || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.STRING
        ) {
            return new DataValue(valueLeft.getValue() + valueRight.getValue(), ListTypeData.STRING);
        } 
        // Suma de integer y decimal: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.DECIMAL) {
            int integer = (int) Double.parseDouble(valueLeft.getValue().replace("\"", ""));
            double decimal = Double.parseDouble(valueRight.getValue().replace("\"", ""));
            return new DataValue(String.valueOf(integer + decimal), ListTypeData.DECIMAL);
        } 
        // Suma de string y boolean: marcado como error en el documento
        else if (valueLeft.getType() == ListTypeData.STRING && valueRight.getType() == ListTypeData.BOOLEAN) {
            this.reportError();
            return null;
        } 
        // Suma de dos integers: resultado es integer
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.INTEGER) {
            int result = Integer.parseInt(valueLeft.getValue()) + Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        } 
        // Suma de dos decimals: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.DECIMAL) {
            double result = Double.parseDouble(valueLeft.getValue()) + Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        } 
        // Suma de dos chars: resultado es string (concatenación)
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.CHAR) {
            char valueLeftChar = (valueLeft.getValue().length()>0)? valueLeft.getValue().charAt(0) : 0;
            char valueRightChar = (valueRight.getValue().length()>0)? valueRight.getValue().charAt(0) : 0;
            return new DataValue(String.valueOf(valueLeftChar+valueRightChar), ListTypeData.STRING);
        } 
        // Suma de integer y char: resultado es integer (char convertido a ASCII)
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.CHAR) {
            int intValue = Integer.parseInt(valueLeft.getValue());
            char charValue = (valueRight.getValue().length()>0)? valueRight.getValue().charAt(0) : 0;
            int result = intValue + (int) charValue;
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        } 
        // Suma de dos booleans: implementado como OR lógico
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.BOOLEAN
        ) {
            boolean result = Boolean.parseBoolean(valueLeft.getValue()) || Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.BOOLEAN);
        } 
        // Suma de decimal e integer: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.INTEGER) {
            double decimal = Double.parseDouble(valueLeft.getValue());
            int integer = Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(decimal + integer), ListTypeData.DECIMAL);
        }
        // Suma de decimal e boolean: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.BOOLEAN){
            double decimal = Double.parseDouble(valueLeft.getValue());
            int integer = (Boolean.parseBoolean(valueRight.getValue()) ? 1 : 0);
            return new DataValue(String.valueOf(decimal + integer), ListTypeData.DECIMAL);
        }
        // Suma de char e boolean: resultado es integer
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.BOOLEAN){
            char charValue = (valueLeft.getValue().length()>0)? valueLeft.getValue().charAt(0) : 0;
            int integer = (Boolean.parseBoolean(valueRight.getValue()) ? 1 : 0);
            return new DataValue(String.valueOf(charValue + integer), ListTypeData.INTEGER);
        }  
        // Suma de char e integer: resultado es integer (char convertido a ASCII)
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.INTEGER) {
            char charValue = (valueLeft.getValue().length()>0)? valueLeft.getValue().charAt(0) : 0;
            int intValue = Integer.parseInt(valueRight.getValue());
            int result = (int) charValue + intValue;
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        } 
        // Suma de char e decimal: resultado es integer (char convertido a ASCII)
        else if (valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.DECIMAL) {
            char charValue = (valueLeft.getValue().length()>0)? valueLeft.getValue().charAt(0) : 0;
            Double intValue = Double.parseDouble(valueRight.getValue());
            Double result = charValue + intValue;
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        } 
        // Suma de boolean e integer: boolean convertido a 0 o 1, resultado es integer
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.INTEGER
        ) {
            int result = (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0) + Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        } 
        // Suma de boolean e decimal : boolean convertido a 0 o 1, resultado es integer
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.DECIMAL
        ) {
            double result = (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0) + Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        else if (
            // Suma de integer e boolean: boolean convertido a 0 o 1, resultado es integer
             valueLeft.getType() == ListTypeData.INTEGER &&  valueRight.getType() == ListTypeData.BOOLEAN
        ){
            int result = Integer.parseInt(valueLeft.getValue()) + (Boolean.parseBoolean(valueRight.getValue()) ? 1 : 0);
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Suma de decimal y char: char convertido a ASCII, resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.CHAR) {
            double decimal = Double.parseDouble(valueLeft.getValue());
            char charValue  = (valueRight.getValue().length()>0)? valueRight.getValue().charAt(0) : 0;
            return new DataValue(String.valueOf(decimal + (int) charValue), ListTypeData.DECIMAL);
        }
        // Suma de boolean y char: char convertido a ASCII, resultado es decimal
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.CHAR) {
            int decimal = (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0);
            char charValue  = (valueRight.getValue().length()>0)? valueRight.getValue().charAt(0) : 0;
            return new DataValue(String.valueOf(decimal + (int) charValue), ListTypeData.INTEGER);
        }  
        // Para cualquier otra combinación no especificada, reportar error
        else {
            this.reportError();
            return null;
        }
    }

    private DataValue operationSubtraction(DataValue valueLeft, DataValue valueRight) {
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
                 || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.INTEGER) {
            int intValue = (valueLeft.getType() == ListTypeData.INTEGER) 
                           ? Integer.parseInt(valueLeft.getValue()) 
                           : valueLeft.getValue().charAt(0);
            int charValue = (valueRight.getType() == ListTypeData.CHAR) 
                            ? valueRight.getValue().charAt(0) 
                            : Integer.parseInt(valueRight.getValue());
            int result = intValue - charValue;
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Resta de decimal y char: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.CHAR
                 || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.DECIMAL) {
            double decimalValue = (valueLeft.getType() == ListTypeData.DECIMAL) 
                                  ? Double.parseDouble(valueLeft.getValue()) 
                                  : valueLeft.getValue().charAt(0);
            double charValue = (valueRight.getType() == ListTypeData.CHAR) 
                               ? valueRight.getValue().charAt(0) 
                               : Double.parseDouble(valueRight.getValue());
            double result = decimalValue - charValue;
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Resta de integer y boolean: boolean convertido a 0 o 1, resultado es integer
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.BOOLEAN) {
            int result = Integer.parseInt(valueLeft.getValue()) - (Boolean.parseBoolean(valueRight.getValue()) ? 1 : 0);
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Resta de boolean y decimal: boolean convertido a 0 o 1, resultado es decimal
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.DECIMAL) {
            double result = (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0) - Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Para cualquier otra combinación (incluyendo operaciones con string), reportar error
        else {
            this.reportError();
            return null;
        }
    }

    private DataValue operationMultiplication(DataValue valueLeft, DataValue valueRight) {
        // Multiplicación de dos integers: resultado es integer
        if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.INTEGER) {
            int result = Integer.parseInt(valueLeft.getValue()) * Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Multiplicación de integer y decimal: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.DECIMAL
                 || valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.INTEGER) {
            double result = Double.parseDouble(valueLeft.getValue()) * Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Multiplicación de dos decimals: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.DECIMAL) {
            double result = Double.parseDouble(valueLeft.getValue()) * Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Multiplicación de integer y char: resultado es integer (char convertido a ASCII)
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.CHAR
                 || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.INTEGER) {
            int intValue = (valueLeft.getType() == ListTypeData.INTEGER) 
                           ? Integer.parseInt(valueLeft.getValue()) 
                           : valueLeft.getValue().charAt(0);
            int charValue = (valueRight.getType() == ListTypeData.CHAR) 
                            ? valueRight.getValue().charAt(0) 
                            : Integer.parseInt(valueRight.getValue());
            int result = intValue * charValue;
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Multiplicación de decimal y char: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.CHAR
                 || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.DECIMAL) {
            double decimalValue = (valueLeft.getType() == ListTypeData.DECIMAL) 
                                  ? Double.parseDouble(valueLeft.getValue()) 
                                  : valueLeft.getValue().charAt(0);
            double charValue = (valueRight.getType() == ListTypeData.CHAR) 
                               ? valueRight.getValue().charAt(0) 
                               : Double.parseDouble(valueRight.getValue());
            double result = decimalValue * charValue;
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Multiplicación de dos booleans: implementado como AND lógico
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.BOOLEAN) {
            boolean result = Boolean.parseBoolean(valueLeft.getValue()) && Boolean.parseBoolean(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.BOOLEAN);
        }
        // Multiplicación de integer y boolean: boolean convertido a 0 o 1, resultado es integer
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.BOOLEAN
                 || valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.INTEGER) {
            int result = (valueLeft.getType() == ListTypeData.INTEGER)
                         ? Integer.parseInt(valueLeft.getValue()) * (Boolean.parseBoolean(valueRight.getValue()) ? 1 : 0)
                         : (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0) * Integer.parseInt(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.INTEGER);
        }
        // Multiplicación de decimal y boolean: boolean convertido a 0 o 1, resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.BOOLEAN
                 || valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.DECIMAL) {
            double result = (valueLeft.getType() == ListTypeData.DECIMAL)
                            ? Double.parseDouble(valueLeft.getValue()) * (Boolean.parseBoolean(valueRight.getValue()) ? 1 : 0)
                            : (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0) * Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Para cualquier otra combinación (incluyendo operaciones con string), reportar error
        else {
            this.reportError();
            return null;
        }
    }

    private DataValue operationDivision(DataValue valueLeft, DataValue valueRight) {
        // Verificar división por cero
        if (isZero(valueRight)) {
            //"División por cero (boolean false)"
            this.reportError();
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
                              : valueLeft.getValue().charAt(0);
            double charValue = (valueRight.getType() == ListTypeData.CHAR) 
                               ? valueRight.getValue().charAt(0) 
                               : Integer.parseInt(valueRight.getValue());
            double result = intValue / charValue;
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // División de decimal y char: resultado es decimal
        else if (valueLeft.getType() == ListTypeData.DECIMAL && valueRight.getType() == ListTypeData.CHAR
                 || valueLeft.getType() == ListTypeData.CHAR && valueRight.getType() == ListTypeData.DECIMAL) {
            double decimalValue = (valueLeft.getType() == ListTypeData.DECIMAL) 
                                  ? Double.parseDouble(valueLeft.getValue()) 
                                  : valueLeft.getValue().charAt(0);
            double charValue = (valueRight.getType() == ListTypeData.CHAR) 
                               ? valueRight.getValue().charAt(0) 
                               : Double.parseDouble(valueRight.getValue());
            double result = decimalValue / charValue;
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // División de integer y boolean: boolean convertido a 0 o 1, resultado es integer
        else if (valueLeft.getType() == ListTypeData.INTEGER && valueRight.getType() == ListTypeData.BOOLEAN) {
            if (Boolean.parseBoolean(valueRight.getValue())) {
                return new DataValue(valueLeft.getValue(), ListTypeData.INTEGER);
            } else {
                //"División por cero (boolean false)"
                this.reportError();
                return null;
            }
        }
        // División de boolean y decimal: boolean convertido a 0 o 1, resultado es decimal
        else if (valueLeft.getType() == ListTypeData.BOOLEAN && valueRight.getType() == ListTypeData.DECIMAL) {
            double result = (Boolean.parseBoolean(valueLeft.getValue()) ? 1 : 0) / Double.parseDouble(valueRight.getValue());
            return new DataValue(String.valueOf(result), ListTypeData.DECIMAL);
        }
        // Para cualquier otra combinación (incluyendo operaciones con string), reportar error
        else {
            this.reportError();
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
                return value.getValue().charAt(0) == '0';
            case BOOLEAN:
                return !Boolean.parseBoolean(value.getValue());
            default:
                return false;
        }
    }

    private void reportError() {

    }
}
