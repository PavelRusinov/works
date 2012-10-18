
package palindrome;

public class PalindromeCaseIndep extends Palindrome
{
    @Override
    public boolean compare(char e, char b){
        return (Character.toLowerCase(e) != Character.toLowerCase(b));
    }
}
