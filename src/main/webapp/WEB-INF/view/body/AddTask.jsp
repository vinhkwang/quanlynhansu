<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	      <c:forEach items="${listUser}" var="c">
			<option value="${c.ID}">${c.ten}</option>
			</c:forEach>
		</select>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
</html>