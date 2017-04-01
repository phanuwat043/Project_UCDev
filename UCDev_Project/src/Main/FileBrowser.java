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

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import GenXML.*;
import FunctionFrame.*;
import org.w3c.dom.Node;

public class FileBrowser extends JInternalFrame {

    UCDev_Main uc;
    String file;
    ReadActorXML readXML;
    ReadXML_Usecase readUseXML;
    
    public FileBrowser() {
        setSize(300, 500);

        File fileRoot = new File("D:\\Doc\\");
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
        tree.repaint();
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
        popup = new JPopupMenu();
        mi = new JMenuItem("Delete");
        edit = new JMenuItem("Edit");
        path = tree.getSelectionPath();
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
                //actorForm aForm = new actorForm();
                
                Object[] paths = tree.getSelectionPath().getPath();
                selectedNode = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();
                String fileActor = selectedNode.getUserObject().toString();
                String fileUsecase = selectedNode.getUserObject().toString();
                
                System.out.println(fileActor);
                if(paths[2].toString().equals("Actor")){
                    actorForm aForm = new actorForm();
                    readXML = new ReadActorXML("Id", "title", "description", "stereotype", "D:\\Doc\\" + paths[1] + "\\"+paths[2]+"\\" + fileActor);
                    String id, title, des, type;

                    for (int temp = 0; temp < readXML.nList.getLength(); temp++) {
                        readXML.nNode = readXML.nList.item(temp);
                        if (readXML.nNode.getNodeType() == Node.ELEMENT_NODE) {

                            readXML.eElement = (Element) readXML.nNode;

                            id = readXML.eElement.getElementsByTagName(readXML.id).item(0).getTextContent();
                            title = readXML.eElement.getElementsByTagName(readXML.title).item(0).getTextContent();
                            des = readXML.eElement.getElementsByTagName(readXML.descrip).item(0).getTextContent();
                            type = readXML.eElement.getElementsByTagName(readXML.sterio).item(0).getTextContent();

                            aForm.txtID.setText(id);
                            aForm.txtTitle.setText(title);
                            aForm.txtDes.setText(des);
                            aForm.comboType.setSelectedItem(type);
                        }
                    }
                }
                if(paths[2].toString().equals("UseCase")){
                    scenarioForm scenario = new scenarioForm();
                    readUseXML = new ReadXML_Usecase("use-case-Id","use-case-Name","primary-actor","priority","complexity"
                            ,"goal","pre-requisites","success-outcome","main-flow"
                            ,"alternate-flows","exception-flows","D:\\Doc\\"+paths[1]+"\\"+paths[2]+"\\"+fileUsecase);
                    
                    String id,name,primary,priority,complex,goal,pre,post,flow,alternate,exception;
                    
                    for (int temp = 0; temp < readUseXML.nList.getLength(); temp++) {
                        readUseXML.nNode = readUseXML.nList.item(temp);
                        if (readUseXML.nNode.getNodeType() == Node.ELEMENT_NODE) {

                            readUseXML.eElement = (Element) readUseXML.nNode;

                            id = readUseXML.eElement.getElementsByTagName(readUseXML.id).item(0).getTextContent();
                            name = readUseXML.eElement.getElementsByTagName(readUseXML.name).item(0).getTextContent();
                            primary = readUseXML.eElement.getElementsByTagName(readUseXML.primay).item(0).getTextContent();
                            priority = readUseXML.eElement.getElementsByTagName(readUseXML.priority).item(0).getTextContent();
                            complex = readUseXML.eElement.getElementsByTagName(readUseXML.complex).item(0).getTextContent();
                            goal = readUseXML.eElement.getElementsByTagName(readUseXML.goal).item(0).getTextContent();
                            pre = readUseXML.eElement.getElementsByTagName(readUseXML.pre).item(0).getTextContent();
                            post = readUseXML.eElement.getElementsByTagName(readUseXML.post).item(0).getTextContent();
                            flow = readUseXML.eElement.getElementsByTagName(readUseXML.flow).item(0).getTextContent();
                            alternate = readUseXML.eElement.getElementsByTagName(readUseXML.alternate).item(0).getTextContent();
                            exception = readUseXML.eElement.getElementsByTagName(readUseXML.exception).item(0).getTextContent();
                            
                            scenario.txtUID.setText(id);
                            scenario.txtUname.setText(name);
                            scenario.txtPrimaryActor.setText(primary);
                            scenario.priorityCombo.setSelectedItem(priority);
                            scenario.complexCombo.setSelectedItem(complex);
                            scenario.txtGoal.setText(goal);
                            scenario.txtPre.setText(pre);
                            scenario.txtPost.setText(post);
                        }
                    }
                }
            }
        });
        popup.show(tree, x, y);
    }

    protected void deleteSelectedItems() {
        Object[] paths1 = tree.getSelectionPath().getPath();
        DefaultMutableTreeNode node;
        DefaultTreeModel model = (DefaultTreeModel) (tree.getModel());
        paths = tree.getSelectionPaths();
        File file = new File("D:\\Doc\\"+paths1[1]+"\\"+paths1[2]+"\\"+paths1[3]);
        System.out.println(file);
        file.delete();
        for (int i = 0; i < paths.length; i++) {
            node = (DefaultMutableTreeNode) (paths[i].getLastPathComponent());
            model.removeNodeFromParent(node);
        }
    }
    
    public String getFile() {
        return file;
    }

    public JPopupMenu popup;
    public JMenuItem mi;
    public JMenuItem edit;
    public TreePath path;
    public JTree tree;
    public DefaultMutableTreeNode root;
    public DefaultTreeModel treeModel;
    public DefaultMutableTreeNode selectedNode;
    public TreePath[] paths;
}
