
import acm.program.*;
import java.util.ArrayList; 
public class DogPound extends ConsoleProgram
{

    public void run()
    {
           String[] possibleNames = {"Fido", "Spike", "Spot", "Rex", "Clifford", "buster", "Champ", "lady", "Tramp", "Duke", "Max"}; 
           ArrayList<Dog> dogs = new ArrayList<Dog>(); 
           for(int i=0; i<101; i++)
           {
               int index = (int)(Math.random()*possibleNames.length);
               Dog d = new Dog(possibleNames[index]); 
               dogs.add(d);
            }
            for(Dog dog : dogs)
            {
                println(dog.getName() + " " + dog.getTagNumber() +" " + Dog.getSound() +" " + Dog.isHappyToSeeYou());
            }
    }


}
