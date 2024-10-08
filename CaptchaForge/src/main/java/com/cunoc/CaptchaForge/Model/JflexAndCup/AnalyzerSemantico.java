package com.cunoc.CaptchaForge.Model.JflexAndCup;

import java.util.Map;

import com.cunoc.CaptchaForge.Model.Analyzer.ErrorTypeInTheInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;

import java.util.HashMap;
import java.util.ArrayList;

public class AnalyzerSemantico {
    private Map<String, DataValue> tablaSimbolos;
    private ArrayList<ReportErrorInterpreter> listError;
    private final String REPEATED_VARIABLE_ID = "";
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

    public void registerVariable(String id, DataValue value, Token token) {
        if (tablaSimbolos.containsKey(id)) {
            this.repeatedId(id, value, token);
        } else {
            tablaSimbolos.put(id, value);
        }
    }

    public DataValue operationsDatas(DataValue valueLeft, DataValue valueRight, ListTypeOperations typeOperation, Token token) {
        return this.operationAnalyzer.operations(valueLeft, valueRight, typeOperation,token);
    }

    // Error de id repetido
    private void repeatedId(String id, DataValue value, Token token) {
        listError.add(new ReportErrorInterpreter(ErrorTypeInTheInterpreter.SEMANTIC, token, REPEATED_VARIABLE_ID));
    }

    public Map<String, DataValue> getTablaSimbolos() {
        return tablaSimbolos;
    }

    public ArrayList<ReportErrorInterpreter> getListError() {
        return listError;
    }

}