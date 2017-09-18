

public class VotingMachine
{
    private int numYes;
    private int numNo;
    
    public VotingMachine()
    {
        numYes = 0;
        numNo = 0;
    }
    public void voteYes()
    {
        numYes += 1;
    }
    
    public void voteNo()
    {
        numNo += 1;
    }
    public void rigElection(double rigFactor)
    {
        int stolenVotes = (int)(numNo*rigFactor);
        numYes = numYes + stolenVotes;
        numNo = numNo - stolenVotes;
        
    }
    
    public double getYesPercent()
    {
        return 100.0*numYes/(numYes + numNo);
        
        
    }
    
    public double getNoPercent()
    {
        return 100.0 - getYesPercent();
    }
    
    public String getWinner()
    {
       if (numYes > numNo)
       {
           return "yes";
        }else if (numYes < numNo)
        {
            return "No";
        }else 
        {
            return "tie";
        }
    }
}
