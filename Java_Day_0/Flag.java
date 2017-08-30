
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;

//Jamee Krzanich, Period C

public class Flag extends GraphicsProgram
{

    public void run()
    {
        circleOfFlag();
        borderOfFlag();
        addText();

    }
    
    public void borderOfFlag()
    {
      GRect border = new GRect(20, 20, 240, 120);
       add(border);  
    }

    public void circleOfFlag()
    {
      GOval redCenter = new GOval(115, 55, 50, 50);
        redCenter.setFilled(true);
        redCenter.setColor(Color.RED);
        add(redCenter); 
    }
    
    public void addText()
    {
        GLabel text = new GLabel("The Japanese Flag", 20, 180);
        Font flagFont = new Font("Palatino", Font.PLAIN, 30);
        text.setFont(flagFont);
        add(text);
    }     
}
