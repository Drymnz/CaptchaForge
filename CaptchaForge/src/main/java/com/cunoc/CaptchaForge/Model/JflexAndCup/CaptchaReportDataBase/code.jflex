package com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaReportDataBase;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.io.StringReader;
import com.cunoc.CaptchaForge.Model.Analyzer.ErrorTypeInTheInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;

%%
/*segunda seccion: configuracion*/

%line
%column
%public
%class LexemaCaptchaReportDataBase
%unicode
%cup
%char
%state DATA_COLLECTION
%eofval{
  return new java_cup.runtime.Symbol(SymCaptchaReportDataBase.EOF);
%eofval}

%{
    /*START-CODE*/

    private ArrayList<ReportErrorInterpreter> listError = new ArrayList();
    private ArrayList<String> listScripting = new ArrayList();
    private String dataCollected = "";

    public LexemaCaptchaReportDataBase(String in) {
        this.zzReader = new StringReader(in);
    }
      
    private void print(String token) {
        //System.out.println(token+ " < " + yytext() + " > <Linea\"" + (yyline + 1) + "\">" + "<Columna\"" + (yycolumn+1) + "\">");
    }

    private void addError(){
        print("error");
        ErrorTypeInTheInterpreter type = ErrorTypeInTheInterpreter.LEXICON;
        Token toke = new Token(yyline + 1, yycolumn + 1, yytext());
        this.listError.add(new ReportErrorInterpreter(type, toke, ""));
    }

    public ArrayList<ReportErrorInterpreter> getListError() {
        return this.listError;
    }

    public String getDataCollected(){
        return this.dataCollected;
    }

    public void setDataCollected(String newdataCollected){
        this.dataCollected = newdataCollected;
    }

    /*FINAL-CODE*/
%}

DIGIT = [0-9]
DATE = "\""{DIGIT}{DIGIT}{DIGIT}{DIGIT}"-"{DIGIT}{DIGIT}"-"{DIGIT}{DIGIT}"\""
WHOLE = {DIGIT}+
DECIMAL = {WHOLE}[.]{WHOLE}
REAL_NUMEBERS = {DECIMAL}|{WHOLE}

STRING = \"([^\"\\]|\\.)*\"

espacio =[\n|\r|\t|\f|\b|\s| ]+

%%

/*tercer seccion: reglase lexicas*/
/*INGNORAR*/
{espacio}               {/* print(); */}
/*JSON*/
"{"                     {print("{"); return new Symbol(SymCaptchaReportDataBase.KEYS_O ,yyline,yycolumn,yytext());}
"}"                     {print("}"); return new Symbol(SymCaptchaReportDataBase.KEYS_C ,yyline,yycolumn,yytext());}
"["                     {print("["); return new Symbol(SymCaptchaReportDataBase.BRACKETS_O ,yyline,yycolumn,yytext());}
"]"                     {print("]"); return new Symbol(SymCaptchaReportDataBase.BRACKETS_C ,yyline,yycolumn,yytext());}
//OBJ JSON
"\"id\""                {print("\"ID\""); return new Symbol(SymCaptchaReportDataBase.ID ,yyline,yycolumn,yytext());}
"\"numberHits\""        {print("\"NUMBER_HITS\""); return new Symbol(SymCaptchaReportDataBase.NUMBER_HITS ,yyline,yycolumn,yytext());}
"\"numberFaill\""       {print("\"NUMBER_FAILL\""); return new Symbol(SymCaptchaReportDataBase.NUMBER_FAILL ,yyline,yycolumn,yytext());}
"\"lastData\""          {print("\"LAST_DATA\""); return new Symbol(SymCaptchaReportDataBase.LAST_DATA ,yyline,yycolumn,yytext());}
/*SIMBOLOS ARIMETICOS*/
":"                     {print(":"); return new Symbol(SymCaptchaReportDataBase.COLNO,yyline,yycolumn, (yytext()));}
","                     {print(","); return new Symbol(SymCaptchaReportDataBase.COMA,yyline,yycolumn, (yytext()));}
/*SIMBOLOS ARIMETICOS*/
"+"                     {print("+"); return new Symbol(SymCaptchaReportDataBase.SUMAR,yyline,yycolumn, (yytext()));}
"-"                     {print("-"); return new Symbol(SymCaptchaReportDataBase.RESTAR,yyline,yycolumn, (yytext()));}
"/"                     {print("/"); return new Symbol(SymCaptchaReportDataBase.DIVIDIR,yyline,yycolumn, (yytext()));}
"*"                     {print("*"); return new Symbol(SymCaptchaReportDataBase.MULTIPLICAR,yyline,yycolumn, (yytext()));}
"="                     {print("="); return new Symbol(SymCaptchaReportDataBase.EQUAL,yyline,yycolumn, (yytext()));}
":"                     {print(":"); return new Symbol(SymCaptchaReportDataBase.COLNO,yyline,yycolumn, (yytext()));}
","                     {print(","); return new Symbol(SymCaptchaReportDataBase.COMA,yyline,yycolumn, (yytext()));}
/*SIMBOLOS DE AGRUPACION*/
"("                     {print("("); return new Symbol(SymCaptchaReportDataBase.PARENTESIS_A,yyline,yycolumn,yytext());}
")"                     {print(")"); return new Symbol(SymCaptchaReportDataBase.PARENTESIS_C,yyline,yycolumn,yytext());}
{DATE}                  {print("DATE"); return new Symbol(SymCaptchaReportDataBase.STRING_DATE,yyline,yycolumn,yytext());}
{REAL_NUMEBERS}         {print("REAL_NUMEBERS"); return new Symbol(SymCaptchaReportDataBase.REAL_NUMEBERS ,yyline,yycolumn,yytext());}
{STRING}                {print("STRING"); return new Symbol(SymCaptchaReportDataBase.STRING ,yyline,yycolumn,yytext());}
/*ERROR LEXICO*/
.                       {
                        //MANEJAR EL ERROR LEXICO
                        print("ERROR");
                        addError();
                        }
