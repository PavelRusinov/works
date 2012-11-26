
package interpreter.lexer;

public class Lexeme {
    private LexemType type;
    
    public Lexeme(LexemType l){
        type = l;
    }
    
    public LexemType getType() {
        return type;
    }
}
