<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title> The George. </title>
</head>
<body>
<header>
	<div class="wrapper">
    	<h1> The George <span class="orange">.</span></h1>
	</div>

</header>
<body>	
	<div class="login">
	<form action="/login" method="post">	
	    <div class="container">
	    <label for="username"><b>Username</b></label>
	    <input type="text" placeholder="Enter Username" name="username" required>
	
	    <label for="password"><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="password" required>
	
	    <button type="submit">Login</button>
	    <a href="/register">Register</a>	 
	
	</form>
	</div>
	
	<img class = "logo" src="${pageContext.request.contextPath}/image/logo.jpg" alt="logo"/> 

	<link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet">
	<link rel="stylesheet" href="/styles/main.css">
</body>
	<footer class="text-center">
		
		<h5>The George<span class="orange">. </span> </h5>
	</footer>
</html>