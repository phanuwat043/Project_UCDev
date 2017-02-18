
package Actor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.*;
import javax.swing.JPanel;

public class Actor extends JPanel implements MouseListener, MouseMotionListener{
    Ellipse2D eclipse = new Ellipse2D.Double(0, 0, 100, 50);
    Graphics2D g2d;
    int x,y;
    
    public Actor(){
        setBackground(Color.white);
        addMouseMotionListener(this);
        addMouseListener(this);
        
        
    }
    
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(5, 5, 60, 60);
        g2d.setColor(Color.red);
    }
}
