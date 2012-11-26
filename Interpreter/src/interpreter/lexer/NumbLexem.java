
package interpreter.lexer;

public class NumbLexem extends Lexeme{
    private int value;
    
    public NumbLexem(int v){
        super(LexemType.NUMB);
        value = v;
    }
    
    public int getValue(){
        return value;
    }
}
