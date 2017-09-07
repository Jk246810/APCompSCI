
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class PyramidB extends GraphicsProgram
{
    private static int BRICK_HEIGHT = 12;
    private static int BRICK_WIDTH = 30;
    private static int GAP = 4;
    private static int NUM_ROWS = 10;
    private static int START_X = 50;
    private static int START_Y = 60;

    public void run()
    {
        for (int r=0; r<NUM_ROWS; r++)
        {
            for (int i=0; i<r-1; i++)
            {
                GRect block = new GRect(START_X + i*(BRICK_WIDTH + GAP),
                                        START_Y + r*(BRICK_HEIGHT + GAP),
                                        BRICK_WIDTH,
                                        BRICK_HEIGHT);
               block.setFilled(true);
               add(block);
            }
        }
       
    }

}
