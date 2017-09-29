
import acm.program.*;

public class ChangesMaker extends ConsoleProgram
{

    public void run()
    {
        double cost = readDouble("Enter the cost of the item: ");
        double paid = readDouble("Enter the amount paid: ");
        if (cost > paid)
        {
            println("insuffiecient funds!");
        }else 
        {
            double change = paid - cost;
            int cents = (int)(change*100+0.5);
            int dollars = cents/100;
            cents = cents % 100;
            int quarters = cents/25;
            cents = cents % 25;
            int dimes = cents / 10; 
            cents = cents % 10;
            int nickels = cents/5;
            int pennies = cents % 5;
            
            println("Your Change is " + dollars + " dollars " 
                                      + quarters + " quarters " 
                                      + nickels + " nickels " 
                                      + pennies + " pennies"); 
                                      
           //sometimes it is a penny off because at times doubles are inexact 
        }
    }


}
