package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class FileBrowser extends JInternalFrame{

    private DefaultMutableTreeNode root;

    private DefaultTreeModel treeModel;

    private JTree tree;

    public FileBrowser() {
        setSize(300,500);

        File fileRoot = new File("C:\\Users\\NUT\\Documents\\GitHub\\Project_UCDev\\UCDev_Project\\List");
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);

        tree = new JTree(treeModel);
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);

        

        CreateChildNodes ccn
                = new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();

        tree.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                if (((event.getModifiers() & InputEvent.BUTTON3_MASK) != 0)
                        && (tree.getSelectionCount() > 0)) {
                    showMenu(event.getX(), event.getY());
                }
            }
        });
        getContentPane().add(tree);
        setVisible(true);
    }

    public class CreateChildNodes implements Runnable {

        private DefaultMutableTreeNode root;

        private File fileRoot;

        public CreateChildNodes(File fileRoot,
                DefaultMutableTreeNode root) {
            this.fileRoot = fileRoot;
            this.root = root;
        }

        @Override
        public void run() {
            createChildren(fileRoot, root);
        }

        private void createChildren(File fileRoot, DefaultMutableTreeNode node) {
            File[] files = fileRoot.listFiles();
            if (files == null) {
                return;
            }

            for (File file : files) {
                DefaultMutableTreeNode childNode
                        = new DefaultMutableTreeNode(new FileNode(file));
                node.add(childNode);
                if (file.isDirectory()) {
                    createChildren(file, childNode);
                }
            }
        }

    }

    public class FileNode {

        private File file;

        public FileNode(File file) {
            this.file = file;
        }

        @Override
        public String toString() {
            String name = file.getName();
            if (name.equals("")) {
                return file.getAbsolutePath();
            } else {
                return name;
            }
        }
    }

    protected void showMenu(int x, int y) {
        JPopupMenu popup = new JPopupMenu();
        JMenuItem mi = new JMenuItem("Delete");
        JMenuItem edit = new JMenuItem("Edit");
        TreePath path = tree.getSelectionPath();
        Object node = path.getLastPathComponent();
        if (node == tree.getModel().getRoot()) {
            mi.setEnabled(false);
            edit.setEnabled(false);
        }
        popup.add(mi);
        popup.add(edit);

        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                deleteSelectedItems();
            }
        });

        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //deleteSelectedItems();
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();
                String file = selectedNode.getUserObject().toString();
                //ReadXML xml;
                //xml = new ReadXML("1","","","", "D:\\" + file);
                System.out.println(file);
                //xml.getFileName();
                //JOptionPane.showMessageDialog(null, file);
            }
        });
        popup.show(tree, x, y);
    }

    protected void deleteSelectedItems() {
        DefaultMutableTreeNode node;
        DefaultTreeModel model = (DefaultTreeModel) (tree.getModel());
        TreePath[] paths = tree.getSelectionPaths();
        for (int i = 0; i < paths.length; i++) {
            node = (DefaultMutableTreeNode) (paths[i].getLastPathComponent());
            model.removeNodeFromParent(node);
        }
    }

}
