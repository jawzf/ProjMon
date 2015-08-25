package servMon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;

import dbConnection.ConnectionProvider;

public class contRun extends TimerTask {
	public void getData()
	{//comment
		
		try {
			
			Connection con=ConnectionProvider.getCon();
			Statement stmt=con.createStatement();  
			System.out.println("Initialised!");
			StatusUpdate su=new StatusUpdate();
			ResultSet rs=stmt.executeQuery("select * from statusTable where status='DOWN' minus select * from downTable");
			
			
			while(rs.next())
			{
				System.out.println("Check:"+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				
				try
				{
					URL url = new URL("http://localhost:8099/MonitServ/SendEmail?custid="+rs.getString(2)+"&status=1");
					
					
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
					String line = in.readLine(); 

					System.out.println( "Email Sent:"+line );	

					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				try
				{
					
					
				String query="INSERT INTO downTable values(?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, rs.getString(1));
				ps.setString(2, rs.getString(2));
				ps.setString(3, rs.getString(3));
				ps.setString(4, rs.getString(4));
				ps.setString(5, rs.getString(5));
				ps.executeUpdate();
				ps.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
	public void run()
	{
		
		System.out.println("Works");
		getData();
		
		
		
		

	}
}
