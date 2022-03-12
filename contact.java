package zoho;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;
//import net.proteanit.sql.DbUtils;

public class contact extends JFrame implements ActionListener{

   JFrame f;
    JLabel l1,l2,l3,t4;
    JTextField t1,t2,t3;
    JButton b1;
   private JTable table;
   private JPanel contentPane;
    
    
    contact(String Email){
        
        super("Contact");        
        
        setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel("Name");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Phone No.");
        l2.setBounds(40,70,100,30);
        add(l2);
        
        l3 = new JLabel("Email");
        l3.setBounds(40,120,100,30);
        add(l3);
 
        t4 = new JLabel(Email);
        t4.setBounds(110,170,200,30);
        add(t4);
        
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JTextField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        t3=new JTextField();
        t3.setBounds(150,120,150,30);
        add(t3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("zoho/icons/zoho.jfif"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        add(l3);


        b1 = new JButton("Save");
        b1.setBounds(40,240,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,600);
        setLocation(500,300);
         
        
        //setBounds(350, 200, 930, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
//
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(300, 300, 1080, 282);
//        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
               int row = table.getSelectedRow();
               //search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
       
        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
//        scrollPane.setViewportView(table);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Book-Details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
        panel.setBounds(50, 250, 600,600);
        contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        //Book();
        //setSize(1200,500);

    }

    public void actionPerformed(ActionEvent ae){

        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            String w = t3.getText();
            String E = t4.getText();
            
           if(ae.getSource() == b1){
                String q1 = "insert into contact values ('"+E+"','"+u+"','"+v+"','"+w+"')";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Contact inserted Successfully");
                setVisible(false);
                System.exit(0);
            }
           
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        contact l = new contact("Email");
    }
}
