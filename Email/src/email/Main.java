
package email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   
    public static void main(String[] args) throws IOException {
        IsEmail s = new IsEmail();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        System.out.println(s.IsEmail(str));
    }
}
