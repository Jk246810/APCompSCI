
import acm.program.*;

public class BaseballRunner extends ConsoleProgram
{

    public void run()
    {
        BaseballInning inning;
        inning = new BaseballInning(3);
        inning.batterBaseHit(1);
        inning.batterOut();
        println("There are " + inning.getOuts() + " outs.");
        println(inning.getBaseRunners());
    }


}
