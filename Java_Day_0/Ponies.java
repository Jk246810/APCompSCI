
import acm.program.*;

public class Ponies extends ConsoleProgram
{

    public void run()
    {
        String name = readLine("What is your name?");
        int numPonies = readInt("How many ponies?");
        int numLegs = numPonies * 4; 
        println("Good afternoon" + name + "Welcome to pony leg calculator");
        println("you have " + numPonies + " ponies");
     
        println("there are "  + numLegs + " legs");
        
    }


}
