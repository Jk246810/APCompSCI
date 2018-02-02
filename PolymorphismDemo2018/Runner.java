
public class Runner extends Athlete
{
	private int myNumRaces;
	private double myMilesRaced;
	 
	public Runner(String first, String last)
	{
	    super(first, last, "Running");
	    myNumRaces = 0;
	    myMilesRaced = 0;
	}
	
	public void race(double raceLength)
	{
	 System.out.println(getName() + " is racing in a " + raceLength + 
	                    " mile race.");
	 myNumRaces++;
	 myMilesRaced  += raceLength;
	}
	
	public int getRaces() { return myNumRaces;}
	public double getMilesRaced() { return myMilesRaced;}
	public String getDietPlan() {return "25% protein, 65% carbs, 10% fat";}

}
