package DragDrop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ajarn
 */
 
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Graphics2D;

public class MyImagePanel extends JPanel {
    private BufferedImage bi;
    int x, y;
    String current, filePath;
    
        public MyImagePanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        addMouseMotionListener(new MouseMotionHandler());
        
         try {                
          current = new java.io.File( "." ).getCanonicalPath();
          filePath = current + "\\actor.jpg";
         } catch (IOException ex) {
            // handle exception...
         }
          Image image = getToolkit().getImage(filePath);
          MediaTracker mt = new MediaTracker(this);
          mt.addImage(image, 1);
           try {
             mt.waitForAll();
            } catch (Exception e) {
                System.out.println("Exception while loading image.");
            } 
           
           if (image.getWidth(this) == -1) {
            System.out.println("no jpg file");
            System.exit(0);
           }
           bi = new BufferedImage(image.getWidth(this), image.getHeight(this),
            BufferedImage.TYPE_INT_ARGB);
            Graphics2D big = bi.createGraphics();
            big.drawImage(image, 0, 0, this);
       
    //}
        
      
    }

        
    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

        
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bi, x, y, this);
        /*g.drawString("This is my custom Panel!",10,20);
        g.setColor(Color.RED);
        g.fillRect(squareX,squareY,squareW,squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW,squareH);*/
    }  
    
    class MouseMotionHandler extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent e) {
      x = e.getX();
      y = e.getY();
      repaint();
    }
  }
}


