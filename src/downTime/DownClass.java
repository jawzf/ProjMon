package downTime;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DownClass")
public class DownClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Check");
		String equipID=request.getParameter("eID");
		String startDay=request.getParameter("startDay");
		String endDay=request.getParameter("endDay");
		System.out.println(equipID+"\n"+startDay+"\n"+endDay);
	}

}
