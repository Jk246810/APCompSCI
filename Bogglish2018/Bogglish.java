import java.util.ArrayList;
import acm.program.*;

public class Bogglish extends ConsoleProgram
{
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPRSTUVWXYZ";
    

    public void run()
    {
        setFont("*-*-24");
        String[][] board = new String[5][5];
        createBoard(board); 
        printBoard(board);
        enterSomething(board);
        // version 0.1, 0.2, and 0.5 here
    }

    /** Returns true if the word is "contained" somewhere in the board,
     *  following our "Bogglish" rules, false otherwise.
     *  @param word the word to check
     *  @param board the Bogglish board
     *  @return true if the word is in the board, false otherwise.
     */
    private void enterSomething(String[][] board) 
    {
       
       int counter = 0; 
       boolean enter = true; 
       while(enter == true) 
       {
             String x = readLine("Enter a word:"); 
             x=x.toUpperCase();
            if (x.length()!= 0)
            {
               
               //reaching this point
               checkWord(x, board);
               if (checkWord(x, board) == true)
               {
                   counter++;
                   println("Good Job! You now have " +counter+ " points");
                }else 
                {
                    println("sorry that's not a word");
                }
               
            } else
            {
                enter = false; 
               
                 
            }
        }
        printAllWords(board);
      
    }
    
    private void printAllWords(String[][] board)
    {
        ArrayList<String> allWords = new ArrayList<String>();
        allWords =Dictionary.getAllWords();
                
                for(int i=0; i<allWords.size(); i++)
                {
                    String word = allWords.get(i).toUpperCase();
                   if (checkWord(word, board) == true)
                   {
                       //is not reaching this statement
                       
                        println(word);
                        
                  }
                }
       
    }
    
    private boolean checkWord(String word, String[][] board)
    {
        
        
       
        if (word.contains("Q")||word.length()<3)
        {
            
            //this works 
            return false; 
            
        }
        for (int i =0; i<word.length()-1; i++)

        {
            
            String letter = word.substring(i, i+1);
            String nxtLetter = word.substring(i+1, i+2); 
            Position pos = getLetterPosition(nxtLetter, board);
            Position current = getLetterPosition(letter, board);
           if (pos==null || current==null)
              return false;
            
            
           if(Math.abs(current.getRow() - pos.getRow())>1 || Math.abs(current.getCol()-pos.getCol())>1)
           {
               return false; 
            }
            
            
              
        }
    
        return true;
             
      } 
      
    
    
    private void createBoard(String[][] board)
    {
        ArrayList<String> letters = new ArrayList<String>();
        for (int i=0; i<ALPHABET.length(); i++)
        {
            letters.add(ALPHABET.substring(i, i+1)); 
        } 
        int index; 
        for (int r=0; r<board.length; r++) 
        {
            for(int c=0; c<board[0].length; c++) 
            {
                index = (int)(Math.random()*letters.size());
                board[r][c] = letters.remove(index); 
            } 
        }
    }
    
    private void printBoard(String[][] board)
    {
        for (int r=0; r<board.length; r++) 
        {
            for(int c=0; c<board[0].length; c++) 
            {
                print(board[r][c]); 
                
            } 
            println();
        }
    } 

    /** Returns the Position of where the letter is in the board
     *  Note that this returns a Position, which is a class you wrote.
     *  @param letter a String of length 1 representing the letter
     *  @param board the Bogglish board
     *  @return the Position of the letter, or null if it is not there 
     */
    private Position getLetterPosition(String letter, String[][] board)
    {
        // version 0.3 here
        for (int r=0; r<board.length; r++) 
        {
            for(int c=0; c<board[0].length; c++)
            {
                if(board[r][c].equals(letter))
                {
                    Position newP = new Position(r,c); 
                    return newP; 
                } 
            } 
        }return null; 
    }

}
