package pubproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/app/home")
@WebServlet(urlPatterns = "/home")
public class ProductDisplay extends HttpServlet{
	
	private ProductService productService = new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("products", productService.getProducts());
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		
//		Product newProduct = new Product(name, price);
		
		request.setAttribute("products", productService.getProducts());
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);	
	}

}
