package pubproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login") 
public class LoginServlet extends HttpServlet { 
 
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);	
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String dbName = null;
		String dbPassword = null;
		
		String sql = "SELECT * FROM user_pub WHERE username = ? AND password=?";
		
		Connection connection = Database.getConnection();
		
		try {
			PreparedStatement statement =  connection.prepareStatement(sql);
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet resultSet = statement.executeQuery();
			
			PrintWriter out = response.getWriter();
			while(resultSet.next()) {
				dbName = resultSet.getString(2);
				dbPassword = resultSet.getString(3);	
			}
			if(username.equals(dbName) && password.equals(dbPassword)) {
				out.print("Welcome, " + username);
				HttpSession session = request.getSession(true);
				
				session.setAttribute("user", username);
				session.setMaxInactiveInterval(90);
				response.sendRedirect("/home");
				
			}
			else {
				request.setAttribute("errorMessage", "Invalid Credentials");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
				rd.include(request, response);
			}
		}
		catch (SQLException e) {
        e.printStackTrace();
//        System.out.println("Failed");        
		} 				
	}
} 
