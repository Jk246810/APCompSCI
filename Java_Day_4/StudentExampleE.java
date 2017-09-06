
import acm.program.*;

public class StudentExampleE extends ConsoleProgram
{

    public void run()
    {
        Student senior;
        senior = new Student("CJ");
        
        takeSeveralQuizzes(senior);
        
        println(senior.getName() + " has a quiz average of " + senior.quizAverage());
    }
    
    public void takeSeveralQuizzes(Student senior)
    {
        int numQuizzes = readInt("How many quizzes? ");
        int score;
        for (int i=0; i<numQuizzes; i++)
        {
            score = readInt("Enter quiz score: ");
            senior.takeQuiz(score);
        }
    }


}
