package servMon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import pullDataPackage.pullEmailClass;
import dbConnection.ConnectionProvider;

public class StatusUpdate {
	public StatusUpdate()
	{
		try {
					
					Connection con=ConnectionProvider.getCon();
					Statement stmt=con.createStatement();  
					System.out.println("Initialised!");
					ResultSet rs=stmt.executeQuery("select equipid,custid,address from proView minus select equipid,custid,address from statusTable");
					pullEmailClass pec=new pullEmailClass();
					
					while(rs.next())
					{
						System.out.println("Check:"+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+pec.getEmail(rs.getString(2)));
						String query="insert into statusTable values ('"+rs.getString(1)+"','"+rs.getString(2)+"','"+rs.getString(3)+"','"+pec.getEmail(rs.getString(2))+"','UP')";
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
		
			
		
		
