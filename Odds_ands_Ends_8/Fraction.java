
public class Fraction
{
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    /**  This method automatically reduces the fraction, using
     *   a "greatest common factor" method discovered by Euclid.
     *   (How cool and historic!)
     */
    private void reduce()
    {
        int gcf = numerator;
        int temp = denominator;
        while (temp != 0) 
        {
            if (gcf > temp)
                gcf -= temp;
            else
                temp -= gcf;
        }        
        numerator /= gcf;
        denominator /= gcf;        
    }
    
    public Fraction divide(Fraction other)
    {
        return this.multiply(other.reciprocal()); 
    }
    
    public Fraction reciprocal()
    {
        return new Fraction(denominator, numerator); 
    }
    
    public Fraction multiply(Fraction other)
    {
        return new Fraction(numerator*other.numerator, numerator*other.numerator); 
    }
    
    
}
