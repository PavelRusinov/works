
package palindrome;

public class PalindromeCaseIndep extends Palindrome
{
    @Override
    public boolean isPalindrome(String str) 
    {
        int fromBeg;
	int fromEnd;
	boolean result;
	
	fromEnd = str.length() - 1;
	fromBeg = 0;
	result = true;
	
	while(fromEnd > fromBeg && result)
	{
		if(!Character.isLetter(Character.toLowerCase(str.charAt(fromEnd))))
		{
			fromEnd = fromEnd - 1;
		}
	
		if(!Character.isLetter(Character.toLowerCase(str.charAt(fromBeg))))
		{
			fromBeg = fromBeg + 1;
		}
		
		if(Character.isLetter(Character.toLowerCase(str.charAt(fromEnd))) && Character.isLetter(Character.toLowerCase(str.charAt(fromBeg))))
		{
			if(Character.toLowerCase(str.charAt(fromEnd)) != Character.toLowerCase(str.charAt(fromBeg)))
			{
				result = false;
			}
			
			else
			{
				fromEnd = fromEnd-1;
				fromBeg = fromBeg+1;
			}
		}
	}
	
	return result;
    }
}
