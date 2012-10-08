package palindrome;

import static org.junit.Assert.*;
import org.junit.Test;

public class PalindromeCaseIndepTest {
    
    public PalindromeCaseIndepTest() {
    }

    @Test
    public void emptyStr() {
        System.out.println("empty string");
        String str = "";
        PalindromeCaseIndep instance = new PalindromeCaseIndep();
        boolean expResult = true;
        boolean result = instance.isPalindrome(str);
        assertEquals(expResult, result);
    }
    
    @Test
    public void hidChar() {
        System.out.println("hidden characters");
        String str = "?#";
        PalindromeCaseIndep instance = new PalindromeCaseIndep();
        boolean expResult = true;
        boolean result = instance.isPalindrome(str);
        assertEquals(expResult, result);
    }
    
    @Test
    public void isPalindroms() {
        System.out.println("strings are palindroms");
        String str[] = {"asa", "asdffdsa", "madam, i'm adam", "saippuakauppias",
        "Sum summus mus", "67a6", "gre%erg", "br^ty&ytr*b", "1as44as1"};
        PalindromeCaseIndep instance = new PalindromeCaseIndep();
        boolean expResult = true;
        boolean result = true;
        int i;
        for(i = 0; i < 8; i++){
            result = result && instance.isPalindrome(str[i]);
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void notPalindroms() {
        System.out.println("strings aren't palindroms");
        String str[] = {"a  sad", "asd4gfdsa", "vasdffd &sa1", "vsaippakaupp5ias",
        "vSumfgh summus 34mus", "v676g6", "gre%Frervgy", "vbr^ty&yyhtr*b", "v1ashv44as1"};
        PalindromeCaseIndep instance = new PalindromeCaseIndep();
        boolean expResult = false;
        boolean result = false;
        int i;
        for(i = 0; i < 8; i++){
            result = result || instance.isPalindrome(str[i]);
        }
        assertEquals(expResult, result);
    }
}
