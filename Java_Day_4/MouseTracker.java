
import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;


public class MouseTracker extends GraphicsProgram
{
    GLabel label;
    
    public void run()
    {
        
        label = new GLabel("", 20, 80);
        Font myFont = new Font("Arial", Font.BOLD, 24);
        label.setFont(myFont);
        add(label);
        addMouseListeners();
       
    }
    
    public void mouseMoved(MouseEvent event)
    {
       int x = event.getX();
       int y = event.getY();
       label.setLabel("X=" +x+ ", Y=" + y);
       GObject object = getElementAt(x, y);
       if (object == label)
       {
           label.setColor(Color.MAGENTA);
        }
        else 
        {
           label.setColor(Color.BLACK);
        }
    }
    
    public void mouseClicked(MouseEvent event)
    {
        GImage cheese = new GImage("grilledcheese.jpeg", event.getX(), event.getY());
        cheese.scale(0.3,0.3);
        add(cheese);
    }
    
    

}
