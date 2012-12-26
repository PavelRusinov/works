
package interpreter;

import interpreter.nodes.*;
import interpreter.parser.Parser;
import static org.junit.Assert.*;
import org.junit.Test;

public class InterpreterTest {
    
    public InterpreterTest() {
    }

    @Test
    public void testLazyAndNormalInterpreter() throws Exception {
        
        String []exprs = {"let x = 2*2-3 in x+x", "let y = 7*2-9 in 5",
                          "let f = fun x -> fun y -> x*x+y*y in f (3*3-1) (2*2)"};
        String []expres = {"2", "5", "80"};
        int []evalCountAct = {9,7,21};
        int []evalCountLazy = {12,2,24};
        Expression res;
                              
        Interpreter interpr = new LazyInterpreter();
        Parser pr = new Parser();
        
        System.out.println("lazy interpreter");
        
        for(int i = 0; i < 3; i++) {
            System.out.print(i);
            res = interpr.evalExpr((Expression)pr.parseExpr(exprs[i]));
            assertEquals(res.toString(), expres[i]);
            assertEquals(interpr.getCounter(), evalCountLazy[i]);
        }
        
        interpr = new ActiveInterpreter();
        
        System.out.println("active interpreter");
        
        for(int i = 0; i < 3; i++) {
            System.out.print(i);
            res = interpr.evalExpr((Expression)pr.parseExpr(exprs[i]));
            assertEquals(res.toString(), expres[i]);
            assertEquals(interpr.getCounter(), evalCountAct[i]);
        }
    }
}
