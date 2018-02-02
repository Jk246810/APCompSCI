 
public class SkiJumper extends Athlete implements Flier
{
    private int myNumJumps;
    
    public SkiJumper(String first, String last)
    {
        super(first, last, "Ski Jumping");
        myNumJumps = 0;
    }
    
    public void fly()
    {
        System.out.println("Using skis to take " + getName() + " into the air.  Whee!");
        myNumJumps++;
    }
    
    public void train(double hours)
    {
     System.out.println("I am on the slopes " + hours + " hours today.");
     super.train(hours);
    }
    
    public String getDietPlan() {return "45% protein, 45% carbs, 10% fat";}
    public int getJumps() {return myNumJumps;}
   
}
