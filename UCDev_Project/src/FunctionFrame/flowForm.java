/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.scene.input.KeyCode.F;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private String[][] data = new String[20][2];
    int i=0,stepID=1;
    String id,id2;
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
        
        
        //label
        label1 = new JLabel("StepID");
        label2 = new JLabel("Description");
        
         //textField
        txtStepID = new JTextField();
        txtDes = new JTextField();
        
        //Button
        addBtn = new JButton("Add to list");
        saveBtn = new JButton("Save");
        
         //set bounds of btn
        addBtn.setBounds(320,100,90,20);
        saveBtn.setBounds(200,300,90,20);
        
        //setBounds of label
        label1.setBounds(20,60,90,20);
        label2.setBounds(20,100,120,20);
        
         //set Bounds of textField
        txtStepID.setBounds(150,60,100,20);
        txtDes.setBounds(150,100,150,20);
        txtStepID.setEditable(false);
        
        //add btn to panel
        panel1.add(saveBtn);
        panel1.add(addBtn);
        
        //add label to panel
        panel1.add(label1);
        panel1.add(label2);
        
        //add textField to panel
        panel1.add(txtStepID);
        panel1.add(txtDes);
        
       //setValue
        txtStepID.setText(String.valueOf(stepID));
        
        //save data
        addBtn.addActionListener(new ActionListener() {
   
            
            public void actionPerformed(ActionEvent e) {
                 //a = txtStepID.getText().toString();
                 //b = txtDes.getText().toString();
                
                 
                 id = String.valueOf(stepID);
                 data[i][0] = id;
                 data[i][1] = txtDes.getText().toString();
                 System.out.println(stepID);
                 
                 System.out.println("A: "+data[i][0]+" and  B: "+data[i][1]);
                 
                 
                 
                 table = new JTable(data,header);
                 JScrollPane scrollPane = new JScrollPane(table);
                 scrollPane.setBounds(36, 180, 407, 79);
                 panel1.add(scrollPane);
                 i = i+1;
                 stepID = stepID+1;
                 
                id2 = String.valueOf(stepID);
                System.out.println(id2);
                txtStepID.setText(id2);
                txtDes.setText("");
                
            }
        });
        
        saveBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                 for(int j=0;j<i;j++){
                    System.out.println("Flow event:"+j+" "+data[j][0]+"   Flow event:"+j+" "+data[j][1]);
                 }
                 JOptionPane.showMessageDialog(null,"SAVE!!!");
                 setVisible(false);
                
            }
        });
        
        getContentPane().add(panel1);
        
    }
    
   
    /*public static void main(String args[]){
        flowForm fl = new flowForm();
        
    }*/
    
    //variable
    private JPanel panel1;
    private JLabel label1,label2;
    private JTextField txtStepID,txtDes;
    private JButton saveBtn,addBtn;
    private JTable inputTable,table;
    private JScrollPane scrollpane1;
    private DefaultTableModel model;
    
}
