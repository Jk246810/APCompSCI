import acm.graphics.*;

public class GVectorPolygon extends GPolygon
{
    private double vx, vy;
    private double theta;
    private double maxX, maxY; // dimensions of the "window" to enable "wrapping around"

    private static final double MAXVELOCITY = 3;

    public GVectorPolygon(int width, int height)
    {
        vx = 0;
        vy = 0; 
        theta= 0; 
        maxX = width; 
        maxY = height; 
        // to be written in version 0.1
    }
    /** this means that this is now a java doc comment
     * @param numPixels how much you want to increase the velocity by; units are pixels per turn
     */
    public void increaseVelocity(double numPixels)
    {

        double thetaInRadians = theta * Math.PI/180;

        vx += numPixels * Math.cos(thetaInRadians); 
        vy += -numPixels * Math.sin(thetaInRadians); 
        double v = Math.sqrt(vx*vx + vy*vy);
        if (v > MAXVELOCITY)
        {
            vx *= MAXVELOCITY/v;
            vy *= MAXVELOCITY/v; 
        }
        // to be written in version 0.1
    }
    /**
     * this updates the position of the gvector polygon. you probably want to do this
     * repeatedly inside some loop 
     */
    public void updatePosition()
    {
        move(vx, vy); 
        if(getX()<0)
            setLocation(maxX, getY()); 
        if(getX() > maxX)

            setLocation(0,getY());
        if(getY()<0)
            setLocation(getX(), maxY); 

        if(getY() > maxY)

            setLocation(getX(),0);
        // to be written in version 0.1
    }

    public void rotate(double angle)
    {
        super.rotate(angle);
        theta += angle; 
        // to be written in version 0.1 
    }
     /**
      * gets the angle for the vector of this polygon 
      * @return the angle in degrees
      */
    public double getTheta()
    {
        return theta;
    }

    public double getVelocityX()
    {
        return vx;
    }

    public double getVelocityY()
    {
        return vy;
    }

    public GRectangle getBoundingRectangle()
    {
        return new GRectangle(0,0,maxX, maxY);
    }
}
