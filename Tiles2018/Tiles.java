
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Tiles extends GraphicsProgram
{
    private static final int TILE_SIZE = 80;
    private static final int NUM_ROWS = 6;
    private static final int NUM_COLS = 5;
    private static final Color firstColor = Color.red;
    private static final Color secondColor = Color.black;

    private GRect[][] tiles;
    private int status;

    public void run()
    {
        setSize(TILE_SIZE*NUM_COLS, TILE_SIZE*NUM_ROWS+24);
        status = -1;
        makeBoard(); 
        addMouseListeners(); 
        status = playGame(); 
        displayMessage(); 
    }
    
    
    private void makeBoard()
    {
        tiles = new GRect[NUM_ROWS][NUM_COLS]; 
        for (int r = 0; r< tiles.length; r++)
        {
            for(int c=0; c<tiles[0].length; c++) 
            {
                tiles[r][c] = new GRect(c*TILE_SIZE, r*TILE_SIZE, TILE_SIZE, TILE_SIZE); 
                tiles[r][c].setFilled(true); 
                if(Math.random()< 0.5)
                {
                    tiles[r][c].setColor(firstColor); 
                }else 
                {
                    tiles[r][c].setColor(secondColor);
                }
                add(tiles[r][c]); 
            } 
        } 
    } 
    
    private int playGame()
    {
       while(true)
       {
           if(allSameColor())
                return 0;
           if(ringAroundOutside())
                return 1;
           if(checkerBoard())
                return 2;
           if(stripes())
                return 3;
       }
       
    } 
    
    private boolean allSameColor()
    {
        Color theColor = tiles[0][0].getColor();
        for(int r=0; r< tiles.length; r++)
        {
            for(int c=0; c< tiles[0].length; c++)
            {
                   if(!tiles[r][c].getColor().equals(theColor))
                   {
                       return false;
                    }
            }
            
        }
        return true;
    }
     private boolean ringAroundOutside()
    {
        Color theColor = tiles[0][0].getColor();
        for(int r=0; r< tiles.length; r++)
        {
            for(int c=0; c< tiles[0].length; c++)
            {
                   if(r==0)
                   {
                         if(!tiles[r][c].getColor().equals(theColor))
                         {
                             return false;
                         }
                   }
                   if(r==tiles.length-1) 
                   {
                        if(!tiles[r][c].getColor().equals(theColor))
                         {
                             return false;
                         } 
                   }
                   
            
                }
            }
            
        for(int r=1; r< tiles.length-1; r++)
        {
            for(int c=1; c< tiles[0].length-1; c++)
            {
                  
                         if(tiles[r][c].getColor().equals(theColor))
                         {
                             return false;
                         }
                        }
            }
            
            
        for(int r=0; r< tiles.length; r++)
        {
            for(int c=0; c< tiles[0].length; c+=tiles.length-1)
            {
                
                if(!tiles[r][c].getColor().equals(theColor))
                   {
                       return false;
                    }  
            }
            
        }
        
        return true; 
        
   
    }
    
    private boolean stripes()
    {
       Color theColor = tiles[0][0].getColor();
        for(int r=0; r< tiles.length; r++)
        {
            for(int c=0; c< tiles[0].length; c++)
            {
                   if(c%2 == 0)
                   {
                         if(!tiles[r][c].getColor().equals(theColor))
                         {
                             return false;
                         }
                   }
                   else 
                   {
                        if(tiles[r][c].getColor().equals(theColor))
                         {
                             return false;
                         } 
                   }
                   
            
                }
            }
            return true;
    } 
     private boolean checkerBoard()
    {
        Color theColor = tiles[0][0].getColor();
        for(int r=0; r< tiles.length; r++)
        {
            for(int c=0; c< tiles[0].length; c++)
            {
                   if((r+c)%2==0)
                   {
                         if(!tiles[r][c].getColor().equals(theColor))
                         {
                             return false;
                         }
                   }
                   else
                   {
                        if(tiles[r][c].getColor().equals(theColor))
                         {
                             return false;
                         } 
                   }
            
                }
            }
        return true;
    }
    
    private void displayMessage()
    {
        String[] messages = {"All same color", "Ring", "Checkerboard", "stripes"}; 
        GLabel message = new GLabel(messages[status], 0, 0); 
        message.setFont("*-*-24");
        message.setLocation(getWidth()/2-message.getWidth()/2,getHeight()/2-message.getHeight()/2);
        
        message.setColor(Color.cyan); 
        add(message); 
    } 
    public void mouseClicked(MouseEvent event)
    {
        if (status != -1)
            return;
        int col = event.getX()/TILE_SIZE; 
        int row = event.getY()/TILE_SIZE; 
        toggleTileColor(tiles[row][col]); 
        if(isShiftKeyDown(event))
        {
            if(row>0)
            {
                toggleTileColor(tiles[row-1][col]); 
            }if(row<tiles.length-1)
            {
                toggleTileColor(tiles[row+1][col]); 
            }
            if(col<tiles[0].length-1)
            {
                toggleTileColor(tiles[row][col+1]); 
            }
            if(col>0)
            {
                toggleTileColor(tiles[row][col-1]); 
            }
            
        }
    }
    
    private void toggleTileColor(GRect tile)
    {
        if(tile.getColor().equals(firstColor))
        {
            tile.setColor(secondColor); 
        }else{
            tile.setColor(firstColor); 
        }
    } 

    private boolean isShiftKeyDown(MouseEvent event)
    {
        return (event.getModifiers() & MouseEvent.SHIFT_MASK) != 0;
    }
    
    
}
