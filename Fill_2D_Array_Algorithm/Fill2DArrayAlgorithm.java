
public class Fill2DArrayAlgorithm
{
    public int[][] getGridOfNumbersUsingCounterStartingAtOne(int rows, int cols)
    {
        // question #0
        int[][] result = new int[rows][cols]; 
        int counter = 1; 
        for(int r = 0; r<rows; r++)
        {for (int c= 0; c<cols; c++)
            {
                result[r][c] = counter; 
                counter++; 
            }
        }return result; 
    }

    public int[][] getGridOfNumbersUsingCounter(int rows, int cols)
    {
         // question #1
        int[][] result = new int[rows][cols]; 
        int counter = 0; 
        for(int r = 0; r<rows; r++)
        {for (int c= 0; c<cols; c++)
            {
                result[r][c] = counter; 
                counter++; 
            }
        }return result; 
    }

    public int[][] getGridOfNumbersUsingMath(int rows, int cols)
    {
         // question #2a
       int[][] result = new int[rows][cols]; 
         
        for(int r = 0; r<rows; r++)
        {for (int c= 0; c<cols; c++)
            {
                result[r][c] = r*cols + c; 
               
            }
        }return result; 
    }
    
     public int[][] getGridOfNumbersUsingMath2(int rows, int cols)
    {
         // question #2b
       int[][] result = new int[rows][cols]; 
         
        for(int i =0; i<rows*cols; i++)
       
        {
                int row= i/cols;
                int col= i%cols; 
                result[row][col] = i;
               
        }
        return result; 
    }

    public int[][] getGridOfNumbersUsingMathColumnMajorOrder(int rows, int cols)
    {
        // question #3
        int[][] result = new int[rows][cols]; 
         //dont need to flip for loops 
        for(int c = 0; c<rows; c++)
        {for (int r= 0; r<cols; r++)
            {
                result[r][c] = c*rows + r; 
               
            }
        }return result;
    }

    public String[][] getGridOfWordsUsingMath (int rows, int cols, String[] words)
    {
        // question #4
          String[][] result = new String[rows][cols]; 
         
        for(int r = 0; r<rows; r++)
        {for (int c= 0; c<cols; c++)
            {
                int index = r*cols + c;
                result[r][c] = words[index]; 
               
            }
        }return result; 
        
    }

    public String[][] getGridOfWordsUsingMathIfPresent (int rows, int cols, String[] words)
    {
        // question #5
        String[][] result = new String[rows][cols]; 
         
        for(int r = 0; r<rows; r++)
        {for (int c= 0; c<cols; c++)
            {
                int index = r*cols + c;
                if (index < words.length)
                {
                    result[r][c] = words[index]; 
                }else {
                    result[r][c] = "";
                }
               
            }
        }return result; 
        
    }

    public String[][] getGridOfWordsColumnMajorUsingMathIfPresent (int rows, int cols, String[] words)
    {
        // question #6
         String[][] result = new String[rows][cols]; 
         
        for(int r = 0; r<rows; r++)
        {for (int c= 0; c<cols; c++)
            {
                int index = c*rows + r;
                if (index < words.length)
                {
                    result[r][c] = words[index]; 
                }else {
                    result[r][c] = "";
                }
               
            }
        }return result; 
        
        
    }
    
    // your solution to question #7 should be in the other class
}
