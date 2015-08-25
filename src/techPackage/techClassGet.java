package techPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConnection.ConnectionProvider;

public class techClassGet {
	 Connection conn=null;
	 String technician_id;
	 String[] add=new String[30];
	 int length=0;
	 
	techClassGet(String a)
	{
		technician_id=a;
		
	}
	public String[] dbConnEid()
	{
		String[] res;
		String[] b=new String[30];
		try
		{
			
			conn=ConnectionProvider.getCon();
			
			Statement s=conn.createStatement();
			System.out.println(""+technician_id);
			
			ResultSet rs=s.executeQuery("select equipid from assignTable where technicianid='"+technician_id+"'");
			 int i=0;
			 
			 PreparedStatement ps1 = conn.prepareStatement("select count(equipid) from assignTable where technicianid='"+technician_id+"'");
				ResultSet rs1 = ps1.executeQuery();
				
				if(rs1.next())
					length=rs1.getInt(1);
				System.out.println(length);
				
				res=new String[length];
				
			while(rs.next())
			{
				System.out.println("Hola");
				res[i]=rs.getString(1);
				add[i]=dbGetAdd(res[i]);
				System.out.println(res[i]);
				i++;
			}		
			return res;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return b;
		}
		
		
	
	}
	
	public String dbGetAdd(String eid)
	{
		String res="";
		try
		{
			
			conn=ConnectionProvider.getCon();
			
			Statement s=conn.createStatement();
			
			System.out.println(res);
			
					ResultSet rs2=s.executeQuery("select address from downTable where equipid='"+eid+"'");
					System.out.println("dbGetAdd"+eid);
					
						while(rs2.next())
						{
							res=rs2.getString(1);
							System.out.println("dbGetAdd"+res);
						}	
					
			//s.executeQuery("select address from downTable where equip_id="+equip_id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	
	}
	
	public String[] dbConnAdd()
	{
		System.out.println("dbConnAdd"+add[0]);
		return add;
		
	}
	

}
