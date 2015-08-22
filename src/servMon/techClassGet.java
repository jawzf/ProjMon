package servMon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class techClassGet {
	 Connection conn=null;
	 String technician_id,add;
	techClassGet(String a)
	{
		technician_id=a;
		
	}
	public String dbConnEid()
	{
		String res="";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			Statement s=conn.createStatement();
			
			
			ResultSet rs1=s.executeQuery("select equip_id from assignTable where technician_id="+technician_id);
			 
					res=rs1.getString(1);
					
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	
	}
	
	public String dbConnAdd()
	{
		String res="";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			Statement s=conn.createStatement();
			
			
			
					
					ResultSet rs2=s.executeQuery("select address from downTable where equipid="+res);
					
					add=rs2.getString(1);
					
			//s.executeQuery("select address from downTable where equip_id="+equip_id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return add;
	
	}
	

}
