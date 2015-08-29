package emailPackage;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.ConnectionProvider;



/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    String cid;int mess;
    String mssg,sday,eday;
// @see HttpServlet#HttpServlet()
 public SendEmail()
 { 
 	super();
 }
   
 
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{
	doGet(request,response);
}


	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  cid=request.getParameter("custid");
		  mess=Integer.parseInt(request.getParameter("status"));
		  sday=request.getParameter("sday");
		  eday=request.getParameter("eday");
			  
		  System.out.println("EMAIL:"+cid);
 	if(mess==1)
 	{
 mssg="Dear Customer,\n This message is sent to bring to your attention that your connection is down due to a faulty device and has been scheduled to be serviced. "+
 	"A technician will get in touch with you shortly. "+". Once the connection is up, you'll be notified. All inconvenience caused is regretted. "+"\nRegards,\nVZ Monitoring";
 	}
 	else if (mess==2)
 	{
 		mssg="Dear Customer,\n This message is sent to bring to your attention that The device is scheduled for regular maintainence";
 	}
 	else if(mess==3)
 	{
 		mssg="Dear Customer,\n This message is sent to bring to your attention that your faulty device has been serviced and should be running properly."+
 				" All inconvenience caused is regretted. "+"\nRegards,\nVZ Monitoring";
 	}
 	else if(mess==4)
 	{
 		mssg="Dear Customer,\n This message is sent to bring to your attention that your connection will be down for a short period for maintenance purposes from"+
 	" "+sday+" to "+eday+". Once the connection is up, you'll be notified. All inconvenience caused is regretted. "+"\nRegards,\nVZ Monitoring";
 	}
 	SendEmailClass se=new SendEmailClass(cid);
 	se.send(mssg);
}
	
}
