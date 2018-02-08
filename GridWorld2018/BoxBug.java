
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color; 

public class BoxBug extends Bug
{
    private int sideLength;
    private int steps; 

    public BoxBug(int side)
    {
        setColor(Color.blue);
        sideLength = side; 
        steps = 0; 
    }
    //override the act method from the Bug class/superclass
    public void act()
    {
        if(canMove() && steps<sideLength)
        {
            move(); 
            steps++; 
        }else
        {
            turn(); 
            turn(); 
            steps = 0; 
        }
    }


}
