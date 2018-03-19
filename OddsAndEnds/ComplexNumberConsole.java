
import acm.program.*;

public class ComplexNumberConsole extends ConsoleProgram
{

    public void run()
    {
        ComplexNumber x = new ComplexNumber(3,4); 
        ComplexNumber y = new ComplexNumber(-2,5);
         ComplexNumber z = new ComplexNumber(6,-3);
         ComplexNumber r = x.add(y); 
         ComplexNumber s = x.multiply(y);
         ComplexNumber t = x.squared(); 
         println("x= " + x);
         //dont need to string, when we wrote to string we overrode the toString method in Java
         println("y= " + x.toString());
         println("z= " + x.toString());
         println("r= " + x.toString());
         println("s= " + x.toString());
         println("t= " + x.toString());

    }


}
