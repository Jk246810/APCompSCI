
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Test extends GraphicsProgram
{

    public void run()
    {
        GVectorPolygon thing = new Asteroid(getWidth(), getHeight()); 
        GVectorPolygon ships = new Ship(getWidth(), getHeight()); 
        
        ships.increaseVelocity(1);
        ships.setLocation(100,200);
        add(ships);  
        
        //thing.rotate(46);
        thing.increaseVelocity(1);
        thing.setLocation(100,200);
        add(thing);
        
       
        while(true)
        {
            pause(10);
            thing.updatePosition();
            ships.updatePosition();
           
        }
        
        
    }


}
