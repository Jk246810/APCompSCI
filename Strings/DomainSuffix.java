
import acm.program.*;

public class DomainSuffix extends ConsoleProgram
{

    public void run()
    {
        
        while(true)
        {
            String url = readLine("enter a website ");
            int dot = url.indexOf(".");
            String rest = url.substring(dot + 1);
            dot = rest.indexOf(".");
            int slash = rest.indexOf("/");
            String suffix;
            if (slash == -1)
            {
                suffix = rest.substring(dot+1);
                
            }else
            {
                suffix = rest.substring(dot+1, slash);
               
            }
            println(suffix);
            
        }
    }


}
