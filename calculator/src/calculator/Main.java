
package calculator;

import exceptions.*;
import java.io.IOException;

public class Main {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws InvalidCharException, NoClBracketException, NoOperandException, DivByZeroException, NoOperatorException, IOException, UnknownIdException, Exception {
        String[] e = {"x = 3+2*(7-3)","y=4","y+x*2"};
        Parser p = new Parser(e);
        int[] res = p.parse();
        int i;
        for(i = 0; i < res.length; i++){
             System.out.println(res[i]);
        }
             
    }
}
