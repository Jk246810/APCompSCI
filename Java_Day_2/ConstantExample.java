import acm.program.*; 
import acm.graphics.*; 
import java.awt.Color;

public class ConstantExample extends GraphicsProgram 
{
    private static final double BOX_WIDTH = 450; 
    private static final double BOX_HEIGHT = 360; 
    private static final double WINDOW_WIDTH = 754; 
    private static final double WINDOW_HEIGHT = 492;

        public void run() 
        {
            GRect box = new GRect(WINDOW_WIDTH/2 - BOX_WIDTH/2,
                                  WINDOW_HEIGHT/2 - BOX_HEIGHT/2,
                                  BOX_WIDTH,
                                  BOX_HEIGHT);
            box.setFilled(true);
            box.setColor(Color.RED);
            add(box);
            
            
            GOval oval = new GOval(WINDOW_WIDTH/2 - BOX_WIDTH/2,
                                  WINDOW_HEIGHT/2 - BOX_HEIGHT/2,
                                  BOX_WIDTH,
                                  BOX_HEIGHT);
            oval.setFilled(true);
            oval.setColor(Color.GREEN);
            add(oval);
             
            
        }
}
