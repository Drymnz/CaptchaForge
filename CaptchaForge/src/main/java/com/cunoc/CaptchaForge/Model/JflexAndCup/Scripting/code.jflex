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
%state STATE_SCRIPTING
%eofval{
  return new java_cup.runtime.Symbol(SymScripting.EOF);
%eofval}

%{
    /*START-CODE*/

    private String space = "";
    private String stringScripting = "";
    private ArrayList<ReportErrorInterpreter> listError = new ArrayList();
    private ArrayList<String> listScripting = new ArrayList();
    ///
    private boolean returnLessThan = true;
    private boolean returnGreaterThan = true;
    private boolean resturnarBar = true;

    public LexemaScripting(String in) {
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

    public String getSpace(){
        return this.space;
    }

    /*FINAL-CODE*/
%}

STRING = \"([^\"\\]|\\.)*\"

COMMENT_LINE = "!""!" ~"\n"
COMMENT_MULTI_LINE = "<!--" ~"-->"


espacio =[\n|\r|\t|\f|\b|\s| ]+

OPEN_BAR = "<"{espacio}?"/"

%%
<YYINITIAL> {
/*tercer seccion: reglase lexicas*/
/*HTML*/
">"             {print(">" ); return new Symbol(SymScripting.CLOSE ,yyline,yycolumn,yytext());}
"<"             {print("<" ); return new Symbol(SymScripting.OPEN ,yyline,yycolumn,yytext());}
"version"       {print("version"); return new Symbol(SymScripting.VERSION ,yyline,yycolumn,yytext());}
/*SIMBOLOS EXTRAS*/
"="     {print("="); return new Symbol(SymScripting.EQUAL,yyline,yycolumn, (yytext()));}
"/"     {print("/"); return new Symbol(SymScripting.BAR,yyline,yycolumn, (yytext()));}
/*PALABRAS CLAVES DE CC*/
"C_CC"              {print("/"); return new Symbol(SymScripting.C_CC,yyline,yycolumn, (yytext()));}
"C_HEAD"            {print("C_HEAD"); return new Symbol(SymScripting.C_HEAD,yyline,yycolumn, (yytext()));}
"C_TITLE"           {print("C_TITLE"); return new Symbol(SymScripting.C_TITLE,yyline,yycolumn, (yytext()));}
"C_LINK"            {print("C_LINK"); return new Symbol(SymScripting.C_LINK,yyline,yycolumn, (yytext()));}
"C_BODY"            {print("C_BODY"); return new Symbol(SymScripting.C_BODY,yyline,yycolumn, (yytext()));}
"C_SPAM"            {print("C_SPAM"); return new Symbol(SymScripting.C_SPAM,yyline,yycolumn, (yytext()));}
"C_INPUT"           {print("C_INPUT"); return new Symbol(SymScripting.C_INPUT,yyline,yycolumn, (yytext()));}
"C_TEXTAREA"        {print("C_TEXTAREA"); return new Symbol(SymScripting.C_TEXTAREA,yyline,yycolumn, (yytext()));}
"C_SELECT"          {print("C_SELECT"); return new Symbol(SymScripting.C_SELECT,yyline,yycolumn, (yytext()));}
"C_OPTION"          {print("C_OPTION"); return new Symbol(SymScripting.C_OPTION,yyline,yycolumn, (yytext()));}
"C_DIV"             {print("C_DIV"); return new Symbol(SymScripting.C_DIV,yyline,yycolumn, (yytext()));}
"C_IMG"             {print("C_IMG"); return new Symbol(SymScripting.C_IMG,yyline,yycolumn, (yytext()));}
"C_BR"              {print("C_BR"); return new Symbol(SymScripting.C_BR,yyline,yycolumn, (yytext()));}
"C_BUTTON"          {print("C_BUTTON"); return new Symbol(SymScripting.C_BUTTON,yyline,yycolumn, (yytext()));}
"C_H1"              {print("C_H1"); return new Symbol(SymScripting.C_H1,yyline,yycolumn, (yytext()));}
"C_H2"              {print("C_H2"); return new Symbol(SymScripting.C_H2,yyline,yycolumn, (yytext()));}
"C_H3"              {print("C_H3"); return new Symbol(SymScripting.C_H3,yyline,yycolumn, (yytext()));}
"C_H4"              {print("C_H4"); return new Symbol(SymScripting.C_H4,yyline,yycolumn, (yytext()));}
"C_H5"              {print("C_H5"); return new Symbol(SymScripting.C_H5,yyline,yycolumn, (yytext()));}
"C_H6"              {print("C_H6"); return new Symbol(SymScripting.C_H6,yyline,yycolumn, (yytext()));}
"C_P"               {print("C_P"); return new Symbol(SymScripting.C_P,yyline,yycolumn, (yytext()));}
"C_FORM"            {print("C_FORM"); return new Symbol(SymScripting.C_FORM,yyline,yycolumn, (yytext()));}
"C_SCRIPTING"       {
                        print("C_SCRIPTING"); 
                        yybegin(STATE_SCRIPTING);
                        return new Symbol(SymScripting.C_SCRIPTING,yyline,yycolumn, (yytext()));
                    }
/*PALABRAS CLAVES DE PROMS*/
"href"          {print("href"); return new       Symbol(SymScripting.HREF,yyline,yycolumn, (yytext()));}
"background"    {print("background"); return new Symbol(SymScripting.BACKGROUND,yyline,yycolumn, (yytext()));}
"color"         {print("color"); return new      Symbol(SymScripting.COLOR,yyline,yycolumn, (yytext()));}
"font-size"     {print("font"); return new       Symbol(SymScripting.FONT_SIZE,yyline,yycolumn, (yytext()));}
"font-family"   {print("font"); return new       Symbol(SymScripting.FONT_FAMILY,yyline,yycolumn, (yytext()));}
"text-align"    {print("text"); return new       Symbol(SymScripting.FONT_ALIG,yyline,yycolumn, (yytext()));}
"type"          {print("type"); return new       Symbol(SymScripting.TYPE,yyline,yycolumn, (yytext()));}
"id"            {print("id"); return new         Symbol(SymScripting.ID,yyline,yycolumn, (yytext()));}
"name"          {print("name"); return new       Symbol(SymScripting.NAME,yyline,yycolumn, (yytext()));}
"cols"          {print("cols"); return new       Symbol(SymScripting.COLS,yyline,yycolumn, (yytext()));}
"rows"          {print("rows"); return new       Symbol(SymScripting.ROWS,yyline,yycolumn, (yytext()));}
"class"         {print("class"); return new      Symbol(SymScripting.CLASS,yyline,yycolumn, (yytext()));}
"src"           {print("src"); return new        Symbol(SymScripting.SRC,yyline,yycolumn, (yytext()));}
"width"         {print("width"); return new      Symbol(SymScripting.WIDTH,yyline,yycolumn, (yytext()));}
"height"        {print("height"); return new     Symbol(SymScripting.HEIGHT,yyline,yycolumn, (yytext()));}
"alt"           {print("alt"); return new        Symbol(SymScripting.ALT,yyline,yycolumn, (yytext()));}
"onclick"       {print("onclick"); return new    Symbol(SymScripting.ONCLICK,yyline,yycolumn, (yytext()));}
/*COMPLEJOS*/
{STRING}        {print("STRING"); return new Symbol(SymScripting.STRING ,yyline,yycolumn,yytext());}
[a-zA-Z0-9@#\$%\^&*_\+\!\~\`\-:;',áéíóúÁÉÍÓÚñÑ]+      {print("CONTENIDO"); return new Symbol(SymScripting.CONTENIDO ,yyline,yycolumn,yytext());}
/*INGNORAR*/
{espacio}               { space = yytext(); }
{COMMENT_LINE}          {/* print(); */}
{COMMENT_MULTI_LINE}    {/* print(); */}
/*ERROR LEXICO*/
[^]                     {
                        //MANEJAR EL ERROR LEXICO
                        print("ERROR");
                        addError();
                        }
}

<STATE_SCRIPTING> {
"/"             {
                    if(resturnarBar){
                        resturnarBar = false;
                        print("/"); 
                        return new Symbol(SymScripting.BAR,yyline,yycolumn, (yytext()));
                    }else{
                        stringScripting += yytext();
                    }
                }
                    
"C_SCRIPTING"   { 
                    print("C_SCRIPTING"); 
                    yybegin(YYINITIAL);
                    returnGreaterThan = true;
                    returnLessThan=true;
                    resturnarBar=true;
                    listScripting.add(stringScripting);
                    stringScripting="";
                    return new Symbol(SymScripting.C_SCRIPTING,yyline,yycolumn, (yytext()));
                }
">"             {
                    if(returnGreaterThan){
                        returnGreaterThan = false;
                        print(">"); return new Symbol(SymScripting.CLOSE ,yyline,yycolumn,yytext());
                    }else{
                        stringScripting += yytext();
                    }                    
                }
{OPEN_BAR}      {
                if(returnLessThan){
                    returnLessThan=false;
                    print("</"); return new Symbol(SymScripting.OPEN_BAR ,yyline,yycolumn,yytext());
                }else{
                    stringScripting += yytext();
                }
                }
{COMMENT_LINE}          {/* print(); */}
{COMMENT_MULTI_LINE}    {/* print(); */}
[^]              { stringScripting += yytext();}
}