
package main;

import interpreter.*;
import interpreter.nodes.*;
import interpreter.parser.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Parser p = new Parser();
        LazyInterpreter i = new LazyInterpreter();
        Node n = p.parseExpr("let x = 2*2-3 in x+x");
        n = i.evalExpr((Expression)n);
        System.out.print(((Numb)n).getValue() + " " + i.getCounter());
        
    }
}
