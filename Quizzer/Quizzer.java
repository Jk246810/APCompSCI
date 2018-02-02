
import acm.program.*;
import java.util.ArrayList;

public class Quizzer extends ConsoleProgram
{
    private ArrayList<Question> questions;
    //new because putting two types of questions in the arrayList, two types

    public void run()
    {
        createQuiz(10); 
        giveQuiz(); 

    }

    private void createQuiz(int numQuestions)
    {
        questions = new ArrayList<Question>();
        for(int i=0; i<numQuestions; i++)
        {
           double number= Math.random();
            Question q;
            if (Math.random()<1.0/3)
            {
                q= new ArithmeticQuestion();
            }else if(Math.random()<2.0/3)
            {
                q = new FavoriteQuestion();
            }else{
                q = new CapitalQuestion();
            }
            questions.add(q); 
        }
    }
    
    private void giveQuiz()
    {
        int numCorrect = 0; 
        for(int i =0; i<questions.size(); i++)
        {
            String prompt = questions.get(i).getQuestion(); 
            //polymorphism uses the method appropriate to what you are 
            String response = readLine(prompt); 
            if(questions.get(i).isCorrect(response))
            {
                println("Correct!");
                numCorrect++; 
            }
            else 
            {
                println("Incorrect!");
                println("the correct answer is " + questions.get(i).getAnswer());
                
            }
            println();
        }
        println("your score is " + numCorrect + " / " + questions.size());
    }
}
