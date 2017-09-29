

public class Employee
{
    private String name;
    private double salary;

    public Employee(String startingName, double startingSalary)
    {
        name = startingName;
        salary = startingSalary;
    }
    
    public void raiseSalary(int amount)
    {
        salary += amount;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getSalary()
    {
        return salary;
    }


}
