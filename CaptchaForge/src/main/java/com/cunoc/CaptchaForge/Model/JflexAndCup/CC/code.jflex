package com.cunoc.CaptchaForge.Model.JflexAndCup.CC;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
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
%eofval{
  return new java_cup.runtime.Symbol(SymCC.EOF);
%eofval}

%{
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
{espacio}               {/* print(); */}
">"                     {print(">" ); return new Symbol(SymCC.CLOSE ,yyline,yycolumn,yytext());}
"<"                     {print("<" ); return new Symbol(SymCC.OPEN ,yyline,yycolumn,yytext());}
"version"               {print("version"); return new Symbol(SymCC.VERSION ,yyline,yycolumn,yytext());}
/*JSON*/
"{"                     {print("{"); return new Symbol(SymCC.KEYS_O ,yyline,yycolumn,yytext());}
"}"                     {print("}"); return new Symbol(SymCC.KEYS_C ,yyline,yycolumn,yytext());}
"["                     {print("["); return new Symbol(SymCC.BRACKETS_O ,yyline,yycolumn,yytext());}
"]"                     {print("]"); return new Symbol(SymCC.BRACKETS_C ,yyline,yycolumn,yytext());}
/*SIMBOLOS ARIMETICOS*/
"="                     {print("="); return new Symbol(SymCC.EQUAL,yyline,yycolumn, (yytext()));}
":"                     {print(":"); return new Symbol(SymCC.COLNO,yyline,yycolumn, (yytext()));}
","                     {print(","); return new Symbol(SymCC.COMA,yyline,yycolumn, (yytext()));}
/*SIMBOLOS DE AGRUPACION*/
{STRING}                {print("STRING"); return new Symbol(SymCC.STRING ,yyline,yycolumn,yytext());}
/*ERROR LEXICO*/
//Solucion de lo de case sentisi
{CASE_SENTI}               {
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
.                       {
                        //MANEJAR EL ERROR LEXICO
                        print("ERROR");
                        addError();
                        }
