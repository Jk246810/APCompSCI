
import acm.program.*;

public class BigNumbers extends ConsoleProgram
{

    public void run()
    {
        long num = Integer.MAX_VALUE;
        for (int i=0; i<10; i++)
        {
            println(num);
            num++;
        }
    }


}
