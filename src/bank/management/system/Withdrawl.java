
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(130,250,300,20);
        image.add(text);

        amount =  new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        amount.setBounds(130,280,250,20);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(300,370,100,20);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(300,400,100,20);
        back.addActionListener(this);
        image.add(back);



          
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter The Amount you want to Withdraw");
            }else{
                 try{
                    conn c = new conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                    c.stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                 }catch(Exception e){
                    System.out.println(e);
                 }
                 

            }

        }else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }
    }


    public static void main(String args[]){
        new Withdrawl("");
    }
    
}
