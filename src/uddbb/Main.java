package uddbb;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author dell-1
 */
public class Main
{
    
  public static void main(String[] args)
  {
      Scanner input = new Scanner(System.in);
      ConnectionMySQL cn = new ConnectionMySQL();
      String SQL = 
      "SELECT students.id, students.student_name,students.lastname, careers.career_name\n" +
      "FROM university.students INNER JOIN university.careers ON students.id_career = careers.id\n"+
      "WHERE careers.id = ?";
      
      System.out.print("Enter a ID career: ");
      String response = input.nextLine();
      
       PreparedStatement ps;
       ResultSet rs;
       
        try
        {
             ps = cn.connection.prepareStatement(SQL);
             ps.setString(1, response);
             rs = ps.executeQuery();
                 
             if(rs.next())
             {
                   System.out.println("\n\tID\tSTUDENT NAME\tLASTNAME\tCAREER NAME");
                   
                   System.out.println("\t" +rs.getInt("id") + "\t  " +
                          rs.getString("student_name")+
                          "\t\t  " + rs.getString("lastname") + "\t\t " +
                          rs.getString("career_name")); 
              
                    while(rs.next())
                    {
                         System.out.println("\t" +rs.getInt("id") + "\t  " +
                                          rs.getString("student_name")+
                                          "\t\t  " + rs.getString("lastname") + "\t\t " +
                                          rs.getString("career_name"));    
                    } 
                 
             }
             
             else
                System.out.println("NO DATA");
          
          
       }catch(SQLException e)
        {
            System.out.println(e);
        }

  }

} // Class end.
