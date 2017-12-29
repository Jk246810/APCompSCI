
//Jamee Krzanich, Period C
import java.awt.Color;
import info.gridworld.grid.*;

public class ConnectFourGame
{
    private int[][] board;
    private int currentTurnNumber;
    
    public ConnectFourGame(int rows, int cols)
    {
        board = new int[rows][cols];
        // you need to fill board with 0's
        currentTurnNumber = 1;
    }

    // returns 0, 1, or 2
    public int getWinner()
    {      
        // complete this in version 1.0
        for(int r= 0; r<board.length;r++){
            for(int c=0; c< board[0].length ;c++){
                if(board[r][c]!=0){
                    if(row(r,c)||column(r,c) || leftDiagonal(r,c) || rightDiagonal(r,c))
                    {
                        return board[r][c];
                    }
                   
                }
  
            }}
         return 0;
       
    }
    public boolean leftDiagonal(int r, int c)
    {
        return(r<= board.length-4 &&
        c>= 3 &&
        board[r][c]==board[r+1][c-1] &&
        board[r+1][c-1]==board[r+2][c-2] &&
        board[r+2][c-2]==board[r+3][c-3]);
         
    }
    
    public boolean rightDiagonal(int r, int c)
    {
         return(r<= board.length-4 &&
         c<= board[0].length-4 &&
         board[r][c]==board[r+1][c+1] &&
         board[r+1][c+1]==board[r+2][c+2] &&
         board[r+2][c+2]==board[r+3][c+3]);
    }
    
    public boolean row(int r, int c)
    {
       
        return( c<= board[0].length-4 
        && board[r][c]==board[r][c+1] 
        && board[r][c+1]==board[r][c+2] 
        && board[r][c+2]==board[r][c+3]);     
    
     
    }
    
    public boolean column(int r, int c)
    {
        return( r<= board.length-4 &&
        board[r][c]==board[r+1][c] &&
        board[r+1][c]==board[r+2][c] &&
        board[r+2][c]==board[r+3][c]);
   
       
     
    }
    
    
   
    public int dropChecker(int col)
    {
        for (int r = board.length-1; r>=0; r--)
        {
            if (board[r][col] ==0) 
            {
                board[r][col] = currentTurnNumber; 
                currentTurnNumber = (currentTurnNumber%2) + 1;
                return r; 
            }
        } return -1; 
        
    }
}













