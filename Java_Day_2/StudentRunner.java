
import acm.program.*;

public class StudentRunner extends ConsoleProgram
{

    public void run()
    {
        Student stud = new Student("Bob");
        stud.takeQuiz(90);
        stud.takeQuiz(36);
        stud.takeQuiz(4);
        println("your average is " + stud.quizAverage());
        String name = stud.getName();
        println(name.toUpperCase() + " is great!");

    }


}
