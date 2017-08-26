
import stanford.karel.*;

public class MidpointFinder extends Karel
{
    

    public void run()
    {
       findMidpoint();
    }
    
    public void findMidpoint()
    {
        setUpRowOfBlocks();
        pickBeeper();
        turnAround();
        move();
        checkIfNoBeepersPresent();
    }
    public void setUpRowOfBlocks()
    {
        while(frontIsClear())
        {
            move();
            putBeeper();
        }
     
    
    }
    
    public void checkIfNoBeepersPresent()
    {
        while(beepersPresent())
        {
            move();
        }
        collectBlocks();
    }
    
    public void collectBlocks()
    {
        turnAround();
        move();
        while(beepersPresent())
        {
           pickBeeper();
           move();
           checkIfNoBeepersPresent();
        }
    }
    
    public void turnAround()
    {
        for(int i=0; i<2; i++)
        {
            turnLeft();
            
        }
    }

    /* IGNORE THE CODE BELOW.  (Don't delete it, but we
     * had to include it to get Karel to play nicely with
     * BlueJ.  You don't need to understand what it means
     * at all.  */
    public static void launchKarelEnvironment()
    {
        String[] args = new String[1];
        String name = new SecurityManager() {
            public String className() 
                {return this.getClassContext()[1].getCanonicalName();}
            }.className();
        args[0] = "code=" + name;         
        Karel.main(args);
    }
}
