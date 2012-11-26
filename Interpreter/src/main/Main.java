
package main;


import interpreter.nodes.*;
import interpreter.parser.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Parser p = new Parser("let f = fun x -> fun y -> x + y in f 1 (f 1 (f 1 1))");
        Node n = p.parseExpr();
    }
}
