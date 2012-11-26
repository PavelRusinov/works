
package interpreter.lexer;

public class BinOpLexem extends Lexeme{
    private Operator op;
    
    public BinOpLexem(Operator o){
        super(LexemType.BINOP);
        op = o;
    }
    
    public Operator getOp(){
        return op;
    }
    
}
