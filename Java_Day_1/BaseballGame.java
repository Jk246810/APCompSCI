
import acm.program.*;
//Jamee Krzanich, Period C
public class BaseballGame extends ConsoleProgram
{

    public void run()
    {
        BaseballInning inning = new BaseballInning(3);
        inning = new BaseballInning(3);
        inning.batterBaseHit(1);
        
        inning.batterOut();
        println("There are " + inning.getOuts() + " outs.");
        println(inning.getBaseRunners());
        
        println("the current batter is " + inning.getCurrentBatter());
        println("there have been " + inning.getRuns() + " runs");
        

    }


}
