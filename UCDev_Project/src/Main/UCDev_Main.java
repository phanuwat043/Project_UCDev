package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

//Event of click and object
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.RepaintManager;

//import from DragDrop pagkage
import DragDrop.*;

//import from FunctionFrame
import FunctionFrame.dataDictForm;
import FunctionFrame.propertiesForm;
import FunctionFrame.scenarioForm;
import java.awt.event.MouseListener;
//import net.sourceforge.xuse.Xuse;

public class UCDev_Main extends JFrame implements MouseListener {

    //Xuse x = new Xuse();
    ActorXMLfile acXml = new ActorXMLfile();
    DragDrop d = new DragDrop(20, 20);
    //DrawOval o = new DrawOval(50, 50);
    Graphics g;
    Graphics2D g2d;
    private String[] sType = {"Person", "System"};

    public UCDev_Main() {
        initUI();
        setSize(1000, 700);
        jpanel2.addMouseListener(this);
    }

    
  

    private void initUI(){
        setTitle("UCDev version 1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        //Menubar
        JMenuBar menuBar = new JMenuBar();

        //Menu
        JMenu menu1 = new JMenu("File");

        //Item
        open = new JMenuItem("Open");
        create = new JMenuItem("create");
        save_as = new JMenuItem("Save as");
        save = new JMenuItem("Save");
        import_item = new JMenuItem("Import");
        export_item = new JMenuItem("Export");
        export_pdf = new JMenuItem("Export PDF");
        export_XMI = new JMenuItem("Export XMI");

        menu1.add(open);
        menu1.add(create);
        menu1.add(save_as);
        menu1.add(save);
        menu1.addSeparator();
        menu1.add(import_item);
        menu1.add(export_item);

        //export_item.add(export_pdf);
        //export_item.add(export_XMI);
        //add jmenu
        menuBar.add(menu1);
        //add jmenubar
        setJMenuBar(menuBar);

        //event JMenuitem
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //x.newProject();
            }

        });

        export_item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //x.pdfUseCases();
            }

        });

        //panel
        jpanel1 = new JPanel();
        jpanel2 = new JPanel();
        jpanel3 = new JPanel();
        //set background color panel 
        //jpanel1.setBackground(Color.CYAN);
        jpanel2.setBackground(Color.white);
        //jpanel3.setBackground(Color.CYAN);

        //set layout of jpanel3
        jpanel3.setLayout(new BorderLayout());

        //jtool bar
        JToolBar toolBar = new JToolBar("My Toolbar", JToolBar.VERTICAL);
        //blankLabel = new JLabel("    ");
        
        //system = new ImageIcon("image/Object.gif");
        
        // button system
	systemBtn = new JButton(new ImageIcon("image/Object.gif"));
        JLabel label1 = new JLabel("System");
        label1.setBounds(20,10,70,20);
        toolBar.add(systemBtn);
        toolBar.add(label1);
        toolBar.add(new JLabel("    "));
       
        //button actor
        actorBtn = new JButton(new ImageIcon("image/Actor.gif"));
        JLabel label2 = new JLabel("Actor");
        label2.setBounds(20,10,70,20);
        //actorBtn.setIcon(system);
        toolBar.add(actorBtn);
        toolBar.add(label2);
        toolBar.add(new JLabel("    "));

        //usecaseBtn
        usecaseBtn = new JButton(new ImageIcon("image/useCase.gif"));
        //usecaseBtn.setIcon(system);
        JLabel label3 = new JLabel("UseCase");
        label3.setBounds(20,10,70,20);
        toolBar.enable(false);
        toolBar.setBorderPainted(false);
        toolBar.add(usecaseBtn);
        toolBar.add(label3);
        toolBar.add(new JLabel("    "));

        //assiciationBtn
        associationBtn = new JButton(new ImageIcon("image/Association.gif"));
        JLabel label4 = new JLabel("Association");
        label4.setBounds(20,10,70,20);
        //associationBtn.setIcon(system);
        toolBar.add(associationBtn);
        toolBar.add(label4);
        toolBar.add(new JLabel("    "));

        jpanel1.add(toolBar);//add toolbar to jpanel1

        //Scrollpane
        scrollpane = new JScrollPane();
        scrollpane.add(jpanel2);
        getContentPane().add(scrollpane, BorderLayout.CENTER);

        //splitpane
        splitPane1 = new JSplitPane();
        splitPane1.setBounds(70, 70, 70, 70);
        splitPane1.setDividerLocation(120);// divide location
        splitPane1.setLeftComponent(jpanel1); // Left
        splitPane1.setRightComponent(jpanel2); // Right

        splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane2.setBounds(70, 70, 70, 70);
        splitPane2.setDividerLocation(500);
        splitPane2.setTopComponent(jpanel2);//top
        splitPane2.setBottomComponent(jpanel3);//bottom
        splitPane1.add(splitPane2);
        getContentPane().add(splitPane1);

        EventBtn(); //call method btnEvent
        createTappane();
        //jpanel2.addMouseMotionListener(this);
    }

    //create Tappane
    public void createTappane() {
        //add panel to tappane
        jpanel_1 = new JPanel();
        jpanel_2 = new JPanel();
        jpanel_1.setLayout(null);
        jpanel_2.setLayout(null);

        tabPane = new JTabbedPane();
        tabPane.addTab("Actor", jpanel_1);
        tabPane.addTab("Usecase", jpanel_2);
        jpanel3.add(tabPane);

        itemTap1();
        itemTap2();
    }

    //event of tappane1
    public void itemTap1() {
        JLabel label1, label2, label3, label4;

        //add label actorid
        label1 = new JLabel("Actor ID");
        label1.setBounds(20, 10, 70, 20);
        jpanel_1.add(label1);

        //add label actorname
        label2 = new JLabel("Actor name");
        label2.setBounds(20, 50, 90, 20);
        jpanel_1.add(label2);

        //add label description
        label3 = new JLabel("Description");
        label3.setBounds(400, 10, 90, 20);
        jpanel_1.add(label3);

        //add label steriotype
        label4 = new JLabel("Sterio Type");
        label4.setBounds(400, 50, 90, 20);
        jpanel_1.add(label4);

        //add idtxt
        actorIDtxt = new JTextField();
        actorIDtxt.setBounds(110, 10, 100, 20);
        jpanel_1.add(actorIDtxt);

        //add nametxt
        actorNametxt = new JTextField();
        actorNametxt.setBounds(110, 50, 200, 20);
        jpanel_1.add(actorNametxt);

        //add destxt
        actorDestxt = new JTextField();
        actorDestxt.setBounds(490, 10, 200, 20);
        jpanel_1.add(actorDestxt);

        //add comboBox steriotype
        typeCombo = new JComboBox(sType);
        typeCombo.setSelectedIndex(0);
        typeCombo.setBounds(490, 50, 100, 20);
        jpanel_1.add(typeCombo);

        //add button Save Actor
        saveActorBtn = new JButton("Save Actor");
        saveActorBtn.setBounds(630, 50, 100, 30);
        jpanel_1.add(saveActorBtn);
        
        saveActorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acXml.getInfo(actorIDtxt.getText(), actorNametxt.getText(), 
                        actorDestxt.getText(), typeCombo.getSelectedItem().toString());
            }
        });
    }

    //event of tappane2

   
    public void itemTap2(){
        JLabel label1, label2;


        //add label usecaseID
        label1 = new JLabel("Usecase ID");
        label1.setBounds(20, 10, 70, 20);
        jpanel_2.add(label1);

        //add label usecaseName
        label2 = new JLabel("Usecase name");
        label2.setBounds(20, 50, 90, 20);
        jpanel_2.add(label2);

        //add usecaseID txt
        caseIDtxt = new JTextField();
        caseIDtxt.setBounds(110, 10, 150, 20);
        jpanel_2.add(caseIDtxt);

        //add usecaseName txt
        caseNametxt = new JTextField();
        caseNametxt.setBounds(110, 50, 300, 20);
        jpanel_2.add(caseNametxt);

        
        //btn action
        
    }

    // event of button
    public void EventBtn() {
        systemBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new dataDictForm();
                d.paint(jpanel2.getGraphics());
            }
        });

        

        usecaseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new scenarioForm();
            }
        });

    }

    public void mousePressed(MouseEvent e) {
        d.x = e.getX();
        d.y = e.getY();
        jpanel2.repaint();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    //variable
    private JButton systemBtn, actorBtn, usecaseBtn, associationBtn, extendBtn, includeBtn;
    private JSplitPane splitPane1, splitPane2;
    private JPanel jpanel1, jpanel2, jpanel3;
    private JScrollPane scrollpane;
    private JPanel jpanel_1, jpanel_2;
    private JMenuItem open, create, save_as, save, import_item, export_item, export_pdf, export_XMI;
    private JTabbedPane tabPane;
    private JTextField actorIDtxt, actorNametxt, actorDestxt, actorTypetxt;//actor
    private JComboBox typeCombo;//actor
    private JTextField caseIDtxt, caseNametxt;//use case
    private JButton saveActorBtn;//actor && usecase
    private ImageIcon system;//image icon
}
