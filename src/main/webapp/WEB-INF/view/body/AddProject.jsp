<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../Common/header.jsp" />
<div class="container">
	<form action="add-project" method="post" id="form-new">
	  <div class="mb-3">
	    <label for="project" class="form-label">Tên dự án</label>
	    <input type="text" class="form-control" id="project" name ="project">
	  </div>
	  <div class="mb-3">
	    <label for="startday" class="form-label">Ngày bắt đầu</label>
	    <input type="date" class="form-control" id="startday" name="startday">
	  </div>
	  <div class="mb-3">
	    <label for="enddate" class="form-label">Ngày kết thúc</label>
	    <input type="date" class="form-control" id="enddate" name="enddate">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
</html>