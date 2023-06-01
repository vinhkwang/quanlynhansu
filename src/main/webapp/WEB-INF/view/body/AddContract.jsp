<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header.jsp" />
<div class="container">
	<form action="add-contract" method="post" id="form-new">
	  <div class="mb-3">
	    <label for="contract" class="form-label">Tên Hợp đồng</label>
	    <input type="text" class="form-control" id="contract" name ="contract">
	  </div>
	  <div class="mb-3">
	    <label for="nameEmployee" class="form-label">Tên nhân viên</label>
	    <input type="text" class="form-control" id="nameEmployee" name ="nameEmployee">
	  </div>
	  <div class="mb-3">
	    <label for="role" class="form-label">Role</label>
	    <select name="role" class="form-select" aria-label="Default select example">
			<option value="3">Nhân viên</option>
			<option value="2">PM</option>
			<option value="1">Amin</option>
		</select>
	  </div>
	  <div class="mb-3">
	    <label for="userName" class="form-label">Tên đăng nhập</label>
	    <input type="text" class="form-control" id="userName" name ="userName">
	  </div>
	  <div class="mb-3">
	    <label for="password" class="form-label">Mật khẩu</label>
	    <input type="password" class="form-control" id="password" name ="password">
	  </div>
	  <div class="mb-3">
	    <label for="birthday" class="form-label">Năm sinh</label>
	    <input type="date" class="form-control" id=""birthday" name ="birthday">
	  </div>
	  <div class="mb-3">
	    <label for=ThoiHan class="form-label">Thời hạn</label>
	    <input type="number" class="form-control" id="ThoiHan" name ="ThoiHan">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
</html>