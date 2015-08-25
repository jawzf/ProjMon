package serviceUIPackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import techPackage.techClassGet;
import MiscPackage.mString;

/**
 * Servlet implementation class jobServ
 */
@WebServlet("/jobServ")
public class jobServ extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		jobClassGet gt=new jobClassGet();
		String res[]=gt.getEIDown();
		System.out.println("tS:"+res[0]);
		String jsonString="[";
		int i=0;
		while(i<res.length)
		{
			jsonString=jsonString+"{\"equipID\":\""+res[i]+"\"}";
			i++;
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
		// TODO Auto-generated method stub
	}

}
