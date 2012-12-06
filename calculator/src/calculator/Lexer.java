
package calculator;

import exceptions.InvalidCharException;

public class Lexer {
    private LexemValue currlexem;
    private int p;
    private int NumberValue;
    private String VarName;
    protected String Exp;
    
    public Lexer(){
        currlexem = LexemValue.START;
    }
    
    public void newExpr(String e){
        Exp = e;
        currlexem = LexemValue.START;
        p = 0;
    }
    
    public void nextlexem() throws InvalidCharException
    {
            while(Exp.charAt(p)== ' ') {p++;}
            
            switch(Exp.charAt(p)){
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
                    case '\n': currlexem = LexemValue.EOL;
                                  p++;
                                  break;
                    case '.': currlexem = LexemValue.EOL;
                                  p++;
                                  break;
                    default: if(Character.isDigit(Exp.charAt(p))){
                                 currlexem = LexemValue.NUMBER;
                                 int i = p;
                                 while(Character.isDigit(Exp.charAt(p))) {p++;}
                                 NumberValue = Integer.parseInt(Exp.substring(i, p));
                                 break;
                             }
                             if(Character.isLetter(Exp.charAt(p))){
                                    currlexem = LexemValue.VAR;
                                    int i = p;
                                    while(Character.isLetterOrDigit(Exp.charAt(p))) {p++;}
                                    VarName = Exp.substring(i, p);
                                   break;
                             }
                             else {
                                    throw new InvalidCharException();
                             }             
                }
    }
    
    public LexemValue futurelexem() throws InvalidCharException
    {
        LexemValue c = currlexem;
        int i = p;
        int n = NumberValue;
        String v = VarName;
        nextlexem();
        LexemValue next = currlexem;
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
}
