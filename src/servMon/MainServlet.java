package servMon;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	Timer timer;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()
    {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		// TODO Auto-generated method stub
		timer.cancel();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body background=\"img/bg.jpg\" style=\"color:white\"><br><br><br><center><h1>Monitoring Cancelled</h1>");
		out.println("<form action=MainServlet method=post><input type=submit value=\"Restart Monitoring\"></center></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body background=\"img/bg.jpg\" style=\"color:white\"><br><br><br><center><h1>Monitoring In-Process</h1>");
		out.println("<form action=MainServlet method=get><input type=submit value=\"Stop Mon\"></form></center></body></html>");
		timer = new Timer();
        timer.schedule(new contRun(),0, 10*1000);
      

		
		
	}

}
