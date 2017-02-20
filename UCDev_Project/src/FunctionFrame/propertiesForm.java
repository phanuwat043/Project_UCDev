/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionFrame;

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

/**
 *
 * @author NUT
 */
public class propertiesForm extends JFrame{
      String[] actor = {"ac1","ac2","ac3"};
      String[] degree = {"1-Very High","2-High","3-Medium","4-Low","5-Very Low"};
    
    
    public propertiesForm(){
         initUI();
         setSize(450,600);
    
     }
    private void initUI() {
        setTitle("properties");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        //add panel
        panel1 = new JPanel();
        panel1.setLayout(null);
        getContentPane().add(panel1);
        
        //label
        label1 = new JLabel("Goal");
        label2 = new JLabel("Primary Actor");
        label3 = new JLabel("Pre-conditions");
        label4 = new JLabel("Post-conditions");
        label5 = new JLabel("Priority");
        label6 = new JLabel("Complexity");
        
        //textField
        txtGoal = new JTextField();
        txtPre = new JTextField();
        txtPost = new JTextField();
        
        //ComboBox
        primaryCombo = new JComboBox(actor);
        priorityCombo = new JComboBox(degree);
        complexCombo = new JComboBox(degree);
        
        //Button
        saveBtn = new JButton("Save");
        
        //set bounds of btn
        saveBtn.setBounds(320,340,90,20);
        
        //setBounds of label
        
        label1.setBounds(20,60,90,20);
        label2.setBounds(20,100,120,20);
        label3.setBounds(20,140,90,20);
        label4.setBounds(50,180,90,20);
        label5.setBounds(50,220,90,20);
        label6.setBounds(50,250,90,20);
        
        //set Bounds of textField
        txtGoal.setBounds(130,60,100,20);
        txtPre.setBounds(130,100,150,20);
        txtPost.setBounds(150,180,150,20);
        
        //set bounds of combobox
        primaryCombo.setBounds(150,250,100,20);
        priorityCombo.setBounds(150,250,100,20);
        complexCombo.setBounds(150,250,100,20);
        
        //set default value of index
        primaryCombo.setSelectedIndex(0);
        priorityCombo.setSelectedIndex(0);
        complexCombo.setSelectedIndex(0);
        
        //add btn to panel
        panel1.add(saveBtn);
        
        //add label to panel
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(label5);
        panel1.add(label6);
        
        //add textField to panel
        panel1.add(txtGoal);
        panel1.add(txtPre);
        panel1.add(txtPost);
        
        //add combobox to panel
        panel1.add(primaryCombo);
        panel1.add(priorityCombo);
        panel1.add(complexCombo);
        
        
        CreateTable();
    }
    public void CreateTable(){
        scrollpane1 = new JScrollPane();
        scrollpane1.setBounds(20,400,400,100);
        panel1.add(scrollpane1);
    }
    
    public static void main(String args[]){
        new dataDictForm();
    }
    
    //variable
    private JPanel panel1;
    private JLabel label1,label2,label3,label4,label5,label6;
    private JTextField txtGoal,txtPre,txtPost;
    private JComboBox primaryCombo,priorityCombo,complexCombo;
    private ButtonGroup requireBtn;
    private JButton saveBtn;
    private JScrollPane scrollpane1,scrollpane2;
    private DefaultTableModel model;
}



