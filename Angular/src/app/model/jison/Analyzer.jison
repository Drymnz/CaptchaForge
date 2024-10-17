/* description: Parses end executes mathematical expressions. */
%{
    function printText(yytext) {
        /*sector de pruevas*/
    //console.log(yytext);
  }
  function addErroLexico(yytext) {
    //listToken.push(new yy.ErrorParser(0, 0,yy.TipoErrorParser.INVALID,yytext));
  }
%}
/* lexical grammar */
%lex

%%

\s+                   /* skip whitespace */
\f+   					                {}
\n+   					                {}
\r+   					                {}
\v+   					                {}
"\"id\""                        return 'ID';
"\"link\""                      return 'LINK';
(\"[^\"]*\"|['][^']*['])        return 'TEXT';
"["                             return 'OPEN_CLASP';
"]"                             return 'OUT_CLASP';
"{"                             return 'OPEN_KEY';
"}"                             return 'OUT_KEY';
","                             return 'COMA';
":"                             return 'DOUBLE_POINTS';
<<EOF>>                         return 'EOF';
("~"|"`"|"&"|"!"|"@"|"#"|"$"|"%"|"_"|"\\"|"<"|">"|"\?"|"."|";"|"^")+ {printText(yytext+'  INVALID'); return 'INVALID';};
.                               return 'INVALID';

/lex
/* operator associations and precedence */


%start expressions

%% /* language grammar */

expressions
    :listado  EOF {return $1;}
    |EOF {$$ = []; return $1;}
    |{$$ = []; return $1;}
    ;

listado
    : OPEN_CLASP bucle_chaptcha OUT_CLASP
    {return $2;}
    ;

bucle_chaptcha
    :bucle_chaptcha COMA chaptcha
    {$$.push($3);}
    |chaptcha
    {
       $$ = []; $$.push($1);
    }
    ;

chaptcha
    :OPEN_KEY attributos OUT_KEY
    {
       $$ = new yy.CaptchaLink($2[0].valor,$2[1].valor);
    }
    ;

attributos
    :attributos COMA atributo
    {$$.push($3);}
    |atributo
    {$$ = []; $$.push($1);}
    ;

atributo
    :ID DOUBLE_POINTS TEXT
    {$$ = new yy.Value(this._$.first_line, this._$.first_column, $1,$3 ,yy.ListTypeData.ID);}
    |LINK DOUBLE_POINTS TEXT
    {$$ = new yy.Value(this._$.first_line, this._$.first_column, $1,$3 ,yy.ListTypeData.LINK);}
    ;