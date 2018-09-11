package pubproject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/updateItem")
public class UpdateItem extends HttpServlet{
	ProductService productService = new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int id = Integer.parseInt(request.getParameter("id"));
		
//		String urlValue = request.getQueryString();
//		String id = urlValue.split("=")[0];
//		int convertedId = Integer.parseInt(id);
	//	String product_id= request.getParameter(id);
		
//		String name = request.getParameter(request.getParameter("name"));
//		String type = request.getParameter(request.getParameter("type"));
//		String price = request.getParameter(request.getParameter("price"));
//		
//		Product newProduct = new Product();
//		try {
//			ProductService.getProductById(id);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			request.setAttribute("product", productService.getProductById((id)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		request.setAttribute("name", productService.getProducts());
		
		request.getRequestDispatcher("/WEB-INF/views/updateItem.jsp").forward(request, response);	
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		double price = Double.parseDouble(request.getParameter("price"));
		
		Product newProduct = new Product(id, name, type,  price);
		productService.updateProduct(newProduct);
		
		response.sendRedirect("/home");
	}
}
