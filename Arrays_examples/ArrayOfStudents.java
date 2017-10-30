
import acm.program.*;

public class ArrayOfStudents extends ConsoleProgram
{

    public void run()
    {
        String[] students;
        students = new String[30];
        initializeStudents(students);
        
        
        for (int i=0; i<students.length; i++){
            if (students[i].indexOf("e") != -1) {
                println(students[i]);
            }
        }
        int counter = 0;
       for (int i=0; i<students.length; i++){
            if (students[i].indexOf("k") != -1) {
                counter ++;
                
            }
            
        } 
        println(counter);
        
        String champion = students[0];
        
        for (int i=1; i<students.length; i++){
            if (students[i].length() < champion.length()) {
                champion = students[i] ;
                
            }
            
        }  
        println(champion);
    }

    
    public void initializeStudents(String[] students)
    {
        students[0] = "Francesca Boerio";
        students[1] = "Jackson Clevenger";
        students[2] = "Grace Connors";
        students[3] = "Emerson Enright";
        students[4] = "Alejandro Grau";
        students[5] = "Madeline Ho";
        students[6] = "Lauren Krikorian";
        students[7] = "Theresa Lim";
        students[8] = "Nick Lin";
        students[9] = "Kevin Molumphy";
        students[10] = "Sean Morrissey";
        students[11] = "John Petrakian";
        students[12] = "Matt Smithers";
        students[13] = "Alexander Tsotadze";
        students[14] = "Zach Abuel-Saud";
        students[15] = "Asha Ararwal";
        students[16] = "Sean Barada";
        students[17] = "Mark Botros";
        students[18] = "Antonio Caceres";
        students[19] = "Cate Desler";
        students[20] = "Simon Koeten";
        students[21] = "Jamee Krzanich";
        students[22] = "John McGrory";
        students[23] = "Andrew McLean";
        students[24] = "Anderson Page";
        students[25] = "Luke Peterson";
        students[26] = "Stefan Schlotter";
        students[27] = "Olivia Smith";
        students[28] = "Will Texido";
        students[29] = "Teddy Vought";        
    }
}
