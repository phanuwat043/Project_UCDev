
package DragDrop;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RectangleDraw {
    
    public Point2D[] points;
    public final int SIZE = 8;
    public int pos;

    public RectangleDraw(){
        pos = -1;

        points = new Point2D[2];
        points[0] = new Point2D.Double(50, 50);
        points[1] = new Point2D.Double(150, 100);
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (Point2D point : points) {
            double x = point.getX() - SIZE / 2;
            double y = point.getY() - SIZE / 2;
            g2.fill(new Rectangle2D.Double(x, y, SIZE, SIZE));
        }

        Rectangle2D r = new Rectangle2D.Double();
        r.setFrameFromDiagonal(points[0], points[1]);

        g2.draw(r);        
    }
    
    public void paintComponent(Graphics g){
        paintComponent(g);
        doDrawing(g);
    }

    public Point2D[] getPoints() {
        return points;
    }

    public int getSIZE() {
        return SIZE;
    }

    public int getPos() {
        return pos;
    }
    
}
