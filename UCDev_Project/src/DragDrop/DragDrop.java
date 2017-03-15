
package DragDrop;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

public class DragDrop {
    public int x,y;
    public int w,h;
    public Graphics2D g2d;
    
    public DragDrop(int x,int y){
        this.x = x;
        this.y = y;
        w = 60;
        h = 60;
        
    }

    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getW(){
        return w;
    }
    
    public int getH(){
        return h;
    }
    
    public void paint(Graphics g){
        g2d = (Graphics2D) g;
        g2d.drawRect(x, y, w, h);
    }
    
    public void paintOval(Graphics g){
        g2d = (Graphics2D) g;
        g2d.drawOval(x, y, w, h);
    }
}
