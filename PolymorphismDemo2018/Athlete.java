
public abstract class Athlete
{ 
    private String myFirstName;
    private String myLastName;
    private String mySport;
    private double myHoursTraining;
    
    public Athlete(String firstName, String lastName, String sportPlayed)
    {
        myFirstName = firstName;
        myLastName = lastName;
        mySport = sportPlayed;
        myHoursTraining = 0.0;
    }
    
    public void train(double hours)
    {
        System.out.println(getName() + " training for " + hours + " hours.");
        myHoursTraining += hours;
    }
    
    public abstract String getDietPlan();
   
    public String getName() {return myFirstName + " " + myLastName;}
    public String getSport() {return mySport;}
    public double getHoursTraining() {return myHoursTraining;}
    
}
