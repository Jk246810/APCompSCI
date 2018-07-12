

public class Dog
{
    //private instance variable 
    private String name;
    private int tagNumber; 
    
    //private static Borg variables 
    private static String sound = "Woof";
    private static int nextAvailableTagNumber = 100; 
    public Dog(String givenName)
    {
        name = givenName;
        this.tagNumber = Dog.nextAvailableTagNumber;
        Dog.nextAvailableTagNumber++; 
        

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
        //not allowed to put private instance variables in a static method
        return Dog.sound; 
    }
    
    public static boolean isHappyToSeeYou()
    {
        return true; 
    }


}
