package techPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConnection.ConnectionProvider;

public class techClassGet {
	 Connection conn=null;
	 String technician_id;
	 String[] add=new String[20];
	techClassGet(String a)
	{
		technician_id=a;
		
	}
	public String[] dbConnEid()
	{
		String[] res=new String[20];
		try
		{
			
			conn=ConnectionProvider.getCon();
			
			Statement s=conn.createStatement();
			
			
			ResultSet rs1=s.executeQuery("select equip_id from assignTable where technician_id="+technician_id);
			 int i=0;
			while(rs1.next())
			{
				res[i]=rs1.getString(1);
				i++;
			}		
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	
	}
	
	public String[] dbConnAdd()
	{
		String res="";
		try
		{
			
			conn=ConnectionProvider.getCon();
			
			Statement s=conn.createStatement();
			
			
			
					
					ResultSet rs2=s.executeQuery("select address from downTable where equipid="+res);
					
					 int i=0;
						while(rs2.next())
						{
							add[i]=rs2.getString(1);
							i++;
						}	
					
			//s.executeQuery("select address from downTable where equip_id="+equip_id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return add;
	
	}
	

}
