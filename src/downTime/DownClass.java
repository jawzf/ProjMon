package downTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

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
		downDAO dd=new downDAO(equipID);
		dd.update();
		GetCID gc=new GetCID(equipID);
		String custid=gc.getCid();
		try
		{
			URL url = new URL("http://localhost:8099/MonitServ/SendEmail?custid="+custid+"&status=4&sday="+startDay+"&eday="+endDay);
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
			String line = in.readLine(); 

			System.out.println( "Email Sent:"+line );	

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
