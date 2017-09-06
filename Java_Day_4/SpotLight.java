
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class SpotLight extends GraphicsProgram
{
    private static final int RADIUS = 50;
    
    GOval light = new GOval(0,0, RADIUS*2, RADIUS*2);
    
    public void run()
    {
        
        light.setFilled(true);
        light.setColor(Color.YELLOW);
        add(light);
        addMouseListeners();
        
        
        
    }
    
    public void mouseMoved(MouseEvent event)
    {
        
        int x = event.getX();
        
        int y = event.getY();
        light.setLocation(x - RADIUS, y - RADIUS);
    }

}
