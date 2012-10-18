
package palindrome;

public abstract class Palindrome {
    
    public abstract boolean compare(char e, char b);  
    
    public boolean isPalindrome(String str){
        int fromBeg;
	int fromEnd;
	boolean result;
	
	fromEnd = str.length() - 1;
	fromBeg = 0;
	result = true;
	
	while(fromEnd > fromBeg && result)
	{
		if(!Character.isLetter(str.charAt(fromEnd)))
		{
			fromEnd = fromEnd - 1;
		}
	
		if(!Character.isLetter(str.charAt(fromBeg)))
		{
			fromBeg = fromBeg + 1;
		}
		
		if(Character.isLetter(str.charAt(fromEnd)) && Character.isLetter(str.charAt(fromBeg)))
		{
			if(compare(str.charAt(fromEnd), str.charAt(fromBeg)))
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
