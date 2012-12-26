
package interpreter.nodes;

import interpreter.lexer.Operator;

public class BinOp extends Expression{
    private Expression left;
    private Expression right;
    private Operator op;
    
    public BinOp(Operator op, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        this.op = op;
        type = ExprType.BINOP;
    }
    
    public Operator getOp() {
        return op;
    }
    
    public Expression getLeft() {
        return left;
    }
    
    public Expression getRight() {
        return right;
    }
    
    public void setRight(Expression r) {
        right = r;
    }
    
    public void setLeft(Expression l) {
        left = l;
    }
    @Override
    public Expression deepcopy(){
        return new BinOp(op, (Expression)left.deepcopy(), (Expression)right.deepcopy());
    }
    
    public String opString(Operator o){
        switch(o){
            case PLUS: return "+";
            case MINUS: return "-";
            case DIV: return "/";
            case MULT: return "*";
        }
        return "";
    }
    
    @Override
    public String toString(){
        return "(" + left.toString() + opString(op) + right.toString() + ")";
    }
}
