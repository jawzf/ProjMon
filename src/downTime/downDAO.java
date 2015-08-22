package downTime;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbConnection.ConnectionProvider;

public class downDAO {
	String eqid;
	
	downDAO(String eqid) {
		this.eqid = eqid;
	}

	public void update()
	{
		try{  
			Connection con=ConnectionProvider.getCon();  
			PreparedStatement ps=con.prepareStatement("update statusTable set status='DOWN' where equipid='"+eqid+"'");  
			
			ps.executeUpdate();  
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}  
			      
	}

}
