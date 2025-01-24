
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    
    String formno;
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category, occupation,education,income;    

    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
       
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,30,400,30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,90,100,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"}; 
        religion = new JComboBox(valReligion);
        religion.setBounds(300,90,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,140,200,30);
        add(fname);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,140,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,190,200,30);
        add(dob);
        
        String valincome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","UPto 10,00,000"};
        income = new JComboBox(valincome);
        income.setBounds(300,190,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
       
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,240,200,30);
        add(gender);
        
       
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,265,200,30);
        add(email);
        
        String educationValues[] = {"Non Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300,250,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,315,200,30);
        add(marital);
        
        String occupationValues[] = {"Salaried","Self-Employee","Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,315,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
     
        JLabel panno = new JLabel("PAN Number:");
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        panno.setBounds(100,365,200,30);
        add(panno);
        
        pan =  new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,365,400,30);
        add(pan);
        
        JLabel aadhars = new JLabel("Aadhar Number:");
        aadhars.setFont(new Font("Raleway",Font.BOLD,20));
        aadhars.setBounds(100,415,200,30);
        add(aadhars);
        
        aadhar =  new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,415,400,30);
        add(aadhar);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,465,200,30);
        add(state);
        
        syes =new JRadioButton("YES");
        syes.setBounds(300,465,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
    
        sno =new JRadioButton("NO");
        sno.setBounds(450,465,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
       ButtonGroup sgroup =new ButtonGroup();
       sgroup.add(syes);
       sgroup.add(sno);
      
        JLabel Exist = new JLabel("Existing Account:");
        Exist.setFont(new Font("Raleway",Font.BOLD,20));
        Exist.setBounds(100,515,200,30);
        add(Exist);
        
        eyes =new JRadioButton("YES");
        eyes.setBounds(300,515,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
    
        eno =new JRadioButton("NO");
        eno.setBounds(450,515,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
       ButtonGroup egroup =new ButtonGroup();
       egroup.add(eyes);
       egroup.add(eno);
       
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 565, 80, 30);
        next.addActionListener(this);
        add(next);
  
        getContentPane().setBackground(Color.WHITE);
        setSize(800,650);
        setLocation(350,10);
        setVisible(true);
         
    }
    
     public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorCitizen = syes.isSelected() ? "YES" : "NO";
        String existingAccount = eyes.isSelected() ? "YES" : "NO";

        String span = pan.getText();
        String saadhar = aadhar.getText();

        if (span.isEmpty() || saadhar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "PAN and Aadhar cannot be empty!");
            return;
        }

        try {
            conn c = new conn();
            String query = "INSERT INTO signuptwo VALUES('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorCitizen + "', '" + existingAccount + "')";
            c.stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Submitted Successfully!");
            c.stmt.close();
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
