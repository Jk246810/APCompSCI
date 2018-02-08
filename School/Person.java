
public abstract class Person
{
    //can write some of the methods but not all of them 
    private String name; 
    
    public Person(String givenName)
    {
        name = givenName; 
    }
    
    public String getName()
    {
        return name;
        
    }
    
    public abstract void doWork(double hours); 
}
