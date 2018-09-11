<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
</head>
<body>
<form action="register" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <label><b>Full Name</b></label>
    <input type="text" placeholder="Full Name" name="fullname" required>

    <label><b>Email</b></label>
    <input type="text" placeholder="Email" name="email" required>
    
    <hr>
    <button type="submit" value="submit">Register</button>
  </div>
</form>
</body>
</html>