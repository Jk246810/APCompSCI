// ### Great job!  10/10
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Bullseye extends GraphicsProgram
{
    private static final int NUMRINGS = 10;
    private static final int RINGWIDTH = 20;
    private static final int INITIALX = 260;
    private static final int INITIALY = 210;

    public void run()
    {
        Color ringColor = Color.red;
        int j;
        for (int i=0; i<NUMRINGS; i++)
        {
            j = NUMRINGS - i;
            GOval oval = new GOval(INITIALX - RINGWIDTH*j, INITIALY - RINGWIDTH*j,
             2*j*RINGWIDTH, 2*j*RINGWIDTH);
            oval.setColor(ringColor);
            oval.setFilled(true);
            add(oval);
            if (ringColor == Color.red)
            {
                ringColor = Color.gray;
            }
            else
            {
                ringColor = Color.red;
            }
        }
    }
            
            
    
}
                
            
        
       
    




