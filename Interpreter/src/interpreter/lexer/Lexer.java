
package interpreter.lexer;

import exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private List<Lexeme> lexemeArray;
    private int p;
    private String expr;
    private boolean eol;
    private int lp;    
    
    public Lexer(String e) throws Exception{
        lexemeArray = new ArrayList<>();
        expr = e;
        p = 0;
        lp = 0;
        eol = false;
        getLexeme();
    }
    
    private void getLexeme() throws Exception{
        while (!eol){
            Lexeme l = readlexem();
            lexemeArray.add(l);
        }
        if(lexemeArray.get(lexemeArray.size()-1).getType() != LexemType.END){
            lexemeArray.add(new EndLexem());
        }
    }
    
    private Lexeme readlexem() throws Exception{
        if(p > expr.length()-1) {
            eol = true;
        }
        
        while(!eol && expr.charAt(p)== ' ') {
            p++; 
            if(p > expr.length() - 1) {
                 eol = true;
             }
         }
         
         if(!eol){
            switch(expr.charAt(p)){
                    case '+': p++;
                              return new BinOpLexem(Operator.PLUS);
                    case '-': if(p+1 < expr.length() - 1 && expr.charAt(p + 1) == '>'){
                                  p+=2;
                                  return new ArrowLexem();
                              }
                              else{
                                  p++;
                                  return new BinOpLexem(Operator.MINUS);
                              }
                    case '*': p++;
                              return new BinOpLexem(Operator.MULT);
                    case '/': p++;
                              return new BinOpLexem(Operator.DIV);
                    case '=': p++;
                              return new AssignLexem();
                    case '(': p++;
                              return new ObraceLexem();
                    case ')': p++;
                              return new ClBraceLexem();
                    default: if(Character.isDigit(expr.charAt(p))){
                                 int i = p;
                                 while(!eol && Character.isDigit(expr.charAt(p))) {
                                        p++;
                                        if(p > expr.length()-1) {
                                           eol = true;
                                     }
                                 }
                                 return new NumbLexem(Integer.parseInt(expr.substring(i, p)));
                             }
                             if(Character.isLetter(expr.charAt(p))){
                                    int i = p;
                                    while(!eol && Character.isLetterOrDigit(expr.charAt(p))) {
                                        p++;
                                        if(p > expr.length()-1) {
                                           eol = true;
                                        }
                                    }
                                    String n = expr.substring(i, p);
                                    switch (n.toLowerCase()) {
                                        case "let":
                                            return new LetLexem();
                                        case "in":
                                            return new InLexem();
                                        case "fun":
                                            return new FunLexem();
                                        default:
                                            return new IdLexem(n);
                                    }
                                        
                             }
                             else {
                                    throw new UnexpectedCharException();
                             }             
                }
        }
        return new EndLexem();
    }
    
    public Lexeme nextlexem(){
        Lexeme i = lexemeArray.get(lp);
        if(lp < lexemeArray.size() - 1){lp++;}
        return i;
    }
}
