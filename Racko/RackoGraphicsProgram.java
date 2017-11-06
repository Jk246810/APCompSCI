
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class RackoGraphicsProgram extends GraphicsProgram
{
    // constants for graphics layout
    private static final int WINDOWSIZE = 500;
    private static final int OFFSET = 20;  // offset from all edges of screen
    private static final int CARDHEIGHT = 40;
    private static final int MINCARDWIDTH = 60;

    // these are all constants for the private instance variable gameState
    private static final int GAME_OVER = -1;
    private static final int PICK_DECK_OR_DISCARD = 0;
    private static final int PICK_CARD_FROM_HAND = 1;
    private static final int WAITING_FOR_COMPUTER_MOVE = 2; 

    // private instance variables
    private RackoGame game;
    private ComputerPlayer computer;
    private int gameState;  // will be one of four constants above
    private JLabel status;  // use status.setText to provide updates of status of game
    private int replacementCardValue;  // the card drawn from either the discard pile or deck

    public void run()
    {
        initWindow();
        initVariables();
        drawGraphics();
        addMouseListeners();
        // version 0.7
    }

    public void initVariables()
    {
        game = new RackoGame();
        gameState = PICK_DECK_OR_DISCARD;
        computer = new PrettyGoodComputerPlayer();
    }

    public void initWindow()
    {
        setSize(WINDOWSIZE, WINDOWSIZE);
        setTitle("Rack-o");
        status = new JLabel("Your move!  Click on deck or discard pile.");
        add(status, NORTH);
    }

    public void drawGraphics()
    {
       // version 0.5
    }

    public void mouseClicked(MouseEvent event)
    {
        // version 0.6   
    }

    private void makeComputerMove()
    {
        // version 0.8
    }
    
    
    // helper methods I wrote for you
    private GCompound getCardForValue(int cardValue)
    {
        GCompound entireCard = new GCompound();
        int width = MINCARDWIDTH + cardValue;
        GRect rect = new GRect(0,0,width,CARDHEIGHT);
        rect.setFillColor(Color.lightGray);
        rect.setFilled(true);
        entireCard.add(rect);
        GLabel valueLabel = new GLabel(cardValue+"", 10, CARDHEIGHT-10);
        valueLabel.setFont("*-*-24");
        entireCard.add(valueLabel);
        return entireCard;
    }
    
    private int getValueForCard(GCompound card)
    {
       return (int)(card.getWidth()-1-MINCARDWIDTH+0.5);
       // the -1 is because of the border, and the 0.5 handles the inexactness of doubles
    }

}
