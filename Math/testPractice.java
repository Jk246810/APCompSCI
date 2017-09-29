
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class testPractice extends GraphicsProgram
{
private static final double WINDOW_WIDTH = 754; private static final double WINDOW_HEIGHT = 492;
// the size of the box
private static final double BOX_WIDTH = 150; private static final double BOX_HEIGHT = 240;

    public void run()
    {
        GRect box = new GRect(WINDOW_WIDTH/2-BOX_WIDTH/2,
                      WINDOW_HEIGHT/2-BOX_HEIGHT/2,
                      BOX_WIDTH, BOX_HEIGHT);
box.setFilled(true);
box.setColor(Color.GREEN);  // or Color.green, it doesn't matter
add(box);
GOval leftCircle = new GOval(WINDOW_WIDTH/2-BOX_WIDTH,
                      WINDOW_HEIGHT/2-BOX_HEIGHT/2-BOX_WIDTH/2,
                      BOX_WIDTH, BOX_WIDTH);
leftCircle.setColor(Color.BLUE);
leftCircle.setFilled(true);
add(leftCircle);
GOval rightCircle = new GOval(WINDOW_WIDTH/2,
                      WINDOW_HEIGHT/2-BOX_HEIGHT/2-BOX_WIDTH/2,
                      BOX_WIDTH, BOX_WIDTH);
rightCircle.setColor(Color.RED);
rightCircle.setFilled(true);
add(rightCircle);

    }


}
