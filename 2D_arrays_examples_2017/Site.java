import java.util.ArrayList;

public class Site
{
    private Archaeologist[][] quadrants;

    public Site(ArrayList<Archaeologist> people, int rows, int cols)
    {
        
       quadrants = new Archaeologist[rows][cols]; 
       int counter = 0; 
       for(int c=0; c<quadrants[0].length; c++)
       {
            for(int r = 0; r<quadrants.length; r++)
           {
               quadrants[r][c] = people.get(counter); 
               counter ++; 
               if (counter == people.size())
               {
                   return; 
                }
            }
        }
       
    }
    
    public int clearSomeQuadrants(String affiliation)
    {
        int counter = 0; 
        for(int r = 0; r<quadrants.length; r++)
       {
            for(int c=0; c<quadrants[0].length; c++)
           {
               if(quadrants[r][c].getAffiliation().equals(affiliation))
               {
                   quadrants[r][c] = null;
                   counter++; 
                }
            }
        }
        // to be written in part (b)
        return counter; // just to get it to compile
    }
    
    public void printSiteInfo()
    {
        for (int r=0; r<quadrants.length; r++)
        {
            for (int c=0; c<quadrants[0].length; c++)
            {
                if (quadrants[r][c]!=null)
                    System.out.print(quadrants[r][c].getIdNum() + " ");
                else
                    System.out.print("-----" + " ");
            }
            System.out.println();
        }
    }
    
    


}
