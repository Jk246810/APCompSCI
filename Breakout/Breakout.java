
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram 
{

/** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** Dimensions of game board in pixels (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
    private static final int BRICK_SEP = 4;

/** Width of a brick */
    private static final int BRICK_WIDTH =
      (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
    private static final int NTURNS = 3;

 /** Global variables declared here.  You should feel free to add others as needed. */
     GRect paddle;
     GOval ball;
     GOval movingBall;
     double dx;
     double dy;
     boolean endGame = false; 
     int numberOfBricks;
     int numberOfLives = 3;
     
    
/** Runs the Breakout program. */
    public void run() 
    {
        initBricks();
        initPaddle();
        initBall();
        addMouseListeners();
        while(endGame == false)
        {
            
            updateBall();
            checkForCollision(); 
            pause(10);
        }
        
        

    }
    
    GRect blocks;
    GRect movingPaddle;
    
    public void initBricks()
    {
        for(int r=0; r<NBRICK_ROWS; r++)
        {
            for (int c=0; c<NBRICK_ROWS; c++)
            {
                blocks = new GRect(0 + c*(BRICK_WIDTH + BRICK_SEP), 
                                        BRICK_Y_OFFSET + r*(BRICK_HEIGHT + BRICK_SEP),
                                        BRICK_WIDTH,
                                        BRICK_HEIGHT);
                                        
                
                
                
                if(r<2)
                {
                    blocks.setColor(Color.RED);  
                }else if(r<4)
                {
                    blocks.setColor(Color.ORANGE);
                }else if(r<6)
                {
                    blocks.setColor(Color.YELLOW);
                }else if(r<8)
                {
                    blocks.setColor(Color.GREEN);
                }else 
                {
                    blocks.setColor(Color.CYAN);
                }
                
                blocks.setFilled(true);
                add(blocks);
            }
           
        }
        numberOfBricks = NBRICK_ROWS * NBRICK_ROWS;
    }
    
    public void initPaddle()
    {
        movingPaddle = new GRect(0,
                           HEIGHT - PADDLE_Y_OFFSET,
                           PADDLE_WIDTH, 
                           PADDLE_HEIGHT);
        
       movingPaddle.setFilled(true);
       add(movingPaddle);
        
    }
    
    public void initBall()
    {
        
        movingBall = new GOval(WIDTH/2, HEIGHT/2, BALL_RADIUS*2, BALL_RADIUS*2);
        dx = 1+ Math.random()*2;
        if(Math.random()>0.5)
        {
            dx = -dx;
           

        }
        dy = 2;
        
        movingBall.setFilled(true);
        add(movingBall);
        
    }
    
    public void updateBall()
    {
       movingBall.move(dx, dy);
       
       
        
          if (movingBall.getX() < 0)
          {
            dx = -dx;   
          }         
          if (movingBall.getX()>WIDTH - 2*BALL_RADIUS)
          {
            dx = -dx;   
          }
          if (movingBall.getY()<0)
          {
            dy = -dy;   
          }         
          if (movingBall.getY()>HEIGHT)
          {
            dy = -dy;
            endGame = true;
            numberOfLives -= 1;
            initializeLoseLabel();
            GameOver();
            
          }
    }
    
    public void checkForCollision()
    {
        double x = movingBall.getX();
        double y = movingBall.getY();
        GObject object = getElementAt(x, y);
        if (object == null) 
        {
           object = getElementAt(x + 2*BALL_RADIUS, y);
           if (object == null)
           {
               object = getElementAt(x, y + 2*BALL_RADIUS);
               if (object == null)
               {
                    object = getElementAt(x + 2*BALL_RADIUS, y + 2*BALL_RADIUS);
                }
            }
        }
       if (object == movingPaddle)
        {
            if (dy > 0)
            {
                dy = -dy;
            }
       }else if (object == null)
       {
           
       }
       else{
           dy = -dy;
           remove(object);
           numberOfBricks -= 1 ;
           if (numberOfBricks == 0)
           {
               endGame = true;
               initializeWinLabel();
               GameOver();
            }
          
       }
        
    }
    
    public void mouseMoved(MouseEvent event)
    {
        int mouseX;
        int mouseY;
        mouseX = event.getX();
        mouseY = event.getY();
        if (mouseX < 0 + PADDLE_WIDTH/2)
        {
            movingPaddle.setLocation(0 ,HEIGHT - PADDLE_Y_OFFSET);
            
        }else if (mouseX > WIDTH - PADDLE_WIDTH/2)
        {
            movingPaddle.setLocation(WIDTH - PADDLE_WIDTH ,HEIGHT - PADDLE_Y_OFFSET);
        }
        else{
            
            movingPaddle.setLocation(mouseX - PADDLE_WIDTH/2,HEIGHT - PADDLE_Y_OFFSET); 
        }
    }
    
    public void initializeLoseLabel()
    {
        
       
       GLabel winner = new GLabel("lives " + numberOfLives, 
                                WIDTH/2, HEIGHT/2);
                                
       GLabel playAgain = new GLabel("Play again ", 
                                0, 0);
       add(winner);
       add(playAgain);
    }
    
    public void initializeWinLabel()
    {
        
       
       GLabel winner = new GLabel("yay", 
                                WIDTH/2, HEIGHT/2);
                                
       GLabel playAgain = new GLabel("try again ", 
                                0, 0);
       add(winner);
       add(playAgain);
    }
    
    public void GameOver()
    {
        
        
        if (endGame == true)
        {
           
            waitForClick();
            removeAll();
            endGame = false;
            run();
            
            
        }
    }
   
   
}
