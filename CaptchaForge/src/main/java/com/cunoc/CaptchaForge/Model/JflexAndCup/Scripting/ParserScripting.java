
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.cunoc.CaptchaForge.Model.JflexAndCup.Scripting;

import java_cup.runtime.*;
import java.util.ArrayList;
import com.cunoc.CaptchaForge.Model.Analyzer.ErrorTypeInTheInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.ReportErrorInterpreter;
import com.cunoc.CaptchaForge.Model.Analyzer.Token;
import com.cunoc.CaptchaForge.Model.JflexAndCup.Report.InterpretSyntaticError;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ParserScripting extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return SymScripting.class;
}

  /** Default constructor. */
  @Deprecated
  public ParserScripting() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ParserScripting(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserScripting(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\055\000\002\002\004\000\002\002\003\000\002\002" +
    "\004\000\002\002\002\000\002\003\004\000\002\003\003" +
    "\000\002\004\003\000\002\004\003\000\002\004\003\000" +
    "\002\005\007\000\002\006\003\000\002\006\004\000\002" +
    "\011\005\000\002\012\003\000\002\012\004\000\002\013" +
    "\005\000\002\013\003\000\002\007\003\000\002\007\003" +
    "\000\002\007\003\000\002\007\003\000\002\007\003\000" +
    "\002\015\006\000\002\014\003\000\002\014\005\000\002" +
    "\016\005\000\002\016\005\000\002\016\005\000\002\016" +
    "\005\000\002\016\005\000\002\016\005\000\002\016\005" +
    "\000\002\016\005\000\002\016\004\000\002\016\005\000" +
    "\002\016\005\000\002\016\005\000\002\016\005\000\002" +
    "\016\005\000\002\016\005\000\002\016\003\000\002\016" +
    "\003\000\002\016\003\000\002\016\003\000\002\016\003" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\113\000\022\002\ufffe\003\020\004\005\005\004\006" +
    "\012\007\021\010\015\011\017\001\002\000\006\011\uffef" +
    "\042\uffef\001\002\000\006\011\ufff0\042\ufff0\001\002\000" +
    "\022\002\ufffb\004\ufffb\005\ufffb\006\ufffb\007\ufffb\010\ufffb" +
    "\011\ufffb\041\ufffb\001\002\000\006\011\102\042\103\001" +
    "\002\000\020\002\000\004\005\005\004\006\012\007\021" +
    "\010\015\011\017\001\002\000\022\002\ufff9\004\ufff9\005" +
    "\ufff9\006\ufff9\007\ufff9\010\ufff9\011\ufff9\041\ufff9\001\002" +
    "\000\006\011\uffee\042\uffee\001\002\000\004\002\101\001" +
    "\002\000\022\002\ufffc\004\ufffc\005\ufffc\006\ufffc\007\ufffc" +
    "\010\ufffc\011\ufffc\041\ufffc\001\002\000\006\011\uffec\042" +
    "\uffec\001\002\000\022\002\ufffa\004\ufffa\005\ufffa\006\ufffa" +
    "\007\ufffa\010\ufffa\011\ufffa\041\ufffa\001\002\000\006\020" +
    "\024\037\025\001\002\000\016\004\005\005\004\006\012" +
    "\007\021\010\015\011\017\001\002\000\006\011\uffed\042" +
    "\uffed\001\002\000\020\002\uffff\004\005\005\004\006\012" +
    "\007\021\010\015\011\017\001\002\000\022\002\ufffd\004" +
    "\ufffd\005\ufffd\006\ufffd\007\ufffd\010\ufffd\011\ufffd\041\ufffd" +
    "\001\002\000\016\011\034\014\037\015\040\016\041\017" +
    "\036\031\035\001\002\000\004\036\026\001\002\000\004" +
    "\040\027\001\002\000\020\004\005\005\004\006\012\007" +
    "\021\010\015\011\017\041\030\001\002\000\022\002\ufff7" +
    "\004\ufff7\005\ufff7\006\ufff7\007\ufff7\010\ufff7\011\ufff7\041" +
    "\ufff7\001\002\000\020\004\005\005\004\006\012\007\021" +
    "\010\015\011\017\041\033\001\002\000\022\002\ufff8\004" +
    "\ufff8\005\ufff8\006\ufff8\007\ufff8\010\ufff8\011\ufff8\041\ufff8" +
    "\001\002\000\022\002\ufff6\004\ufff6\005\ufff6\006\ufff6\007" +
    "\ufff6\010\ufff6\011\ufff6\041\ufff6\001\002\000\040\012\uffd5" +
    "\021\uffd5\022\uffd5\023\uffd5\024\uffd5\025\uffd5\026\uffd5\027" +
    "\uffd5\030\uffd5\032\uffd5\033\uffd5\034\uffd5\035\uffd5\036\uffd5" +
    "\037\uffd5\001\002\000\016\011\034\014\037\015\040\016" +
    "\041\017\036\031\035\001\002\000\040\012\uffd9\021\uffd9" +
    "\022\uffd9\023\uffd9\024\uffd9\025\uffd9\026\uffd9\027\uffd9\030" +
    "\uffd9\032\uffd9\033\uffd9\034\uffd9\035\uffd9\036\uffd9\037\uffd9" +
    "\001\002\000\040\012\uffd8\021\uffd8\022\uffd8\023\uffd8\024" +
    "\uffd8\025\uffd8\026\uffd8\027\uffd8\030\uffd8\032\uffd8\033\uffd8" +
    "\034\uffd8\035\uffd8\036\uffd8\037\uffd8\001\002\000\040\012" +
    "\uffd7\021\uffd7\022\uffd7\023\uffd7\024\uffd7\025\uffd7\026\uffd7" +
    "\027\uffd7\030\uffd7\032\uffd7\033\uffd7\034\uffd7\035\uffd7\036" +
    "\uffd7\037\uffd7\001\002\000\040\012\uffd6\021\uffd6\022\uffd6" +
    "\023\uffd6\024\uffd6\025\uffd6\026\uffd6\027\uffd6\030\uffd6\032" +
    "\uffd6\033\uffd6\034\uffd6\035\uffd6\036\uffd6\037\uffd6\001\002" +
    "\000\040\012\055\021\054\022\050\023\051\024\045\025" +
    "\057\026\056\027\060\030\043\032\052\033\047\034\053" +
    "\035\061\036\046\037\044\001\002\000\016\011\034\014" +
    "\037\015\040\016\041\017\036\031\035\001\002\000\016" +
    "\011\034\014\037\015\040\016\041\017\036\031\035\001" +
    "\002\000\016\011\034\014\037\015\040\016\041\017\036" +
    "\031\035\001\002\000\016\011\034\014\037\015\040\016" +
    "\041\017\036\031\035\001\002\000\016\011\034\014\037" +
    "\015\040\016\041\017\036\031\035\001\002\000\016\011" +
    "\034\014\037\015\040\016\041\017\036\031\035\001\002" +
    "\000\016\011\034\014\037\015\040\016\041\017\036\031" +
    "\035\001\002\000\016\011\034\014\037\015\040\016\041" +
    "\017\036\031\035\001\002\000\016\011\034\014\037\015" +
    "\040\016\041\017\036\031\035\001\002\000\016\011\034" +
    "\014\037\015\040\016\041\017\036\031\035\001\002\000" +
    "\022\002\uffeb\004\uffeb\005\uffeb\006\uffeb\007\uffeb\010\uffeb" +
    "\011\uffeb\041\uffeb\001\002\000\016\011\034\014\037\015" +
    "\040\016\041\017\036\031\035\001\002\000\016\011\034" +
    "\014\037\015\040\016\041\017\036\031\035\001\002\000" +
    "\016\011\034\014\037\015\040\016\041\017\036\031\035" +
    "\001\002\000\016\011\034\014\037\015\040\016\041\017" +
    "\036\031\035\001\002\000\040\012\uffdc\021\054\022\050" +
    "\023\051\024\045\025\057\026\056\027\060\030\043\032" +
    "\uffdc\033\uffdc\034\uffdc\035\uffdc\036\046\037\044\001\002" +
    "\000\040\012\uffe2\021\uffe2\022\uffe2\023\uffe2\024\uffe2\025" +
    "\uffe2\026\uffe2\027\uffe2\030\043\032\uffe2\033\uffe2\034\uffe2" +
    "\035\uffe2\036\046\037\044\001\002\000\040\012\uffe4\021" +
    "\uffe4\022\uffe4\023\uffe4\024\uffe4\025\uffe4\026\uffe4\027\060" +
    "\030\043\032\uffe4\033\uffe4\034\uffe4\035\uffe4\036\046\037" +
    "\044\001\002\000\040\012\uffe3\021\uffe3\022\uffe3\023\uffe3" +
    "\024\uffe3\025\uffe3\026\uffe3\027\060\030\043\032\uffe3\033" +
    "\uffe3\034\uffe3\035\uffe3\036\046\037\044\001\002\000\040" +
    "\012\uffe8\021\uffe8\022\uffe8\023\uffe8\024\uffe8\025\uffe8\026" +
    "\uffe8\027\060\030\043\032\uffe8\033\uffe8\034\uffe8\035\uffe8" +
    "\036\046\037\044\001\002\000\040\012\uffdd\021\054\022" +
    "\050\023\051\024\045\025\057\026\056\027\060\030\043" +
    "\032\uffdd\033\uffdd\034\uffdd\035\uffdd\036\046\037\044\001" +
    "\002\000\040\012\uffdf\021\054\022\050\023\051\024\045" +
    "\025\057\026\056\027\060\030\043\032\uffdf\033\uffdf\034" +
    "\053\035\061\036\046\037\044\001\002\000\040\012\uffe6" +
    "\021\uffe6\022\uffe6\023\uffe6\024\uffe6\025\uffe6\026\uffe6\027" +
    "\060\030\043\032\uffe6\033\uffe6\034\uffe6\035\uffe6\036\046" +
    "\037\044\001\002\000\040\012\uffe7\021\uffe7\022\uffe7\023" +
    "\uffe7\024\uffe7\025\uffe7\026\uffe7\027\060\030\043\032\uffe7" +
    "\033\uffe7\034\uffe7\035\uffe7\036\046\037\044\001\002\000" +
    "\040\012\uffde\021\054\022\050\023\051\024\045\025\057" +
    "\026\056\027\060\030\043\032\uffde\033\uffde\034\053\035" +
    "\061\036\046\037\044\001\002\000\040\012\uffda\021\uffda" +
    "\022\uffda\023\uffda\024\uffda\025\uffda\026\uffda\027\uffda\030" +
    "\uffda\032\uffda\033\uffda\034\uffda\035\uffda\036\uffda\037\uffda" +
    "\001\002\000\040\012\uffe5\021\uffe5\022\uffe5\023\uffe5\024" +
    "\uffe5\025\uffe5\026\uffe5\027\060\030\043\032\uffe5\033\uffe5" +
    "\034\uffe5\035\uffe5\036\046\037\044\001\002\000\040\012" +
    "\uffdb\021\uffdb\022\uffdb\023\uffdb\024\uffdb\025\uffdb\026\uffdb" +
    "\027\uffdb\030\uffdb\032\uffdb\033\uffdb\034\uffdb\035\uffdb\036" +
    "\uffdb\037\uffdb\001\002\000\040\012\uffe1\021\uffe1\022\uffe1" +
    "\023\uffe1\024\uffe1\025\uffe1\026\uffe1\027\uffe1\030\uffe1\032" +
    "\uffe1\033\uffe1\034\uffe1\035\uffe1\036\046\037\044\001\002" +
    "\000\040\012\uffe0\021\uffe0\022\uffe0\023\uffe0\024\uffe0\025" +
    "\uffe0\026\uffe0\027\uffe0\030\uffe0\032\uffe0\033\uffe0\034\uffe0" +
    "\035\uffe0\036\046\037\044\001\002\000\004\002\001\001" +
    "\002\000\010\012\ufff1\013\ufff1\020\ufff1\001\002\000\004" +
    "\011\115\001\002\000\006\012\111\020\112\001\002\000" +
    "\010\012\ufff4\013\106\020\ufff4\001\002\000\004\011\107" +
    "\001\002\000\010\012\ufff2\013\ufff2\020\ufff2\001\002\000" +
    "\022\002\ufff5\004\ufff5\005\ufff5\006\ufff5\007\ufff5\010\ufff5" +
    "\011\ufff5\041\ufff5\001\002\000\022\002\uffea\004\uffea\005" +
    "\uffea\006\uffea\007\uffea\010\uffea\011\uffea\041\uffea\001\002" +
    "\000\016\011\034\014\037\015\040\016\041\017\036\031" +
    "\035\001\002\000\040\012\114\021\054\022\050\023\051" +
    "\024\045\025\057\026\056\027\060\030\043\032\052\033" +
    "\047\034\053\035\061\036\046\037\044\001\002\000\022" +
    "\002\uffe9\004\uffe9\005\uffe9\006\uffe9\007\uffe9\010\uffe9\011" +
    "\uffe9\041\uffe9\001\002\000\006\012\ufff3\020\ufff3\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\113\000\020\002\012\003\007\004\013\005\005\007" +
    "\006\011\015\015\010\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\012\103\013\104\001" +
    "\001\000\014\004\022\005\005\007\006\011\015\015\010" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\016\003\021\004\013\005\005\007" +
    "\006\011\015\015\010\001\001\000\002\001\001\000\014" +
    "\004\022\005\005\007\006\011\015\015\010\001\001\000" +
    "\002\001\001\000\004\016\041\001\001\000\002\001\001" +
    "\000\002\001\001\000\020\003\030\004\013\005\005\006" +
    "\031\007\006\011\015\015\010\001\001\000\002\001\001" +
    "\000\014\004\022\005\005\007\006\011\015\015\010\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\016\077\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\016\076\001\001\000\004\016\075\001\001\000" +
    "\004\016\074\001\001\000\004\016\073\001\001\000\004" +
    "\016\072\001\001\000\004\016\071\001\001\000\004\016" +
    "\070\001\001\000\004\016\067\001\001\000\004\016\066" +
    "\001\001\000\004\016\065\001\001\000\002\001\001\000" +
    "\004\016\064\001\001\000\004\016\063\001\001\000\004" +
    "\016\062\001\001\000\004\016\061\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\014\107\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\016\112\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserScripting$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserScripting$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ParserScripting$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




private ArrayList<ReportErrorInterpreter> listError = new ArrayList();


	  public ParserScripting(LexemaScripting lexer) {
        super(lexer);
    }

    //erorr
    public void syntax_error(Symbol cur_token) {
        String nameTerminal = symbl_name_from_id(this.cur_token.sym);
        int numberTerminal = this.cur_token.sym;
        ///codigo para el objeto
        ErrorTypeInTheInterpreter type = ErrorTypeInTheInterpreter.SYNTACTIC;
        int line = cur_token.left+1;
        int columna = cur_token.right +1;
        String lexema = (this.cur_token.value!=null)? this.cur_token.value.toString() : "Token no existe";
        Token token =  new Token(line, columna, lexema);
        this.listError.add(new ReportErrorInterpreter(type, token, (new InterpretSyntaticError(this.stack)).descriptionParser(this)));
    }

    //Returnar el listado de errores
    public ArrayList<ReportErrorInterpreter> getListError() {
        return this.listError;
    }

    /**
     * ***END CODE*******
     */


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$ParserScripting$actions {
  private final ParserScripting parser;

  /** Constructor */
  CUP$ParserScripting$actions(ParserScripting parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ParserScripting$do_action_part00000000(
    int                        CUP$ParserScripting$act_num,
    java_cup.runtime.lr_parser CUP$ParserScripting$parser,
    java.util.Stack            CUP$ParserScripting$stack,
    int                        CUP$ParserScripting$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserScripting$result;

      /* select the action based on the action number */
      switch (CUP$ParserScripting$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-1)).value;
		RESULT = start_val;
              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-1)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserScripting$parser.done_parsing();
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= bucle_inicio 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // inicio ::= error bucle_inicio 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-1)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // inicio ::= 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // bucle_inicio ::= bucle_inicio instrucciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("bucle_inicio",1, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-1)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // bucle_inicio ::= instrucciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("bucle_inicio",1, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // instrucciones ::= funcion 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("instrucciones",2, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // instrucciones ::= declaracion 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("instrucciones",2, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // instrucciones ::= asignar_variable 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("instrucciones",2, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // funcion ::= ID PARENTHESIS_OPEN PARENTHESIS_CLOSE BRACKETS_OPEN bucle_funcione 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("funcion",3, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-4)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // bucle_funcione ::= BRACKETS_CLOSE 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("bucle_funcione",4, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // bucle_funcione ::= bucle_inicio BRACKETS_CLOSE 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("bucle_funcione",4, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-1)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // declaracion ::= tipos_datos derivando_declaracion asignar 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("declaracion",7, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // derivando_declaracion ::= bucle_id 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("derivando_declaracion",8, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // derivando_declaracion ::= MODO ID 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("derivando_declaracion",8, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-1)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // bucle_id ::= bucle_id COMA ID 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("bucle_id",9, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // bucle_id ::= ID 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("bucle_id",9, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // tipos_datos ::= INTEGER 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("tipos_datos",5, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // tipos_datos ::= DECIMAL 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("tipos_datos",5, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // tipos_datos ::= BOOLEAN 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("tipos_datos",5, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // tipos_datos ::= CHAR 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("tipos_datos",5, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // tipos_datos ::= STRING 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("tipos_datos",5, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // asignar_variable ::= ID EQUAL operaciones SEMICOLON 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("asignar_variable",11, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-3)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // asignar ::= SEMICOLON 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("asignar",10, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // asignar ::= EQUAL operaciones SEMICOLON 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("asignar",10, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // operaciones ::= operaciones SAME_AS operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // operaciones ::= operaciones NOT_THE_SAME operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // operaciones ::= operaciones LESS_THAN operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // operaciones ::= operaciones LESS_THAN_EQUAL operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // operaciones ::= operaciones GREATER_THAN operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // operaciones ::= operaciones GREATER_THAN_EQUAL operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // operaciones ::= operaciones OR operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // operaciones ::= operaciones AND operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // operaciones ::= NOT operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-1)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // operaciones ::= operaciones ADDITION operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // operaciones ::= operaciones SUBTRACTION operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // operaciones ::= operaciones DIVISION operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // operaciones ::= operaciones MULTIPLICATION operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // operaciones ::= operaciones PARENTHESIS_OPEN operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // operaciones ::= operaciones PARENTHESIS_CLOSE operaciones 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.elementAt(CUP$ParserScripting$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // operaciones ::= TEXT 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // operaciones ::= TRUE 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // operaciones ::= FALSE 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // operaciones ::= REAL_NUMEBERS 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // operaciones ::= ID 
            {
              Object RESULT =null;

              CUP$ParserScripting$result = parser.getSymbolFactory().newSymbol("operaciones",12, ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScripting$stack.peek()), RESULT);
            }
          return CUP$ParserScripting$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ParserScripting$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ParserScripting$do_action(
    int                        CUP$ParserScripting$act_num,
    java_cup.runtime.lr_parser CUP$ParserScripting$parser,
    java.util.Stack            CUP$ParserScripting$stack,
    int                        CUP$ParserScripting$top)
    throws java.lang.Exception
    {
              return CUP$ParserScripting$do_action_part00000000(
                               CUP$ParserScripting$act_num,
                               CUP$ParserScripting$parser,
                               CUP$ParserScripting$stack,
                               CUP$ParserScripting$top);
    }
}

}
