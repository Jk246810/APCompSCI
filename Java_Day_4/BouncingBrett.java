
// This program requires a graphic file called brett.jpeg to be in the project folder - 
// The file should be in the same folder as this file, BouncingBrent.java.

import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class BouncingBrett extends GraphicsProgram
{

    public void run()
    {
        int width = getWidth();
        int height = getHeight();
        double dx = 1;
        double dy = 1;
        GImage brett = new GImage("brett.jpeg", 100, 100);
        brett.scale(0.5, 0.5);
        add(brett);
        while (true)
        {
          brett.move(dx, dy);
          pause(5);
          if (brett.getX()<0)
          {
            dx = -dy;   
          }         
          if (brett.getX()>width)
          {
            dx = -dx;   
          }
          if (brett.getY()<0)
          {
            dy = -dy;   
          }         
          if (brett.getY()>height)
          {
            dy = -dy;   
          }
        }
    }


}
