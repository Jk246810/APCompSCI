
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Circles extends GraphicsProgram
{

    public void run()
    {
        int numCircles = (int)(Math.random()*1000); 
        for(int i = 0; i<numCircles; i++)
        {
            double x = Math.random()*getWidth();
            double y = Math.random()*getHeight();
            double radius = Math.random()*200;
            GOval randomCircle = new GOval(x-radius, y-radius, radius*2, radius*2);
            randomCircle.setFilled(true);
            
            int r = (int)(Math.random()*256);
            int g = (int)(Math.random()*256);
            int b = (int)(Math.random()*256);
            
            Color color = new Color(r, g, b);
            randomCircle.setColor(color);
            add(randomCircle);
            pause(50);
        }
    }


}
