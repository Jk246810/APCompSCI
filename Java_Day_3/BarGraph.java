
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

//Jamee Krzanich, Period C

public class BarGraph extends GraphicsProgram
{
    private static final int NUMBARS=12;
    private static final int BARWIDTH=20;
    private static final int TALLESTBARHEIGHT=256;
    private static final int DECREASEBARAMOUNT=10;
    private static final int BOTTOMLEFT_X = 45;
    private static final int BOTTOMLEFT_Y = 310;

    public void run()
    {
        for(int i=0; i<NUMBARS; i++)
        {
          
            int width = BARWIDTH;
            int height = TALLESTBARHEIGHT - (DECREASEBARAMOUNT*i);
            
            int x = BOTTOMLEFT_X + (BARWIDTH*i); 
            int y = BOTTOMLEFT_Y - height;
            
            GRect bar = new GRect(x, y, width, height);
            
            bar.setColor(Color.BLUE);
            add(bar);
            
        }
    }

}
