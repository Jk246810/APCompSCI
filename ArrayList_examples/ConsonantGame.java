
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class ConsonantGame extends GraphicsProgram
{
    private ArrayList<GLabel> labels;
    private RandomWordGenerator generator;
    private int turns;

    public void run()
    {
        initializeVariables();
        createLabels(25);
        // fill up labels with 25 random labels here
        addKeyListeners();
        // play the game and tell me how many turns it took
        // to win here
        while(labels.size()>0)
        {
            pause(27); 
        }
        youWin();
        
        
    }
    
    public void youWin()
    {
        GLabel winner = new GLabel("Congratulations! It took you " + turns + " turns", 50, 250); 
        add(winner); 
    }
    public void createLabels(int numLabels)
    {
        for (int i=0; i<numLabels; i++)
        {
            GLabel label = getRandomLabel(); 
            labels.add(label); 
            add(label); 
        }
    }
    
    public void initializeVariables()
    {
      labels = new ArrayList<GLabel>();
        generator = new RandomWordGenerator();
        turns = 0;
    }
    public void keyPressed(KeyEvent event)
    {
        String letter = KeyEvent.getKeyText(event.getKeyCode()).toUpperCase();  
        String vowels = "AEIOU"; 
        if (vowels.indexOf(letter) != -1)
            return; 
        for(int i=0; i< labels.size(); i++)
        {
            if(labels.get(i).getLabel().indexOf(letter) != -1)
            {
                remove(labels.get(i)); 
                labels.remove(i); 
                i--; 
                //IMPORTANT
            }
        } 
        turns ++; 
        if(turns%3 == 0)
        {
            createLabels(5); 
        }
    }

    public GLabel getRandomLabel()
    {
        int x = (int)(Math.random()*getWidth());
        int y =  (int)(Math.random()*getHeight());
        String word = generator.getRandomWord(); 
        GLabel result = new GLabel(word, x, y);
        Color color = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)); 
        result.setColor(color); 
        int size = (int)(Math.random()*33)+24; 
        result.setFont("*-*-" + size); 
        while(result.getX()+result.getWidth() > getWidth())
        {
             x = (int)(Math.random()*getWidth());
             result.setLocation(x,y); 
            
        }
        while(result.getY()-result.getHeight() < 0)
        {
             y = (int)(Math.random()*getHeight());
             result.setLocation(x,y); 
            
        }
        return result; 
        
    }

}
