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
%class LexemaCaptchaDataBase
%unicode
%cup
%char
%state STATE_SCRIPTING
%eofval{
  return new java_cup.runtime.Symbol(SymCaptchaDataBase.EOF);
%eofval}

%{
    /*START-CODE*/

    private ArrayList<ReportErrorInterpreter> listError = new ArrayList();
    private ArrayList<String> listScripting = new ArrayList();

    public LexemaCaptchaDataBase(String in) {
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

    /*FINAL-CODE*/
%}

DATA = "{_-=>" ~"<=-_}"

OPEN_BAR = "<"{espacio}?"/"

%%
<YYINITIAL> {
"C@pTch@"       {print("C@pTch@"   ); return new Symbol(SymCC.OPEN ,yyline,yycolumn,yytext());}
"FinC@pTch@"    {print("FinC@pTch@"); return new Symbol(SymCC.CLOSE ,yyline,yycolumn,yytext());}
{DATA}  {
                        print("DATA"); 
                        return new Symbol(SymCaptchaDataBase.DATA,yyline,yycolumn, (yytext()));
                    }
/*ERROR LEXICO*/
[^]                     {
                        //MANEJAR EL ERROR LEXICO
                        print("ERROR");
                        addError();
                        }
}
