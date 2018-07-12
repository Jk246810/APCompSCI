
import acm.program.*;
import java.util.ArrayList;

public class ForEachExample extends ConsoleProgram
{

    public void run()
    {
        ArrayList<String> fruits = new ArrayList<String>();
        
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("pear");
        fruits.add("peach");
        fruits.add("strawberry");
        fruits.add("kiwi");
        fruits.add("blueberry");
        fruits.add("mango");
        fruits.add("blackberry");
        fruits.add("watermelon");
        
        for (String fruit : fruits)
        {
            if (fruit.indexOf("berry") != -1)
                fruits.add("broccoli");
        }
    }


}
