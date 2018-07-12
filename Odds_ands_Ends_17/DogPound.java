
import acm.program.*;
import java.util.*;

public class DogPound extends ConsoleProgram
{

    public void run()
    {
        String[] possibleNames = {"Fido", "Rex", "Lucky", "Archie", "Bojangles", "Max", "Snoopy", "Champ", "Mufasa"};
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        for (int i=0; i<101; i++)
        {
           Dog d = new Dog(possibleNames[(int)(Math.random()*possibleNames.length)]);
           dogs.add(d);
        }
        
        for (Dog d : dogs)
        {
           println(d.getName() + " " + d.getTagNumber() + " " +
                   Dog.getSound() + " " + Dog.isHappyToSeeYou());
        }
    }


}
