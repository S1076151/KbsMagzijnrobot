package tspsysteem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;




public class PaintPanel extends JPanel {
  private int rows;
  private int collums;
    
    
    public PaintPanel (int r, int c){
        setPreferredSize(new Dimension (1200,800));
        rows = r;
        collums = c;
        
        
    }
    

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponents(g);
        setBackground(Color.white);
        g.setColor(Color.red);
      
        g.fillRect(20, 20, 30, 30);
        int i;
        int rowHt = 800/(rows);
        for (i = 0; i < rows; i++)
      g.drawLine(0, i * rowHt ,  1200, i * rowHt );
        
         int rowWid = 1200 / (collums);
    for (i = 0; i < collums; i++)
      g.drawLine(i * rowWid, 0, i * rowWid, 800);
        
    g.drawLine(1199, 0, 1199, 800);
    g.drawLine(0, 799, 1199, 799);
        
        
        
         
       
    
        
        
    }

    
}



