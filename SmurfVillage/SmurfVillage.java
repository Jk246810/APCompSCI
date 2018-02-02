
public class SmurfVillage
{
    public static void main(String[] args)
    {
        Picture village = new Picture("images/" + "village.jpg");
        Picture papa = new Picture("images/papa.png"); 
        Picture smurfette = new Picture("images/smurfette.png"); 
        Picture smurfB = new Picture("images/smurfB.png");
        Picture grouchy = new Picture("images/grouchy.png"); 
        
      
        Picture small = smurfette.scale(0.5,0.5); 
        for(int r = 0; r<6; r++)
        {
            if(r%2 == 0)
            {
                for(int c=0; c<11; c++)
                {
                    
                   if (c%2 ==0)
                    {
                        village.insert(grouchy,5+60*r, 5+60*c);
                    }else
                    {
                        village.insert(smurfette,5+60*r, 5+60*c);
                    }
                    
                }
            }else{
                 for(int c=0; c<11; c++)
                {
                    
                   if (c%2 ==0)
                    {
                        village.insert(papa,5+60*r, 5+60*c);
                    }else
                    {
                        village.insert(smurfB,5+60*r, 5+60*c);
                    }
                    
                }
            }
            
        }
        village.show();
    }
    
  
}