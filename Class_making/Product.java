

public class Product
{
    private String name;
    private double price; 

    public Product(String startingName, double startingPrice)
    {
        name = startingName;
        price = startingPrice;

    }
    
    public void reducePrice(double discount)
    {
        price = price - discount;
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getPrice()
    {
        return price;
    }


}
