
package calculator;

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
}
