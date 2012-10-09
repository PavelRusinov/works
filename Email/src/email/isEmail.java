
package email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsEmail {
    
    public boolean IsEmail(String str){
        if (str == null) {
            return false;
        }
        
        Pattern p;
        String beg = "[a-zA-Z\\u005F]{1}[a-zA-Z\\d]*([\\u002E\\u005F]{1}[a-zA-Z\\d]+)*"; /*до @*/
        String lowLewDom = "@([a-zA-Z]+\\u002E)+"; /*@ и домены (кроме первого уровня) + точка*/
        String longTopLevDom = "((travel)|(jobs)|(coop)|(asia)|(aero)|(info)|(mobi)|(name)|(museum)|"; /*домены верхнего уровня больше 4 символов*/
        String otherTopLevDom = "([a-zA-Z]{2,3}))"; /*остальные домены верхнего уровня*/
        p = Pattern.compile(beg + lowLewDom + longTopLevDom + otherTopLevDom);
        Matcher m = p.matcher(str);
        
        return m.matches();
    }
}
