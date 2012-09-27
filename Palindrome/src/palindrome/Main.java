
package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        String str;
        PalindromeCaseIndep p = new PalindromeCaseIndep();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        str = in.readLine();
        if(str == null) {
            System.out.println("123");
        }
        else {
            if(p.isPalindrome(str)){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
     }
        
}
