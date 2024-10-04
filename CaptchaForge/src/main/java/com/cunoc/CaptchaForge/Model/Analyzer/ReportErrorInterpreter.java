package com.cunoc.CaptchaForge.Model.Analyzer;

public class ReportErrorInterpreter {
    private ErrorTypeInTheInterpreter type;
    private Token toke;
    private String description;

    public ReportErrorInterpreter(ErrorTypeInTheInterpreter type, Token toke, String description) {
        this.type = type;
        this.toke = toke;
        this.description = description;
    }

    public ErrorTypeInTheInterpreter getType() {
        return type;
    }

    public Token getToke() {
        return toke;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "- Tipo de error:" + type.toString() + "\n - Token afectado: " + toke.toString() + "\n - Descripción: "
                + description.toString();
    }
}
