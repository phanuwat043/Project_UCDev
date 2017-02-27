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
public class scenarioForm extends JFrame{
    String[] degree = {"1-Very High","2-High","3-Medium","4-Low","5-Very Low"};
    public scenarioForm(){
         initUI();
         setSize(450,530);
    
     }
     private void initUI() {
        setTitle("Use case description");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        //add panel
        panel1 = new JPanel();
        panel1.setLayout(null);
        getContentPane().add(panel1);
        
        //label
        label1 = new JLabel("Use case ID");
        label2 = new JLabel("Use case name");
        label3 = new JLabel("Primary Actor");
        label4 = new JLabel("Priority");
        label5 = new JLabel("Pre-conditions");
        label6 = new JLabel("Post-conditions");
        label7 = new JLabel("Flow of event");
        label8 = new JLabel("Alternative flow");
        label9 = new JLabel("Exception event");
        
        //textField
        txtUID = new JTextField();
        txtUname = new JTextField();
        txtPrimaryActor = new JTextField();
        txtPre = new JTextField();
        txtPost = new JTextField();
        
        //ComboBox
        priorityCombo = new JComboBox(degree);

        
        //Button
        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");
        flowBtn = new JButton("View Detail");
        altBtn = new JButton("View Detail");
        excepBtn = new JButton("View Detail");
        
        //set bounds of btn
        saveBtn.setBounds(200,430,90,20);
        cancelBtn.setBounds(300,430,90,20);
        flowBtn.setBounds(160,300,110,20);
        altBtn.setBounds(160,340,110,20);
        excepBtn.setBounds(160,380,110,20);
        
        
        //setBounds of label
        
        label1.setBounds(20,60,90,20);
        label2.setBounds(20,100,120,20);
        label3.setBounds(20,140,90,20);
        label4.setBounds(20,180,90,20);
        label5.setBounds(20,220,90,20);
        label6.setBounds(20,260,90,20);
        label7.setBounds(20,300,90,20);
        label8.setBounds(20,340,90,20);
        label9.setBounds(20,380,90,20);
        
        //set Bounds of textField
        txtUID.setBounds(150,60,100,20);
        txtUname.setBounds(150,100,150,20);
        txtPrimaryActor.setBounds(150,140,150,20);
        txtPre.setBounds(150,220,150,20);
        txtPost.setBounds(150,260,150,20);
        
        
        //set bounds of combobox
        priorityCombo.setBounds(150,180,100,20);
        
        //set default value of index
        priorityCombo.setSelectedIndex(0);
        
        //add btn to panel
        panel1.add(saveBtn);
        panel1.add(cancelBtn);
        panel1.add(flowBtn);
        panel1.add(altBtn);
        panel1.add(excepBtn);
        
        
        //add label to panel
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
        panel1.add(txtUID);
        panel1.add(txtUname);
        panel1.add(txtPrimaryActor);
        panel1.add(txtPre);
        panel1.add(txtPost);
        
        //add combobox to panel
        panel1.add(priorityCombo);

        
        
        
    }
     public static void main(String args[]){
        new scenarioForm();
    }
    
    //variable
    private JPanel panel1;
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
    private JTextField txtUID,txtUname,txtPrimaryActor,txtPre,txtPost;
    private JComboBox priorityCombo;
    private JButton saveBtn,cancelBtn,flowBtn,altBtn,excepBtn;
}
