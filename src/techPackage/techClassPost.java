package techPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dbConnection.ConnectionProvider;

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
		
		conn=ConnectionProvider.getCon();
		
		Statement s=conn.createStatement();
		Statement s1=conn.createStatement();
		Statement s2=conn.createStatement();
		
		s.executeUpdate("insert into assignTable values('"+equip_id+"','"+technician_id+"')");
		
		s1.executeUpdate("update statusTable set status='IN-PROGRESS' where equipid='"+equip_id+"'");
		
		
		s2.executeUpdate("update downTable set status='IN-PROGRESS' where equipid='"+equip_id+"'");
		
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
