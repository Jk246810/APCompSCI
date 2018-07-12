
import acm.program.*;
import java.util.*;
import java.io.*;

public class ReadingFromFiles extends ConsoleProgram
{

    public void run()
    {
        try{
            String champion = ""; 
        File file =  new File("polymorphism_test.txt"); 
        Scanner scanner = new Scanner(file); 
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine(); 
            String[] words = line.split(" "); 
            for( String word: words)
            {
                if(word.compareTo(champion)>0)
                    champion = word;  
            }
            println("the last word alphabetucally is " + champion); 
        }}
        catch(Exception exception)
        {
            println("something went horribly wrong"); 
            println("let me tell you what happened: "); 
            println(exception.toString());
        }

    }

}
