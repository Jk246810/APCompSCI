
import acm.program.*;

public class FibonacciSequence extends ConsoleProgram
{

    public void run()
    {
        int[] nums;
        nums = new int[45];
        nums[0] = 0;
        nums[1] = 1;
        for (int i=2; i<nums.length; i++)
        {
            nums[i] = nums[i-1] + nums[i-2];
            
        }
        println(nums[nums.length-1]);
    }

}
