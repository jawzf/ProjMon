package servMon;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.TimerTask;

import dbConnection.ConnectionProvider;

public class contRun extends TimerTask {
	public boolean getData()
	{//comment
		boolean m=false;
		try {
			
			InputStream iStream=contRun.class.getClassLoader().getResourceAsStream("url.properties");
			Properties props=new Properties();
			props.load(iStream);
			String yoorl=props.getProperty("url");
			String port=props.getProperty("port");	
			
			System.out.println(yoorl+port);
			Connection con=ConnectionProvider.getCon();
			Statement stmt=con.createStatement();  
			System.out.println("Initialised!");
			StatusUpdate su=new StatusUpdate();
			ResultSet rs=stmt.executeQuery("select * from statusTable where status='DOWN' minus select * from downTable");
			m=true;
			
			while(rs.next())
			{
				System.out.println("Check:"+rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3));
				
				
				try
				{
					URL url = new URL("http://"+yoorl+":"+port+"/MonitServ/SendEmail?custid="+rs.getInt(2)+"&status=1");
					
					
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
				System.out.println("enter contRun");	
					
				String query="INSERT INTO downTable values(?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, rs.getString(1));
				ps.setInt(2, rs.getInt(2));
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
		
		return m;
	}
	
	public void run()
	{
		
		System.out.println("Works");
		getData();
		
		
		
		

	}
}
