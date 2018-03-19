import java.awt.Color;

public class Ship extends GVectorPolygon
{

    public Ship(int w, int h)
    {
        super(w,h); 
        
        addVertex(0,0);
        addVertex(-20, 12);
        addVertex(30, 0);
        addVertex(-20, -12); 
        recenter();
        setColor(Color.RED);
        setFilled(true); 
        // write this in version 0.4  
    }

  
    public Bullet makeBullet()
    {
        int w = (int)(getBoundingRectangle().getWidth()); 
        int h = (int)(getBoundingRectangle().getHeight()); 
        
        Bullet bb = new Bullet(w, h);
        bb.setLocation(getX(), getY());
        bb.rotate(getTheta());
        bb.increaseVelocity(3);
        return bb; 
        
    }
  

}
