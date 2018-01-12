

public class Student
{
    private String name;
    private int absences;

    public Student(String name, int absences)
    {
        this.name = name;
        this.absences = absences;
    }
    
    public String getName() { return name; }
    public int getAbsenceCount() { return absences; }
    public String toString() { return name + " (" + absences + ")"; }


}
