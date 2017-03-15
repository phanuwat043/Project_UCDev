
package FunctionFrame;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class dataDictForm extends JFrame{
    
    private String[] type = {"int","float","double","String","char"};
    private String[][] data = {{"1","1"},{"1","1"},{"1","1"},{"1","1"}};
    private String[] header = {"Name","Description"};
    
    public dataDictForm(){
        initUI();
        setSize(480,700);
    }
    private void initUI(){
        setTitle("Data Dictionary");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        //add panel
        panel1 = new JPanel();
        //panel1.setBackground(Color.red);
        panel1.setLayout(null);
        
        
        //add text to label
        label1 = new JLabel("Use case ID");
        label2 = new JLabel("Use case Name");
        label3 = new JLabel("Input");
        label4 = new JLabel("Name");
        label5 = new JLabel("Description");
        label6 = new JLabel("Type");
        label7 = new JLabel("Require");
        label8 = new JLabel("Min");
        label9 = new JLabel("Max");
        label10 = new JLabel("Data Dictionary");
        
        //create object textField
        txtUCID = new JTextField();
        txtUCName = new JTextField();
        txtName = new JTextField();
        txtDes = new JTextField();
        txtMax = new JTextField();
        txtMin = new JTextField();
        
        //create object jComboBox
        typeCombo = new JComboBox(type);
        
        //create object radiobutton
        yesRadio = new JRadioButton("Yes");
        noRadio = new JRadioButton("No");
        
        //create object Button
        saveBtn = new JButton("Save");
        
        //set bounds of btn
        saveBtn.setBounds(320,340,90,20);
        
        //setBounds of label
        label10.setBounds(20,20,120,20);
        label1.setBounds(20,60,90,20);
        label2.setBounds(20,100,120,20);
        label3.setBounds(20,140,90,20);
        label4.setBounds(50,180,90,20);
        label5.setBounds(50,220,90,20);
        label6.setBounds(50,250,90,20);
        label7.setBounds(50,280,90,20);
        label8.setBounds(50,310,90,20);
        label9.setBounds(50,340,120,20);
        
        //set Bounds of textField
        txtUCID.setBounds(130,60,100,20);
        txtUCName.setBounds(130,100,150,20);
        txtName.setBounds(150,180,150,20);
        txtDes.setBounds(150,220,150,20);
        txtMax.setBounds(150,310,150,20);
        txtMin.setBounds(150,340,150,20);
        
        //set bounds of combobox
        typeCombo.setBounds(150,250,100,20);
        
        //set default value of index
        typeCombo.setSelectedIndex(0);
        
        //set bounds of radiobutton
        yesRadio.setBounds(150,280,70,20);
        noRadio.setBounds(230,280,70,20);
        
        //add btn to panel
        panel1.add(saveBtn);
        
        //add label to panel
        panel1.add(label10);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(label5);
        panel1.add(label6);
        panel1.add(label7);
        panel1.add(label8);
        panel1.add(label9);
        
        //add textField to panel
        panel1.add(txtUCID);
        panel1.add(txtUCName);
        panel1.add(txtName);
        panel1.add(txtDes);
        panel1.add(txtMax);
        panel1.add(txtMin);
        
        //add combobox to panel
        panel1.add(typeCombo);
        
        //add radiobtn to panel
        panel1.add(yesRadio);
        panel1.add(noRadio);
        
        //set btnGroup
        requireBtn = new ButtonGroup();
        requireBtn.add(yesRadio);
        requireBtn.add(noRadio);
        
        //add method createtable
        
        
        JTable table = new JTable(data,header);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(36, 400, 407, 79);
        panel1.add(scrollPane);
        
        JTable table2 = new JTable(data,header);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(36, 530, 407, 79);
        panel1.add(scrollPane2);
        
        getContentPane().add(panel1);
        
    }
    
    
    
    /*public static void main(String args[]){
        dataDictForm da = new dataDictForm();
    }*/
    
    //variable
    private JPanel panel1;
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
    private JTextField txtUCID,txtUCName,txtName,txtDes,txtMin,txtMax;
    private JComboBox typeCombo;
    private JRadioButton yesRadio,noRadio;
    private ButtonGroup requireBtn;
    private JButton saveBtn;
    private JTable inputTable,outputTable;
    private JScrollPane scrollpane1,scrollpane2;
    private DefaultTableModel model;
}
