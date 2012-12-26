
package calculator;

import exceptions.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class ParserTest {
    
    public ParserTest() {
    }

    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
        String[] e = {"x = 3+2*(7-3)","y=4","y+x*2"};
        Parser instance = new Parser(e);
        int[] expResult = {11,4,26};
        int[] result = instance.parse();
        assertArrayEquals(expResult, result);
    }
    @Test(expected = NoClBracketException.class)
    public void invalidBracket() throws Exception{
        String[] e = {"(3+2*(7-3)"};
        Parser instance = new Parser(e);
        int[] result = instance.parse();
    }
    @Test(expected = IncorrectEndOfExprException.class)
    public void invalidEnd() throws Exception{
        String[] e = {"3+2*(7-3))"};
        Parser instance = new Parser(e);
        int[] result = instance.parse();
    }
    @Test(expected = IncorrectEndOfExprException.class)
    public void invalidEnd2() throws Exception{
        String[] e = {"3+2*(7-3)4"};
        Parser instance = new Parser(e);
        int[] result = instance.parse();
    }
    @Test(expected = InvalidCharException.class)
    public void invalidChar() throws Exception{
        String[] e = {"3+2*.(7-3)4"};
        Parser instance = new Parser(e);
        int[] result = instance.parse();
    }
    @Test(expected = NoOperandException.class)
    public void invalidOperand() throws Exception{
        String[] e = {"3+2*(7-)4"};
        Parser instance = new Parser(e);
        int[] result = instance.parse();
    }
    @Test(expected = IncorrectEndOfExprException.class)
    public void invalidAssignment() throws Exception{
        String[] e = {"3=2*(7-3)"};
        Parser instance = new Parser(e);
        int[] result = instance.parse();
    }
    @Test(expected = UnknownIdException.class)
    public void unknownId() throws Exception{
        String[] e = {"3+2*(7-x)"};
        Parser instance = new Parser(e);
        int[] result = instance.parse();
    }
}
