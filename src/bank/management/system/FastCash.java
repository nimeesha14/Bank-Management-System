/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
 

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, pinchange, balance, statement, exit;
    String pinNumber;

    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(150,230,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(130,270,130,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(270,270,130,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(130,310,130,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        pinchange = new JButton("Rs 2000");
        pinchange.setBounds(270,310,130,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        balance = new JButton("Rs 5000");
        balance.setBounds(130,350,130,30);
        balance.addActionListener(this);
        image.add(balance);
        
        statement = new JButton("Rs 10000");
        statement.setBounds(270,350,130,30);
        statement.addActionListener(this);
        image.add(statement);
        
        
        exit = new JButton("BACK");
        exit.setBounds(270,390,130,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(700,650);
        setLocation(300,20);
        setUndecorated(true);
        setVisible(true);
      
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
           setVisible(false);
           new Transaction(pinNumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn c = new conn();
            try{
                ResultSet rs = c.stmt.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);





            }catch(Exception e){
                System.out.println(e);
            }
           
        }

    }
    public static void main(String args[]){
        new FastCash("");
    }
}
    

