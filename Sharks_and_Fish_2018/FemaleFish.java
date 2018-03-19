import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

//Jamee and Teddy, Period C

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
        super();  
        setColor(Color.PINK);
        turnsPregnant = 0; 

    }

    public void act()
    {
        super.act();
        if (turnsPregnant >0)
        {
            setColor(Color.RED);
            turnsPregnant++;
        }
        else
            setColor(Color.PINK);

        if (turnsPregnant == GESTATIONPERIOD)
            giveBirth();

       
    }

    public void giveBirth()
    {
        ArrayList<Fish> fishies = new ArrayList<Fish>();
        for (int i=0; i<numBabies; i++)
        {
            double random = (Math.random());
            
            if (random<.5)
             fishies.add(new MaleFish());
            else 
              fishies.add(new FemaleFish()); 
            
        }
        
       ArrayList<Location> locations = getMoveLocations(); 
       
       while(fishies.size()>0 && locations.size()>0)
       {
           int index = (int)(Math.random()*locations.size());
           fishies.get(0).putSelfInGrid(getGrid(), locations.get(index)); 
           locations.remove(index);
           fishies.remove(0);
           numBabies--;
        }
       if(fishies.size()==0)
       {
           turnsPregnant = 0; 
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
