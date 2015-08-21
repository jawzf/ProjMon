package servMon;




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
			String cust_id=request.getParameter("custid");
			String eqp_id= request.getParameter("equipid");
			System.out.println("eqpid:"+eqp_id);
				
			request.setAttribute("custid", cust_id);
			request.setAttribute("status", 3);
			
		s.executeUpdate("update statusTable set status='UP' where EQUIPID="+eqp_id);	
			System.out.println("updated");
				
			System.out.println(eqp_id);
			
			s.executeUpdate("delete from downTable where equipid="+eqp_id);
						
			ServletContext sc = request.getServletContext();
			
	RequestDispatcher rd =sc.getRequestDispatcher("/SendEmail");
					rd.forward(request, response);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	
	

}
