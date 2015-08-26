package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConnection.ConnectionProvider;

public class dbUpdateClass {
	String[] eq;
	String st;
	Connection conn;
	public dbUpdateClass(String[] eqid,String status)
	{
		eq=eqid;
		st=status;
	}
	public void update()
	{
		try
		{
			
			conn=ConnectionProvider.getCon();
			
			Statement s=conn.createStatement();
			System.out.println(""+st);
			
			
			for(int i=0;i<eq.length;i++)
			{
				s.executeQuery("update statusTable set status='"+st+"' where equipid='"+eq[i]+"'");
			}
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

}
