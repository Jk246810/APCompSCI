
import acm.program.*;

public class FractionProgram extends ConsoleProgram
{
 
    public void run()
    {
        Fraction a = new Fraction(3, 8);
        Fraction b = new Fraction(5, 6);
        Fraction c = a.add(b);
        Fraction d = a.reciprocal();
        Fraction e = a.multiply(b);
        Fraction f = a.divide(b);
        Fraction g = b.cubed();
        println("a = " + a.toString());
        println("b = " + b.toString());
        println("c = " + c.toString());
        println("d = " + d.toString());
        println("e = " + e.toString());
        println("f = " + f.toString());
        println("g = " + g);

    }

}
