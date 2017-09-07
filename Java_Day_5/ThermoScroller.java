
import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class ThermoScroller extends GraphicsProgram
{
    private static final double BUTTON_SIZE = 60; 
    private static final double FROM_SIDE = 100; 
    private static final double WINDOW_WIDTH = 754; 
    private static final double WINDOW_HEIGHT = 492;
    //abstract idea of a thermostat
    GRect blueButton; 
    GRect redButton;
    Thermostat thermo;
    GLabel thermoLabel;
    public void run()
    {
        initializeVariables();
        addMouseListeners();
        while(true) //animation loop
        {
            pause(5);
            updateLabelPosition();
        }
        
        
       
    }
    
    public void updateLabelPosition()
    {
        thermoLabel.move(1,0);
        if (thermoLabel.getX()>WINDOW_WIDTH)
        {
            thermoLabel.move(-WINDOW_WIDTH, 0);
        }
    }
    
    public void initializeVariables()
    {
       blueButton = new GRect(FROM_SIDE, FROM_SIDE, BUTTON_SIZE, BUTTON_SIZE);
       blueButton.setFilled(true);
       blueButton.setColor(Color.BLUE);
       add(blueButton);
       
       redButton = new GRect(WINDOW_WIDTH - FROM_SIDE - BUTTON_SIZE, FROM_SIDE, BUTTON_SIZE, BUTTON_SIZE);
       redButton.setFilled(true);
       redButton.setColor(Color.RED);
       add(redButton);
       
       
       thermo = new Thermostat(0,100);
       
       thermoLabel = new GLabel("Temperature = " + thermo.getValue(), 
                                0, WINDOW_HEIGHT-FROM_SIDE);
       Font thermoFont = new Font("Arial", Font.BOLD, 24);
       thermoLabel.setFont(thermoFont);
       add(thermoLabel);
       
    }
    
    public void mouseMoved(MouseEvent event)
    {
        int x = event.getX();
        int y = event.getY();
        GObject thing = getElementAt(x, y);
        if (thing == redButton)
        {
            thermo.warmer();
            thermoLabel.setLabel("Temperature = " + thermo.getValue());
        } else if (thing == blueButton)
        {
            thermo.colder();
            thermoLabel.setLabel("Temperature = " + thermo.getValue());
        }
        else if (thing == thermoLabel)
        {
           thermoLabel.setColor(Color.CYAN); 
        }
        else 
        {
            thermoLabel.setColor(Color.BLACK);
        }
        
    }
    
    
}
