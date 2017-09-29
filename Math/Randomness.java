
import acm.program.*;

public class Randomness extends ConsoleProgram
{

    public void run()
    {
        while(true)
        {
            int num = (int)(Math.random()*10 + 1);
            println(num);
            pause(100);
        }

    }


}
