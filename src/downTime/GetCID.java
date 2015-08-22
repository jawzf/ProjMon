package downTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetCID {
String eqid,custid="";
	
	GetCID(String eqid) {
		this.eqid = eqid;
	}

	public String getCid()
	{
		try{  
			Connection con=ConnectionProvider.getCon();  
			PreparedStatement ps=con.prepareStatement("select custid from statusTable where equipid='"+eqid+"'");  
			
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				custid=rs.getString(1);
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}  
		return custid;
			      
	}


}
