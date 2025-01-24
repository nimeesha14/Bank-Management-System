package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, pinchange, balance, statement, exit;
    String pinNumber;

    Transaction(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text = new JLabel("please Select Your Transaction");
        text.setBounds(150,230,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(130,270,130,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Withdrawal");
        withdrawl.setBounds(270,270,130,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(130,310,130,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(270,310,130,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        balance = new JButton("Balance");
        balance.setBounds(130,350,130,30);
        balance.addActionListener(this);
        image.add(balance);
        
        statement = new JButton("Statement");
        statement.setBounds(270,350,130,30);
        statement.addActionListener(this);
        image.add(statement);
        
        
        exit = new JButton("Exit");
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
            System.exit(0);
       } else if(ae.getSource() == deposit){
           setVisible(false);
           new Deposit(pinNumber).setVisible(true);
      
        } else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        
       } else if(ae.getSource() == fastcash){
           setVisible(false);
           new FastCash(pinNumber).setVisible(true);
        } else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        
       } else if(ae.getSource() == balance){
           setVisible(false);
           new BalanceEnquiry(pinNumber).setVisible(true);
       } else if(ae.getSource() == statement){
           new MiniStatement(pinNumber).setVisible(true);
       }
    }
    
    public static void main(String args[]){
        new Transaction("");
    }
}
    

