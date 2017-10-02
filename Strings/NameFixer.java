
import acm.program.*;

public class NameFixer extends ConsoleProgram
{

    public void run()
    {
        while (true)
        {
            String fullName = readLine("Enter your name: ");
            int space = fullName.indexOf(" ");
            if (space == -1)
                println(fullName);
            else
            {
                String first = fullName.substring(0, space);
                String last = fullName.substring(space+1);
                println(last + ", " + first);
            }
        }
    }

}
