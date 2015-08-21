package servMon;

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



/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    String cid;int mess;
    String mssg;
// @see HttpServlet#HttpServlet()
 public SendEmail()
 { 
 	super();
 }
   
 
 
 public void send(String emailMessage){

     try{
         final String fromEmail = "wemonitor.verizon@gmail.com"; //requires valid gmail id
         final String password = ""; // correct password for gmail id
         String toEmail = ""; // can be any email id 

         System.out.println("TLSEmail Start");
         java.util.Properties props = System.getProperties();
         props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
         props.put("mail.smtp.port", "587"); //TLS Port
         props.put("mail.smtp.auth", "true"); //enable authentication
         props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

             //create Authenticator object to pass in Session.getInstance argument
         Authenticator auth = new Authenticator()
        {
             //override the getPasswordAuthentication method
             protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(fromEmail, password);
             }

         };
         
         Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		    Statement st = con.createStatement();
		    ResultSet rs =st.executeQuery("select email from statusTable where custid= '"+cid+"'");
 		   
 		    while(rs.next())
 		    {
 		    	System.out.println(rs.getString("EMAIL"));
 		    	toEmail=rs.getString("EMAIL");
 		    }           
Session session = Session.getInstance(props, auth);

         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(fromEmail));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

         System.out.println("Mail Check 2");

         message.setSubject("Verizon Monitoring-Service Report");
         message.setText(emailMessage);

         System.out.println("Mail Check 3");

         Transport.send(message);
         System.out.println("Mail Sent");
     }catch(Exception ex){
         System.out.println("Mail fail");
         System.out.println(ex);
     }
 }



	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  cid=request.getParameter("custid");
		  mess=Integer.parseInt(request.getParameter("status"));
		  System.out.println(cid);
 	if(mess==1)
 	{
 mssg="Dear Customer,\n This message is sent to bring to your attention that your Device is down and has been scheduled to be serviced";
 	}
 	else if (mess==2)
 	{
 		mssg="Dear Customer,\n This message is sent to bring to your attention that The device is scheduled for regular maintainence";
 	}
 	else if(mess==3)
 	{
 		mssg="Dear Customer,\n This message is sent to bring to your attention that The device has been serviced and should be running properly";
 	}
 	send(mssg);
}
	
}
