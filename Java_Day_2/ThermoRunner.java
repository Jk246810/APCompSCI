
import acm.program.*;

public class ThermoRunner extends ConsoleProgram
{

    public void run()
    {
        Thermostat therm = new Thermostat(60, 90);
        println("current value is " + therm.getValue());
        
        int num = readInt("How many times do you want to press the warmer?");
        for (int i=0; i<num; i++)
        {
            therm.warmer();
        }
        
       num = readInt("How many times do you want to press the colder?");
        for (int i=0; i<num; i++)
        {
            therm.colder();
        }
        
        println("Now the current value is " + therm.getValue());
    }


}
