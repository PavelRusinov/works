
package palindrome;


public class PalindromeCaseDep extends Palindrome 
{
    @Override
    public boolean compare(char e, char b){
        return (e != b);
    }
}
