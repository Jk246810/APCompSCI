

public class RoachPopulation
{
    private int numRoaches;
    
    public RoachPopulation(int startingNumRoaches)
    {
        numRoaches = startingNumRoaches;  
    }
    
    public void breed()
    {
        numRoaches = numRoaches * 2;
        
    }

    public void spray()
    {
        numRoaches = numRoaches / 10;
    }
    
    public int getNumRoaches()
    {
        return numRoaches; 
    }
}
