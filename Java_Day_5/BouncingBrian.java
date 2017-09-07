
// This program requires a graphic file called brian.jpeg to be in the project folder - 
// The file should be in the same folder as this file, BouncingBrian.java.

import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class BouncingBrian extends GraphicsProgram
{

    public void run()
    {
        double dx = 1;
        double dy = 1;
        GImage brian = new GImage("brian.jpeg", 100, 100);
        brian.scale(0.5, 0.5);
        add(brian);
        int height = getHeight();
        int width = getWidth();
        while (true)
        {
            pause(5);
            brian.move(dx, dy);
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
