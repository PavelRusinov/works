
package email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isEmail {
    
    public boolean isEmail(String str){
        if (str == null) {
            return false;
        }
        
        Pattern p;
        String beg = "[a-zA-Z]{1}[a-zA-Z\\d]*([\\u002E\\u005F]{1}[a-zA-Z\\d]+)*"; /*до @*/
        String mid = "@([a-zA-Z]+\\u002E)+"; /*@ и домены (кроме первого уровня) + точка*/
        String end = "((info)|(mobi)|(name)|([a-zA-Z]{1,3}))"; /*домены первого уровня*/
        p = Pattern.compile(beg+mid+end);
        Matcher m = p.matcher(str);
        
        return m.matches();
    }
}
