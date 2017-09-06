
import acm.program.*;

public class HappyBirthday extends ConsoleProgram
{

    public void run()
    {
        sing("Chris Christie");
        // chris christy is an actual parameter
        sing("Jeff Adams");
        
        sing("Jane Addams");
        sing("Pippa Middleton");
    
    }

    public void sing(String name)
    //String name is a formal parameter
    {
        
        println("Happy birthday to you");
        println("Happy birthday to you");
        println("Happy birthday dear " + name);
        println("Happy birthday to you");
        println();
        
    }

}
