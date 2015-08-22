package servMon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class techClassPost {
	 Connection conn=null;
		String equip_id="";
		String technician_id="";
	 public techClassPost(String a, String b) 
	 {
		equip_id=a;
		technician_id=b;
	}
	public void dbQueries()
	{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
		Statement s=conn.createStatement();
		
		s.executeUpdate("insert into assignTable values('"+equip_id+"','"+technician_id+"')");
		
		s.executeUpdate("update statusTable set status='IN-PROGRESS' where equip_id="+equip_id);
		
		s.executeUpdate("update downTable set status='IN-PROGRESS' where equip_id="+equip_id);
		
	}
	catch(SQLException e)
	{
		System.out.println("sql exception");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
}
