package servMon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class linkMapClass {

	public String[] getAddresses()
	{
		String a[];
		int d=0;
		String b[]=new String[30];
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott","tiger");
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
			con.close();
			return a;
			
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