
import stanford.karel.*;


//Jamee Krzanich, Period C
public class SpringTime extends Karel
{

    public void run()
    {
  
        for (int i=0; i<5; i++)
       {
           buildFlower();
       }
        
    }
    public void buildFlower()
    {
        moveToStem();
        ascendStem();
        constructFlower();
        descendStem();
    }
    
    public void moveToStem()
    {
       while (frontIsClear()) 
       {
           move();
           
       }
       
    }
    
    public void ascendStem() 
    {
        turnLeft();
        while (rightIsBlocked())
        {
            move();
        }
        
    }
    
    public void constructFlower()
    {
        
        if (rightIsClear())
        {
            putBeeper();
            for (int i=0; i<3; i++)
            {
               
               move();
               putBeeper();
               turnRight(); 

            }
            
        }
        
    }
    
    public void descendStem()
    {
        
        turnLeft();
        
        while (frontIsClear())
        {
            move();
        }
        turnLeft();
        
    }
   
    
    public void turnRight()
    {
        for (int i=0; i<3; i++)
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
