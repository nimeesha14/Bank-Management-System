/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposite, back;
    String pinnumber;

    Deposit(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposite");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(130,250,300,20);
        image.add(text);

        amount =  new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        amount.setBounds(130,280,250,20);
        image.add(amount);

        deposite = new JButton("Deposit");
        deposite.setBounds(300,370,100,20);
        deposite.addActionListener(this);
        image.add(deposite);

        back = new JButton("Back");
        back.setBounds(300,400,100,20);
        back.addActionListener(this);
        image.add(back);



          
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposite){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter The Amount you want to deposit");
            }else{
                 try{
                    conn c = new conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                    c.stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
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
        new Deposit("");
    }
    
}
