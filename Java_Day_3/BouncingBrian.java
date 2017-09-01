
// This program requires a graphic file called brian.jpeg to be in the project folder - 
// The file should be in the same folder as this file, BouncingBrian.java.

import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class BouncingBrian extends GraphicsProgram
{

    public void run()
    {
        int width = getWidth();
        int height = getHeight();
        double dx = 1;
        double dy = 1;
        GImage brian = new GImage("brian.jpeg", 100, 100);
        brian.scale(0.5, 0.5);
        add(brian);
        while (true)
        {
          brian.move(dx, dy);
          pause(5);
          if (brian.getX()<0)
          {
            dx = -dx;   
          }         
          if (brian.getX()>width)
          {
            dx = -dx;   
          }
          if (brian.getY()<0)
          {
            dy = -dy;   
          }         
          if (brian.getY()>height)
          {
            dy = -dy;   
          }
        }
    }


}
