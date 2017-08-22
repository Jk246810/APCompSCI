
import stanford.karel.*;

public class MailToChair extends Karel
{

    public void run()
    {
        move(); 
        turnLeft(); 
        move(); 
        threeLeft();
        move();
        pickBeeper();
        twoleft();
        bigMove();
        putBeeper();
        twoleft();
        move();
        threeLeft();
        move();
        turnLeft();
    }
    
    public void bigMove()
    {
        move();
        move();
        move(); 
    }
    public void threeLeft() 
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void twoleft()
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
