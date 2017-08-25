
import stanford.karel.*;

public class MidpointFinder extends Karel
{
    

    public void run()
    {
        int length = 0;
        
        while(frontIsClear())
        {
            move();
            length++;
        }
        
      
      length = (length)/2; 
      
      turnAround();
      for (int i = 0; 1<length; i++)
      {
          while(frontIsClear())
          {
              move();
              putBeeper();
           }
      }
    }
    
    public void turnAround()
    {
        turnLeft();
        turnLeft();
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
