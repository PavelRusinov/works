
package palindrome;

import static org.junit.Assert.*;
import org.junit.Test;

public class PalindromeCaseDepTest {
    
    public PalindromeCaseDepTest() {
    }

    @Test
    public void emptyStr() {
        System.out.println("empty string");
        String str = "";
        PalindromeCaseDep instance = new PalindromeCaseDep();
        boolean expResult = true;
        boolean result = instance.isPalindrome(str);
        assertEquals(expResult, result);
    }
    
    @Test
    public void hidChar() {
        System.out.println("hidden characters");
        String str = "?#";
        PalindromeCaseDep instance = new PalindromeCaseDep();
        boolean expResult = true;
        boolean result = instance.isPalindrome(str);
        assertEquals(expResult, result);
    }
    
    @Test
    public void isPalindroms() {
        System.out.println("strings are palindroms");
        String str[] = {"AsA", "ASDFFDSA", "MadaM, I'M adaM", "saippuakauppias",
        "Sum suMMus muS", "67a6", "gre%erg", "Br^Ty&yTr*B", "1aD44Da1"};
        PalindromeCaseDep instance = new PalindromeCaseDep();
        boolean expResult = true;
        boolean result = true;
        for(String t: str){
            result = result && instance.isPalindrome(t);
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void notPalindroms() {
        System.out.println("strings aren't palindroms");
        String str[] = {"a  sad", "ASDFFDSa", "vFsdffd &sa1", "vsaippakaupp5ias",
        "vSumfgh summus 34mus", "v676g6", "Gre%eRg", "vbr^ty&yyhtr*b", "1AD44Da1"};
        PalindromeCaseDep instance = new PalindromeCaseDep();
        boolean expResult = false;
        boolean result = false;
      
        for(String t : str){
            result = result || instance.isPalindrome(t);
        }
        assertEquals(expResult, result);
    }
}
