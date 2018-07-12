
public class AuthorSignature
{
    // declare private instance variables here
    private String authorName; 
    private double avgWordLength; 
    private double diffWordRatio; 
    private double hapaxRatio; 
    private double avgWordsPerSentence; 
    private double avgPhrasesPerSentence; 
   
    public AuthorSignature(String aN, double aWL, 
    double dWR, double hR, double aWPS, double aPPS )
    {
        
    authorName=aN; 
    avgWordLength=aWL; 
    diffWordRatio=dWR; 
    hapaxRatio=hR; 
    avgWordsPerSentence=aWPS; 
    avgPhrasesPerSentence=aPPS; 
        // "the job of the constructor is to initialize the private instance varables"
    }
    
    public String getAuthorName()
    {
        return authorName; 
    }
    
    public double getAverageWordLength()
    {
        return avgWordLength;
    }
    
    public double getDifferentWordRatio()
    {
        return diffWordRatio; 
        
    }
    
    public double getHapaxRatio()
    {
        return hapaxRatio; 
    }
    
    public double getAverageWordsPerSentence()
    {
        return avgWordsPerSentence; 
    }
    
    public double getAveragePhrasesPerSentence()
    {
        return avgPhrasesPerSentence; 
    }
    // you'll need five more methods here
}
