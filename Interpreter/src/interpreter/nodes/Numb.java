
package interpreter.nodes;

public class Numb extends Expression{
    private int value;
    
    public Numb(int val) {
        value = val;
        type = ExprType.NUMBER;
    }
    
    public int getValue() {
        return value;
    }
}
