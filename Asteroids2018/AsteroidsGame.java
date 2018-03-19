
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.applet.AudioClip;
import acm.util.MediaTools;

public class AsteroidsGame extends GraphicsProgram
{
    private ArrayList<Asteroid> asteroids;
    private boolean playing;
    private GLabel notificationLabel, scoreLabel;
    // uncomment out the lines below in version 0.4.1 and 0.5.2
    private Ship ship;
    private ArrayList<Bullet> bullets;
    private int level;
    private int ships;
    private int score;
    private int numAsteroids; 
    private AudioClip thrustClip, fireClip, bigBangClip, mediumBangClip, smallBangClip;

    public void init()
    {
        thrustClip = MediaTools.loadAudioClip("thrust.wav");   
        fireClip = MediaTools.loadAudioClip("fire.wav");   
        bigBangClip = MediaTools.loadAudioClip("bangLarge.wav");   
        mediumBangClip = MediaTools.loadAudioClip("bangMedium.wav");   
        smallBangClip = MediaTools.loadAudioClip("bangSmall.wav");   

        level = 1;
        //how do I 
        ships = 3;
        score = 0;
        numAsteroids = 3; 

        setBackground(Color.BLACK);

        notificationLabel = new GLabel("(i) = thrust, (j) = rotate left, (k) = rotate right, (space) = fire. Click mouse to continue");
        notificationLabel.setColor(Color.WHITE);
        notificationLabel.setFont("Courier-Plain-12");
        notificationLabel.setLocation((getWidth()-notificationLabel.getWidth())/2, getHeight()/2-40);
        add(notificationLabel);

        scoreLabel = new GLabel("Score:"+score);
        scoreLabel.setColor(Color.WHITE);
        scoreLabel.setFont("Courier-Plain-10");
        scoreLabel.setLocation(16, 16);
        add(scoreLabel);

        asteroids = new ArrayList<Asteroid>();
        bullets = new ArrayList<Bullet>();

        ship = new Ship(getWidth(), getHeight()); 
        ship.setLocation(getWidth()/2,getHeight()/2);
        ship.setFilled(true); 
        ship.setColor(Color.red);
        add(ship); 

        makeAsteroids();

        addKeyListeners(); 
        addMouseListeners(); 

    }

    private void makeAsteroids()
    {
        for(int i=0; i< numAsteroids; i++)
        {
            int xPos = (int)(Math.random()*getWidth());
            int yPos = (int)(Math.random()*getHeight());
            int rrotate = (int)(Math.random()*360);

            Asteroid asteroid = new Asteroid(getWidth(), getHeight());

            asteroid.rotate(Math.random()*360); 
            asteroid.increaseVelocity(1); 

            while(Math.abs(yPos-(int)(ship.getY()))<50)
            {
                yPos = (int)(Math.random()*getHeight());
            }
            while(Math.abs(xPos-(int)(ship.getX()))<50)
            {
                xPos = (int)(Math.random()*getWidth());
            }
            asteroid.setLocation(xPos,yPos);

         
            asteroids.add(asteroid);
            add(asteroid);

        }
        // code for version 0.3.1 goes here
    }

    public void run()
    {

        while (true)
        {
            pause(10);
            for(int i=0; i<asteroids.size(); i++)
            {
                asteroids.get(i).updatePosition(); 

            }

            if(playing)
            {
                ship.updatePosition();

                for(int i=0; i<bullets.size(); i++)
                {
                    if(bullets.get(i).stillMoving())
                    {
                        bullets.get(i).updatePosition();
                        if(checkForCollisions(bullets.get(i)) != null)
                        {
                            shotAsteroid(checkForCollisions(bullets.get(i)));
                            remove(bullets.get(i));
                            bullets.remove(i); 
                            i--;
                        }
                    }else {
                        remove(bullets.get(i));
                        bullets.remove(bullets.get(i)); 
                        i--; 
                    }

                }

               shipCollided();
              
            }
            // code for version 0.3 goes here
        } 
    }

    public void newLevel()
    {
        playing = false; 
        level++;
        numAsteroids++; 
        ships= 3;
        
        add(notificationLabel); 
        notificationLabel.setLabel("you have advanced to level: " + level);
        pause(2000); 
       
        removeAll();
        playing = true; 
        
        add(ship);   
        makeAsteroids();
    } 

    public void keyPressed(KeyEvent e) 
    {
        if(playing){
            if(e.getKeyCode() == KeyEvent.VK_J)
            {
                ship.rotate(15);
            }
            else if(e.getKeyCode() == KeyEvent.VK_I)
            {
                 ship.increaseVelocity(0.5);
                 thrustClip.play();

            }
          
            else if(e.getKeyCode() == KeyEvent.VK_K)
            {
               
                ship.rotate(-15); 

            }
            else if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                Bullet bb = ship.makeBullet();
                bullets.add(bb); 
                bb.setColor(Color.white);
                add(bb); 
                fireClip.play();
            }
        }
    }

   public void mouseClicked(MouseEvent e)
    {
        if(!playing)
        {
            playing = true; 
            remove(notificationLabel); 
        }
    }

    private Asteroid checkForCollisions(GVectorPolygon obj)
    {
        for (Asteroid a:asteroids)
            if (a.getBounds().intersects(obj.getBounds()))
            {
                return a;
        }
        return null;       
    }
    
    private void shipCollided()
    {
        Asteroid x = checkForCollisions(ship);
        if(x != null)
        {
            playing = false; 
            ships --; 
            
            if(ships >0)
            {
                remove(ship); 
                ship = new Ship(getWidth(), getHeight()); 
                ship.setLocation(getWidth()/2, getHeight()/2);
                add(ship);
                  for(int i=0; i<bullets.size(); i++)
                {
                    remove(bullets.get(i)); 
                    bullets.remove(i);
                    
                    i--;
                }
                
                add(notificationLabel);
                notificationLabel.setLabel("You have " + ships + " lives left"); 
            }else if(ships == 0)
            {
                removeAll();
                add(notificationLabel);
                notificationLabel.setLabel("Sorry you lost!");
                return;
                
            }
        }
    }
    

    private void shotAsteroid(Asteroid a)
    {
        score += 10; 
        scoreLabel.setLabel("Score: " + score); 
        double angle = Math.random() * 360;
      
        if(a instanceof MediumAsteroid)
        {
            for(int i=0; i<3; i++)
            {
                Asteroid asteroid = new SmallAsteroid(getWidth(), getHeight());
                asteroids.add(asteroid);
                add(asteroid);
                asteroid.setLocation(a.getX(), a.getY()); 
                asteroid.rotate(angle + i*120);
                asteroid.increaseVelocity(1);
            }
            mediumBangClip.play();
        }else if(!(a instanceof SmallAsteroid)){
           
            for(int i=0; i<3; i++)
            {
                Asteroid asteroid = new MediumAsteroid(getWidth(), getHeight());
                asteroids.add(asteroid);
                add(asteroid);
                asteroid.setLocation(a.getX(), a.getY()); 
                asteroid.rotate(angle + i*120);
                asteroid.increaseVelocity(1);
            }
            bigBangClip.play();
        }else
        {
           smallBangClip.play();
        }
        remove(a);
        asteroids.remove(a);
         
       if(asteroids.size() == 0)
       {
           newLevel();
       }
    }

}
