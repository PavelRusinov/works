
package braces;

import static org.junit.Assert.*;
import org.junit.Test;

public class CheckBracesTest {
    
    public CheckBracesTest() {
    }

    
    @Test
    public void EmptyStr() throws Exception {
        System.out.println("EmptyStr");
        String s = "";
        CheckBraces instance = new CheckBraces();
        boolean expResult = true;
        boolean result = instance.check(s);
        assertEquals(expResult, result);
    }
    @Test
    public void NullStr() throws Exception {
        System.out.println("NullStr");
        String s = null;
        CheckBraces instance = new CheckBraces();
        boolean expResult = true;
        boolean result = instance.check(s);
        assertEquals(expResult, result);
    }
    @Test
    public void Right() throws Exception {
        System.out.println("RightSeq");
        String []s = {"<name fggs435twref][]> [()] </name> <xz /> (<xy/>)",
        "(<name> 123[([<xa />]())]fergeg </name>)[]", "(<f>dfd <name>dfd [wefw] "
                + "<x/> </name> </f>)"};
        CheckBraces instance = new CheckBraces();
        boolean expResult = true;
        boolean result;
        for(int i = 0; i < s.length; i++) {
            System.out.println(i);
            result = instance.check(s[i]);
            assertEquals(expResult, result);
        }
    }
    @Test
    public void Wrong() throws Exception {
        System.out.println("WrongSeq");
        String []s = {"<n> (</n>)", "<> (</>)", "<n> </name>","</nf><n>",
        "<n>", "<sdfsdf ()", ")("};
        CheckBraces instance = new CheckBraces();
        boolean expResult = false;
        boolean result;
        for(int i = 0; i < s.length; i++) {
            System.out.println(i);
            result = instance.check(s[i]);
            assertEquals(expResult, result);
        }
    }
}
