
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
       
        return new Fraction(this.numerator*other.numerator, this.denominator*other.denominator); 
        
    }
    public Fraction add(Fraction other) 
    {
        int n = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int d = (this.denominator * other.denominator);
        Fraction added = new Fraction(n, d); 
        return added; 
    }
    
    public Fraction cubed()
    {
        return multiply(multiply(this)); 
    }
    
    public String toString()
    {
        return numerator + "/" + denominator; 
    }
    
}
