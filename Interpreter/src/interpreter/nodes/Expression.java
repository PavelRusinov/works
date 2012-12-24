
package interpreter.nodes;

public abstract class Expression extends Node{
    protected ExprType type;
    
    public ExprType getType() {
        return type;
    }
}
