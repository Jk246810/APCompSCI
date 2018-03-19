import java.awt.Color;

public class Bullet extends GVectorPolygon
{
    private int numTurns;
    
    private static final int MAXTURNS=150;
    
    public Bullet(int width, int height)
    {
        super(width,height); 
        addVertex(0,0);
        addVertex(2,0);
        addVertex(2,-2); 
        addVertex(0,-2); 
        recenter(); 
        numTurns =0; 
        
       // complete this in version 0.5
    }
   //CHECK WHAT DO I DO WITH THIS  
    public boolean stillMoving()
    {
        if(numTurns<MAXTURNS)
        {
            return true; 
        }
            return false; 
      
    } 
    
    public void updatePosition()
    {
        super.updatePosition(); 
        numTurns ++; 
    }
    // complete this in version 0.5


}
