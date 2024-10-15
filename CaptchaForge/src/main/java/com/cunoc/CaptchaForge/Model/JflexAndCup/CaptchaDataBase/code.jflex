package com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaDataBase;

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
%state DATA_COLLECTION
%eofval{
  return new java_cup.runtime.Symbol(SymCaptchaDataBase.EOF);
%eofval}

%{
    /*START-CODE*/

    private ArrayList<ReportErrorInterpreter> listError = new ArrayList();
    private ArrayList<String> listScripting = new ArrayList();
    private String dataCollected = "";

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

    public String getDataCollected(){
        return this.dataCollected;
    }

    public void setDataCollected(String newdataCollected){
        this.dataCollected = newdataCollected;
    }

    /*FINAL-CODE*/
%}

//DATA = "{_-=>" ~"<=-_}"

espacio =[\n|\r|\t|\f|\b|\s| ]+

%%
<YYINITIAL> {
{espacio}    {}
"CapTcha"    {print("C@pTch@"   ); return new Symbol(SymCaptchaDataBase.CapTcha ,yyline,yycolumn,yytext());}
"FinCapTcha" {print("FinC@pTch@"); return new Symbol(SymCaptchaDataBase.FinCapTcha ,yyline,yycolumn,yytext());}
"ID"         {print("ID"); return new Symbol(SymCaptchaDataBase.ID ,yyline,yycolumn,yytext());}
"HTML"       {print("HTML"); return new Symbol(SymCaptchaDataBase.HTML ,yyline,yycolumn,yytext());}
"="          {print("="); return new Symbol(SymCaptchaDataBase.EQUAL ,yyline,yycolumn,yytext());}
"{_-=>"         {
                    yybegin(DATA_COLLECTION);
                    print("{_-=>"); 
                    return new Symbol(SymCaptchaDataBase.START_HARVESTING ,yyline,yycolumn,yytext());
                }
/*ERROR LEXICO*/
[^]                     {
                        //MANEJAR EL ERROR LEXICO
                        print("ERROR");
                        addError();
                        }
}

<DATA_COLLECTION>{
"<=-_}"         {
                    yybegin(YYINITIAL);
                    print("<=-_}"); 
                    return new Symbol(SymCaptchaDataBase.OUT_HARVESTING ,yyline,yycolumn,yytext());
                }
[^]     { dataCollected += yytext();}
.       { dataCollected += yytext();}
}