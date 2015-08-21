package servMon;


/*
 * CHECK THIS CODE WITH KARTHIKA FIRST :D
 * LINK THE CODE PROPERLY TOMORROW!
 * 
 * 
 * 
 */


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
			
			System.out.println("here");
			
			int eqp_id= Integer.parseInt(request.getParameter("e_id"));
			System.out.println("eqpid:"+eqp_id);
				
			request.setAttribute("equip_id", eqp_id);
			request.setAttribute("status", 2);
			
		s.executeUpdate("update kar set age=19 where no="+eqp_id);	
			System.out.println("updated");
				
			System.out.println(eqp_id);
			
			s.executeUpdate("delete from down_table where equip_id="+eqp_id);
						
			ServletContext sc = request.getServletContext();
			
	RequestDispatcher rd =sc.getRequestDispatcher("/temp");
					rd.forward(request, response);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	
	

}
