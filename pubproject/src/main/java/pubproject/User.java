package pubproject;

public class User {
	String username;
	String password;
	String fullName;
	String email;
	
	public User (String username, String password, String fullName, String email)
	{
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	public String getFullName()
	{
		return fullName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
}
