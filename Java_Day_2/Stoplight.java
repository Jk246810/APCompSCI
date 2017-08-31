
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Stoplight extends GraphicsProgram
{
    private static final double BULB_RADIUS = 60; 
    private static final double WINDOW_WIDTH = 754; 
    private static final double WINDOW_HEIGHT = 492;

    public void run()
    {
         GRect box = new GRect(WINDOW_WIDTH/2 -  BULB_RADIUS,
                               WINDOW_HEIGHT/2 - BULB_RADIUS * 3,
                               BULB_RADIUS*2 ,
                               BULB_RADIUS*6);
                               
        box.setFilled(true);
        box.setColor(Color.GRAY);
        add(box);
        
        GOval oval1 = new GOval(WINDOW_WIDTH/2 -  BULB_RADIUS,
                               WINDOW_HEIGHT/2 - BULB_RADIUS * 3,
                               BULB_RADIUS*2,
                               BULB_RADIUS*2);
            oval1.setFilled(true);
            oval1.setColor(Color.RED);
            add(oval1);
        
        GOval oval2 = new GOval(WINDOW_WIDTH/2 -  BULB_RADIUS,
                               WINDOW_HEIGHT/2 - BULB_RADIUS,
                               BULB_RADIUS*2,
                               BULB_RADIUS*2);
            oval2.setFilled(true);
            oval2.setColor(Color.YELLOW);
            add(oval2);
            
        GOval oval3 = new GOval(WINDOW_WIDTH/2 -  BULB_RADIUS,
                               WINDOW_HEIGHT/2 + BULB_RADIUS,
                               BULB_RADIUS*2,
                               BULB_RADIUS*2);
            oval3.setFilled(true);
            oval3.setColor(Color.GREEN);
            add(oval3);
        
        
        
    }


}
