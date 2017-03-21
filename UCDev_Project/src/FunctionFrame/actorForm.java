
package FunctionFrame;

import GenXML.WriteActorXML;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class actorForm extends JFrame{
    
    String[] type = {"Person","System"};
    
    public actorForm(){
        init();
        setSize(420,370);
    }
    
    public void init(){
        setTitle("Actor Properties");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        //add panel
        panel1 = new JPanel();
        panel1.setLayout(null);
        getContentPane().add(panel1);
        
        //addLabel
        label1 = new JLabel("Actor ID");
        label2 = new JLabel("Actor Name");
        label3 = new JLabel("Description");
        label4 = new JLabel("SterioType");
        
        //txtField
        txtID = new JTextField();
        txtTitle = new JTextField();
        txtDes = new JTextField();
        
        //comboBox
        comboType = new JComboBox(type);
        
        //button
        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");
        
        //setBounds
        label1.setBounds(20, 60, 90, 20);
        label2.setBounds(20, 100, 120, 20);
        label3.setBounds(20, 140, 90, 20);
        label4.setBounds(20, 180, 90, 20);
        
        //setBounds textFild
        txtID.setBounds(150, 60, 100, 20);
        txtTitle.setBounds(150, 100, 150, 20);
        txtDes.setBounds(150, 140, 150, 20);
        
        //
        comboType.setBounds(150, 180, 100, 20);
        
        //
        comboType.setSelectedIndex(0);
        
        //set bounds of btn
        btnSave.setBounds(150,250, 90, 20);
        btnCancel.setBounds(250,250, 90, 20);
        
        //add label to panel
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        
        //add button to panel
        panel1.add(btnSave);
        panel1.add(btnCancel);
        
        //add txtField to panel
        panel1.add(txtID);
        panel1.add(txtTitle);
        panel1.add(txtDes);
        
        //comboBox
        panel1.add(comboType);
        
        eventBtn();
    }
    
    /*public static void main(String args[]) {
        new actorForm();
    }*/
    
    public void eventBtn(){
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                WriteActorXML writeXML = new WriteActorXML(txtID.getText()
                        ,txtTitle.getText(),txtDes.getText(),comboType.getSelectedItem().toString());
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
            }
        });
    }
    
    private JPanel panel1;
    private JLabel label1,label2,label3,label4,label5;
    public JTextField txtID,txtTitle,txtDes;
    public JComboBox comboType;
    private JButton btnSave,btnCancel;
}
