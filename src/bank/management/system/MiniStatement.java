package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    
    String pinnumber;

    MiniStatement(String pinnumber){
        setLayout(null);
        setTitle("Mini Statement");

        JLabel text = new JLabel();
        text.setBounds(20,90,500,200);
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            conn c = new conn();
            ResultSet rs = c.stmt.executeQuery("select * from login where pinNumber = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }

        }catch(Exception e){
            System.out.println(e);
        }

        try{
            conn c = new conn();
            int bal = 0;
            ResultSet rs = c.stmt.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                text.setText(text.getText() +  "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("your current balance is Rs " + bal);

        }catch(Exception e){
            System.out.println(e);
        }






        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }




     public void actionPerformed(ActionEvent ae){
        
    }
    public static void main(String args[]){
        new MiniStatement("").setVisible(true);
    }
    
}
