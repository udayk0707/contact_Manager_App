package zoho;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class signin extends JFrame implements ActionListener{

    JFrame f;
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3,b4;

    signin(){

        super("Sign In");

        setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        l3 = new JLabel("Don't have an account?");
        l3.setBounds(40,240,200,30);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("zoho/icons/zoho.jfif"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        
        
        b4=new JButton("Sign Up");
        b4.setBounds(110,280,150,30);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        add(b4);
        b4.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,350);
        setLocation(500,300);

    }

    public void actionPerformed(ActionEvent ae){

        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            //connecting to database and checking if login details are correct
            String q = "select * from signin where email='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new contact(u).setVisible(true);
                setVisible(false);
            }
            else if(ae.getSource()==b4){
                setVisible(false);
                new SignUp();
              }
            else if(ae.getSource()==b2){
                setVisible(false);
                System.exit(0);
              }
            
             
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        
        signin l = new signin();
    }
}