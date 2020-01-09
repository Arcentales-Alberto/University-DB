package uddbb;

import java.sql.*;

public class ConnectionMySQL
{
   public static final String URL = "jdbc:mysql://localhost:3306/university";
   public static final String USERNAME = "root"; 
   public static final String PASSWORD = ""; 
   Connection connection;
    
   public ConnectionMySQL()
   {
        try
        {
           connection = (Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        }catch(SQLException e)
         {
             System.out.println(e);   
         }
        
    }

}
