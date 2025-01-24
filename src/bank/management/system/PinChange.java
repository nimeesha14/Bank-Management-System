
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
         ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,700,700);
         add(image);

         JLabel text = new JLabel("CHANGE YOUR PIN");
         text.setBounds(130,240,200,20);
         text.setForeground(Color.white);
         text.setFont(new Font("System",Font.BOLD,14));
         image.add(text);

         JLabel repintext = new JLabel("New PIN");
         repintext.setBounds(130,280,200,20);
         repintext.setForeground(Color.white);
         repintext.setFont(new Font("System",Font.BOLD,12));
         image.add(repintext);

         pin = new JPasswordField();
         pin.setBounds(240,320,160,20);
         pin.setFont(new Font("Raleway",Font.BOLD,14));
         image.add(pin);
         
         JLabel pintext = new JLabel("Re-Enter New PIN");
         pintext.setBounds(130,320,200,20);
         pintext.setForeground(Color.white);
         pintext.setFont(new Font("System",Font.BOLD,12));
         image.add(pintext);

         repin = new JPasswordField();
         repin.setBounds(240,280,160,20);
         repin.setFont(new Font("Raleway",Font.BOLD,14));
         image.add(repin);

         change = new JButton("Change");
         change.setBounds(300,370,100,20);
         change.addActionListener(this);
         image.add(change);

         back = new JButton("Back");
         back.setBounds(300,400,100,20);
         back.addActionListener(this);
         image.add(back);
         
         setSize(700,700);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);


    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
            String npin = pin.getText();
            String rpin = repin.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Enetere PIN does not match");
                return;
            } 
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new PIN ");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new  PIN ");
                return;
            }
            
            conn c = new conn();
             String disableFKCheck = "SET FOREIGN_KEY_CHECKS = 0";
             c.stmt.executeUpdate(disableFKCheck);
    
            String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            String query2 = "update login set pinNumber = '"+rpin+"' where pinNumber = '"+pinnumber+"'";
            String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            
            String enableFKCheck = "SET FOREIGN_KEY_CHECKS = 1";
            c.stmt.executeUpdate(enableFKCheck);
           

            c.stmt.executeUpdate(query1);
            c.stmt.executeUpdate(query2);
            c.stmt.executeUpdate(query3);
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            
            setVisible(false);
            new Transaction(rpin).setVisible(true);

           
            
        }catch (Exception e){
            System.out.println(e);
        }

        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }

    
    }
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
