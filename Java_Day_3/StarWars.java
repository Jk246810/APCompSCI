
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class StarWars extends GraphicsProgram
{

    public void run()
    {
        GRect laser = new GRect(100, 120, 75, 5);
        laser.setFilled(true);
        laser.setColor(Color.yellow);
        add(laser);
        
        GImage deathstar = new GImage("deathstar.jpeg", 60, 40);
        deathstar.scale(1.5, 1.5);
        add(deathstar);
        
        for (int i=0; i<1000000; i++)
        {
            laser.move(1, 0);
            pause(5);
        }
        
    }


}
