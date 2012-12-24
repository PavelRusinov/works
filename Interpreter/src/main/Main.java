
package main;

import interpreter.*;
import interpreter.nodes.*;
import interpreter.parser.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Parser p = new Parser("let y=6*23-7 in 5");
        NormalInterpreter i = new NormalInterpreter();
        Node n = p.parseExpr();
        n = i.eval((Expression)n);
        System.out.print(((Numb)n).getValue());
        
    }
}
