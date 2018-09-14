<%@ include file="../common/header.jspf" %>

<body>
<header>
	<div class="wrapper" >
    	<h1 > The George <span class="orange">.</span></h1>
	</div>
	<div class="image" style="margin: -10px 480px;position:absolute;float:right;">
		<img class = "img-circle" src="${pageContext.request.contextPath}/image/logo.jpg" alt="logo"/>
	</div>
	
</header> 

<body>	
	<c:if test="${success != null }">
		<div class="alert alert-success" role="alert">
			${success}
		</div>
	</c:if>
	
</div>
<div class="container-fluid">
	<form action="/login" method="post" style="margin: 100px 500px;position:absolute;float:center;" >	
	<div class="form-group">
	    <label for="username"><b>Username</b></label>
	    <input type="text" placeholder="Enter Username" name="username" required class="form-control">
	</div>
	<div class="form-group">
	    <label for="password"><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="password" required class="form-control">
	</div>
	    <button type="submit" class="btn btn-default">Login</button>
	    <a href="/register">Register</a>	 
	
	</form>
<!-- 
	<div class="container">
	<c:if test="${errorMessage != null }">
		<div class="alert alert-danger mt-3" role="alert">
			${errorMessage}
		</div>
	</c:if>
 -->

	
<!-- <img class = "logo" src="${pageContext.request.contextPath}/image/logo.jpg" alt="logo"/>  -->	
</div>

	<!-- <link href="https://fonts.googleapis.com/css?family=Crete+Round" rel="stylesheet"> --> 
	
  <div class="card-footer text-muted" style="margin: 400px 600px;position:absolute;float:center;">
   <b>ComIt © 2018</b> 
  </div>	
</body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" />
</html>