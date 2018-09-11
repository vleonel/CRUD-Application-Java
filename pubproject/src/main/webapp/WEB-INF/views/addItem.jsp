<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Item</title>
</head>
<body>
	  <h5 class="card-header">Add Item</h5>
	  <div class="card-body">					  
	  	<form action="/addItem" method="post">
		  <div class="form-group">
		    <label>Name</label>
		    <input type="text" class="form-control" name="name" placeholder="Enter Name">
		  </div>
		  <div class="form-group">
		    <label>Type</label>
		    <input type="text" class="form-control" name="type" placeholder="Enter Type">
		  </div>
		  <div class="form-group">
		    <label>Price</label>
		    <input type="text" class="form-control" name="price" placeholder="Enter Price">
		  </div>
		  <button type="submit" class="btn btn-primary">Add</button>
		</form>
	  </div>
</body>
</html>