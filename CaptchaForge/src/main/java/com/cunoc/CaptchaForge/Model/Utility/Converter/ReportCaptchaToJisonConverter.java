package com.cunoc.CaptchaForge.Model.Utility.Converter;

import java.util.List;

import com.cunoc.CaptchaForge.Model.WebIdentities.ReportCaptcha;

public class ReportCaptchaToJisonConverter {
    
    public String convertToJsonString(List<ReportCaptcha> reportList) {
        if (reportList == null || reportList.isEmpty()) {
            return "[]";
        }
        
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");
        
        for (int i = 0; i < reportList.size(); i++) {
            ReportCaptcha report = reportList.get(i);
            jsonBuilder.append("  {\n");
            jsonBuilder.append("    \"id\": \"").append(escapeJsonString(report.getId())).append("\",\n");
            jsonBuilder.append("    \"numberHits\": ").append(report.getNumberHits()).append(",\n");
            jsonBuilder.append("    \"numberFaill\": ").append(report.getNumberFaill()).append(",\n");
            jsonBuilder.append("    \"lastData\": \"").append(escapeJsonString(report.getLastData())).append("\"\n");
            jsonBuilder.append("  }");
            
            // Añadir coma si no es el último elemento
            if (i < reportList.size() - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }
        
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
    
    private String escapeJsonString(String input) {
        if (input == null) {
            return "";
        }
        
        StringBuilder escaped = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '"':
                    escaped.append("\\\"");
                    break;
                case '\\':
                    escaped.append("\\\\");
                    break;
                case '\b':
                    escaped.append("\\b");
                    break;
                case '\f':
                    escaped.append("\\f");
                    break;
                case '\n':
                    escaped.append("\\n");
                    break;
                case '\r':
                    escaped.append("\\r");
                    break;
                case '\t':
                    escaped.append("\\t");
                    break;
                default:
                    if (c < ' ') {
                        escaped.append(String.format("\\u%04x", (int) c));
                    } else {
                        escaped.append(c);
                    }
            }
        }
        return escaped.toString();
    }
}