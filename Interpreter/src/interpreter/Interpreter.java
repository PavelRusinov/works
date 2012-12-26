
package interpreter;

import exceptions.*;
import interpreter.nodes.*;

public abstract class Interpreter {
    
    protected int evalCounter;
    
    public Expression substitute(Expression expr, String id, Expression x) throws Exception{
        switch(expr.getType()){
            case BINOP: 
                BinOp op = (BinOp)expr;
                op.setLeft(substitute(op.getLeft(), id, x));
                op.setRight(substitute(op.getRight(), id, x));
                return op;
            
            case IDENTIFIER: Identifier i = (Identifier)expr;
                if (id.equals(i.getName())) {
                    return (Expression)x.deepcopy();
                }
                return i;
            
            case FUNDEF: 
                FunDef f = (FunDef)expr;
                if(!(f.getId()).equals(id)){
                    f.setBody(substitute(f.getBody(), id ,x));
                }
                return f; 
            
            case FUNCALL: 
                FunCall c = (FunCall)expr;
                c.setFun(substitute(c.getFun(), id, x));
                c.setArg(substitute(c.getArg(), id, x));
                return c;
            case NUMBER: return expr;
            
            case LET: 
                Let l = (Let)expr;
                if(!(l.getId()).equals(id)) {
                    l.setBound(substitute(l.getBound(), id, x));
                    l.setExpr(substitute(l.getExpr(), id, x));
                }
                return l;
        }
        throw new UnexpectedTypeException();
    }
    
    protected Expression eval(Expression expr) throws Exception {
        evalCounter++;
        switch (expr.getType()) {
            case BINOP: return eval((BinOp)expr);
            case IDENTIFIER: return eval((Identifier)expr);
            case FUNDEF: return eval((FunDef)expr);
            case FUNCALL: return eval((FunCall)expr);
            case NUMBER: return eval((Numb)expr);
            case LET: return eval((Let)expr);
        }
        throw new UnexpectedTypeException();
    }
    
    private Expression eval(Numb n){
        return n;
    }
    
    private Expression eval(Identifier id) throws Exception{
        throw new UnexpectedTypeException();
    }
    
    private Expression eval(FunDef f){
        return f;
    }
    
    private Expression eval(BinOp b) throws Exception{
        Expression left = eval(b.getLeft());
        Expression right = eval(b.getRight());
        
        if(left.getType() != ExprType.NUMBER || right.getType() != ExprType.NUMBER){
            throw new UnexpectedTypeException();
        }
        
        switch(b.getOp()){
            case PLUS: return new Numb(((Numb)left).getValue()+((Numb)right).getValue());
            case MINUS: return new Numb(((Numb)left).getValue()-((Numb)right).getValue());
            case MULT: return new Numb(((Numb)left).getValue()*((Numb)right).getValue());
            case DIV: if(((Numb)right).getValue() == 0){
                            throw new DivByZeroException();
                      }
                return new Numb(((Numb)left).getValue()/((Numb)right).getValue());
        }
        throw new UnexpectedTypeException();
    }
    
    public Expression evalExpr(Expression e) throws Exception{
        evalCounter = 0;
        return eval(e);
    }
    
    abstract Expression eval(FunCall func) throws Exception;
    abstract Expression eval(Let l) throws Exception;
    
    public int getCounter(){
        return evalCounter;
    }
    
}
