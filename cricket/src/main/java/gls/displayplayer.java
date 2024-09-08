package gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displayplayer
 */
@WebServlet("/displayplayer")
public class displayplayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayplayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		try
		{
			
		 Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team1","root","kush");
		PreparedStatement p1 = con.prepareStatement("SELECT * FROM team1");
         ResultSet r1 = p1.executeQuery();
         
         while (r1.next()) {
             String username = r1.getString(1);
             String password = r1.getString(2);
             String playername = r1.getString(3);
             String playernumber= r1.getString(4);
             String playertype = r1.getString(5);

             out.println("<tr>");
             out.println("<td>" + username+ "</td>"); 
             out.println("<td>" + password+ "</td>");
             out.println("<td>" + playername + "</td>");
             out.println("<td>" + playernumber + "</td>");
             out.println("<td>" + playertype + "</td>");
             out.println("</tr>");
         }

         out.println("</table>");

         out.println("<h2>Player Details</h2>");
         out.println("<table>");
         out.println("<tr><th>username</th><th>password</th><th>playername</th><th>playernumber</th><th>playertype</th></tr>");

         PreparedStatement p2 = con.prepareStatement("SELECT * FROM team1");
         ResultSet r2 = p2.executeQuery();

         while (r2.next()) {
             String username = r2.getString(1);
             String password = r2.getString(2);
             String playername  = r2.getString(3);
             String playernumber = r2.getString(4);
             String playertype = r2.getString(5);
             
             out.println("<tr>");
             out.println("<td>" + username+ "</td>");
             out.println("<td>" + password + "</td>");
             out.println("<td>" + playername + "</td>");
             out.println("<td>" + playernumber + "</td>");
             out.println("<td>" + playertype + "</td>");
             out.println("</tr>");
         }

         out.println("</table>");
         
         out.println("<a href='login.jsp'>Go to Login page</a><br>");
         
         out.println("<a href='AddPlayers.jsp'>Add New Players</a><br>");
         
         out.println("<a href='UpdateDetails.jsp'>Update Player Details</a><br>");
         
         out.println("<a href='delete.jsp'>Delete Player Details</a><br>");
         
         

         out.println("</body>");
         out.println("</html>");

		

     } 
	catch(Exception e)
	{
		System.out.println(e);
	}
	
 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
