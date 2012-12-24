
package calculator;

import exceptions.*;
import hashtable.*;

public class Parser {
    Lexer lexer;
    HashTable h;
    String[] expressions;
    
    public Parser(String[] e){
        lexer = new Lexer();
        expressions = e;
        h = new HashTable(500);
    }
    
    private int factor() throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException, UnknownIdException{
        if(lexer.getCurrLexem() == LexemValue.NUMBER){
             int res = lexer.getLexemValue();
             lexer.nextlexem();
             return res;
        }
        else if(lexer.getCurrLexem() == LexemValue.VAR){
             if(!h.isInTable(lexer.getVariableName())){
                 throw new UnknownIdException();
             }
             int res = (int) h.get(lexer.getVariableName()).getData();
             lexer.nextlexem();
             return res;
        }
        else if(lexer.getCurrLexem() == LexemValue.OBRACE){
             
             lexer.nextlexem();
             int res = expr();

             if (lexer.getCurrLexem() != LexemValue.CBRACE){
                 throw new NoClBracketException();
             }

             lexer.nextlexem();
             return res;
        }
        else{
            throw new NoOperandException();
        }
    }

    private int term() throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException, UnknownIdException {
        int left = factor();

        while(lexer.getCurrLexem() == LexemValue.MULT || lexer.getCurrLexem() == LexemValue.DIV){
                if(lexer.getCurrLexem() == LexemValue.MULT) {
                    lexer.nextlexem();
                    left *= factor();
                }
                if(lexer.getCurrLexem() == LexemValue.DIV){
                    lexer.nextlexem();
                    int d = factor();
                    if (d == 0) {throw new DivByZeroException();}
                    left /= d;
                }    
            }   
        return left;
    }

    private int expr() throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException, UnknownIdException {
        int left = term();

        while(lexer.getCurrLexem() == LexemValue.PLUS || lexer.getCurrLexem() == LexemValue.MINUS){
            if(lexer.getCurrLexem() == LexemValue.PLUS){
                lexer.nextlexem();
                left += term();
            }
            if(lexer.getCurrLexem() == LexemValue.MINUS){
                lexer.nextlexem();
                left -= term();
            }    
        }   
        return left;
    }

    private int parseAssign() throws Exception{
        lexer.nextlexem();
        lexer.nextlexem();
        int res = expr();
        if (!lexer.eol()){
            throw new NoOperatorException();
        }
        return res;
    }
    
    private int parseExpr() throws Exception{
        int res = expr();
            if (!lexer.eol()){
                throw new NoOperatorException();
            }
        return res;
    }
    
    public int[] parse() throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException, UnknownIdException, Exception{
        int l = expressions.length;
        int result[] = new int[l];
        int i;
        for(i = 0; i < l; i++){
            lexer.newExpr(expressions[i]);
            lexer.nextlexem();
            if(lexer.futurelexem() == LexemValue.EQS){
                String id = lexer.getVariableName();
                int res = parseAssign();
                h.put(id, (int) res);
                result[i] = res;
            }else{
                result[i] = parseExpr();
            }
        }
        return result;
    }
}
    
