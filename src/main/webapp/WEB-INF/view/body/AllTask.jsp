<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header.jsp" />
<div class="container">
<c:if test="${role != 1}">
<a href="${pageContext.request.contextPath}/add-task?idProject=${idProject}" type="button" class="btn btn-primary">Add Task</a>
</c:if>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Trạng thái</th>
      <c:if test="${role != 3}">
      	<th scope="col">Assign</th>
      </c:if>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${listTask}" var="c">
		<tr>
			<td scope="row">${c.ID}</td>
			<td>${c.name}</td>
			<td>${c.status == 1 ? 'Open' : c.status == 2 ? 'Process': 'Complete'}</td>
			<c:if test="${role != 1}">
				<td>${c.assign}</td>
			</c:if>
			<td>
				<a href="${pageContext.request.contextPath}/edit-task?ID=${c.ID}&task=${c.name}&status=${c.status}&ID_Project=${c.projectID}&ID_User=${c.userID}" type="button" class="btn btn-primary">Edit</a>
				<c:if test="${role != 3}">
				   <a href="${pageContext.request.contextPath}/delete-task?ID=${c.ID}" type="button" class="btn btn-danger">Delete</a>
				</c:if>
			</td>
		</tr>
	</c:forEach>
  </tbody>
</table>
</div>

</body>
</html>