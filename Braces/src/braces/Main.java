
package braces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException, Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        CheckBraces s = new CheckBraces();
        System.out.print(s.check(str));
        
    
    }
    
}
