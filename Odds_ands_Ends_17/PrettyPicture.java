
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class PrettyPicture extends GraphicsProgram
{

    public void run()
    {
        GLabel caption = new GLabel("This is a " + getVerys(8) + " pretty picture.", 20, 480);
        add(caption);

        tree(300, 450, 90, 100);
    }

    private void tree(double startX, double startY, double angle, double length)
    {
        if (length < 3)
        {
        }
        else
        {
            double radians = angle * Math.PI/180;
            double endX = startX + Math.cos(radians) * length;
            double endY = startY - Math.sin(radians) * length;
            GLine line = new GLine(startX, startY, endX, endY);
            add(line);

            tree(endX, endY, angle - 40, length * 0.8);
            tree(endX, endY, angle + 40, length * 0.8);
        }
    }

    private String getVerys(int numVerys)
    {
        if (numVerys <= 0)
            return "";
        else if (numVerys==1)
            return "very";
        else 
            return "very, " + getVerys(numVerys-1);
    }

}
