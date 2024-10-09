package com.cunoc.CaptchaForge.Model.JflexAndCup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cunoc.CaptchaForge.Model.Analyzer.ErrorTypeInTheInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;

public class AnalyzerSemantico {
    private Map<String, DataValue> tablaSimbolos;
    private ArrayList<ReportErrorInterpreter> listError;
    private final String REPEATED_VARIABLE_ID = "Ya existe una variable con este nombre :";
    private final String THAT_VARIABLE_DOES_NOT_EXIST = "No existe la varible :";
    private OperationAnalyzer operationAnalyzer;
    public static Token tokenError = new Token(0,0,"");

    public AnalyzerSemantico() {
        this.listError = new ArrayList();
        this.tablaSimbolos = new HashMap<>();
        this.operationAnalyzer = new OperationAnalyzer(this,listError); 
    }

    // Registrar una nueva variable en la tabla de símbolos
    public void registerVariables(ArrayList<String> listID, DataValue value, Token token) {
        for (String id_element : listID) {
            this.registerVariable(id_element, value, token);
        }
    }

    //Registar el dato
    public void registerVariable(String id, DataValue value, Token token) {
        if (tablaSimbolos.containsKey(id)) {
            this.repeatedId(id, token);
        } else {
            tablaSimbolos.put(id, value);
        }
    }

    //Recupera el valor del dato
    public DataValue retrieveDataVariableOrFunction(String id,Token token){
        if (tablaSimbolos.containsKey(id)) {
            return tablaSimbolos.get(id);
        } else {
            errorThereisVariable(id, token);
            return  null;
        }
    }

    //Reasignacion de valor 
    public void assignNewData(String id,DataValue dope,Token token){
        DataValue tableValueID = this.retrieveDataVariableOrFunction(id, token);
        if (tableValueID != null) {
            System.out.println(tableValueID);
            System.out.println(dope);
            tableValueID.setValue(dope.getValue());
            tableValueID.setType(dope.getType());
        }
    }

    // Error si no existe la variable
    private void errorThereisVariable(String id,Token token){
        listError.add(new ReportErrorInterpreter(ErrorTypeInTheInterpreter.SEMANTIC, token, THAT_VARIABLE_DOES_NOT_EXIST + id));
    }

    //Realiza las operaciones
    public DataValue operationsDatas(DataValue valueLeft, DataValue valueRight, ListTypeOperations typeOperation, Token token) {
        DataValue returnar = this.operationAnalyzer.operations(valueLeft, valueRight, typeOperation,token);
        return returnar;
    }

    // Error de id repetido
    private void repeatedId(String id, Token token) {
        listError.add(new ReportErrorInterpreter(ErrorTypeInTheInterpreter.SEMANTIC, token, REPEATED_VARIABLE_ID + id));
    }

    public Map<String, DataValue> getTablaSimbolos() {
        return tablaSimbolos;
    }

    public ArrayList<ReportErrorInterpreter> getListError() {
        return listError;
    }

}