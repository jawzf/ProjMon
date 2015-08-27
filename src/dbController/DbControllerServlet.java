package dbController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.ConnectionProvider;
import serviceUIPackage.jobClassGet;
import MiscPackage.mString;

/**
 * Servlet implementation class DbControllerServlet
 */
@WebServlet("/DbControllerServlet")
public class DbControllerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbControlClass gt=new DbControlClass();
		String res[]=gt.getEIDown();
		for(int k=0;k<res.length;k++)
		{
			System.out.println("jobServ:"+res[k]);
		}
		
		
		String jsonString="[";
		int i=0;
		for(i=0;i<res.length;i++)
		{
			jsonString=jsonString+"{\"equipID\":\""+res[i]+"\"}";
			
			if(i!=res.length-1)
			{
				jsonString+=",";
			}
			else
				break;
		} 
		
		jsonString=mString.lastCut(jsonString);
		jsonString=jsonString+"]";
		System.out.println(jsonString);
		  response.setContentType("application/json");
		
		  response.getWriter().print(jsonString);
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try
		{
			
			Connection conn=ConnectionProvider.getCon();
			
			Statement s1=conn.createStatement(),s2=conn.createStatement(),s3=conn.createStatement();
			
		s1.executeUpdate("truncate table downTable");
		s2.executeUpdate("truncate table assignTable");
		s3.executeUpdate("update statusTable set status='UP' where status='DOWN'");
			 response.sendRedirect("TableController.jsp");
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	
	}
	

}
