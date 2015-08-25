package serviceUIPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbConnection.ConnectionProvider;

public class linkMapClass {

	public String[] getAddresses()
	{
		String a[];
		
		String b[]=new String[30];
		try{
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement ps = con.prepareStatement("select equipid,address from downTable where status='DOWN'");
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps1 = con.prepareStatement("select count(address) from downTable where status='DOWN'");
			ResultSet rs1 = ps1.executeQuery();
			int length=0;
			if(rs1.next())
				length=rs1.getInt(1);
			System.out.println(length);
			
			a=new String[length];
			
			int i=0;
			while (rs.next()) {
				
				a[i]=rs.getString(2).trim();
				System.out.println(a[i]);
				i++;
				
				
			}
			
			return a;
			
		} catch (Exception e) {
			e.printStackTrace();
		return	b;
		}
		
	}
	public String[] equip_id()
	{
		String loc[];
		String b[]=new String[30];
	try{
		
		Connection con = ConnectionProvider.getCon();
		PreparedStatement ps = con.prepareStatement("select equipid from downTable where status='DOWN'");
		ResultSet rs = ps.executeQuery();
		PreparedStatement ps1 = con.prepareStatement("select count(address) from downTable where status='DOWN'");
		ResultSet rs1 = ps1.executeQuery();
		int length=0;
		if(rs1.next())
			length=rs1.getInt(1);
		loc=new String[length];
		
		
		
		
		int i=0;
		while (rs.next()) {
			loc[i]=rs.getString(1).trim();
			
			i++;
			
			
		}
		
		return loc;
		
	} catch (Exception e) {
		e.printStackTrace();
	return	b;
	}
	
}
	public static void main(String[] args) {
		linkMapClass ls=new linkMapClass();
		System.out.println(ls.getAddresses().length);
		

	}

	

}