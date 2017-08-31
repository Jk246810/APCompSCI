
import acm.program.*;

public class HotelRunner extends ConsoleProgram
{

    public void run()
    {
        HotelTelevision tv; 
        tv = new HotelTelevision(4);
        
        for (int i=0; i<8; i++)
        {
            tv.channelUp();
        
        
        
            println("the channel you are on " + tv.getChannel() + " name is " + tv.getChannelName());
        }
        
        tv.setChannel(700);
        println("the channel you are on " + tv.getChannel() + " name is " + tv.getChannelName());
    }


}
