
import stanford.karel.*;

public class MountainClimber extends Karel
{

    public void run()
    {
        moveToWall(); 
        climbMountain();
        moveToWall();
        
    }
    
    public void moveToWall()
    {
        while(frontIsClear()) {
            move();
        }
    }
    
     public void climbMountain()
    {
      ascendMountain();
      putBeeper();
      descendMountain();
    }
    
    public void ascendMountain()
    {
        while(frontIsBlocked()) 
        {
           goUpOneStep(); 
        }
    }
    
    public void goUpOneStep()
    {
        turnLeft();
            move();
            turnRight();
            move();
    }
    
    public void turnRight()
    {
        for (int i=0; i<3; i++)
        {
            turnLeft();
        }
    }
     
    public void descendMountain()
    {
      move();
      while (rightIsClear())
      {
          goDownOneStep();
      }
    }
    
    
    public void goDownOneStep()
    {
        turnRight();
        move();
        turnLeft();
        move();
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
