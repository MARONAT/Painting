package painter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
public class PaintPanel extends JPanel {
    //count number of points
    private int pointCount;
    // array of 10000 java.awt.Point references
    private Point[] points = new Point[10000];
    // set up GUI and register mouse event handler
    public PaintPanel(){
        //handle frame mouse motion event
        addMouseMotionListener(
                new MouseMotionAdapter() // anonymous inner class
                 {  
            // store drag coordinates and repaint
            @Override
            public void mouseDragged(MouseEvent event)
            { // start method mouseDragged
               if ( pointCount < points.length ) 
               { //start if
                   
                  points[pointCount] = event.getPoint(); // find point
                  ++pointCount; // increment number of points in array
                  repaint(); // repaint JFrame
                  
               } // end if
            } // end method mouseDragged
         } // end anonymous inner class
      ); // end call to addMouseMotionListener
        
    }//end gui PaintPanel constructor
    //draw ovals in a 4x4 bounding box at spcified locations
    @Override
    public void paintComponent(Graphics g){
        // clears the drawing area 
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        setBackground(Color.yellow);
        //draw all points in the array
        for(int i = 0; i < pointCount; i++)
        g.drawOval(points[i].x, points[i].y,4,4);
          
    }//end paint component class
}//end class
