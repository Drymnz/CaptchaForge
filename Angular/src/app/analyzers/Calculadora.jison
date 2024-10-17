/* description: Parses end executes mathematical expressions. */

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
    {$$ = []; $$.push($2);}
    ;

bucle_chaptcha
    :bucle_chaptcha COMA chaptcha
    { $$ = $1; $$.push($3); }
    |chaptcha
    {$$ = []; $$.push($1);}
    ;

chaptcha
    :OPEN_KEY attributos OUT_KEY
    {$$ = $2}
    ;

attributos
    :attributos COMA atributo
    { $$ = $1; $$.push($3); }
    |atributo
    {$$ = []; $$.push($1);}
    ;

atributo
    :ID DOUBLE_POINTS TEXT
    |LINK DOUBLE_POINTS TEXT
    ;