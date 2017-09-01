
import acm.program.*;

public class ThermoRunner extends ConsoleProgram
{

    public void run()
    {
        Thermostat therm = new Thermostat(60, 90);
        println("The current value is " + therm.getValue());

        int num = readInt("How many times do you want to press warmer? ");
        for (int i=0; i<num; i++)
        {
            therm.warmer();
        }
        println("The current value is " + therm.getValue());
        
        num = readInt("How many times do you want to press colder? ");
        for (int i=0; i<num; i++)
        {
            therm.colder();
        }
        println("The current value is " + therm.getValue());
    }

}
