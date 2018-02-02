

public class FavoriteQuestion implements Question
{ 
    private String noun;

    public FavoriteQuestion()
    {
        String[] nouns = {"princess","color", "story", "animal", "shape", "food", "Smurf", "flavor of ice cream"};
        int index = (int)(Math.random()*nouns.length);
        noun = nouns[index]; 
        
    }
    
    public String getQuestion()
    {
        return "what is your favorite " + noun+ "?";
    }
    
    public String getAnswer()
    {
        return "Whatever you want";
    }
    
    public boolean isCorrect(String Response)
    {
        return true;
    }


}
