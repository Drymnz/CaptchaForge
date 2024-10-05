package com.cunoc.CaptchaForge.Model.JflexAndCup.CC;

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
%class LexemaCC
%unicode
%cup
%char
%eofval{
  return new java_cup.runtime.Symbol(SymCC.EOF);
%eofval}

%{

     public LexemaCC(String in) {
    this.zzReader = new StringReader(in);
    }
    /*START-CODE*/
    private ArrayList<ReportErrorInterpreter> listError = new ArrayList();
  
    private void print(String token) {
        //System.out.println(" < " + yytext() + " > <Linea\"" + (yyline + 1) + "\">" + "<Columna\"" + (yycolumn+1) + "\">");
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

    /*FINAL-CODE*/
%}

STRING = \"([^\"\\]|\\.)*\"

CASE_SENTI = ([a-zA-Z]+|_)+

espacio =[\n|\r|\t|\f|\b|\s| ]+

%%

/*tercer seccion: reglase lexicas*/
/*INGNORAR*/
{espacio}       {/* print(); */}
">"             {print(">" ); return new Symbol(SymCC.CLOSE ,yyline,yycolumn,yytext());}
"<"             {print("<" ); return new Symbol(SymCC.OPEN ,yyline,yycolumn,yytext());}
"version"       {print("version"); return new Symbol(SymCC.VERSION ,yyline,yycolumn,yytext());}
/*JSON*/
"{"         {print("{"); return new Symbol(SymCC.KEYS_O ,yyline,yycolumn,yytext());}
"}"         {print("}"); return new Symbol(SymCC.KEYS_C ,yyline,yycolumn,yytext());}
"["         {print("["); return new Symbol(SymCC.BRACKETS_O ,yyline,yycolumn,yytext());}
"]"         {print("]"); return new Symbol(SymCC.BRACKETS_C ,yyline,yycolumn,yytext());}
/*SIMBOLOS ARIMETICOS*/
"="     {print("="); return new Symbol(SymCC.EQUAL,yyline,yycolumn, (yytext()));}
":"     {print(":"); return new Symbol(SymCC.COLNO,yyline,yycolumn, (yytext()));}
","     {print(","); return new Symbol(SymCC.COMA,yyline,yycolumn, (yytext()));}
"/"     {print("/"); return new Symbol(SymCC.BAR,yyline,yycolumn, (yytext()));}
/*SIMBOLOS CC*/
"C_CC"              {print("/"); return new Symbol(SymCC.C_CC,yyline,yycolumn, (yytext()));}
"C_HEAD"            {print("C_HEAD"); return new Symbol(SymCC.C_HEAD,yyline,yycolumn, (yytext()));}
"C_TITLE"           {print("C_TITLE"); return new Symbol(SymCC.C_TITLE,yyline,yycolumn, (yytext()));}
"C_LINK"            {print("C_LINK"); return new Symbol(SymCC.C_LINK,yyline,yycolumn, (yytext()));}
"C_BODY"            {print("C_BODY"); return new Symbol(SymCC.C_BODY,yyline,yycolumn, (yytext()));}
"C_SPAM"            {print("C_SPAM"); return new Symbol(SymCC.C_SPAM,yyline,yycolumn, (yytext()));}
"C_INPUT"           {print("C_INPUT"); return new Symbol(SymCC.C_INPUT,yyline,yycolumn, (yytext()));}
"C_TEXTAREA"        {print("C_TEXTAREA"); return new Symbol(SymCC.C_TEXTAREA,yyline,yycolumn, (yytext()));}
"C_SELECT"          {print("C_SELECT"); return new Symbol(SymCC.C_SELECT,yyline,yycolumn, (yytext()));}
"C_OPTION"          {print("C_OPTION"); return new Symbol(SymCC.C_OPTION,yyline,yycolumn, (yytext()));}
"C_DIV"             {print("C_DIV"); return new Symbol(SymCC.C_DIV,yyline,yycolumn, (yytext()));}
"C_IMG"             {print("C_IMG"); return new Symbol(SymCC.C_IMG,yyline,yycolumn, (yytext()));}
"C_BR"              {print("C_BR"); return new Symbol(SymCC.C_BR,yyline,yycolumn, (yytext()));}
"C_BUTTON"          {print("C_BUTTON"); return new Symbol(SymCC.C_BUTTON,yyline,yycolumn, (yytext()));}
"C_H1"              {print("C_H1"); return new Symbol(SymCC.C_H1,yyline,yycolumn, (yytext()));}
"C_H2"              {print("C_H2"); return new Symbol(SymCC.C_H2,yyline,yycolumn, (yytext()));}
"C_H3"              {print("C_H3"); return new Symbol(SymCC.C_H3,yyline,yycolumn, (yytext()));}
"C_H4"              {print("C_H4"); return new Symbol(SymCC.C_H4,yyline,yycolumn, (yytext()));}
"C_H5"              {print("C_H5"); return new Symbol(SymCC.C_H5,yyline,yycolumn, (yytext()));}
"C_H6"              {print("C_H6"); return new Symbol(SymCC.C_H6,yyline,yycolumn, (yytext()));}
"C_P"               {print("C_P"); return new Symbol(SymCC.C_P,yyline,yycolumn, (yytext()));}
/*COMPLEJOS*/
{STRING}        {print("STRING"); return new Symbol(SymCC.STRING ,yyline,yycolumn,yytext());}
/*ERROR LEXICO*/
//Solucion de lo de case sentisi
{CASE_SENTI}    {
                             String lowercaseText = yytext().toLowerCase();
                                     switch(lowercaseText) {
                                         case "version":
                                            print("version"); 
                                            return new Symbol(SymCC.VERSION ,yyline,yycolumn,yytext());
                                        default:
                                            print("ERROR");
                                            addError();
                                            break;
                                     }
                        }
.               {
                        //MANEJAR EL ERROR LEXICO
                        print("ERROR");
                        addError();
                        }
