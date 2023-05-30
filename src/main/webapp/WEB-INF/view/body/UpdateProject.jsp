<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header.jsp" />
<div class="container">
	<form action="edit-project" method="post" id="form-new">
		<input type="hidden" value="${ID}" name="ID">
	  <div class="mb-3">
	    <label for="name" class="form-label">Tên dự án</label>
	    <input type="text" class="form-control" id="name" name ="name" value="${name}">
	  </div>
	  <div class="mb-3">
	    <label for="startDate" class="form-label">Ngày bắt đầu</label>
	    <input type="date" class="form-control" id="startDate" name="startDate" value="${startDate}">
	  </div>
	  <div class="mb-3">
	    <label for="endDate" class="form-label">Ngày kết thúc</label>
	    <input type="date" class="form-control" id="endDate" name="endDate" value="${endDate}">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
</html>