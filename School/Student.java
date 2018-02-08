

public class Student extends Person 
{

    public Student(String givenName)
    {
        super(givenName); 
        
    }
    
    public void doWork(double hours)
    {
        System.out.println(getName() + " just completed " + (2*hours) + " homework assignment."); 
    }


}
