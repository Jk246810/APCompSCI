
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class MountainPathFinder extends GraphicsProgram
{
    private TopographicMap mountainMap;

    private JButton loadButton;
    private JButton drawButton;
    private JButton findPathButton;
    private JTextField fileNameField;
    private JTextField rowsField, colsField;

    public void init()
    {
        setSize(960, 560);
        setTitle("Mountain Path Finder");
        initGUI();
    }

    public void run()
    {
        addActionListeners();
    }

    private void initGUI()
    {
        JLabel fileNameLabel = new JLabel("File name:"); 
        add(fileNameLabel, NORTH);
        fileNameField = new JTextField("Colorado_480x480.txt", 18); 
        add(fileNameField, NORTH); 
        
         JLabel mapSizeLabel = new JLabel("Map size:"); 
         add(mapSizeLabel, NORTH);
         
         rowsField = new JTextField("480", 4); 
        add(rowsField, NORTH); 
        
         JLabel xLabel = new JLabel("x"); 
         add(xLabel, NORTH);
         
         colsField = new JTextField("480", 4); 
        add(colsField, NORTH); 
        
        loadButton = new JButton("Load File"); 
        add(loadButton, NORTH); 
        
        
        drawButton = new JButton("Draw Map"); 
        drawButton.setEnabled(false);
        add(drawButton, NORTH); 
        
        findPathButton = new JButton("Find Path"); 
        findPathButton.setEnabled(false);
        add(findPathButton, NORTH); 
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == loadButton)
            handleLoadButton();
        else if (event.getSource() == drawButton)
            handleDrawButton();
        else if (event.getSource() == findPathButton)
            handleFindPathButton();
        // more to do here eventually
    }

    private void handleLoadButton()
    {
        String filename = fileNameField.getText();
        int rows = Integer.parseInt(rowsField.getText()); 
        int cols = Integer.parseInt(colsField.getText()); 
        mountainMap = new TopographicMap(filename, rows, cols);
        drawButton.setEnabled(true); 
        findPathButton.setEnabled(true); 
        
        if(mountainMap.isValid())
        {
            JOptionPane.showMessageDialog(this, "the map data was loaded successfully"); 
            drawButton.setEnabled(true); 
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "something went wrong loading the map data");
            drawButton.setEnabled(false);
        }
        // you'll do this in task #2
    }
    
    private void handleDrawButton(){
        mountainMap.drawMap(this);
        
    }
    
    private void handleFindPathButton(){
         mountainMap.greenTopPath(this);
         mountainMap.greenPath(this);
        
         
    }
    

}
