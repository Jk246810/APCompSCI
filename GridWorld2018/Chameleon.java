
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color; 
import java.util.ArrayList; 

public class Chameleon extends Critter
{

    public Chameleon()
    {
        setColor(Color.white);
    }
    public void processActors(ArrayList<Actor> actors)
    {
        if(actors.size() > 0)
        {
            int index = (int)(Math.random()*actors.size()); 
            Actor a = actors.get(index); 
            Color c = a.getColor(); 
            setColor(c); 
        }
    }
    
    public void makeMove(Location loc)
    {
        Location current = getLocation();
        int dir = current.getDirectionToward(loc);
        setDirection(dir); 
        super.makeMove(loc);
    }

}
