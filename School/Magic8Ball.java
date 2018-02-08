

public class Magic8Ball implements Advisor
{

    
    public String giveAdvice(Student student)
    {
        return student.getName() + " you should ask again?"; 
    }


}
