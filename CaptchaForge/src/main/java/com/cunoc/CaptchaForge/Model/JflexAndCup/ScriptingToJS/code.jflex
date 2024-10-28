package com.cunoc.CaptchaForge.Model.JflexAndCup.ScriptingToJS;

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
%class LexemaScriptingToJS
%unicode
%cup
//%char
///%state STATE_ScriptingToJS
%eofval{
  return new java_cup.runtime.Symbol(SymScriptingToJS.EOF);
%eofval}

%{
    /*START-CODE*/

    private String stringScriptingToJS = "";
    private ArrayList<ReportErrorInterpreter> listError = new ArrayList();

    public LexemaScriptingToJS(String in) {
        this.zzReader = new StringReader(in);
    }
      
    private void print(String token) {
         //   System.out.println("Token: " + token +" | Texto: '" + yytext() + "'" +" | ASCII: " + String.format("%d", (int)yytext().charAt(0)) +" | Línea: " + (yyline + 1) +" | Columna: " + (yycolumn+1));
    }

    private void addError(){
        ErrorTypeInTheInterpreter type = ErrorTypeInTheInterpreter.LEXICON;
        Token toke = new Token(yyline + 1, yycolumn + 1, yytext());
        this.listError.add(new ReportErrorInterpreter(type, toke, ""));
    }

    public ArrayList<ReportErrorInterpreter> getListError() {
        return this.listError;
    }

    /*FINAL-CODE*/
%}

COMMENT_LINE = "!""!" ~[\n]
COMMENT_MULTI_LINE = "<!--" ~"-->"

DIGIT = [0-9]
WHOLE = {DIGIT}+
DECIMAL = {WHOLE}[.]{WHOLE}

ID = (["_"|"$"]?[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ]+["_"|"$"]?)+


///FIRST, SECOND, THIRD, FOURTH
STRING_FIRS = \"([^\"\\]|\\.)*\"
STRING_SECOND = '([^']|\\.)*'
STRING_THIRD = ’([^’]|\\.)*’ 

espacio =[\n|\r|\t|\f|\b|\s| ]+

