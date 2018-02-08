

public abstract class Employee extends Person
{
    private double salary; 

    public Employee(String givenName, double startingSalary)
    {
        super(givenName);
        salary = startingSalary; 
        //order does matter the super must be first. Wont compile if you flip the two 
    }
    
    public double getSalary()
    {
        return salary; 
    }

}
