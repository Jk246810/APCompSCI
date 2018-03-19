
import acm.program.*;

public class BigNumbers extends ConsoleProgram
{

    public void run()
    {
        int num = Integer.MAX_VALUE - 5; 
        //roughly 2 billion, biggest number you can possibly have
        for(int i=0; i<10; i++)
        {
            println(num);
            num++;
        }
        
        //only allocate 32 bits for a number

    }


}
