package gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updatedetails
 */
@WebServlet("/Updatedetails")
public class Updatedetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatedetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String playername= request.getParameter("playername");
		String playernumber= request.getParameter("playernumber");
        String playertype= request.getParameter("playertype");
        String linkUrl="displayplayer";
        try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String updateSQL="UPDATE team1 SET username=?,password=?,password=?,playername=?,playertype=? WHERE playernumber=?";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/team1","root","kush");
			PreparedStatement p1=con.prepareStatement(updateSQL);
			
			p1.setString(1,username);
			p1.setString(2, password);
			p1.setString(3, playername);
			p1.setString(4, playernumber);
			p1.setString(5, playertype);
			
			p1.executeUpdate();
			out.println("Player Details Updated");
			response.sendRedirect("displayplayer");
		}
		catch(Exception e)
        {
			System.out.println(e);
        }
        
		doGet(request, response);
	}
}
