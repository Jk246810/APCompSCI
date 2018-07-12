
import acm.program.*;
import java.util.Arrays;

public class SearchingRunner extends ConsoleProgram
{
    private static final int MAX = 1000000;
    private static final int VALUE = 27;

    public void run()
    {
        setFont("*-*-24");

        int[] nums = getRandomArray(1000000);

        long startTime = System.currentTimeMillis();
        boolean result = linearSearch(nums, VALUE);
        long stopTime = System.currentTimeMillis();

        if (result)
            println("Value found");
        else
            println("Value not found");
        println("Elapsed time for linear search: " + (stopTime - startTime) + " milliseconds.");

        Arrays.sort(nums);  // we'll talk about how this works later!

        startTime = System.currentTimeMillis();
        result = binarySearch(nums, VALUE);
        stopTime = System.currentTimeMillis();

        if (result)
            println("Value found");
        else
            println("Value not found");
        println("Elapsed time for binary search: " + (stopTime - startTime) + " milliseconds.");

        startTime = System.currentTimeMillis();
        result = recursiveBinarySearch(nums, VALUE);
        stopTime = System.currentTimeMillis();

        if (result)
            println("Value found");
        else
            println("Value not found");
        println("Elapsed time for recursive binary search: " + (stopTime - startTime) + " milliseconds.");

        
    }

    private int[] getRandomArray(int len)
    {
        int[] temp = new int[len];
        for (int i=0; i<len; i++)
            temp[i] = (int)(Math.random()*MAX);
        return temp;
    }

    private boolean linearSearch(int[] nums, int value)
    {
        for (int i=0; i<nums.length; i++)
        {
            if (nums[i]==value)
                return true;
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int value)
    {
        int low = 0;
        int high = nums.length-1;
        while (low <= high)
        {
            int mid = (low+high)/2;
            if (nums[mid]==value)
                return true;
            else  if (nums[mid]<value)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
    
    private boolean recursiveBinarySearch(int[] nums, int value)
    {
       return recursiveBinarySearch(nums, value, 0, nums.length-1);
    }
    
    private boolean recursiveBinarySearch(int[] nums, int value, int low, int high)
    {
        if (low > high)
           return false;
        else
        {
           int mid = (low + high)/2;
           if (nums[mid] == value)
               return true;
           else if (nums[mid]<value)
               return recursiveBinarySearch(nums, value, mid+1, high);
           else
               return recursiveBinarySearch(nums, value, low, mid-1);
        }
    }

    // can you also write binary search recursively?

}
