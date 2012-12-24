
package calculator;

import exceptions.InvalidCharException;

public class Lexer {
    private LexemValue currlexem;
    private int p;
    private int NumberValue;
    private String VarName;
    private boolean eol;
    protected String exp;
    
    public Lexer(){
        currlexem = LexemValue.START;
        eol = false;
    }
    
    public void newExpr(String e){
        eol = false;
        exp = e;
        currlexem = LexemValue.START;
        p = 0;
    }
    
    public void nextlexem() throws InvalidCharException
    {
            if(p > exp.length()-1) {
                eol = true;
            }
            
            while(!eol && exp.charAt(p)== ' ') {
                p++; 
                if(p > exp.length() - 1) {
                     eol = true;
                 }
             }
            
            if(!eol){
                switch(exp.charAt(p)){
                    case '+': currlexem = LexemValue.PLUS;
                                  p++;
                                  break;
                    case '-': currlexem = LexemValue.MINUS;
                                  p++;
                                  break;
                    case '*': currlexem = LexemValue.MULT;
                                  p++;
                                  break;
                    case '/': currlexem = LexemValue.DIV;
                                  p++;
                                  break;
                    case '=': currlexem = LexemValue.EQS;
                                  p++;
                                  break;
                    case '(': currlexem = LexemValue.OBRACE;
                                  p++;
                                  break;
                    case ')': currlexem = LexemValue.CBRACE;
                                  p++;
                                  break;
                    case '\n':    eol = true;
                                  p++;
                                  break;
                    default: if(Character.isDigit(exp.charAt(p))){
                                 currlexem = LexemValue.NUMBER;
                                 int i = p;
                                 while(!eol && Character.isDigit(exp.charAt(p))) {
                                     p++;
                                     if(p > exp.length()-1) {
                                        eol = true;
                                     }
                                 }
                                 NumberValue = Integer.parseInt(exp.substring(i, p));
                                 break;
                             }
                             if(Character.isLetter(exp.charAt(p))){
                                    currlexem = LexemValue.VAR;
                                    int i = p;
                                    while(!eol && Character.isLetterOrDigit(exp.charAt(p))) {
                                        p++;
                                        if(p > exp.length()-1) {
                                                eol = true;
                                        }
                                    }
                                    VarName = exp.substring(i, p);
                                    break;
                             }
                             else {
                                    throw new InvalidCharException();
                             }             
                      }
              }
    }
    
    public LexemValue futurelexem() throws InvalidCharException
    {
        boolean e = eol;
        LexemValue c = currlexem;
        int i = p;
        int n = NumberValue;
        String v = VarName;
        nextlexem();
        LexemValue next = currlexem;
        eol = e;
        currlexem = c;
        p = i;
        NumberValue = n;
        VarName = v;
        return next;
    }
    
    public int getLexemValue(){
        return NumberValue;
    }
    
    public String getVariableName(){
        return VarName;
    }
    
    public LexemValue getCurrLexem(){
        return currlexem;
    }
    
    public boolean eol(){
        return eol;
    }
}
