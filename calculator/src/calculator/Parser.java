
package calculator;

import exceptions.*;
import hashtable.*;

public class Parser {
    Lexer lexer;
    HashTable h;
    
    public Parser(Lexer l){
        lexer = l;
        h = new HashTable(500);
    }
    
    private int factor() throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException{
        
        if(lexer.getCurrLexem() == LexemValue.NUMBER){
             int res = lexer.getLexemValue();
             lexer.nextlexem();
             return res;
        }
        else if(lexer.getCurrLexem() == LexemValue.VAR){
             if(!h.isInTable(lexer.getVariableName())){
                 throw new NoOperatorException();
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

    private int term() throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException {
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

    private int expr() throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException {
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

    public int parse() throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException{
        lexer.nextlexem();
        if(lexer.futurelexem() == LexemValue.EQS){
            String var = lexer.getVariableName();
            lexer.nextlexem();
            lexer.nextlexem();
            int res = expr();
            if (lexer.getCurrLexem() != LexemValue.EOL){
                throw new NoOperatorException();
            }
            h.put(var, (int) res);
            return res;
        }
        int res = expr();
	if (lexer.getCurrLexem() != LexemValue.EOL){
            throw new NoOperatorException();
	}
	return res;	
    }
}
