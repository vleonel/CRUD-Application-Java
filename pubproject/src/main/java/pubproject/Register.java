/**
 * 
 */
package pubproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Leo
 *
 */
@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet{
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);	
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			response.setContentType("text/html;charset=UTF-8");
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			String dbName = null;
			String dbPassword = null;
			String dbFullName = null;
			String dbEmail = null;
			
			String sql = "INSERT INTO user_pub(username, password, fullname, email) VALUES(?, ?, ?, ?)";
			
			Connection connection = Database.getConnection();
			try {
				PreparedStatement statement =  connection.prepareStatement(sql);
				
				statement.setString(1, username);
				statement.setString(2, password);
				statement.setString(3, fullname);
				statement.setString(4, email);
				
				statement.executeUpdate();
				
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
				// request.setAttribute("success", "Successfully connected!");
			}
			catch (SQLException e) {
	        e.printStackTrace();
//	        System.out.println("Failed");        
			} 				
		}	

}
