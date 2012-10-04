
package email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isEmail {
    
    public boolean isEmail(String str){
        if (str == null) {
            return false;
        }
        
        Pattern p;
        p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org)|(ru))");
        Matcher m = p.matcher(str);
        
        return m.matches();
    }
}
