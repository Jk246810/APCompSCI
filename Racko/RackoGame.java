import java.util.ArrayList;

public class RackoGame
{
    // private instance variables
    private ArrayList<Integer> deck;
    private ArrayList<Integer> discardPile;
    private int[] playerHand;
    private int[] computerHand;

    public RackoGame()
    {
        
       for(int i=0; i<59; i++)
       {
           deck.add(i+1);
        }
        for(int i =0; i<deck.size(); i++)
        {
            int number= (int)(Math.random()*59) + 1;
            deck.set(number, i);
            deck.set(i, number); 
            
        }
       // player.add
    }
    
    public void makeMove(int newCardValue, int handIndex, int[] hand)
    {
        // version 0.2
    }
    
    public boolean playerWins()
    {
        // version 0.3
    }
    
    public boolean computerWins()
    {
        // version 0.3
    }
    
    public int removeTopCardFromDeck()
    {
        // version 0.4
    }
    
    public int removeTopCardFromDiscardPile()
    {
        // version 0.4
    }
    
    public int peekAtTopCardFromDiscardPile()
    {
        // version 0.4
    }
    
    public int[] getPlayerHand()
    {
        // version 0.4
    }
    
    public int[] getComputerHand()
    {
        // version 0.4
    }

}