
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


}
