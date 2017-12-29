import java.util.ArrayList;
 
public class DigAdministration
{
    public static void main(String[] args)
    {
        System.out.println("FIRST SITE:");
        ArrayList<Archaeologist> group1 = new ArrayList<Archaeologist>();
        group1.add(new Archaeologist("Francesca", "Gators", 56432));
        group1.add(new Archaeologist("Jackson", "Iowa", 71650));
        group1.add(new Archaeologist("Grace", "Boston", 57735));
        group1.add(new Archaeologist("Emerson", "Gators", 34902));
        group1.add(new Archaeologist("Alex", "Iowa", 63028));
        group1.add(new Archaeologist("Maddie", "Bulldogs", 11853));
        group1.add(new Archaeologist("Lauren", "Gators", 44822));
        group1.add(new Archaeologist("Theresa", "Gators", 12693));
        Site site1 = new Site(group1, 3, 5);
        site1.printSiteInfo();

        System.out.println();
        System.out.println("SECOND SITE:");        
        ArrayList<Archaeologist> group2 = new ArrayList<Archaeologist>();
        group2.add(new Archaeologist("Zach", "Gators", 65423));
        group2.add(new Archaeologist("Asha", "Iowa", 17549));
        group2.add(new Archaeologist("Sean", "Boston", 72239));
        group2.add(new Archaeologist("Mark", "Gators", 98155));
        group2.add(new Archaeologist("Antonio", "Bulldogs", 12808));
        group2.add(new Archaeologist("Cate", "Gators", 28192));
        group2.add(new Archaeologist("Simon", "Gators", 74347));
        group2.add(new Archaeologist("Jamee", "Iowa", 14013));
        group2.add(new Archaeologist("John", "Gators", 52681));
        group2.add(new Archaeologist("Andrew", "Gators", 19206));
        group2.add(new Archaeologist("Anderson", "Gators", 48460));
        group2.add(new Archaeologist("Luke", "Boston", 93277));
        group2.add(new Archaeologist("Stefan", "Gators", 41932));
        group2.add(new Archaeologist("Olivia", "Gators", 36998));
        group2.add(new Archaeologist("Will", "Bulldogs", 30078));
        group2.add(new Archaeologist("Teddy", "Gators", 22495));
        group2.add(new Archaeologist("Brian", "Gators", 30236));
        group2.add(new Archaeologist("Matt", "Boston", 68204));

        Site site2 = new Site(group2, 4, 2);
        site2.printSiteInfo();

        System.out.println();
        System.out.println("SECOND SITE AFTER REMOVING \"Iowa\":");
        int removed = site2.clearSomeQuadrants("Iowa");
        site2.printSiteInfo();
        System.out.println("Number removed = " + removed);
    }
}
