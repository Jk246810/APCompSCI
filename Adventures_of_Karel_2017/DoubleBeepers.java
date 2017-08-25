
import stanford.karel.*;

public class DoubleBeepers extends Karel
{
    

    public void run()
    {
        move();
        doubleBeepersInPile();
        moveBackwards();

    }
    
    public void moveBackwards()
    {
        turnAround();
        move();
        turnAround();
    }
    
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
    
    public void doubleBeepersInPile()
    {
        makePileTwiceAsBigNextDoor();
        copyNextDoorPileBack();
    }
    
    public void makePileTwiceAsBigNextDoor()
    {
        while(beepersPresent())
        {
            pickBeeper();
            putTwoBeepersNextDoor();
        }
    }
    
    public void putTwoBeepersNextDoor()
    {
        move();
        putBeeper();
        putBeeper();
        moveBackwards();
    }
    
    public void copyNextDoorPileBack()
    {
        move();
        while(beepersPresent())
        {
            pickBeeper();
            moveBackwards();
            putBeeper();
            move();
        }
        moveBackwards();
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
