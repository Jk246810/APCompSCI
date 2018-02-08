import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color; 
import java.util.ArrayList; 

public class Crab extends Critter
{

    public Crab()
    {
        setColor(Color.red);
        

    }
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> result = new ArrayList<Actor>();
        Location current = getLocation();
        int dir = getDirection();
        Grid<Actor> grid = getGrid();
        //check front
        Location front = current.getAdjacentLocation(dir);
        if(grid.isValid(front) && grid.get(front)!=null)
        {
            result.add(grid.get(front)); 
          
        }
        //check left
        Location left = current.getAdjacentLocation(dir+Location.HALF_LEFT);
        if(grid.isValid(left) && grid.get(left)!=null)
        {
            result.add(grid.get(left)); 
          
        }
        
        Location right = current.getAdjacentLocation(dir+Location.HALF_RIGHT);
        if(grid.isValid(right) && grid.get(right)!=null)
        {
            result.add(grid.get(right)); 
          
        }
        
        return result;
        
    }
    
    public void processActors(ArrayList<Actor> actors)
    {
        if(actors.size()>0)
        {
            int index = (int)(Math.random()*actors.size());
            Actor a = actors.get(index);
            if(!(a instanceof Rock) && !(a instanceof Critter))
                a.removeSelfFromGrid();
        }
    }
    
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> result = new ArrayList<Location>();
        Location current = getLocation();
        int dir = getDirection();
        Grid<Actor> grid = getGrid();
        
        Location left = current.getAdjacentLocation(dir + Location.LEFT);
        if(grid.isValid(left) && grid.get(left) == null)
        {
            result.add(left); 
        }
        
        Location right = current.getAdjacentLocation(dir + Location.RIGHT);
        if(grid.isValid(right) && grid.get(right) == null)
        {
            result.add(right); 
        }
        
        return result;
    }
    
    public void makeMove(Location loc)
    {
        Location current = getLocation();
        if(current.equals(loc))
        {
            int dir = getDirection();
            if(Math.random()<0.5)
            {
                setDirection(dir + Location.LEFT);
                
            }else 
            {
                setDirection(dir + Location.RIGHT);
            }
        }else 
        {
            super.makeMove(loc); 
        }
    }


}
