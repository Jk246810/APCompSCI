
import acm.program.*;

public class ComplexNumberTester extends ConsoleProgram
{

    public void run()
    {
        ComplexNumber x = new ComplexNumber(3, 4);
        ComplexNumber y = new ComplexNumber(-2, 5);
        ComplexNumber z = new ComplexNumber(6, -3);
        ComplexNumber q = x.add(y);
        ComplexNumber r = x.multiply(y);
        ComplexNumber s = z.squared();
        println("x = " + x);
        println("y = " + y.toString());
        println("z = " + z.toString());
        println("q = " + q.toString());
        println("r = " + r.toString());
        println("s = " + s.toString());
    }

}
