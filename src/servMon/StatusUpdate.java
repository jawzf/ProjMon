package servMon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConnection.ConnectionProvider;

public class StatusUpdate {
	public StatusUpdate()
	{
		try {
					
					Connection con=ConnectionProvider.getCon();
					Statement stmt=con.createStatement();  
					System.out.println("Initialised!");
					ResultSet rs=stmt.executeQuery("select equipid,custid,address,email from proView minus select equipid,custid,address,email from statusTable");
					
					
					while(rs.next())
					{
						System.out.println("Check:"+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
						String query="insert into statusTable values ('"+rs.getString(1)+"','"+rs.getString(2)+"','"+rs.getString(3)+"','"+rs.getString(4)+",'UP'";
						stmt.executeUpdate(query);
						System.out.println("done y'all");
					}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
}
		
			
		
		
