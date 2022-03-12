package zoho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import java.sql.*;
public class conn {
    public Connection c;
    public Statement s;
    
    public conn(){
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///zoho","root","");
            s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
