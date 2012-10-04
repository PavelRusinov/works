
package email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   
    public static void main(String[] args) throws IOException {
        isEmail s = new isEmail();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        System.out.println(s.isEmail(str));
    }
}
