
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ClickForCate extends GraphicsProgram
{
    public void run()
    {
        addMouseListeners();
    }
    
    public void mouseMoved(MouseEvent event)
    {
        int x = event.getX();
        int y = event.getY();
        GImage pic = new GImage("cate.jpeg", x, y);
        add(pic);
    }

}
