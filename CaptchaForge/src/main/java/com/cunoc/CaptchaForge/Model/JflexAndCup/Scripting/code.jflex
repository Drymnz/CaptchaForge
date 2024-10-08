package com.cunoc.CaptchaForge.Model.JflexAndCup.Scripting;

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
%class LexemaScripting
%unicode
%cup
%char
///%state STATE_SCRIPTING
%eofval{
  return new java_cup.runtime.Symbol(SymScripting.EOF);
%eofval}

%{
    /*START-CODE*/

    private String stringScripting = "";
    private ArrayList<ReportErrorInterpreter> listError = new ArrayList();

    public LexemaScripting(String in) {
        this.zzReader = new StringReader(in);
    }
      
    private void print(String token) {
    System.out.println(token+ " < " + yytext() + " > <Linea\"" + (yyline + 1) + "\">" + "<Columna\"" + (yycolumn+1) + "\">");
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

COMMENT_LINE = "!""!" ~[\n]
COMMENT_MULTI_LINE = "<!--" ~"-->"

DIGIT = [0-9]
WHOLE = "-"?{DIGIT}+
DECIMAL = {WHOLE}[.]{WHOLE}
REAL_NUMEBERS = {DECIMAL}|{WHOLE}

ID = ([a-zA-Z0-9@#\$%\^áéíóúÁÉÍÓÚñÑ]+[&*_\+\!\~\`\-:']?)+


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
"integer"       {print("integer" ); return new Symbol(SymScripting.INTEGER ,yyline,yycolumn,yytext());}
"decimal"       {print("decimal" ); return new Symbol(SymScripting.DECIMAL ,yyline,yycolumn,yytext());}
"boolean"       {print("boolean" ); return new Symbol(SymScripting.BOOLEAN ,yyline,yycolumn,yytext());}
"char"          {print("char"    ); return new Symbol(SymScripting.CHAR ,yyline,yycolumn,yytext());}
"string"        {print("string"  ); return new Symbol(SymScripting.STRING ,yyline,yycolumn,yytext());}
//valores
"true"        {print("true" ); return new Symbol(SymScripting.TRUE ,yyline,yycolumn,yytext());}
"false"       {print("false"); return new Symbol(SymScripting.FALSE ,yyline,yycolumn,yytext());}
/*Operadores*/
//operadores logicos
"=="        {print("=="  ); return new Symbol(SymScripting.SAME_AS ,yyline,yycolumn,yytext());}
"!="        {print("!="  ); return new Symbol(SymScripting.NOT_THE_SAME ,yyline,yycolumn,yytext());}
"<"         {print("<"   ); return new Symbol(SymScripting.LESS_THAN ,yyline,yycolumn,yytext());}
"<="        {print("<="  ); return new Symbol(SymScripting.LESS_THAN_EQUAL ,yyline,yycolumn,yytext());}
">"         {print(">"   ); return new Symbol(SymScripting.GREATER_THAN ,yyline,yycolumn,yytext());}
">="        {print(">="  ); return new Symbol(SymScripting.GREATER_THAN_EQUAL ,yyline,yycolumn,yytext());}
"||"        {print("||"  ); return new Symbol(SymScripting.OR ,yyline,yycolumn,yytext());}
"&&"        {print("&&"  ); return new Symbol(SymScripting.AND ,yyline,yycolumn,yytext());}
"!"         {print("!"   ); return new Symbol(SymScripting.NOT ,yyline,yycolumn,yytext());}
//operadores aritmeticos
"+" {print("+"); return new Symbol(SymScripting.ADDITION ,yyline,yycolumn,yytext());}
"-" {print("-"); return new Symbol(SymScripting.SUBTRACTION ,yyline,yycolumn,yytext());}
"/" {print("/"); return new Symbol(SymScripting.DIVISION ,yyline,yycolumn,yytext());}
"*" {print("*"); return new Symbol(SymScripting.MULTIPLICATION ,yyline,yycolumn,yytext());}
//agrupacion
")" {print(")"); return new Symbol(SymScripting.PARENTHESIS_CLOSE ,yyline,yycolumn,yytext());}
"(" {print("("); return new Symbol(SymScripting.PARENTHESIS_OPEN ,yyline,yycolumn,yytext());}
"[" {print("["); return new Symbol(SymScripting.BRACKETS_OPEN ,yyline,yycolumn,yytext());}
"]" {print("]"); return new Symbol(SymScripting.BRACKETS_CLOSE ,yyline,yycolumn,yytext());}
//signos
";" {print(";"); return new Symbol(SymScripting.SEMICOLON ,yyline,yycolumn,yytext());}
"," {print(","); return new Symbol(SymScripting.COMA ,yyline,yycolumn,yytext());}
"=" {print("="); return new Symbol(SymScripting.EQUAL ,yyline,yycolumn,yytext());}

/*FUNCIONES*/
"ASC"                   {print("ASC"               ); return new Symbol(SymScripting.ASC ,yyline,yycolumn,yytext());}
"DESC"                  {print("DESC"              ); return new Symbol(SymScripting.DESC ,yyline,yycolumn,yytext());}
"LETPAR_NUM"            {print("LETPAR_NUM"        ); return new Symbol(SymScripting.LETPAR_NUM ,yyline,yycolumn,yytext());}
"LETIMPAR_NUM"          {print("LETIMPAR_NUM"      ); return new Symbol(SymScripting.LETIMPAR_NUM ,yyline,yycolumn,yytext());}
"REVERSE"               {print("REVERSE"           ); return new Symbol(SymScripting.REVERSE ,yyline,yycolumn,yytext());}
"CARACTER_ALEATORIO"    {print("CARACTER_ALEATORIO"); return new Symbol(SymScripting.CARACTER_ALEATORIO ,yyline,yycolumn,yytext());}
"NUM_ALEATORIO"         {print("NUM_ALEATORIO"     ); return new Symbol(SymScripting.NUM_ALEATORIO ,yyline,yycolumn,yytext());}
"ALERT_INFO"            {print("ALERT_INFO"        ); return new Symbol(SymScripting.ALERT_INFO ,yyline,yycolumn,yytext());}
"EXIT"                  {print("EXIT"              ); return new Symbol(SymScripting.EXIT ,yyline,yycolumn,yytext());}
"REDIRECT"              {print("REDIRECT"          ); return new Symbol(SymScripting.REDIRECT ,yyline,yycolumn,yytext());}

"INSERT"                {print("INSERT"            ); return new Symbol(SymScripting.INSERT ,yyline,yycolumn,yytext());}
/*PARAMETROS*/
"@global"  {print("@global"); return new Symbol(SymScripting.MODO ,yyline,yycolumn,yytext());}
//instrucciones
"INIT"            {print("INIT"); return new Symbol(SymScripting.INIT ,yyline,yycolumn,yytext());}
"{:"              {print("{:"  ); return new Symbol(SymScripting.START_INIT ,yyline,yycolumn,yytext());}
":}"              {print(":}"  ); return new Symbol(SymScripting.AND_INIT ,yyline,yycolumn,yytext());}
//if
"IF"            {print("IF"  ); return new Symbol(SymScripting.IF ,yyline,yycolumn,yytext());}
"THEN"          {print("THEN"); return new Symbol(SymScripting.THEN ,yyline,yycolumn,yytext());}
"END"           {print("END" ); return new Symbol(SymScripting.END ,yyline,yycolumn,yytext());}
"ELSE"          {print("ELSE"); return new Symbol(SymScripting.ELSE ,yyline,yycolumn,yytext());}
//bucle
//for
"REPEAT"              {print("REPEAT"); return new Symbol(SymScripting.REPEAT ,yyline,yycolumn,yytext());}
"HUNTIL"              {print("HUNTIL"); return new Symbol(SymScripting.HUNTIL ,yyline,yycolumn,yytext());}
//
"WHILE"              {print("WHILE"); return new Symbol(SymScripting.WHILE ,yyline,yycolumn,yytext());}
"THENWHILE"          {print("THENWHILE"); return new Symbol(SymScripting.THENWHILE ,yyline,yycolumn,yytext());}
/*TOKEN*/
{REAL_NUMEBERS}     {print("REAL_NUMEBERS"); return new Symbol(SymScripting.REAL_NUMEBERS ,yyline,yycolumn,yytext());}
{STRING_FIRS}       {print("STRING_FIRS"); return new Symbol(SymScripting.TEXT ,yyline,yycolumn,yytext());}
{STRING_SECOND}     {print("STRING_SECOND"); return new Symbol(SymScripting.TEXT ,yyline,yycolumn,yytext());}
{STRING_THIRD}      {print("STRING_THIRD"); return new Symbol(SymScripting.TEXT ,yyline,yycolumn,yytext());}
{ID}                {print("ID"); return new Symbol(SymScripting.ID ,yyline,yycolumn,yytext());}
/*ERROR LEXICO*/
[^]                     {
                        //MANEJAR EL ERROR LEXICO
                        print("ERROR");
                        addError();
                        }
}
