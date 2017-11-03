
import acm.program.*;
import java.util.ArrayList;

public class PokerGame extends ConsoleProgram
{

    public void run()
    {
        ArrayList<PlayingCard>deck; 
        deck = new ArrayList<PlayingCard>();
        for(int s=0; s<4; s++)
        {
            for(int r = 0; r<13; r++)
            {
                PlayingCard card = new PlayingCard(r,s); 
                deck.add(card);
            }
        }
        for (int i=0; i<5; i++)
        {
            int index = (int)(Math.random()*deck.size());
            PlayingCard card = deck.get(index);
            println(card.toString());
            //deck.remove(index); 
            
        } 
    }
}
