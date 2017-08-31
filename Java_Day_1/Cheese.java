
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Cheese extends GraphicsProgram
{

    public void run()
    {
        GImage cheese;
        cheese = new GImage("grilledcheese.jpeg", 100, 150);
        add(cheese);
        for (int i=0; i<300; i++)
        {
            cheese.move(1,0);
            pause(20);
            
        }

    }


}
