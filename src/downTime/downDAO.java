package downTime;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbConnection.ConnectionProvider;

public class downDAO {
	String eqid;
	
	downDAO(String eqid) {
		this.eqid = eqid;
	}

	public boolean update()
	{
		boolean m=false;
		try{  
			Connection con=ConnectionProvider.getCon();  
			PreparedStatement ps=con.prepareStatement("update statusTable set status='DOWN' where equipid='"+eqid+"'");  
			
			ps.executeUpdate();  
			m=true;
			}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		return m;
			      
	}

}
