import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class FemaleFish extends Fish
{
    // constants
    private final static int GESTATIONPERIOD = 5;
    private final static int MAXBABIES = 4;

    // private instance variables
    private int numBabies;
    private int turnsPregnant;

    public FemaleFish()
    {
        super();  // needed to call Fish constructor, which initializes age
        setColor(Color.PINK);

    }

    public void act()
    {
        if (turnsPregnant >0)
        {
            setColor(Color.RED);
            turnsPregnant++;
        }
        else
            setColor(Color.PINK);

        if (turnsPregnant = GESTATIONPERIOD)
            giveBirth();

        // finish this up
    }

    public void giveBirth()
    {
        ArrayList<Fish> fishies = new ArrayList<Fish>();
        for (int i=0; i<numBabies; i++)
        {
            int random = (Math.random());
            
            if (random<.5)
              MaleFish boy = new MaleFish();
           // fishies.add(
            
            
            
        }
        
        
        
        
    }

    public void processActors(ArrayList<Actor> actors)
    {

        if (actors.size()>0)
        {
            for (int i=0; i<actors.size(); i++)
            {
                if (actors.get(i) instanceof MaleFish)
                {
                    if(((MaleFish)actors.get(i)).getAge()>= BREEDAGE && turnsPregnant==0)
                    {
                        turnsPregnant =1; 
                        numBabies = (int)(Math.random()*MAXBABIES+1);

                    }

                }
            }

        }

    }

}
