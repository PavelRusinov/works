
package email;

import static org.junit.Assert.*;
import org.junit.Test;

public class IsEmailTest {
    
    public IsEmailTest() {
    }

    @Test
    public void nullStr() {
        System.out.println("Null String");
        String str = null;
        IsEmail instance = new IsEmail();
        boolean expResult = false;
        boolean result = instance.IsEmail(str);
        assertEquals(expResult, result);
    }
    @Test
    public void emptyStr() {
        System.out.println("Empty String");
        String str = "";
        IsEmail instance = new IsEmail();
        boolean expResult = false;
        boolean result = instance.IsEmail(str);
        assertEquals(expResult, result);
    }
    @Test
    public void correctEmails() {
        int i;
        System.out.println("Correct emails");
        String emails[] = {"asd@mail.ru", "asd.asd@std.gmail.ru", "asd_asd@std.gmail.ru",
        "as12as@asda.name", "asd_asd.dsa@asd.com", "aa_aa_da@rwe.info", "as_12@wqe.mobi"};
        IsEmail instance = new IsEmail();
        boolean expResult = true;
        boolean result = true;
        for(i = 0; i < 6; i++){
            result = result && instance.IsEmail(emails[i]);
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
        IsEmail instance = new IsEmail();
        boolean expResult = false;
        boolean result = false;
        for(i = 0; i < 7; i++){
            result = result || instance.IsEmail(emails[i]);
        }
        assertEquals(expResult, result);
    }
    @Test
    public void correctEmailsVpolozov() {
        int i;
        System.out.println("Correct emails (edu.vpolozov.name)");
        String emails[] = {"a@b.cc", "victor.polozov@mail.ru", "my@domain.info",
        "_.1@mail.com", "coins@hermitage.museum"};
        IsEmail instance = new IsEmail();
        boolean expResult = true;
        boolean result = true;
        for(i = 0; i < 4; i++){
            result = result && instance.IsEmail(emails[i]);
        }
        assertEquals(expResult, result);
    }
    @Test
    public void incorrectEmailsVpolozov() {
        int i;
        System.out.println("Incorrect emails (edu.vpolozov.name)");
        String emails[] = {"a@b.c", "a..b@mail.ru",
        ".a@mail.ru","yo@domain.domain","1@mail.ru"};
        IsEmail instance = new IsEmail();
        boolean expResult = false;
        boolean result = false;
        for(i = 0; i < 4; i++){
            result = result || instance.IsEmail(emails[i]);
        }
        assertEquals(expResult, result);
    }
}