%%
<YYINITIAL> {
/*tercer seccion: reglase lexicas*/
{espacio}               {  }
{COMMENT_LINE}          {/* print(); */}
{COMMENT_MULTI_LINE}    {/* print(); */}
/*Tipos de Datos*/
"integer"       {print("integer" ); return new Symbol(SymScriptingToJS.INTEGER ,yyline,yycolumn,yytext());}
"decimal"       {print("decimal" ); return new Symbol(SymScriptingToJS.DECIMAL ,yyline,yycolumn,yytext());}
"boolean"       {print("boolean" ); return new Symbol(SymScriptingToJS.BOOLEAN ,yyline,yycolumn,yytext());}
"char"          {print("char"    ); return new Symbol(SymScriptingToJS.CHAR ,yyline,yycolumn,yytext());}
"string"        {print("string"  ); return new Symbol(SymScriptingToJS.STRING ,yyline,yycolumn,yytext());}
//valores
"true"        {print("true" ); return new Symbol(SymScriptingToJS.TRUE ,yyline,yycolumn,yytext());}
"false"       {print("false"); return new Symbol(SymScriptingToJS.FALSE ,yyline,yycolumn,yytext());}
/*Operadores*/
//operadores logicos
"=="        {print("=="  ); return new Symbol(SymScriptingToJS.SAME_AS ,yyline,yycolumn,yytext());}
"!="        {print("!="  ); return new Symbol(SymScriptingToJS.NOT_THE_SAME ,yyline,yycolumn,yytext());}
"<"         {print("<"   ); return new Symbol(SymScriptingToJS.LESS_THAN ,yyline,yycolumn,yytext());}
"<="        {print("<="  ); return new Symbol(SymScriptingToJS.LESS_THAN_EQUAL ,yyline,yycolumn,yytext());}
">"         {print(">"   ); return new Symbol(SymScriptingToJS.GREATER_THAN ,yyline,yycolumn,yytext());}
">="        {print(">="  ); return new Symbol(SymScriptingToJS.GREATER_THAN_EQUAL ,yyline,yycolumn,yytext());}
"||"        {print("||"  ); return new Symbol(SymScriptingToJS.OR ,yyline,yycolumn,yytext());}
"&&"        {print("&&"  ); return new Symbol(SymScriptingToJS.AND ,yyline,yycolumn,yytext());}
"!"         {print("!"   ); return new Symbol(SymScriptingToJS.NOT ,yyline,yycolumn,yytext());}
//operadores aritmeticos
"+" {print("+"); return new Symbol(SymScriptingToJS.ADDITION ,yyline,yycolumn,yytext());}
"-" {print("-"); return new Symbol(SymScriptingToJS.SUBTRACTION ,yyline,yycolumn,yytext());}
"/" {print("/"); return new Symbol(SymScriptingToJS.DIVISION ,yyline,yycolumn,yytext());}
"*" {print("*"); return new Symbol(SymScriptingToJS.MULTIPLICATION ,yyline,yycolumn,yytext());}
//agrupacion
")" {print(")"); return new Symbol(SymScriptingToJS.PARENTHESIS_CLOSE ,yyline,yycolumn,yytext());}
"(" {print("("); return new Symbol(SymScriptingToJS.PARENTHESIS_OPEN ,yyline,yycolumn,yytext());}
"[" {print("["); return new Symbol(SymScriptingToJS.BRACKETS_OPEN ,yyline,yycolumn,yytext());}
"]" {print("]"); return new Symbol(SymScriptingToJS.BRACKETS_CLOSE ,yyline,yycolumn,yytext());}
//signos
";" {print(";"); return new Symbol(SymScriptingToJS.SEMICOLON ,yyline,yycolumn,yytext());}
"," {print(","); return new Symbol(SymScriptingToJS.COMA ,yyline,yycolumn,yytext());}
"=" {print("="); return new Symbol(SymScriptingToJS.EQUAL ,yyline,yycolumn,yytext());}

/*FUNCIONES*/
"ON_LOAD"               {print("ON_LOAD"           ); return new Symbol(SymScriptingToJS.ON_LOAD ,yyline,yycolumn,yytext());}
"ASC"                   {print("ASC"               ); return new Symbol(SymScriptingToJS.ASC ,yyline,yycolumn,yytext());}
"DESC"                  {print("DESC"              ); return new Symbol(SymScriptingToJS.DESC ,yyline,yycolumn,yytext());}
"LETPAR_NUM"            {print("LETPAR_NUM"        ); return new Symbol(SymScriptingToJS.LETPAR_NUM ,yyline,yycolumn,yytext());}
"LETIMPAR_NUM"          {print("LETIMPAR_NUM"      ); return new Symbol(SymScriptingToJS.LETIMPAR_NUM ,yyline,yycolumn,yytext());}
"REVERSE"               {print("REVERSE"           ); return new Symbol(SymScriptingToJS.REVERSE ,yyline,yycolumn,yytext());}
"CARACTER_ALEATORIO"    {print("CARACTER_ALEATORIO"); return new Symbol(SymScriptingToJS.CARACTER_ALEATORIO ,yyline,yycolumn,yytext());}
"NUM_ALEATORIO"         {print("NUM_ALEATORIO"     ); return new Symbol(SymScriptingToJS.NUM_ALEATORIO ,yyline,yycolumn,yytext());}
"ALERT_INFO"            {print("ALERT_INFO"        ); return new Symbol(SymScriptingToJS.ALERT_INFO ,yyline,yycolumn,yytext());}
"EXIT"                  {print("EXIT"              ); return new Symbol(SymScriptingToJS.EXIT ,yyline,yycolumn,yytext());}
"REDIRECT"              {print("REDIRECT"          ); return new Symbol(SymScriptingToJS.REDIRECT ,yyline,yycolumn,yytext());}

"INSERT"                {print("INSERT"            ); return new Symbol(SymScriptingToJS.INSERT ,yyline,yycolumn,yytext());}
/*PARAMETROS*/
"@global"  {print("@global"); return new Symbol(SymScriptingToJS.MODO ,yyline,yycolumn,yytext());}
//instrucciones
"INIT"            {print("INIT"); return new Symbol(SymScriptingToJS.INIT ,yyline,yycolumn,yytext());}
"{:"              {print("{:"  ); return new Symbol(SymScriptingToJS.START_INIT ,yyline,yycolumn,yytext());}
":}"              {print(":}"  ); return new Symbol(SymScriptingToJS.AND_INIT ,yyline,yycolumn,yytext());}
//if
"IF"            {print("IF"  ); return new Symbol(SymScriptingToJS.IF ,yyline,yycolumn,yytext());}
"THEN"          {print("THEN"); return new Symbol(SymScriptingToJS.THEN ,yyline,yycolumn,yytext());}
"END"           {print("END" ); return new Symbol(SymScriptingToJS.END ,yyline,yycolumn,yytext());}
"ELSE"          {print("ELSE"); return new Symbol(SymScriptingToJS.ELSE ,yyline,yycolumn,yytext());}
//bucle
//for
"REPEAT"              {print("REPEAT"); return new Symbol(SymScriptingToJS.REPEAT ,yyline,yycolumn,yytext());}
"HUNTIL"              {print("HUNTIL"); return new Symbol(SymScriptingToJS.HUNTIL ,yyline,yycolumn,yytext());}
//
"WHILE"              {print("WHILE"); return new Symbol(SymScriptingToJS.WHILE ,yyline,yycolumn,yytext());}
"THENWHILE"          {print("THENWHILE"); return new Symbol(SymScriptingToJS.THENWHILE ,yyline,yycolumn,yytext());}
/*TOKEN*/
{WHOLE}             {print("NUM_INTEGER"); return new Symbol(SymScriptingToJS.NUM_INTEGER ,yyline,yycolumn,yytext());}
{DECIMAL}           {print("NUM_DECIMAL"); return new Symbol(SymScriptingToJS.NUM_DECIMAL ,yyline,yycolumn,yytext());}
{STRING_SECOND}     {print("CHAR_TEXT"); return new Symbol(SymScriptingToJS.CHAR_TEXT ,yyline,yycolumn,yytext());}
{STRING_FIRS}       {print("STRING_FIRS"); return new Symbol(SymScriptingToJS.TEXT ,yyline,yycolumn,yytext());}
{STRING_THIRD}      {print("STRING_THIRD"); return new Symbol(SymScriptingToJS.TEXT ,yyline,yycolumn,yytext());}
{ID}                {print("ID"); return new Symbol(SymScriptingToJS.ID ,yyline,yycolumn,yytext());}
/*ERROR LEXICO*/
[^]                     {
                        //MANEJAR EL ERROR LEXICO
                        print("ERROR");
                        addError();
                        }
}
