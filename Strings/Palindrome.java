
import acm.program.*;

public class Palindrome extends ConsoleProgram
{

    public void run()
    {
        while(true)
        {
            String phrase = readLine("enter phrase ");
            if (isPalindrome(phrase) == true)
            {
                println("that's a palindrome!");
            }else 
            {
                println("that's not a palindrome");
            }
        }
    }
    
    public boolean isPalindrome(String what)
    {
        what = replaceAll(what, " ", "");
        for (int i=0; i<what.length()/2; i++)
        {
            String x = what.substring(i, i+1);
            String y = what.substring(what.length()-i-1, what.length()-i);
            //length return 7 if the word is racecar, but racecar only has 6 (because of 0)
            
            if (x.equalsIgnoreCase(y))
            {
                
            }else 
            {
                return false; 
            }
           
        }
        return true;
    }
    
   public String replaceAll(String phrase, String letter, String symbol)
    {
        while(phrase.indexOf(letter) > -1)
        {
            int index = phrase.indexOf(letter);
            String before = phrase.substring(0,index);
            String after = phrase.substring(index+1);
            phrase = before + symbol + after;
            
            
        }
         return phrase; 
    }
}
