

public class ClassModerator extends Teacher implements Advisor
{

    public ClassModerator(String givenName)
    {
        super(givenName); 
        
    }
    
    public String giveAdvice(Student student)
    {
        return student.getName() + ", you should be nice to everyone."; 
    }

}
