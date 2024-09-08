package gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
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
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String playername=request.getParameter("playername");
		String playernumber=request.getParameter("playernumber");
		String playertype=request.getParameter("playertype");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String insertSQL="insert into team1 (username,password,playername,playernumber,playertype) VALUES(?,?,?,?,?)";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/team1","root","kush");
			PreparedStatement pst=con.prepareStatement(insertSQL);
			
			pst.setString(1,username);
			pst.setString(2,password);
			pst.setString(3,playername);
			pst.setString(4,playernumber);
			pst.setString(5,playertype);
			
			pst.executeUpdate();
			out.println("Added User into Database");
			System.out.println("Player Added");			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		doGet(request, response);
		doGet(request, response);
	}

}
