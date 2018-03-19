import acm.graphics.*;
import java.awt.Color;

public class Asteroid extends GVectorPolygon
{
    private double rotation;

    public Asteroid(int width, int height)
    {
       // write this in version 0.2
       super(width, height);
       rotation = Math.random(); 
       
       addVertex(0,50);
       addVertex(40,40);
       addVertex(24,0);
       addVertex(30, -45);
       addVertex(-50, -50);
       addVertex(-34,-40);
       addVertex(-40,52);
       recenter();
       this.setColor(Color.green); 
       
       
      
    }
    
    public void updatePosition()
    {
        super.updatePosition();
        rotate(rotation);
        
        
    }

    // complete this in version 0.2
}
