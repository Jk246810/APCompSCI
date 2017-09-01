
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
        Color ringColor = Color.RED;
        
        for(int i=0; i<NUMRINGS; i++)
        {
            int j = NUMRINGS - i; 
            
            GOval bullseye = new GOval(INITIALX - j*RINGWIDTH , 
                                        INITIALY - j*(RINGWIDTH),
                                        2*j * RINGWIDTH,
                                        2*j * RINGWIDTH);
            bullseye.setFilled(true);
            bullseye.setColor(ringColor);
            
            
            add(bullseye);
            
            if (ringColor == Color.RED)
            {
                ringColor = Color.GRAY;
            }else
            {
                ringColor = Color.RED;
            }
            
           
                                        
                                        
                                        
        }
        
    }

}

