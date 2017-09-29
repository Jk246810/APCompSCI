

public class WaterPuzzle
{
    private int jugA;
    private int jugB;

    public WaterPuzzle()
    {
        jugA = 0;
        jugB = 0;
    }
    
    public void fill(String whichJug)
    {
        if(whichJug.equals("A"))
        {
            jugA = 5;
        }
        else 
        {
            jugB = 3;
        }
    }
    
    public void empty(String whichJug)
    {
        if(whichJug.equals("A"))
        {
            jugA = 0;
        }else
        {
            jugB = 0;
        }
        
    }
    
    public void pourFromAtoB()
    {
        int spaceInA = 5 - jugA;
        if (jugB > spaceInA)
        {
            jugA = 5;
            jugB = jugB - spaceInA;
        }else 
        {
            jugA = jugA + jugB;
            jugB = 0;
        }
        
    }
    
    public void pourFromBtoA()
    {
        int spaceInB = 3 - jugB;
        if (jugA > spaceInB)
        {
            jugB = 3;
            jugA = jugA - spaceInB;
        }else 
        {
            jugB = jugB + jugA;
            jugA = 0;
        }
    }
    public int getAmount(String whichJug)
    {
         if(whichJug.equals("A"))
        {
            return jugA;
        }else
        {
            return jugB;
        }
        
    }


}
