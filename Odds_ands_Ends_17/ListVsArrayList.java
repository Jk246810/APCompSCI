
import acm.program.*;
import java.util.*;

public class ListVsArrayList extends ConsoleProgram
{
 
    public void run()
    {
        List<String> fruits;
        if (Math.random()<0.5)
            fruits = new ArrayList<String>();
        else
            fruits = new LinkedList<String>();  // another kind of List!
        
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
                println(fruit);
        }
    }


}
