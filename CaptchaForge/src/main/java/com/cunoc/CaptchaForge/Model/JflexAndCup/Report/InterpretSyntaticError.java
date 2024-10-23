package com.cunoc.CaptchaForge.Model.JflexAndCup.Report;

import java.util.Stack;

import com.cunoc.CaptchaForge.Model.JflexAndCup.CC.ParserCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CC.SymCC;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaDataBase.ParserCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.JflexAndCup.CaptchaDataBase.SymCaptchaDataBase;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Scripting.ParserScripting;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Scripting.SymScripting;
import com.cunoc.CaptchaForge.Model.JflexAndCup.ScriptingToJS.ParserScriptingToJS;
import com.cunoc.CaptchaForge.Model.JflexAndCup.ScriptingToJS.SymScriptingToJS;

import java_cup.runtime.Symbol;
import java_cup.runtime.lr_parser;

public class InterpretSyntaticError {
    private final String ERROR_IF_THERE_IS_NO_TOKEN_TO_PARSE = "No hay nada que analizar en token";
    private final String THE_NEXT_TOKEN_WAS_NOT_EXPECTED_CHECK_THE_DOCUMENTATION = "Le falto un caracter antes de :";
    private final String INITIAL_SUGGESTION = "\n- Sugerencia: El error ocurrió después del token. => \"";
    private final String FINAL_SUGGESTION = " \" Confirma si el token es correcto y está bien ubicado.";

    private Stack stack;

    public InterpretSyntaticError(Stack stack) {
        this.stack = stack;
    }

    public String descriptionParser(lr_parser context) {
        if (this.stack != null && this.stack.get(this.stack.size() - 1) != null && this.stack.get(this.stack.size() - 1) instanceof Symbol) {
            Symbol analizer = (Symbol) this.stack.get(this.stack.size() - 1);
            if (analizer.sym == 0) {
                return this.ERROR_IF_THERE_IS_NO_TOKEN_TO_PARSE;
            } else {
                if (analizer.sym == 1) {
                    int index = (this.stack.size() - 2 > 0) ? this.stack.size() - 2 : this.stack.size() - 1;
                    analizer = (Symbol) this.stack.get(index);
                }
                return accordingToItsSymParserLogin(analizer, context);
            }
        }
        return "";
    }

    private String accordingToItsSymParserLogin(Symbol analizer, lr_parser context) {
        String lastToken = lastToken(analizer, context);
        if (lastToken.equals("EOF") || lastToken.equals("error")) {
            return this.ERROR_IF_THERE_IS_NO_TOKEN_TO_PARSE;
        } else {
            return this.THE_NEXT_TOKEN_WAS_NOT_EXPECTED_CHECK_THE_DOCUMENTATION + this.INITIAL_SUGGESTION + lastToken + this.FINAL_SUGGESTION;
        }
    }
    
    private String lastToken(Symbol analizer, lr_parser context){
        if (context instanceof ParserCC) {
            return textErrorParserCC(analizer);
        }
        else if (context instanceof ParserScripting) {
            return SymScripting.terminalNames[analizer.sym];
        }
        else if (context instanceof ParserScriptingToJS) {
            return SymScriptingToJS.terminalNames[analizer.sym];
        }
        else if (context instanceof ParserCaptchaDataBase) {
            return SymCaptchaDataBase.terminalNames[analizer.sym];
        }
        else
        {
            return "EOF";
        }
    }
    private String textErrorParserCC(Symbol analizer){
        /* for (Object object : stack) {
            if (object instanceof Symbol) {
                Symbol ver = (Symbol) object;
                System.out.println(SymCC.terminalNames[ver.sym]);
            }
        } */
        return SymCC.terminalNames[analizer.sym];
    }
}
