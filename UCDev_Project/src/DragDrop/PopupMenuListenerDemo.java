/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DragDrop;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

// Define PopupMenuListener
class MyPopupMenuListener implements PopupMenuListener {
  public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
    System.out.println("Canceled");
  }

  public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
    System.out.println("Becoming Invisible");
  }

  public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
    System.out.println("Becoming Visible");
  }
}

public class PopupMenuListenerDemo {
  public static void main(final String args[]) {
    JFrame frame = new JFrame("PopupSample Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Create popup menu, attach popup menu listener
    JPopupMenu popupMenu = new JPopupMenu("Title");
    PopupMenuListener popupMenuListener = new MyPopupMenuListener();

    popupMenu.addPopupMenuListener(popupMenuListener);

    // Cut
    JMenuItem cutMenuItem = new JMenuItem("Cut");
    popupMenu.add(cutMenuItem);

    // Copy
    JMenuItem copyMenuItem = new JMenuItem("Copy");
    popupMenu.add(copyMenuItem);
    // Paste
    JMenuItem pasteMenuItem = new JMenuItem("Paste");
    pasteMenuItem.setEnabled(false);
    popupMenu.add(pasteMenuItem);

    // Separator
    popupMenu.addSeparator();

    // Find
    JMenuItem findMenuItem = new JMenuItem("Find");
    popupMenu.add(findMenuItem);
    JButton label = new JButton();
    frame.add(label);
    label.setComponentPopupMenu(popupMenu);

    frame.setSize(350, 250);
    frame.setVisible(true);
  }
}
