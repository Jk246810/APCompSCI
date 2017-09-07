
import acm.program.*;

public class StudentExampleD extends ConsoleProgram
{

    public void run()
    {
        Student senior;
        senior = new Student("John M.");
        
        Student junior;
        junior = new Student("John P.");
        
        takeSeveralQuizzes(senior);
        takeSeveralQuizzes(junior);
        
        println(senior.getName() + " has a quiz average of " + senior.quizAverage());
        println(junior.getName() + " has a quiz average of " + junior.quizAverage());
    }
    
    public void takeSeveralQuizzes(Student someone)
    {
        int numQuizzes = readInt("How many quizzes? ");
        int score;
        for (int i=0; i<numQuizzes; i++)
        {
            score = readInt("Enter quiz score: ");
            someone.takeQuiz(score);
        }
    }


}
