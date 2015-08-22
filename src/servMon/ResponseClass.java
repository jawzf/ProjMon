package servMon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class ResponseClass {
	Connection con;  
	String eqp_id="";
	
	
	public ResponseClass(String eqp_id) {
		
		this.eqp_id = eqp_id;
	}


	public void jobUpdate()
	{
		Connection conn=null;
		try
		{
			System.out.println("hi");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			Statement s=conn.createStatement();
			
			System.out.println("here");
			
			
			s.executeUpdate("update statusTable set status='UP' where EQUIPID="+eqp_id);	
			System.out.println("updated");
				
			System.out.println(eqp_id);
			
			s.executeUpdate("delete from downTable where equipid="+eqp_id);
						
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}

}
