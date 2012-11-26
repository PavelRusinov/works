
package interpreter.lexer;

public class IdLexem extends Lexeme{
    private String name;
    
    public IdLexem(String n){
        super(LexemType.ID);
        name = n;
    }
    
    public String getName(){
        return name;
    }
}
