import java.util.ArrayList;

public class SlidingPuzzle
{
    private int side;
    private int[][] values;

    public SlidingPuzzle(int sideLength)
    {
        side = sideLength;
        values = new int[sideLength][sideLength];
        initialize();
    }
    
    public int getValueAt(int row, int col)
    {
        return values[row][col];
    }
        
    /* The given code creates and initializes an ArrayList 
     containing the numbers 0 to (side*side-1).  This
     method fill in the private instance variable values with 
     random values from this ArrayList temp, which will initialize
     the puzzle to a random starting state.
     */
    private void initialize()
    {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < side * side; i++)
            temp.add(i);
        // to be completed in part (A)
    }
    
    /* returns true if the numbers are in "sliding puzzle"
     order, false otherwise; note that the blank (represented
     by a 0) can be anywhere
    */
    public boolean isDone()
    {
        // to be completed in part (b)
    }
    
    /* The player has clicked on a number at (row, col).  This method
     should "slide" that number to the neighboring blank (represented
     by the number 0), if such a neighboring blank exists.  If there
     is no neighboring blank, this method should do nothing.  If you
     slide a tile, you should change the private instance variable
     values to reflect this slide.  Note: you'll need to do lots of 
     "bounds checking" to make sure you avoid an 
     ArrayIndexOutOfBoundsException!
     */
    public void slide(int row, int col)
    {
        // to be completed in part (c)
    }
    

   

}
