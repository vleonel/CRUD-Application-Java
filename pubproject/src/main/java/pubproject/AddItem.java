package pubproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/addItem")
public class AddItem extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/addItem.jsp").forward(request, response);	
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		double price = Double.parseDouble(request.getParameter("price"));
		 
//		User user = (User)request.getSession().getAttribute("user");
		
		Product newProduct = new Product(name, type,  price);
		ProductService.insertProduct(newProduct);
		
//		Product newProduct = new Product(name, type, user.get  price);
//		ProductService.insertProduct(newProduct);
		
		response.sendRedirect("/home");
	}
}
