
import acm.program.*;

public class NumberGrid extends ConsoleProgram
{

    public void run()
    {
        setFont("*-*-18");
        int[][] origGrid = {{3, 4, 5, 6},      
                            {9, 8, 7, 6}, 
                            {8, 1, 8, 1}, 
                            {1, 3, 5, 7}, 
                            {8, 6, 4, 2}};
        printGrid(origGrid);
        println();
        readLine();
        println();
        int[][] secondGrid = getVerticallySymmetricGrid(origGrid);
        printGrid(secondGrid);
    }

    private void printGrid(int[][] grid)
    {
       for (int[] row : grid)
       {
           for (int num: row)
              print(num + " ");
           println();
       }
    }
    
    private int[][] getVerticallySymmetricGrid(int[][] grid)
    {
        // your code here
        int[][] result = new int[grid.length*2][grid[0].length];
        
        int counter = 0; 
        for(int r = 0; r<grid.length; r++)
        {
            
                for(int c=0; c<grid[0].length; c++)
                {
                result[r][c] = grid[r][c]; 
                result[result.length-1-r][c] = grid[r][c]; 
            }
            counter++; 
        }
        return result;
       
        
        
    }
 
    
    
}
