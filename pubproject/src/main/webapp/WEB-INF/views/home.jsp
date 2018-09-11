<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
	<link rel="stylesheet" href="styles/main.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title> The George. </title>
  </head>

  <body>
   <div class="Welcome">
  	<%
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
				out.print("Welcome " + name );
			} else {
				response.sendRedirect("User not logged in");
			}
		}
	%>
	<form action="logout" method="post">
		<input type="submit" value="logout">
	</form>
	<a href="/addItem">Add Item</a>
   </div>   
	<div class="container">
		<h2 class="mt-4">
			Products for Sale
		</h2>
               
         <table border="1" cellpadding="10" width="50%" class="table">
            <caption><h2>List of Beverages</h2></caption>
            <thead class="thead-dark">
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Price</th>
                <th>#</th>
            </tr>
            </thead>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.type}" /></td>
                    <td><c:out value="${product.getPriceAsCurrency()}" /></td>	
                  
                    <td>
                    <form action="/updateItem" method="get">
                        <input id="id" name="id" type="hidden" value="${product.id}">
                    	<button type="submit" class= "btn btn-primary">Update</button>
                    </form>

                    <form action="/deleteItem" method="post">
                    	<input id="id" name="id" type="hidden" value="${product.id}">
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </form>
                    <!--  <a href="/deleteItem?id=<c:out value='${product.id}' />">Delete</a>  -->                       
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
	</div>
    <footer></footer>
  </body>
</html>