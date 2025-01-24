
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

public class BalanceEnquiry  extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        back = new JButton("Back");
        back.setBounds(300,400,100,20);
        back.addActionListener(this);
        image.add(back);

        conn c = new conn();
        int balance =0;
            try{
                ResultSet rs = c.stmt.executeQuery("select * from bank where pin = '"+pinnumber+"'");
               
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }

        JLabel text = new JLabel("Your Current Account blance is Rs "+balance);
        text.setBounds(130,240,400,30);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
         

        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("").setVisible(true);
    }
    
}
