package servMon;


/*
 * CHECK THIS CODE WITH KARTHIKA FIRST :D
 * LINK THE CODE PROPERLY TOMORROW!
 * 
 * 
 * 
 */


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class resp_serv
 */
@WebServlet("/resp_serv")
public class resp_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con;  
  
    public resp_serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		Connection conn=null;
		try
		{
			System.out.println("hi");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			Statement s=conn.createStatement();
			disp();
			
			ResultSet rs1=s.executeQuery("update kar set age=99 where name='kar'");
			
			System.out.println("updated");
			disp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	void disp()
	{
		Connection con=null;
		
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	
		Statement s=con.createStatement();
		
	
		ResultSet rs=s.executeQuery("select * from kar");//since the query returns many rows.. so we use result set
		System.out.println("no 	name 	age");
		while(rs.next())
		{
		
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));//must give the proper order for the corresponding col name...1 2 3 are the index positions of the cols in table
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
