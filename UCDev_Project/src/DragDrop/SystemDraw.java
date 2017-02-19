package DragDrop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class SystemDraw extends JPanel{
    Graphics g;
    Graphics2D g2d;
    
    public SystemDraw(){
        setBackground(Color.white);
        
        g2d = (Graphics2D) g;
        g2d.drawOval(50, 50, 70, 70);
        g2d.setColor(Color.black);
    }
}
