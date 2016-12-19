
import javax.servlet.*;
import java.sql.*;

public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
		
		Connection con=null;
                Statement st=null;
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mail","root","root");
		
		/*PreparedStatement ps2= con.prepareStatement("CREATE SEQUENCE JAVATPOINT MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER NOCYCLE");
		ps2.executeUpdate();
		PreparedStatement ps=con.prepareStatement("CREATE TABLE MAILCASTINGUSER(EMAIL VARCHAR2(4000),PASSWORD VARCHAR2(4000),NAME VARCHAR2(4000),GENDER VARCHAR2(4000),MNAME VARCHAR2(4000), COUNTRY VARCHAR2(4000))");
		ps.executeUpdate();
		PreparedStatement ps4=con.prepareStatement("CREATE TABLE INBOX6(ID NUMBER,RECIEVER VARCHAR2(4000),SENDER VARCHAR2(4000),MESSAGE VARCHAR2(4000),DATE_OF_RECEIVING VARCHAR2(4000))");
		ps4.executeUpdate();		
		
		Statement stmt=con.createStatement();
	        stmt.executeUpdate("CREATE TRIGGER  BI_INBOX6 before insert on INBOX6 for each row begin select JAVATPOINT.nextval into :NEW.ID from dual;end");
		*/
                st=con.createStatement();
                st.executeUpdate("create table users(email varchar(255),password varchar(255),name varchar(255),gender varchar(255),contactno varchar(255),country varchar(255))");
                st.executeUpdate("create table inbox(id int,receiver varchar(255),sender varchar(255),msg text,date timestamp )");
        }	
	
		
	    catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    }
	    
	    public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("project undeployed");
		
	}
}
