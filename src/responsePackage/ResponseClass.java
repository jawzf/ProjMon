package responsePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import dbConnection.ConnectionProvider;


public class ResponseClass {
	Connection con;  
	String eqp_id="";
	
	
	public ResponseClass(String eqp_id) {
		
		this.eqp_id = eqp_id;
	}


	public boolean jobUpdate()
	{
		Connection conn=null;
		boolean m=false;
		try
		{
			System.out.println("hi");
			
			conn=ConnectionProvider.getCon();
			
			Statement s=conn.createStatement();
			
			System.out.println("here");
			
			
			s.executeUpdate("update statusTable set status='UP' where EQUIPID='"+eqp_id+"'");	
			System.out.println("updated");
				
			System.out.println(eqp_id);
			
			s.executeUpdate("delete from downTable where equipid='"+eqp_id+"'");
			s.executeUpdate("delete from assignTable where equipid='"+eqp_id+"'");
			m=true;		
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return m;
		
	}

}
