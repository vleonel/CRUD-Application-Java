<%@ include file="../common/header.jspf" %>

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
	<form action="logout" method="post" style="margin: -20px 1300px;">
		<input type="submit" value="logout">
	</form>
	<div class="add" style="margin: 40px 600px;position:absolute;float:right;">
		<a href="/addItem">Add Item</a>
	</div>
   </div>   
	<div class="container">
		<h2 class="mt-4">
			Products for Sale
		</h2>
               
         <table border="1" cellpadding="10" width="50%" class="table">
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" />
</html>