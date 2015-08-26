package dbController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import techPackage.techClassPost;

/**
 * Servlet implementation class dbStatServlet
 */
@WebServlet("/dbStatServlet")
public class dbStatServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] equip_id=request.getParameterValues("equipid");
		String status=request.getParameter("status");
		dbUpdateClass duc=new dbUpdateClass(equip_id, status);
		duc.update();
		
		System.out.println("Assigned");
		response.sendRedirect("TableController.jsp");
	}

}
