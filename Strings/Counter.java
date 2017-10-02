
import acm.program.*;

public class Counter extends ConsoleProgram
{

    public void run()
    {
        while(true)
        {
          String phrase = readLine("enter a phrase ");
          int numA = count(phrase, "a");
          println("this phrase has " + numA + " a's");
        }
      
    }
    
    public int count(String phrase, String letter)
    {
        int chops = 0;
        
        while(phrase.indexOf(letter) > -1)
        {
            int index = phrase.indexOf(letter);
            phrase = phrase.substring(index+1);
            chops++;
        }
        return chops;
       
    }
}
