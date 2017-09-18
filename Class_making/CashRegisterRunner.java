
import acm.program.*;

public class CashRegisterRunner extends ConsoleProgram
{

    public void run()
    {
        CashRegister register = new CashRegister();
        //public CashRegister
        
        register.recordPurchase(29.50);
        register.recordPurchase(79.25);
        //void, takes a double parameter
        register.enterPayment(50);
        // void, takes an int parameter
        double change = register.giveChange();
        //returns a double
        println(change);
     
    }


}
