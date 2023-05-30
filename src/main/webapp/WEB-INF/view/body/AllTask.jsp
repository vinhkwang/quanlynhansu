<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header.jsp" />
<div class="container">
<a href="/QuanLyCongViec/add-task?idProject=${idProject}" type="button" class="btn btn-primary">Add Task</a>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Trạng thái</th>
      <th scope="col">Assign</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${listTask}" var="c">
		<tr>
			<td scope="row">${c.ID}</td>
			<td>${c.name}</td>
			<td>${c.status == 1 ? 'Open' : c.status == 2 ? 'Process': 'Complete'}</td>
			<td>${c.assign ? c.assign : 'Chưa aggign'}</td>
			<td>
				<a href="/QuanLyCongViec/edit-task?ID=${c.ID}&task=${c.name}&status=${c.status}&ID_Project=${c.projectID}&ID_User=${c.userID}" type="button" class="btn btn-primary">Edit</a>
				<a href="/QuanLyCongViec/delete-task?ID=${c.ID}" type="button" class="btn btn-danger">Delete</a>
			</td>
		</tr>
	</c:forEach>
  </tbody>
</table>
</div>

</body>
</html>