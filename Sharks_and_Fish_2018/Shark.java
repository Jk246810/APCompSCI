
import info.gridworld.actor.Critter;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import java.awt.Color;
import info.gridworld.grid.*;

public class Shark extends Critter
{
    // constants
    private static final int MUSTEAT = 8;

    // private instance variables
    private int turnsSinceEaten;

    public Shark()
    {
        setColor(Color.black);
    }

    public void act()
    {
        if (getActors().size()>0)
            processActors(getActors());
        else
            makeMove(selectMoveLocation(getMoveLocations()));
        if (turnsSinceEaten > MUSTEAT)
        removeSelfFromGrid();
    }

    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> result = super.getActors();
        for (int i=0; i<result.size(); i++)
        {
            if (!(result.get(i) instanceof Fish))
            {
                result.remove(i);
                i--;
            }

        }

        return result;

    }

    public ArrayList<Location> getMoveLocations()
    {

        ArrayList<Location> result = new ArrayList<Location>();

        Location current = getLocation();
        int dir = getDirection();
        Grid<Actor> grid = getGrid();
        Location front = current.getAdjacentLocation(dir + Location.AHEAD);
        if (grid.isValid(front) && grid.get(front)==null)
            result.add((front));
        Location topLeft = current.getAdjacentLocation(dir + Location.LEFT);
        if (grid.isValid(topLeft) && grid.get(topLeft) == null)
            result.add((topLeft));
        Location topRight = current.getAdjacentLocation(dir + Location.RIGHT);
        if (grid.isValid(topRight) && grid.get(topRight) == null)
            result.add((topRight));

        return result; 

    }

    public void processActors(ArrayList<Actor> actors)
    {
        if (actors.size()>0)
        {
            int index = (int)(Math.random()*actors.size());
            Actor fish = actors.get(index);

            fish.removeSelfFromGrid();
            turnsSinceEaten=0; 
        }
        
    }



    public void makeMove(Location loc)
    {
        Location current = getLocation();
        if (current.equals(loc))
        {
            int dir = current.getDirectionToward(loc);
            double rand = (Math.random());
            if (rand<0.5)
                setDirection(dir + Location.HALF_LEFT);
            else 
                setDirection(dir+ Location.HALF_RIGHT);

        }
        else
        {
             
        int dir = current.getDirectionToward(loc);
        setDirection(dir);
            super.makeMove(loc);
        }
        turnsSinceEaten++;
    }

    // finish this up

}
