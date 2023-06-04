<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script src="js/Validator.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <%if(request.getAttribute("role") != null){
        	int role = (int)request.getAttribute("role");
        	if(role == 1 || role == 2){
        		%>
        			<li class="nav-item">
			          <a class="nav-link" href="/QuanLyCongViec/all-project">Project</a>
			        </li>
        		<%
        	}
        } %>
        
        <%if(request.getAttribute("role") != null){
        	int role = (int)request.getAttribute("role");
        	if(role == 1){
        		System.out.print("role"+ role);
        		%>
        			<li class="nav-item">
			          <a class="nav-link" href="/QuanLyCongViec/all-contract">Contract</a>
			        </li>
        		<%
        	}
        } %>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/logout" tabindex="-1">Logout</a>
        </li>
        <li class="nav-item">
        <%if(request.getAttribute("role") != null){
        	int role = (int)request.getAttribute("role");
        	if(role == 1){
        		%>
		          <a class="nav-link bg-warning text-dark" href="#">Admin</a>
  				<%
        	}
        	if(role == 2){
        		%>
		          <a class="nav-link bg-warning text-dark" href="#">PM</a>
  				<%
        	}
        	if(role == 3){
        		%>
		          <a class="nav-link bg-warning text-dark" href="#">Member</a>
  				<%
        	}
        } %>
        </li>
      </ul>
    </div>
  </div>
</nav>



