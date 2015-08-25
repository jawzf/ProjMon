package techPackage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import MiscPackage.mString;

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
		/*String technician_id=request.getParameter("technicianID");
		
		techClassGet tc=new techClassGet(technician_id);
		String res[]=tc.dbConnEid();
		String add[]=tc.dbConnAdd();
		int i=0;
		while(i<res.length)
		{
			request.setAttribute("equipId"+i,res[i]);
			request.setAttribute("addr"+i,add[i]);
			i++;
		}
		
		*/
		
		String technician_id=request.getParameter("tID");
		System.out.println("ama"+technician_id);
		techClassGet tc=new techClassGet(technician_id);
		String res[]=tc.dbConnEid();
		String add[]=tc.dbConnAdd();
		System.out.println("tS:"+res[0]+add[0]);
		String jsonString="[";
		int i=0;
		while(i<res.length)
		{
			jsonString=jsonString+"{\"equipID\":\""+res[i]+"\","+"\"address\":\""+add[i]+"\"}";
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
