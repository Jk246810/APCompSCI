
import stanford.karel.*;

public class HurricaneDamage extends Karel
{

    public void run()
    {
        findRubble();
        

    }
    
    public void findRubble()
    {
      
            while (noBeepersPresent())
            {
                move();
            }
       
            pickBeeper();
            buildHouse();
     
    }
    
    public void buildHouse()
    {
       
        turnAround();
        //
        move();
        turnRight();
        buildPillar();
        //
        turnRight();
        move();
        turnLeft();
        //
        move();
        turnAround();
        move();
        buildPillar();
        //
        turnLeft();
        move();
        turnLeft();
        //move();
        buildPillar();
        turnAround();
        move();
        move();
        move();
        turnLeft();
        if (frontIsClear())
        {
            move();
           
            findRubble();
        }
 
    }
    
    public void buildPillar()
    {
        for (int i=0; i<3; i++)
        {
            putBeeper();
            move();
        }
    }
    
    public void turnRight()
    {
        for (int i=0; i<3; i++)
        {
            turnLeft();
        }
    }
    
    public void turnAround()
    {
        for (int i=0; i<2; i++)
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
