

public class ArithmeticQuestion implements Question
{
    private int x; 
    private int y; 
    public ArithmeticQuestion()
    {
        x= (int)(Math.random()*90 +10);
        y= (int)(Math.random()*90 +10);

    }

    public String getQuestion()
    {
        return "what is " + x + "+" + y + "? ";
    }
    
    public String getAnswer()
    {
        return (x+y) + ""; 
    }
    
    public boolean isCorrect(String response)
    {
        return response.equals(getAnswer());
        
    }
}
