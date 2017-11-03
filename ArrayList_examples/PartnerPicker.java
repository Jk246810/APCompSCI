//jamee Krzanich, Period C
import acm.program.*;
import java.util.ArrayList;

public class PartnerPicker extends ConsoleProgram
{

    public void run()
    {
        ArrayList<String> students = new ArrayList<String>();
        
        students.add("Jamee Krzanich");
        students.add("jim boy"); 
        students.add("Bob swanson");
        students.add("jerry simspon");
        students.add("taco man");
        ArrayList<String> twoStudents = new ArrayList<String>();
        for(int i=0; i<students.size(); i++)
        {
            
            for(int j=0; j<2; j++)
            {
            
                
                int student = (int)(Math.random()*students.size());
                twoStudents.add(students.get(student));
                students.remove(student); 
             
                
               
            
            }
            
            println(twoStudents.get(twoStudents.size()-2) + " and" + twoStudents.get(twoStudents.size()-1) + " are working together");
            
            
            if(students.size() == 1)
               {
                    println(students.get(0) + " and the teacher will work together");
               } 
        }
        /*
         * 
         * 0.  Add some students.
         * 1.  Pick two random students and remove them from the ArrayList.
         * 2.  Repeat step #1 until there are no more students.
         * 3.  What if there are an odd number of students?
         *     Either make one person go solo, or make one group of three.
         */

    }
}