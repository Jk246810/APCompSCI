
import acm.program.*;

public class Ponies extends ConsoleProgram
{

    public void run()
    {
        String name;
        name = readLine("What is your name? ");
        int numPonies;
        numPonies = readInt("How many ponies? ");
        int numLegs = numPonies * 4;
        println("Good afternoon, " + name + ". Welcome to the pony leg calculator!");
        println("You have " + numPonies + " ponies.");
        println("There are " + numLegs + " legs.");
    }


}
