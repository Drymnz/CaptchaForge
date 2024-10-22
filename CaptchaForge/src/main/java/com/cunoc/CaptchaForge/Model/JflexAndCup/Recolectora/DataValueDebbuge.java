package com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora;

public class DataValueDebbuge extends DataValue{
    private boolean modo;
    private String procedure;
    private String id;
    private int line;

    public DataValueDebbuge(String value, ListTypeData type, boolean modo, String procedure, String id, int line) {
        super(value, type);
        this.modo = modo;
        this.procedure = procedure;
        this.id = id;
        this.line = line;
    }

    public boolean isModo() {
        return modo;
    }

    public void setModo(boolean modo) {
        this.modo = modo;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    
    
}
