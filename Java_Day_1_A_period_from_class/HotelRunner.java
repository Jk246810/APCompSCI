
import acm.program.*;

public class HotelRunner extends ConsoleProgram
{

    public void run()
    {
        HotelTelevision tv;
        tv = new HotelTelevision(8);
        
        tv.channelUp();
        for (int i=0; i<10; i++)
        {
            tv.channelDown();
        }
        println("You are on channel " + tv.getChannel());
        String channel = tv.getChannelName();
        println("I love " + channel + "!");
        
        int differentChannel = readInt("Enter a channel: ");
        tv.setChannel(differentChannel);
        
        println("You are on " + tv.getChannel() + " which is " + tv.getChannelName() + ".");
    }


}
