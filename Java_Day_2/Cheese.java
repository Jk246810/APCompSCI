
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Cheese extends GraphicsProgram
{

    public void run()
    {
        GImage cheese = new GImage("grilledcheese.jpeg", 50, 75);
        add(cheese);
        for (int i=0; i<100; i++)
        {
            cheese.move(1,0);
            pause(10);
        }
    }


}
