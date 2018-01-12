import java.util.*;
import acm.program.*;

public class SeatingChartRunner extends ConsoleProgram
{

    public void run()
    {
        ArrayList<Student> roster = new ArrayList<Student>();
        roster.add(new Student("Karen", 3));
        roster.add(new Student("Liz", 1));
        roster.add(new Student("Paul", 4));
        roster.add(new Student("Lester", 1));
        roster.add(new Student("Henry", 5));
        roster.add(new Student("Renee", 9));
        roster.add(new Student("Glen", 2));
        roster.add(new Student("Fran", 6));
        roster.add(new Student("David", 1));
        roster.add(new Student("Danny", 3));
        
        SeatingChart chart = new SeatingChart(roster, 3, 4);
        println(chart);
        
        println();
        int removed = chart.removeAbsentStudents(4);
        println("Here is the chart after " + removed + " students were removed.");
        println(chart);
    }

}
