package com.cunoc.CaptchaForge.Model.JflexAndCup;

import java.util.Map;

import com.cunoc.CaptchaForge.Model.Analyzer.ErrorTypeInTheInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;

import java.util.HashMap;
import java.util.ArrayList;

public class AnalyzerSemantico {
    private Map<String, DataValue> tablaSimbolos;
    private ArrayList<ReportErrorInterpreter> listError = new ArrayList();
    private final String REPEATED_VARIABLE_ID = "";

    public AnalyzerSemantico() {
        this.tablaSimbolos = new HashMap<>();
    }

    // Registrar una nueva variable en la tabla de símbolos
    public void registerVariables(ArrayList<String> listID, DataValue value,Token token) {
        for (String id_element : listID) {
            boolean verRegister  = this.registerVariable(id_element, value,token);
        }
    }

    public boolean registerVariable(String id, DataValue value,Token token) {
        if (tablaSimbolos.containsKey(id)) {
            this.repeatedId(id, value,token);
            return false;
        } else {
            tablaSimbolos.put(id, value);
            return true;
        }
    }

    private void repeatedId(String id, DataValue value,Token token){
        listError.add(new ReportErrorInterpreter(ErrorTypeInTheInterpreter.SEMANTIC, token, REPEATED_VARIABLE_ID));
    }

    public Map<String, DataValue> getTablaSimbolos() {
        return tablaSimbolos;
    }

    public ArrayList<ReportErrorInterpreter> getListError() {
        return listError;
    }
    
}