
package interpreter.parser;

import exceptions.*;
import interpreter.nodes.Node;
import static org.junit.Assert.*;
import org.junit.Test;


public class ParserTest {
    
    public ParserTest() {
    }

    @Test
    public void testParseExpr() throws Exception {
        String text = "let f = fun x -> fun y -> x + y in f 1 (f 1 (f 1 1))";
        Parser instance = new Parser();
        String expResult = "(let f = ((fun x -> (fun y -> (x+y)))) in ((call (call f (1)) ((call (call f (1)) ((call (call f (1)) (1))))))))";
        String result = instance.parseExpr(text).toString();
        assertEquals(expResult, result);
    }
    
    @Test(expected = IllegalEndOfExprException.class)
    public void invalidEnd1() throws Exception{
        String e = "let x = 3 in x-2)";
        Parser instance = new Parser();
        Node result = instance.parseExpr(e);
    }
    
    @Test(expected = NoClBraceException.class)
    public void NoClBrace() throws Exception{
        String e = "let x = 3 in (x-2";
        Parser instance = new Parser();
        Node result = instance.parseExpr(e);
    }
    
    @Test(expected = UnexpectedCharException.class)
    public void invalidChar() throws Exception{
        String e = "let x = 3. in x-2";
        Parser instance = new Parser();
        Node result = instance.parseExpr(e);
    }
    
    @Test(expected = UnexpectedLexemException.class)
    public void NoOpBracket() throws Exception{
        String e = "let x = 3 in x-)2";
        Parser instance = new Parser();
        Node result = instance.parseExpr(e);
    }
    
    @Test(expected = UnexpectedLexemException.class)
    public void NoInLexem() throws Exception{
        String e = "let x = 3 x-2";
        Parser instance = new Parser();
        Node result = instance.parseExpr(e);
    }
}
