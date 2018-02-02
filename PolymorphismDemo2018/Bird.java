
public class Bird implements Flier
{
//implements flier means it wants to be a flier by having a fly method.
    private String species;
    
    public Bird(String initialSpecies)
    {
        species = initialSpecies;
    }

    public void fly()
    {
        System.out.println("This " + species + " is using its wings to fly.  Whee!");
    }
    

}
