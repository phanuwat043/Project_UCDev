/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionFrame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NUT
 */
public class exceptionForm extends JFrame{
    
    private String[] step = {"Step1","Step2","Step3"};
    private String[][] data = {{"1","1","1"},{"2","2","2"},{"3","3","3"},{"2","2","2"},{"2","2","2"},{"2","2","2"},{"2","2","2"}};
    private String[] header = {"StepID","Description","Ref.Step"};
    
     
    
    public exceptionForm(){
         initUI();
         setSize(500,400);
    
     }
    public void initUI(){
        setTitle("Exception Flow");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        
        //add panel
        panel1 = new JPanel();
        panel1.setLayout(null);
        
        //label
        label1 = new JLabel("StepID");
        label2 = new JLabel("Description");
        label3 = new JLabel("Ref.Step ID");
        
         //textField
        txtStepID = new JTextField();
        txtDes = new JTextField();
        
        //ComboBox
        stepCombo = new JComboBox(step);
        
        //set bounds of combobox
        stepCombo.setBounds(150,140,100,20);
        
        //set default value of index
        stepCombo.setSelectedIndex(0);
        
        
        
        //Button
        saveBtn = new JButton("Save");
        
         //set bounds of btn
        saveBtn.setBounds(280,140,90,20);
        
        //setBounds of label
        label1.setBounds(20,60,90,20);
        label2.setBounds(20,100,120,20);
        label3.setBounds(20,140,120,20);
        
         //set Bounds of textField
        txtStepID.setBounds(150,60,100,20);
        txtDes.setBounds(150,100,150,20);
        
        //add btn to panel
        panel1.add(saveBtn);
        
        //add label to panel
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        
        //add combo box
        panel1.add(stepCombo);
        
        //add textField to panel
        panel1.add(txtStepID);
        panel1.add(txtDes);
        
        //create table
        JTable table = new JTable(data,header);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(36, 180, 407, 79);
        panel1.add(scrollPane);
        
        getContentPane().add(panel1);
        
        
        
    }
    
    
     public static void main(String args[]){
        exceptionForm ex =  new exceptionForm();
     }
      
    
   
    
    //variable
    private JPanel panel1;
    private JLabel label1,label2,label3;
    private JTextField txtStepID,txtDes;
    private JButton saveBtn;
    private JTable inputTable;
    private JComboBox stepCombo;
    private JScrollPane scrollpane1;
    private DefaultTableModel model;
    
    
}
