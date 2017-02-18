
package Actor;

import javax.swing.JFrame;

public class MyWindow {
    public static void main(String[] arg) {
        JFrame frame = new JFrame("qwe");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SMCanvas panel = new SMCanvas();
        //panel.setLayout(null);
        frame.add(panel);
    }
}
