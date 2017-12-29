//Jamee Krzanich, period C

import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ConnectFourGraphicsProgram extends GraphicsProgram
{
    private static final int PIECE_DIAM = 100;
    private static final int NUM_COLS = 7;
    private static final int NUM_ROWS = 6;
    public static final int APPLICATION_WIDTH = NUM_COLS * PIECE_DIAM;
    public static final int APPLICATION_HEIGHT = NUM_ROWS * PIECE_DIAM;

    /** Dimensions of game board in pixels (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    private ConnectFourGame game;
    private boolean gameIsBeingPlayed;
    private Color currentDrawingColor;
    private GLabel w; 

    public void run()
    {
        addMouseListeners();
        boolean continuallyPlay = true; 

        while(continuallyPlay)
        {
            setup(); 
            while (game.getWinner()==0)
            {
                pause(10);
            }
            gameIsBeingPlayed = false;

            pause(300); 
            removeAll(); 

            winnerLabel();

            pause(1500);
            removeAll();
        }
        // add code here in version 0.4
    }

    public void setup()
    {
        currentDrawingColor = Color.RED;
        game = new ConnectFourGame(NUM_ROWS, NUM_COLS);
        gameIsBeingPlayed = true;
    }

    public void winnerLabel()
    {
        if(game.getWinner()==2){
            w = new GLabel("Black wins",15,50);
            w.setFont("*-45");
            w.setColor(Color.GREEN);
            add(w);
        } else{
            w = new GLabel("Red wins",15,50);
            w.setFont("*-45");
            w.setColor(Color.GREEN);
            add(w);
        }

    }

    public void mouseClicked(MouseEvent event) 
    { 
        if (!gameIsBeingPlayed) return;
        int x = event.getX();
        int col = x/PIECE_DIAM;
        int row = game.dropChecker(col);
        if(row == -1)

            return ;

        drawChecker(row,col);
        if(currentDrawingColor == Color.red)
            currentDrawingColor=Color.black;
        else 
            currentDrawingColor =Color.red; 

    }

    public void drawChecker( int row, int col)
    {
        GOval checker = new GOval(col*PIECE_DIAM, row*PIECE_DIAM, 
                PIECE_DIAM, PIECE_DIAM);
        checker.setFilled(true);
        checker.setColor(currentDrawingColor); 
        add(checker);
        // complete this in version 0.3
    }

}
