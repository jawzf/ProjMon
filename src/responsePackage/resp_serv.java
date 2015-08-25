package responsePackage;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servMon.contRun;
import downTime.GetCID;

import java.sql.*;
import java.util.Properties;

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
		
		InputStream iStream=contRun.class.getClassLoader().getResourceAsStream("url.properties");
		Properties props=new Properties();
		props.load(iStream);
		String yoorl=props.getProperty("url");
		String port=props.getProperty("port");	
		
		
		
		String eqp_id= request.getParameter("equipid");
		System.out.println("eqpid:"+eqp_id);
			
		ResponseClass rc=new ResponseClass(eqp_id);
		rc.jobUpdate();
		
		
		GetCID gc=new GetCID(eqp_id);
		String cust_id=gc.getCid();
				
		try
		{
			URL url = new URL("http://"+yoorl+":"+port+"/MonitServ/SendEmail?custid="+cust_id+"&status=3");
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
			String line = in.readLine(); 

			System.out.println( "Email Sent:"+line );	

			response.sendRedirect("TechnicianHome.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	

}
