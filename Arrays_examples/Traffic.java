
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Traffic extends GraphicsProgram
{
    private static final int NUMTYPES = 8;
    private static final int NUMLANES = 12;
    private static final int VEHICLEHEIGHT = 80;

    public void run()
    {
        setSize(1200, NUMLANES*VEHICLEHEIGHT); 
        GImage[] vehicles = new GImage[NUMLANES];
        double[] speeds = new double[NUMLANES];
        
        for (int i=0; i<speeds.length; i++)
        {
            speeds[i] = Math.random()*6;
            
        }
        for(int i =0; i<vehicles.length; i++)
        {
            int type = (int)(Math.random()*8);
            vehicles[i] = new GImage("vehicle" + type + ".jpg",
                                      (int)(Math.random()*1200), 
                                       VEHICLEHEIGHT *i);
                                       
            add(vehicles[i]);
        }
        
        while(true)
        {
            pause(10);
            for(int i = 0; i<vehicles.length; i++)
            {
                vehicles[i].move(-speeds[i], 0);
                if (vehicles[i].getX()<-vehicles[i].getWidth()){
                    vehicles[i].setLocation(1200, vehicles[i].getY());
                }
                
            }
            
        }
    }

}
