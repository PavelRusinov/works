
package interpreter.nodes;

public class FunDef extends Expression{
    private String id;
    private Expression body;
    
    public FunDef(String i, Expression b) {
        id = i;
        body = b;
        type = ExprType.FUNDEF;
    }
    
    public String getId() {
        return id;
    }
    
    public Expression getBody() {
        return body;
    }
    
    public void setBody(Expression b) {
        body = b;
    }
}
