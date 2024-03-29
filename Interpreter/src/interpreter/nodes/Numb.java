
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

    @Override
    public Object deepcopy() {
        return new Numb(value);
    }
    
    @Override
    public String toString(){
        return Integer.toString(value);
    }
}
