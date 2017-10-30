

public class JameePlayer implements McCoveyPlayer
{

    public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        if (myScore + turnScore >= 44)
            return false;
        
         while (myScore<10)
                {
                    return turnScore < 10;
                }
                
       while (myScore > 20 && yourScore < 11) 
        {
            return turnScore < 12;
        } 
      
       
        
        while (myScore >= 26){
               return turnScore < 50;
        }
        
        while(myScore < yourScore){
                return turnScore < 20;
        }
        
         
         
      
         
        return turnScore < 10;
        
        //1/6 
       
    }
    /*
     * Things to think about: 
     * if you are close to 44 just keep on rolling 
     * 
     */
}
