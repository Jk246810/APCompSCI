
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color; 
import java.util.ArrayList; 

public class RockEater extends Critter
{

    public RockEater()
    {
        setColor(Color.gray); 
    }
    
    public void processActors(ArrayList<Actor> actors)
    {
        for(int i=0; i<actors.size(); i++)
        {
            if(actors.get(i) instanceof Rock) 
            {
                actors.get(i).removeSelfFromGrid(); 
            }
        }
    }


}
