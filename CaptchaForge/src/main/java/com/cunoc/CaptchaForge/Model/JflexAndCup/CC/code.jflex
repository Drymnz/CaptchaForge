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
%state STATE_SCRIPTING
%eofval{
  return new java_cup.runtime.Symbol(SymCC.EOF);
%eofval}

%{
    /*START-CODE*/

    private String space = "";
    private String stringScripting = "";
    private ArrayList<ReportErrorInterpreter> listError = new ArrayList();
    private ArrayList<String> listScripting = new ArrayList();

    public LexemaCC(String in) {
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

    public String getSpace(){
        return this.space;
    }

        public String convertToDesiredFormat(String text) {
        text = text.replaceAll("\\s+", "");
        StringBuilder result = new StringBuilder();

        // Iterar sobre cada carácter de la cadena
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            // Verificar si es el primer carácter
            if (i == 0) {
                result.append(Character.toUpperCase(currentChar)); // Mantener en mayúscula
            } else if (currentChar == '_') {
                result.append(currentChar); // Mantener el guion bajo
            } else {
                result.append(Character.toUpperCase(currentChar)); // Convertir a mayúscula
            }
        }

        return result.toString();
    }

    /*FINAL-CODE*/
%}

STRING_TOKEN = \"([^\"\\]|\\.)*\"

COMMENT_LINE = "!""!" ~"\n"
COMMENT_MULTI_LINE = "<!--" ~"-->"


espacio =[\n|\r|\t|\f|\b|\s| ]+

CASE_SENTI = [cC]"_"[a-zA-Z1-6]+

OPEN_BAR = "<"{espacio}?"/"

