import acm.graphics.*;
import java.awt.Color;
import acm.program.*;

public class TopographicMap
{
    // private instance variables
    private double[][] mapData;
    private boolean valid;

    public TopographicMap(String filename, int rows, int cols)
    {
        // you'll do this in task #1
        double[] nums = FileHelper.readDataFromFile(filename, rows*cols);
        if(nums.length == 0)
        {
            valid = false; 
        }else 
        {
            valid = true; 
            mapData = new double[rows][cols]; 
            for(int i=0; i<nums.length; i++)
            {
                mapData[i/cols][i%cols] =  nums[i]; 
            }
        }
    }

    public boolean isValid() {return valid;}

    private double findMaximum()
    {
        double champion = mapData[0][0]; 
        // you'll do this in task #3
        for(int r=0; r<mapData.length; r++)
        {
            for(int c=0; c<mapData[0].length; c++)
            {
                if(mapData[r][c] > champion)
                {
                    champion = mapData[r][c];
                }
            }
        }
        return champion; // just to get it to compile
    }

    private double findMinimum()
    {
        double champion = mapData[0][0]; 
        // you'll do this in task #3
        for(int r=0; r<mapData.length; r++)
        {
            for(int c=0; c<mapData[0].length; c++)
            {

                if(mapData[r][c] < champion)
                {

                    champion = mapData[r][c];
                }
            }
        }
        return champion; 
    }

    public void drawMap(GraphicsProgram graphics)
    {

        double min = this.findMinimum();
        double max = this.findMaximum();
        for(int r=0; r<mapData.length; r++)
        {
            for(int c=0; c<mapData.length; c++)
            {
                GRect block= new GRect(c,r,1,1); 
                int num = (int)(((mapData[r][c]-min)/(max-min))*255);
                Color myColor = new Color(num, num, num); 
                block.setColor(myColor); 
                block.setFilled(true); 
                graphics.add(block); 

            }
        }

        // you'll do this in task #4
    }

    public double drawLowestElevPath(GraphicsProgram graphics, int startRow, Color drawColor)
    {
        // you'll do this in task #5 
        createBlock(graphics, 0,startRow,1,1,drawColor); 
        int choosingRow = startRow;
        double counter =0; 
       

        for(int c=1; c<mapData[0].length; c++)
        {
            double middle = Math.abs(mapData[choosingRow][c-1]-mapData[choosingRow][c]);
            
            
            if(choosingRow > 0 && choosingRow != mapData.length-1){
                double top = Math.abs(mapData[choosingRow][c-1]-mapData[choosingRow-1][c]);
                double bottom = Math.abs(mapData[choosingRow][c-1]-mapData[choosingRow+1][c]);
                if(top <= middle && top<= bottom)
                {
                   createBlock(graphics,c,choosingRow-1,1,1,drawColor);
                    counter+= top; 
                    choosingRow--;   
                }else if(bottom < middle && bottom<top)
                {
                    createBlock(graphics,c,choosingRow+1,1,1,drawColor);
                   
                    counter+= bottom;
                    choosingRow++;
                }else{
                    createBlock(graphics,c,choosingRow,1,1,drawColor); 
                    counter+=middle;
                }

            }else if(choosingRow == 0)
            {
                double bottom = Math.abs(mapData[choosingRow][c-1]-mapData[choosingRow+1][c]);
                if(bottom < middle)
                {
                    createBlock(graphics,c,choosingRow+1,1,1,drawColor);
                    counter+= bottom;
                    choosingRow++;
                }else{
                    createBlock(graphics,c,choosingRow,1,1,drawColor); 
                    counter+=middle;
                }
            }else{
                 double top = Math.abs(mapData[choosingRow][c-1]-mapData[choosingRow-1][c]);
                if(top < middle)
                {
                    createBlock(graphics,c,choosingRow-1,1,1,drawColor);
                    counter+= top; 
                    choosingRow--; 
                }
                else{
                    createBlock(graphics,c,choosingRow,1,1,drawColor); 
                    counter+=middle;
                }
            }

        }
        return counter; 

    }
    
    public double drawElevFromTop(GraphicsProgram graphics, int startCol, Color drawColor)
    {
        createBlock(graphics, startCol,0,1,1,drawColor); 
        int choosingCol = startCol;
        double counter =0; 
        for(int r=1; r<mapData.length; r++)
        {
            double middle = Math.abs(mapData[r-1][choosingCol]-mapData[r][choosingCol]);
            if(choosingCol > 0 && choosingCol != mapData[0].length-1){
                double top = Math.abs(mapData[r-1][choosingCol]-mapData[r][choosingCol-1]);
                double bottom = Math.abs(mapData[r-1][choosingCol]-mapData[r][choosingCol+1]);
                 if(top <= middle && top<= bottom)
                {
                    createBlock(graphics,choosingCol-1,r,1,1,drawColor);
                    counter+= top; 
                    choosingCol--;   
                }
                else if(bottom < middle && bottom<top)
                {
                    createBlock(graphics,choosingCol+1,r,1,1,drawColor);
                    counter+= bottom;
                    choosingCol++;
                }else{
                    createBlock(graphics,choosingCol,r,1,1,drawColor); 
                    counter+=middle;
                }
                
            }else if(choosingCol == 0)
            {
                 double bottom = Math.abs(mapData[r-1][choosingCol]-mapData[r][choosingCol+1]);
                 if(bottom < middle)
                {
                    createBlock(graphics,choosingCol+1,r,1,1,drawColor);
                    counter+= bottom;
                    choosingCol++;
                }else{
                    createBlock(graphics,choosingCol,r,1,1,drawColor); 
                    counter+=middle;
                }
            }
            else{
                double top = Math.abs(mapData[r-1][choosingCol]-mapData[r][choosingCol-1]);
                if(top < middle)
                {
                    createBlock(graphics,choosingCol-1,r,1,1,drawColor);
                    counter+= top; 
                    choosingCol--; 
                }
                else{
                    createBlock(graphics,choosingCol,r,1,1,drawColor); 
                    counter+=middle;
                }
            }
            
        }
        return counter; 
        
    }
    
    public void createBlock(GraphicsProgram graphics, int column, int row, int size1, int size2, Color drawColor) 
    {
        GRect nBlock= new GRect(column,row,size1,size2); 
                    nBlock.setColor(drawColor); 
                    nBlock.setFilled(true); 
                    graphics.add(nBlock); 
    }

    public int getIndexOfLowestElevPath(GraphicsProgram graphics)
    {
        // you'll do this in task #6 
        int championI = 0;
       
        for(int r=0; r<mapData.length; r++)
        {
            
            if(drawLowestElevPath(graphics, r, Color.red) < drawLowestElevPath(graphics, championI, Color.red))
            {
                championI = r;
            }
           

        }
      
        return championI;
        // just to get it to compile
    }
    
    public int getIndexOfLowestElevPathTop(GraphicsProgram graphics)
    {
        // you'll do this in task #6 
        int championI = 0;
       
        for(int c=0; c<mapData[0].length; c++)
        {
            
            if(drawElevFromTop(graphics, c, Color.blue) < drawElevFromTop(graphics, championI, Color.blue))
            {
                championI = c;
            }
           

        }
      
        return championI;
        // just to get it to compile
    }
    
    public void greenPath(GraphicsProgram graphics)
    {
        drawLowestElevPath(graphics, getIndexOfLowestElevPath(graphics), Color.green); 
    }
    public void greenTopPath(GraphicsProgram graphics)
    {
        drawElevFromTop(graphics, getIndexOfLowestElevPathTop(graphics), Color.green); 
    }
    

}
