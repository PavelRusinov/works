
package interpreter.nodes;

public class Identifier extends Expression{
    private String name;
    
    public Identifier(String name) {
        this.name = name;
        type = ExprType.IDENTIFIER;
    }
    
    public String getName() {
        return name;
    } 
}
