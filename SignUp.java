package zoho;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;



public class SignUp extends JFrame implements ActionListener{

    public String Captcha(){
        int len = 5;
String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
}
    
    
    JFrame f;
    JLabel l1,l2,l3;
    JTextField t1,t3;
    JPasswordField t2;
    JButton b1,b2,b3,l4;
    String cap = Captcha();

    SignUp(){

        super("Sign Up");

        setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
        
        l3 = new JLabel("Enter Captcha");
        l3.setBounds(40,170,100,30);
        add(l3);
        
        
        l4 = new JButton(cap);
        l4.setBounds(100,120,120,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        //l4.addActionListener(this);
        l4.setBackground(Color.RED);
        l4.setForeground(Color.WHITE);
        add(l4);
        
      
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        t3=new JTextField();
        t3.setBounds(150,170,150,30);
        add(t3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("zoho/icons/zoho.jfif"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,240,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,240,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        
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
            String w = t3.getText();
            boolean bool = (w.equals(cap));
            
           if(ae.getSource() == b1){
               if(bool == true){
                String q1 = "insert into signin values ('"+u+"','"+v+"')";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                System.exit(0);
               }else{
                   JOptionPane.showMessageDialog(null,"Captcha entered is incorrect");
               }
            }else if(ae.getSource()==b2){
                setVisible(false);
                System.exit(0);
              }
           
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        SignUp l = new SignUp();
    }
}