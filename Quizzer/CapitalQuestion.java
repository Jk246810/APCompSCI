

public class CapitalQuestion implements Question
{
    private String state; 
    private String capital;

    public CapitalQuestion()
    {
        String[] states = {"California", "Arizona", "Nevada"};
        String[] capitals = {"Sacramento", "Phoenix", "Las Vegas"};
        int index = (int)(Math.random()*states.length);
        state = states[index];
        capital = capitals[index]; 
    }
    
    public String getAnswer(){
        return "the capital of " + state + " is " + capital; 
        
    }
    
    public String getQuestion(){
        return "what is the capital of " + state; 
    }
    
    public boolean isCorrect(String response)
    {
        return response.equalsIgnoreCase(capital); 
    }
    


}
