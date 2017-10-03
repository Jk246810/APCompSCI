
import acm.program.*;

public class CelebrityGame extends ConsoleProgram
{

    public void run()
    {
        while(true)
        {
            String phrase = readLine("enter the name of a celebrity: ");
            for (int i=0; i<100; i++)
            {
                println("");
            }
            
            int index = phrase.indexOf(" ");
            
            String hintFirst = phrase.substring(index-2, index);
            
            String hintLast = phrase.substring(index+1, index+4);
            
            println("Here's your clue: " + hintFirst + " " + hintLast);
            
            String guess = readLine("enter your guess: ");
            
            if (guess.equalsIgnoreCase(phrase))
            {
                println("Correct!");
            }else 
            {
                println("Wrong! the celebrity was " + phrase);
            }
        }
    }

}
