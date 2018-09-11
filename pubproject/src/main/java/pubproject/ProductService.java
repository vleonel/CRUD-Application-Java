package pubproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.annotation.WebServlet;

public class ProductService {
	
	public List<Product> getProducts()
	{
		List<Product> products = new ArrayList<Product>();
		Connection connection = Database.getConnection();
		
		String sql = "SELECT * FROM product";
		
        try { 
            PreparedStatement statement = connection.prepareStatement(sql);
 
            ResultSet resultSet = statement.executeQuery();
 
            while(resultSet.next()) {
            	int productId = resultSet.getInt("product_id");
            	String name = resultSet.getString("name");
            	String type = resultSet.getString("type");
            	double price = resultSet.getDouble("price");
            	products.add(new Product(productId, name, type, price));
            } 
            
        	} catch (SQLException e) {
            e.printStackTrace();
        	} 
 
			return products;
	}
	
	public static void insertProduct(Product product)
	{ 
        Connection connection = Database.getConnection();
 
        String sql = "INSERT INTO product (name, type, price) VALUES (?, ?, ?)";
 
        try { 
            PreparedStatement statement = connection.prepareStatement(sql);
 
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setDouble(3, product.getPrice());
             
            statement.execute();
 
        } catch (SQLException e) {
            e.printStackTrace();
        } 
	}
	
	public void updateProduct(Product product)
	{ 
        Connection connection = Database.getConnection();
//        UPDATE product
//        SET name = "Bud"
//        WHERE product_id = 1;
 
        String sql = "UPDATE product SET name = ?, type = ?, price = ? WHERE product_id = ?";
 
        try { 
            PreparedStatement statement = connection.prepareStatement(sql);
 
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setDouble(3, product.getPrice());

            statement.setInt(4, product.getId());
             
            statement.execute();
 
        } catch (SQLException e) {
            e.printStackTrace();
        } 
	}
	
	public Product getProductById(int id) throws SQLException
	{
		Product product = new Product();
		Connection connection = Database.getConnection();
		 
        String sql = "SELECT * FROM product WHERE product_id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, id);
        
        ResultSet res = statement.executeQuery();
        if(res.next()) {
        	product.setName(res.getString("name"));
        	product.setType(res.getString("type"));
        	product.setPrice(res.getInt("price"));
        	product.setId(res.getInt("product_id"));
        }
        
       return product;
	}
	
	public void deleteProduct(int id)
	{
        Connection connection = Database.getConnection();

        String sql = "DELETE FROM product WHERE product_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
