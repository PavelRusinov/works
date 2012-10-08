
package email;

import static org.junit.Assert.*;
import org.junit.Test;

public class isEmailTest {
    
    public isEmailTest() {
    }

    @Test
    public void nullStr() {
        System.out.println("Empty String");
        String str = null;
        isEmail instance = new isEmail();
        boolean expResult = false;
        boolean result = instance.isEmail(str);
        assertEquals(expResult, result);
    }
    @Test
    public void emptyStr() {
        System.out.println("Empty String");
        String str = "";
        isEmail instance = new isEmail();
        boolean expResult = false;
        boolean result = instance.isEmail(str);
        assertEquals(expResult, result);
    }
    @Test
    public void correctEmails() {
        int i;
        System.out.println("Correct emails");
        String emails[] = {"asd@mail.ru", "asd.asd@std.gmail.ru", "asd_asd@std.gmail.ru",
        "as12as@asda.name", "asd_asd.dsa@asd.com", "aa_aa_da@rwe.info", "as_12@wqe.mobi"};
        isEmail instance = new isEmail();
        boolean expResult = true;
        boolean result = true;
        for(i = 0; i < 6; i++){
            result = result && instance.isEmail(emails[i]);
        }
        assertEquals(expResult, result);
    }
    @Test
    public void incorrectEmails() {
        int i;
        System.out.println("Incorrect emails");
        String emails[] = {"asd.@mail.ru", "asd#d9@asas.ru",
        "gfhf@.com",".@ert.ety","1asd@ilfghj.com", "sdfsdfs", 
        "ertw@dfd..name", "adad@werw.tyut"};
        isEmail instance = new isEmail();
        boolean expResult = false;
        boolean result = false;
        for(i = 0; i < 7; i++){
            result = result || instance.isEmail(emails[i]);
        }
        assertEquals(expResult, result);
    }
}
