package serviceUIPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConnection.ConnectionProvider;

public class jobClassGet {
	Connection conn;
	
	
	public String[] getEIDown()
	{
		String[] res,b=new String[2];
		try
		{
			
			conn=ConnectionProvider.getCon();
			
			Statement s=conn.createStatement();
			
			ResultSet rs=s.executeQuery("select equipid from downTable");
			 int i=0;
			 
			 PreparedStatement ps1 = conn.prepareStatement("select count(equipid) from downTable");
				ResultSet rs1 = ps1.executeQuery();
				int length=0;
				if(rs1.next())
					length=rs1.getInt(1);
				System.out.println(length);
				
				res=new String[length];
				
			while(rs.next())
			{
				System.out.println("Hola");
				res[i]=rs.getString(1);
				
				System.out.println(res[i]);
				i++;
			}		
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return b;
		}
		return res;
		
	
	}

}
