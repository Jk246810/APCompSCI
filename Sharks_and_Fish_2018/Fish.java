
import info.gridworld.actor.Critter;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import java.awt.Color;
import info.gridworld.grid.*;

public class Fish extends Critter
{
    // constants (note that this are "protected", so they are
    // available in subclasses of Fish)
    protected final static int BREEDAGE = 5;
    protected final static int OLDAGE = 15;
    protected final static double PROBOFDYING = 0.20;

    // private instance variales
    private int age;
        
    public Fish()
    {
        
       age=0;
       
    }
    
    
    public void act()
    {
        super.act();
        age++;
        if (age >= OLDAGE)
        {
            if (Math.random() <.2)
            removeSelfFromGrid();
            
        }
        
    }
    
    public void processActors(ArrayList<Actor> actors)
    {
        return; 
    }
    
    
    
    public int getAge()
    {
        return age;
        
    }
    
    // finish this up
    
}
