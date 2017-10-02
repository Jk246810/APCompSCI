
import acm.program.*;

public class Geekifier extends ConsoleProgram
{

    public void run()
    {
        while(true)
        {
            String phrase = readLine("enter phrase ");
            String geekyPhrase = geekify(phrase);
            println(geekyPhrase);
        }
        
    }
    
    public String geekify(String phrase)
    {
        phrase = replaceAll(phrase, "a", "@");
        phrase = replaceAll(phrase, "e", "3");
        phrase = replaceAll(phrase, "s", "$");
        phrase = replaceAll(phrase, "t", "+");
        phrase = replaceAll(phrase, "o", "0");
        phrase = replaceAll(phrase, "c", "©");
        phrase = replaceAll(phrase, "i", "1");
        return phrase;
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
