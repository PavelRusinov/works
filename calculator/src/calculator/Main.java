
package calculator;

import exceptions.*;
import java.io.IOException;

public class Main {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException, IOException, UnknownIdException, Exception {
        String[] e = {"3+2*(7-3)4"};
        Parser p = new Parser(e);
        int[] res = p.parse();
        int i;
        for(i = 0; i < res.length; i++){
             System.out.println(res[i]);
        }
             
    }
}
