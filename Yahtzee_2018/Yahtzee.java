
import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants 
{
 
/* Private instance variables */
    private int numPlayers;
    private String[] playerNames;
    private YahtzeeDisplay display;
    private int[][] scores;
    private boolean[][] filled;
    
    public void run() 
    {
        /* You may need to change some of this */
        IODialog dialog = getDialog();
        numPlayers = dialog.readInt("Enter number of players");
        playerNames = new String[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            playerNames[i] = dialog.readLine("Enter name for player " + (i+1));
        }
        display = new YahtzeeDisplay(getGCanvas(), playerNames);
        scores = new int[numPlayers][N_CATEGORIES+1];
        filled = new boolean[numPlayers][N_CATEGORIES+1];
        playGame();
    }

    private void playGame() 
    {
        for(int i=0; i<N_SCORING_CATEGORIES; i++)
        {
            everyPlayerTakesTurn();
        }
        displayWhoWins();
        // here's where you'll need to begin
    }
    
     private void everyPlayerTakesTurn()
    {
        for(int i = 0; i<numPlayers; i++)
        {
            onePlayerTakesTurn(i); 
        } 
    }
    
    private void onePlayerTakesTurn(int playerNum)
    {
        display.printMessage(playerNames[playerNum] + "'s turn. Click \"Roll Dice\" button to roll the dice.");
        display.waitForPlayerToClickRoll(playerNum+1);
        int[] dice = getAllDice(); 
        display.displayDice(dice);
        
        for(int i=0; i< 2; i++)
        {
            display.printMessage("Select the dice you wish to re-roll and click \"roll again\".");
            display.waitForPlayerToSelectDice(); 
            dice = rerollSomeDice(dice); 
            display.displayDice(dice); 
        }
        
        display.printMessage("Select a category for this roll");
        int category = display.waitForPlayerToSelectCategory();
        while(filled[playerNum][category])
        {
             display.printMessage("Please select a different category");
             category = display.waitForPlayerToSelectCategory();
        }
            filled[playerNum][category] = true; 
            int score = getScore(dice, category);
            updateScores(category, playerNum, score); 
            scores[playerNum][category] = score; 
            display.updateScorecard(category, playerNum+1, score);
        
    }
    
    private void updateScores(int category, int playerNum, int score)
    {
         scores[playerNum][category] = score; 
         display.updateScorecard(category, playerNum+1, score);
         if(category<=SIXES)
         {
              scores[playerNum][UPPER_SCORE] += score; 
              display.updateScorecard(UPPER_SCORE, playerNum+1, scores[playerNum][UPPER_SCORE]);
              if(scores[playerNum][UPPER_SCORE] >=63)
              {
                  scores[playerNum][UPPER_BONUS] = 35; 
                  display.updateScorecard(UPPER_BONUS, playerNum+1, scores[playerNum][UPPER_BONUS]);
                }
         }else{
            scores[playerNum][LOWER_SCORE] += score; 
            display.updateScorecard(LOWER_SCORE, playerNum+1, scores[playerNum][LOWER_SCORE]);
         }
         
          scores[playerNum][TOTAL] = (scores[playerNum][UPPER_SCORE] +
                                     scores[playerNum][LOWER_SCORE] +
                                      scores[playerNum][UPPER_BONUS]);
          display.updateScorecard(TOTAL, playerNum+1, scores[playerNum][TOTAL]);
                                   
    }
    
    private int getScore(int[] dice, int category)
    {
        if(category == CHANCE)
            return getSumOfDice(dice);
        else if(category == YAHTZEE)
            return checkForOfaKind(getFrequencies(dice), 50, 5);
            
        //have not done yet
        else if(category == LARGE_STRAIGHT)
            return checkConsecutiveValues(getFrequencies(dice), 40, 5);
        else if(category == SMALL_STRAIGHT)
            return checkConsecutiveValues(getFrequencies(dice), 30, 4); 
        else if(category ==FULL_HOUSE)
            //have not done yet
          //  return checkFor3and2(dice); 
        else if(category == FOUR_OF_A_KIND)
            return checkForOfaKind(getFrequencies(dice), getSumOfDice(dice), 4);
        else if(category == THREE_OF_A_KIND)
            return checkForOfaKind(getFrequencies(dice), getSumOfDice(dice), 3);
        
        else if(category <= SIXES)
            return getSumOfSameValue(category, dice);
       else
          return -1;
    } 
    
    private int checkConsecutiveValues(int[] frequency, int points, int howMany)
    {
        boolean works = true;
        boolean found = false; 
        int counter = 0;
       for(int i=0; i<frequency.length; i++)
       {
           if(found == true && frequency[i] !=1 && counter!=howMany)
           {
              works = false; 
           }
           else if(found == false && frequency[i] >=1)
           {
               found = true;
               counter ++;
           }else if(frequency[i] <1){
               
           }else{
            counter++; 
           }
         
        }
        
        if(works == true)
        {
            return points;
        }
        else {
            return 0; 
        }
        
    }
    private int getSumOfDice(int[] dice)
    {
        int sum = 0; 
        for (int i=0; i<dice.length; i++)
        {
            sum+=dice[i]; 
        }
        return sum;
    }
    
    private int checkForOfaKind(int[] frequency, int points, int howMany)
    {
        for(int i=0; i<frequency.length; i++)
        {
            if(frequency[i] >= howMany)
            {
              return points;
            }
        }
        return 0;
    }
    
    private int[] getFrequencies(int[] dice)
    {
        int[] frequency = new int[7];
        for(int i=0; i<dice.length; i++)
        {
            frequency[dice[i]]++;
        }
        
        return frequency;
    }
    
    
  
    
    private int getSumOfSameValue(int checkingNum, int[] dice)
    {
        int sum = 0; 
           for(int i=0; i<dice.length; i++)
           {
               if(dice[i] == checkingNum)
               {
                   sum+=checkingNum; 
                }
            }
         return sum; 
            
    }
    
    private int[] getAllDice()
    {
        int[] result = new int[N_DICE]; 
        for(int i =0; i< result.length; i++)
        {
            result[i] = (int)(Math.random()*6+1); 
            
        }
         return result;
    }
    
    
    private int [] rerollSomeDice(int[] dice)
    {
        for(int i =0; i< dice.length; i++)
        {
            if (display.isDieSelected(i))
            {dice[i] = (int)(Math.random()*6+1); 
            }
           
            
        }
        return dice; 
        
    } 

   // you'll probably have lots of methods here.
   // (I had fifteen!)
   private void displayWhoWins()
   {
    }
   
    
    /* Java main method to ensure that this program starts correctly */
    public static void main(String[] args) 
    {
        new Yahtzee().start(args);
    }

}
