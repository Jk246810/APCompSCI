
import acm.program.*;

public class quadForm extends ConsoleProgram
{

    public void run()
    {
        double a = readDouble("Enter A: ");
        double b = readDouble("Enter B: ");
        double c = readDouble("Enter C: ");
        
        if (Math.pow(b,2)-4*a*c<0)
        {
            println("none");
        }else
        {
            double x1 = (-b + Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
            double x2 = (-b + Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
        
            println("solutions:" + x1 + " and" + x2);
        }
    }


}
