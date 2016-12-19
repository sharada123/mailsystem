package db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sai
 */
public class NewClass {
    public Connection con=null;
    public ResultSet rs=null;
    public Statement st=null;
    
   public boolean setconnection() {
            try {

              
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail", "root", "root");

               
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            return false;
        }
   public ResultSet selectData(String sql)
   {
       try
       {
           if(setconnection())
           {
            st=(Statement) con.createStatement();
            rs=st.executeQuery(sql);
            return rs;
           }
            
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
       return null;
   }

   public boolean insertData(String sql)
   {
       try
       {
           if(setconnection())
           {
            st=(Statement) con.createStatement();
            st.executeUpdate(sql);
            return true;
           }
            
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
       return false;
   }
   public boolean updateData(String sql)
   {
      try
      {
      if(setconnection())
      {
         st=(Statement) con.createStatement();
         st.executeUpdate(sql);
         return true;
      }
      }
      catch(Exception e)
      {
      System.out.println(e.toString());
      }
      return false;
   }
   public boolean deleteData(String sql)
   {
     try{
         if(setconnection())
         {
     st=(Statement) con.createStatement();
       st.executeUpdate(sql);
     return true;
     }
     }
     catch(Exception ex)
     {
      System.out.println(ex.toString());
     }
     return false;
   }
   public int countRecords(String sql)
   {
     try{
         if(setconnection())
         {
           st=(Statement) con.createStatement();
           st.executeQuery(sql);
         
         }
     }
     catch(Exception e)
     {
       System.out.println(e);
     }
        return 0;
   }
}
