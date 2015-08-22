package servMon;

import java.io.IOException;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class techServ
 */
@WebServlet("/techServ")
public class techServ extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
	 Connection conn=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public techServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String technician_id=request.getParameter("technicianID");
		
		techClassGet tc=new techClassGet(technician_id);
		String res=tc.dbConnEid();
		String add=tc.dbConnAdd();
		request.setAttribute("equipId",res);
		request.setAttribute("addr",add);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		String equip_id=request.getParameter("equipID");
		String technician_id=request.getParameter("technician_id");
		
		techClassPost tcp=new techClassPost(equip_id,technician_id);
		tcp.dbQueries();
		System.out.println("Assigned");

		
		

		
	}

}
