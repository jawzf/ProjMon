package downTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbConnection.ConnectionProvider;

public class GetCID {
String eqid;
int custid=0;	
	public GetCID(String eqid) {
		this.eqid = eqid;
	}

	public int getCid()
	{
		try{  
			Connection con=ConnectionProvider.getCon();  
			PreparedStatement ps=con.prepareStatement("select custid from statusTable where equipid='"+eqid+"'");  
			
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				custid=rs.getInt(1);
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}  
		return custid;
			      
	}


}
