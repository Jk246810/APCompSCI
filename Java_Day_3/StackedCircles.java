
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class StackedCircles extends GraphicsProgram
{
    private static final int START_X = 25;
    private static final int START_Y = 48;
    private static final int NUM_ROWS = 10;
    private static final int NUM_COLS = 8;
    private static final int DIAMETER = 25;  
    
    public void run()
    {
        for (int j=0; j<NUM_COLS; j++)
        {
            for (int i=0; i<NUM_COLS; i++)
            {
                GOval circle = new GOval(START_X + i*DIAMETER,
                                     START_Y + j*DIAMETER,
                                     DIAMETER, DIAMETER);
                add(circle);
            
            }
        }

    }


}
