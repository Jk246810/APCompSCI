import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class Pattern extends GraphicsProgram 
{
    private static final double START_X = 60; 
    private static final double START_Y = 40; 
    private static final int NUM_RECTS = 15; 
    private static final double RECT_WIDTH = 380; 
    private static final double RECT_HEIGHT = 20;
    
    public void run() 
    {
       Color stripeColor;
       stripeColor = Color.pink;
       for (int i=0; i<NUM_RECTS; i++)
       {
           GRect rect = new GRect(START_X, START_Y + i * RECT_HEIGHT, RECT_WIDTH, RECT_HEIGHT);
           rect.setFilled(true);
           rect.setColor(stripeColor);
           add(rect);
           if (stripeColor == Color.pink)
           {
               stripeColor = Color.red;
            }
            else
            {
                stripeColor = Color.pink;
            }
        }
      }
        
    
}





