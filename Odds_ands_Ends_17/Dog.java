

public class Dog
{
    // private instance variables
    private String name;
    private int tagNumber;
    
    // private static (BORG) variables
    private static String sound = "bark";
    private static int nextAvailableTagNumber = 100;

    public Dog(String givenName)
    {
        name = givenName;
        this.tagNumber = Dog.nextAvailableTagNumber;
        nextAvailableTagNumber++;
    }
    
    public String getName()
    {
        return name;   
    }
    
    public int getTagNumber()
    {
        return tagNumber;   
    }
    
    public static String getSound()
    {
        return Dog.sound;
    }
    
    public static boolean isHappyToSeeYou()
    {
       return true; 
    }


}
