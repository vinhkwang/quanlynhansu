<%@page import="com.dmt.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header.jsp" />

<% int status = (int)request.getAttribute("status"); %>
<div class="container">
	<form action="edit-task" method="post" id="form-new">
			<input type="hidden" value="${ID_Project}" name="ID_Project">
		  <input type="hidden" value="${ID}" name="ID">
		  <div class="mb-3">
		    <label for="task" class="form-label">Tên Task</label>
		    <input type="text" class="form-control" id="task" name ="task" value="${task}">
		  </div>
		  <div class="mb-3">
		    <label for="status" class="form-label">Status</label>
		    <select name="status" class="form-select" aria-label="Default select example">
			  <option value="1" <% if ((status == 1)) out.print("selected"); %>>Open</option>
			  <option value="2" <% if ((status == 2)) out.print("selected"); %>>Process</option>
			  <option value="3" <% if ((status == 3)) out.print("selected"); %>>Completed</option>
			</select>
		  </div>
		  <div class="mb-3">
		    <label for="assign" class="form-label">Assign</label>
		    <select name="ID_User" class="form-select" aria-label="Default select example">
		    <c:if test="${not empty listUser}">
			    <c:forEach items="${listUser}" var="u">
				  <option value="${u.ID}" ${u.ID == ID_User ? 'selected' : ''}>${u.ten}</option>
				</c:forEach>
			</c:if>
			<c:if test="${empty listUser}">
			    <option value="-1">Not found Employee</option>
			</c:if>
			</select>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
</div>

</body>
</html>