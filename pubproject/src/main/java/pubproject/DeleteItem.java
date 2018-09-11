package pubproject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/deleteItem")
public class DeleteItem extends HttpServlet{
	
	private ProductService productService = new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		
//		try {
//			request.setAttribute("product", productService.getProductById((id)));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	//	request.getRequestDispatcher("/home").forward(request, response);	
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		productService.deleteProduct(id);
		
		request.setAttribute("products", productService.getProducts());
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);	
	}
}
