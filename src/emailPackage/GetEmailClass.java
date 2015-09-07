package emailPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConnection.ConnectionProvider;

public class GetEmailClass {
	String email="";
	int custid=0;
	
	public GetEmailClass(int custid) {
		super();
		this.custid = custid;
	}

	public String getEmail()
	{
		try{
			Connection con =ConnectionProvider.getCon();
		    Statement st = con.createStatement();
		    ResultSet rs =st.executeQuery("select email from statusTable where custid= "+custid+"");
			   
			    while(rs.next())
			    {
			    	System.out.println(rs.getString("email"));
			    	email= rs.getString("email");
			    }  
			}
		catch(Exception e)
		{
			
		}
		    return email;

	}
	
}
