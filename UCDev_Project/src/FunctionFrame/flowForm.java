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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NUT
 */
public class flowForm extends JFrame{
    private String[][] data = {{"1","1"},{"2","2"},{"3","3"}};
    private String[] header = {"StepID","Description"};
    
    public flowForm(){
         initUI();
         setSize(500,400);
    
     }
    public void initUI(){
      setTitle("Flow of event");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        //add panel
        panel1 = new JPanel();
        panel1.setLayout(null);
        getContentPane().add(panel1);
        
        //label
        label1 = new JLabel("StepID");
        label2 = new JLabel("Description");
        
         //textField
        txtStepID = new JTextField();
        txtDes = new JTextField();
        
        //Button
        saveBtn = new JButton("Save");
        
         //set bounds of btn
        saveBtn.setBounds(320,100,90,20);
        
        //setBounds of label
        label1.setBounds(20,60,90,20);
        label2.setBounds(20,100,120,20);
        
         //set Bounds of textField
        txtStepID.setBounds(150,60,100,20);
        txtDes.setBounds(150,100,150,20);
        
        //add btn to panel
        getContentPane().add(saveBtn);
        
        //add label to panel
        getContentPane().add(label1);
        getContentPane().add(label2);
        
        //add textField to panel
        getContentPane().add(txtStepID);
        getContentPane().add(txtDes);
        
    }
    
     public void CreateTable(){
       
        getContentPane().setLayout(null);
        
        JTable table = new JTable(data,header);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(36, 180, 407, 79);
        getContentPane().add(scrollPane);
    }
    
    public static void main(String args[]){
        flowForm fl = new flowForm();
        fl.CreateTable();
    }
    
    //variable
    private JPanel panel1;
    private JLabel label1,label2;
    private JTextField txtStepID,txtDes;
    private JButton saveBtn;
    private JTable inputTable;
    private JScrollPane scrollpane1;
    private DefaultTableModel model;
    
}
