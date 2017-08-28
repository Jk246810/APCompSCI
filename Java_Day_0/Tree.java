
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Tree extends GraphicsProgram
{

    public void run()
    {
        GRect trunk;
        trunk = new GRect(45, 50, 20, 100);
        trunk.setFilled(true);
        trunk.setColor(Color.BLUE);
        add(trunk);
        
        GOval leaves = new GOval(35, 15, 40, 40);
        leaves.setFilled(true);
        leaves.setColor(Color.GREEN);
        add(leaves);
        
        GLabel description = new GLabel("this is a tree.", 20, 180);
        Font treeFont = new Font("Palatino", Font.BOLD, 24);
        description.setFont(treeFont);
        add(description);
    }


}
