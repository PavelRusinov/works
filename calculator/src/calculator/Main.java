
package calculator;

import exceptions.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException, IOException {
        Lexer l = new Lexer();
        Parser p = new Parser(l);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while(!(str = in.readLine()).equals("exit")){
            l.newExpr(str + ".");
            System.out.println(p.parse());
        }
        
    }
}