CONTENIDO = [a-zA-Z0-9@#\$%\^&*_\+\!\¡\~\`\-:;',áéíóúÁÉÍÓÚñÑ]+

OUTPUT_C_SCRIPTING = "<"{espacio}?"/"{espacio}?"C_SCRIPTING"
OPEN_C_SCRIPTING = "C_SCRIPTING"{espacio}?">"
CASE_SENTI_C_SCRIPTING =[cC]"_"[sS][cC][rR][Ii][pP][tT][Ii][nN][Gg]{espacio}?">"
OUTPUT_CASE_SENTI_C_SCRIPTING = "<"{espacio}?"/"{espacio}?[cC]"_"[sS][cC][rR][Ii][pP][tT][Ii][nN][Gg]

%%
<YYINITIAL> {
{OPEN_C_SCRIPTING}  {
                        print("\"C_SCRIPTING\"{espacio}?\">\""); 
                        yybegin(STATE_SCRIPTING);
                        return new Symbol(SymCC.C_SCRIPTING,yyline,yycolumn, (yytext()));
                    }
/*tercer seccion: reglase lexicas*/
/*HTML*/
">"             {print(">" ); return new Symbol(SymCC.CLOSE ,yyline,yycolumn,yytext());}
"<"             {print("<" ); return new Symbol(SymCC.OPEN ,yyline,yycolumn,yytext());}
"version"       {print("version"); return new Symbol(SymCC.VERSION ,yyline,yycolumn,yytext());}
/*SIMBOLOS EXTRAS*/
"="     {print("="); return new Symbol(SymCC.EQUAL,yyline,yycolumn, (yytext()));}
"/"     {print("/"); return new Symbol(SymCC.BAR,yyline,yycolumn, (yytext()));}
/*PALABRAS CLAVES DE CC*/
"C_CC"              {print("C_CC"); return new Symbol(SymCC.C_CC,yyline,yycolumn, (yytext()));}
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
"C_FORM"            {print("C_FORM"); return new Symbol(SymCC.C_FORM,yyline,yycolumn, (yytext()));}
/*PALABRAS CLAVES DE PROMS*/
"href"          {print("href"); return new       Symbol(SymCC.HREF,yyline,yycolumn, (yytext()));}
"background"    {print("background"); return new Symbol(SymCC.BACKGROUND,yyline,yycolumn, (yytext()));}
"color"         {print("color"); return new      Symbol(SymCC.COLOR,yyline,yycolumn, (yytext()));}
"font-size"     {print("font"); return new       Symbol(SymCC.FONT_SIZE,yyline,yycolumn, (yytext()));}
"font-family"   {print("font"); return new       Symbol(SymCC.FONT_FAMILY,yyline,yycolumn, (yytext()));}
"text-align"    {print("text"); return new       Symbol(SymCC.FONT_ALIG,yyline,yycolumn, (yytext()));}
"type"          {print("type"); return new       Symbol(SymCC.TYPE,yyline,yycolumn, (yytext()));}
"id"            {print("id"); return new         Symbol(SymCC.ID,yyline,yycolumn, (yytext()));}
"name"          {print("name"); return new       Symbol(SymCC.NAME,yyline,yycolumn, (yytext()));}
"cols"          {print("cols"); return new       Symbol(SymCC.COLS,yyline,yycolumn, (yytext()));}
"rows"          {print("rows"); return new       Symbol(SymCC.ROWS,yyline,yycolumn, (yytext()));}
"class"         {print("class"); return new      Symbol(SymCC.CLASS,yyline,yycolumn, (yytext()));}
"src"           {print("src"); return new        Symbol(SymCC.SRC,yyline,yycolumn, (yytext()));}
"width"         {print("width"); return new      Symbol(SymCC.WIDTH,yyline,yycolumn, (yytext()));}
"height"        {print("height"); return new     Symbol(SymCC.HEIGHT,yyline,yycolumn, (yytext()));}
"alt"           {print("alt"); return new        Symbol(SymCC.ALT,yyline,yycolumn, (yytext()));}
"onclick"       {print("onclick"); return new    Symbol(SymCC.ONCLICK,yyline,yycolumn, (yytext()));}
/*INGNORAR*/
{espacio}               { space = yytext(); }
{COMMENT_LINE}          {/* print(); */}
{COMMENT_MULTI_LINE}    {/* print(); */}
{CASE_SENTI}               {
                             String lowercaseText = convertToDesiredFormat(yytext());
                                     switch(lowercaseText) {
                                        case "C_CC":print("C_CC"); return new Symbol(SymCC.C_CC,yyline,yycolumn, (yytext()));
                                        case "C_HEAD":print("C_HEAD"); return new Symbol(SymCC.C_HEAD,yyline,yycolumn, (yytext()));
                                        case "C_TITLE":print("C_TITLE"); return new Symbol(SymCC.C_TITLE,yyline,yycolumn, (yytext()));
                                        case "C_LINK":print("C_LINK"); return new Symbol(SymCC.C_LINK,yyline,yycolumn, (yytext()));
                                        case "C_BODY":print("C_BODY"); return new Symbol(SymCC.C_BODY,yyline,yycolumn, (yytext()));
                                        case "C_SPAM":print("C_SPAM"); return new Symbol(SymCC.C_SPAM,yyline,yycolumn, (yytext()));
                                        case "C_INPUT":print("C_INPUT"); return new Symbol(SymCC.C_INPUT,yyline,yycolumn, (yytext()));
                                        case "C_TEXTAREA":print("C_TEXTAREA"); return new Symbol(SymCC.C_TEXTAREA,yyline,yycolumn, (yytext()));
                                        case "C_SELECT":print("C_SELECT"); return new Symbol(SymCC.C_SELECT,yyline,yycolumn, (yytext()));
                                        case "C_OPTION":print("C_OPTION"); return new Symbol(SymCC.C_OPTION,yyline,yycolumn, (yytext()));
                                        case "C_DIV":print("C_DIV"); return new Symbol(SymCC.C_DIV,yyline,yycolumn, (yytext()));
                                        case "C_IMG":print("C_IMG"); return new Symbol(SymCC.C_IMG,yyline,yycolumn, (yytext()));
                                        case "C_BR":print("C_BR"); return new Symbol(SymCC.C_BR,yyline,yycolumn, (yytext()));
                                        case "C_BUTTON":print("C_BUTTON"); return new Symbol(SymCC.C_BUTTON,yyline,yycolumn, (yytext()));
                                        case "C_H1":print("C_H1"); return new Symbol(SymCC.C_H1,yyline,yycolumn, (yytext()));
                                        case "C_H2":print("C_H2"); return new Symbol(SymCC.C_H2,yyline,yycolumn, (yytext()));
                                        case "C_H3":print("C_H3"); return new Symbol(SymCC.C_H3,yyline,yycolumn, (yytext()));
                                        case "C_H4":print("C_H4"); return new Symbol(SymCC.C_H4,yyline,yycolumn, (yytext()));
                                        case "C_H5":print("C_H5"); return new Symbol(SymCC.C_H5,yyline,yycolumn, (yytext()));
                                        case "C_H6":print("C_H6"); return new Symbol(SymCC.C_H6,yyline,yycolumn, (yytext()));
                                        case "C_P":print("C_P"); return new Symbol(SymCC.C_P,yyline,yycolumn, (yytext()));
                                        case "C_FORM":print("C_FORM"); return new Symbol(SymCC.C_FORM,yyline,yycolumn, (yytext()));
                                        default:print("ERROR");addError();break;
                                     }
                        }
{CASE_SENTI_C_SCRIPTING}    {
                             String lowercaseText = convertToDesiredFormat(yytext());
                                switch(lowercaseText) {
                                    case "C_SCRIPTING>":
                                        print("[cC]\"_\"[sS][cC][rR][Ii][pP][tT][Ii][nN][Gg]{espacio}?\">\""); 
                                        yybegin(STATE_SCRIPTING);
                                        return new Symbol(SymCC.C_SCRIPTING,yyline,yycolumn, (yytext()));
                                    default:print("ERROR");addError();break;
                                }
                        }
                        /*COMPLEJOS*/
{STRING_TOKEN}        {print("STRING"); return new Symbol(SymCC.STRING_TOKEN ,yyline,yycolumn,yytext());}
{CONTENIDO}     {print("CONTENIDO"); return new Symbol(SymCC.CONTENIDO ,yyline,yycolumn,yytext());}
/*ERROR LEXICO*/
[^]                     {
                        //MANEJAR EL ERROR LEXICO
                        print("ERROR");
                        addError();
                        }
}

<STATE_SCRIPTING> {
    /**INGNORA*/
    {COMMENT_LINE}          {/* print(); */}
{COMMENT_MULTI_LINE}    {/* print(); */}
     /**SLIDAD*/             
{OUTPUT_C_SCRIPTING}    { 
                        print("\"<\"{espacio}?\"/\"{espacio}?\"C_SCRIPTING\""); 
                        yybegin(YYINITIAL);
                        listScripting.add(stringScripting);
                        stringScripting="";
                        return new Symbol(SymCC.OUTPUT_C_SCRIPTING,yyline,yycolumn, (yytext()));
                        }                

{OUTPUT_CASE_SENTI_C_SCRIPTING}               {
                             String lowercaseText = convertToDesiredFormat(yytext());
                                     switch(lowercaseText) {
                                        case "</C_SCRIPTING":
                                            print("\"<\"{espacio}?\"/\"{espacio}?[cC]\"_\"[sS][cC][rR][Ii][pP][tT][Ii][nN][Gg]"); 
                                            yybegin(YYINITIAL);
                                            listScripting.add(stringScripting);
                                            stringScripting="";
                                            return new Symbol(SymCC.OUTPUT_C_SCRIPTING,yyline,yycolumn, (yytext()));
                                        default:
                                            stringScripting += yytext();
                                        break;
                                     }
                        }
[^]     { stringScripting += yytext();}
.       { stringScripting += yytext();}
}