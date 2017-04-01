/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DragDrop;

import FunctionFrame.scenarioForm;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SurfaceResize extends JPanel {

    private Point2D[] points;
    private final int SIZE = 8;
    private int pos;
    Ellipse2D r;
    Point p;
    Graphics2D g2;
    
    double x,y;
    public SurfaceResize() {
        initUI();
    }

    private void initUI() {

        addMouseListener(new ShapeTestAdapter());
        addMouseMotionListener(new ShapeTestAdapter());
        pos = -1;

        points = new Point2D[2];
        points[0] = new Point2D.Double(50, 50);
        points[1] = new Point2D.Double(150, 100);
    }
    
    private void doDrawing(Graphics g) {
        
        g2 = (Graphics2D) g;

        for (Point2D point : points) {
            x = point.getX() - SIZE / 2;
            y = point.getY() - SIZE / 2;
            g2.fill(new Rectangle2D.Double(x, y, SIZE, SIZE));
        }

        r = new Ellipse2D.Double();
        r.setFrameFromDiagonal(points[0], points[1]);

        g2.draw(r);        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        doDrawing(g);
    }

    private class ShapeTestAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent event) {

            p = event.getPoint();
            
            for (int i = 0; i < points.length; i++) {

                double x = points[i].getX() - SIZE / 2;
                double y = points[i].getY() - SIZE / 2;

                r = new Ellipse2D.Double(x, y, SIZE, SIZE);

                if (r.contains(p)) {

                    pos = i;
                    return;
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            p = event.getPoint();
            if(r.contains(p)){
                System.out.println("ok");
                scenarioForm s = new scenarioForm();
            }
            pos = -1;
        }

        @Override
        public void mouseDragged(MouseEvent event) {

            if (pos == -1) {
                return;
            }
            points[pos] = event.getPoint();
            
            repaint();
        }
    }
}

/*public class MovingScalingEx extends JFrame {
    
    public MovingScalingEx() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new SurfaceResize());

        setTitle("Moving and scaling");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);        
    }

    public static void main(String[] args) {        
        
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                MovingScalingEx ex = new MovingScalingEx();
                ex.setVisible(true);
            }
        });
    }
}*/