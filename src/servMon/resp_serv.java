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
				
		String cust_id=request.getParameter("custid");
		String eqp_id= request.getParameter("equipid");
		System.out.println("eqpid:"+eqp_id);
			
		ResponseClass rc=new ResponseClass(eqp_id);
		rc.jobUpdate();
		
		
		request.setAttribute("custid", cust_id);
		request.setAttribute("status", 3);
		ServletContext sc = request.getServletContext();
		
		RequestDispatcher rd =sc.getRequestDispatcher("/SendEmail");
		rd.forward(request, response);
	}
	
	
	

}
