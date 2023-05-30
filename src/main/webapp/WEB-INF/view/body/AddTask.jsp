<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header.jsp" />
<div class="container">
	<form action="add-task" method="post" id="form-new">
	  <input type="hidden" value="${idProject}" name="idProject">
	  <div class="mb-3">
	    <label for="task" class="form-label">Tên Task</label>
	    <input type="text" class="form-control" id="task" name ="task">
	  </div>
	  <div class="mb-3">
	    <label for="startday" class="form-label">Giao cho</label>
	    <select name="userID" class="form-select" aria-label="Default select example">
	      <option value="-1">None</option>
		  <option value="1">One</option>
		  <option value="2">Two</option>
		  <option value="3">Three</option>
		</select>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
</html>