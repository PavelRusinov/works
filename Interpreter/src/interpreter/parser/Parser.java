
package interpreter.parser;

import exceptions.*;
import interpreter.lexer.*;
import interpreter.nodes.*;

public class Parser {
    Lexer lexer;
    Lexeme currlexem;
    
    public Parser(String e) throws Exception{
        lexer = new Lexer(e);
    }
    
    private void nextlexem(){
        this.currlexem = lexer.nextlexem();
    }
    
    public Node parseExpr() throws Exception{
        nextlexem();
        Node res = parse();
        return res;
    }
    
    private Node parse() throws Exception{
        switch(currlexem.getType()){
            case LET: return parseLet();
            case FUN: return parseFun();
            default: return expr();
        }
    }
    
    private Node parseFun() throws Exception{
        nextlexem();
        if(currlexem.getType() != LexemType.ID){
            throw new UnexpectedLexemException();
        }
        String id = ((IdLexem)currlexem).getName();
        nextlexem();
        if(currlexem.getType() != LexemType.ARROW){
            throw new UnexpectedLexemException();
        }
        nextlexem();
        return new FunDef(id, (Expression) parse());
    }
    
    private Node parseLet() throws Exception{
        nextlexem();
        if(currlexem.getType() != LexemType.ID){
            throw new UnexpectedLexemException();
        }
        String id = ((IdLexem)currlexem).getName();
        nextlexem();
        if(currlexem.getType() != LexemType.ASSIGN){
            throw new UnexpectedLexemException();
        }
        nextlexem();
        Expression bound = (Expression) parse();
        if(currlexem.getType() != LexemType.IN){
            throw new UnexpectedLexemException();
        }
        nextlexem();
        Expression expr = (Expression) parse();
        return new Let(id, bound, expr);
    }
    
    private Node expr() throws Exception{
        Node left = term();

        if(currlexem.getType() == LexemType.BINOP){
            Operator o = ((BinOpLexem)currlexem).getOp();
            if(o == Operator.PLUS || o == Operator.MINUS){
                nextlexem();
                return new BinOp(o, (Expression)left, (Expression)expr());
            }
        }
        return left;
    }
    
    private Node term() throws Exception {
        Node left = factor();

        if(currlexem.getType() == LexemType.BINOP){
            Operator o = ((BinOpLexem)currlexem).getOp();
            if(o == Operator.MULT || o == Operator.DIV){
                nextlexem();
                return new BinOp(o, (Expression)left, (Expression)term());
            }
        }
        return left;
    }

    private Node factor() throws Exception{
        return funcall();
    }
    
    private Node funcall() throws Exception{
        Node n = primary();
        while(currlexem.getType() == LexemType.ID || 
              currlexem.getType() == LexemType.OBRACE ||
              currlexem.getType() == LexemType.NUMB){
            n = new FunCall((Expression)n, (Expression) primary());
        }
        return n;
    }
    
    private Node primary() throws Exception{
        switch(currlexem.getType()){
            case NUMB: int val = ((NumbLexem)currlexem).getValue();
                       nextlexem();
                       return new Numb(val);
            
            case ID: String id = ((IdLexem)currlexem).getName();
                     nextlexem();
                     return new Identifier(id);
            
            case OBRACE: nextlexem();
                         Node n = parse();
                         if(currlexem.getType() != LexemType.CLBRACE){
                             throw new NoClBraceException();
                         }
                         nextlexem();
                         return n;
        }
        throw new UnexpectedLexemException();
    }
}
