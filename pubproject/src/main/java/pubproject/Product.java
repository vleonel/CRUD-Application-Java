package pubproject;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Product implements Serializable{
	private int id;
	private String name;
	private String type;
	private double price;
	private String user_pub_id;
	
	public Product() 
	{ 
		 
	} 
	 
	public Product (String name, double price)
	{ 
		this.name = name;
		this.price = price;
	} 
	
	public Product (int id, String name, String type, double price)
	{ 
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	} 
	
	public Product (String name, String type, double price) 
	{ 
		this.name = name;
		this.type = type;
		this.price = price;
	} 
	
	public int getId() 
	{ 
		return id;
	} 
	 
	public String getName()
	{ 
		return name;
	} 
	
	public double getPrice() 
	{ 
		return price;
	} 
	
	public String getPriceAsCurrency()
	{ 
		DecimalFormat df = new DecimalFormat("#.00"); 
		return "$" + df.format(price);
	} 
	
	public String getType()
	{ 
		return type;
	} 
	
	public void setId(int id)
	{ 
		this.id = id;
	} 
	 
	public void setName(String name)
	{ 
		this.name = name;
	} 
	
	public void setPrice(double price)
	{ 
		this.price = price;
	} 
	
	public void setType(String type)
	{ 
		this.type = type;
	} 
}
