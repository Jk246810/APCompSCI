

public class Paycheck
{
    private double hoursWorked;
    private double hourlyRate;

    public Paycheck(double hours, double rate)
    {
        hoursWorked = hours;
        hourlyRate = rate;
    }

    public double getAmount()
    {
        double basepay = hoursWorked * hourlyRate; 
        if (hoursWorked >= 40.0)
        {
            basepay += (hoursWorked - 40.0) * (0.5*hourlyRate);
            
        }
        
        
        if (basepay < 200)
        {
            basepay -= basepay * .11;
        }else if (basepay <400)
        {
            basepay -= basepay * .15;
        }
        else if (basepay <600)
        {
            basepay -= basepay * .18;
        } else 
        {
            basepay -= basepay * .24;
        }
        
        
        if (basepay <= 14.00) 
        {
            return 0.0; 
        }
        else 
        {
            return basepay - 14; 
        }
        
    }

}
