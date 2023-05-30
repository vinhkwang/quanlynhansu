<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header.jsp" />
<div class="container">
<a href="/QuanLyCongViec/add-project" type="button" class="btn btn-primary">Add Project</a>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Ngày bắt đầu</th>
      <th scope="col">Ngày kết thúc</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${listProject}" var="c">
		<tr>
			<td scope="row">${c.ID}</td>
			<td>${c.name}</td>
			<td>${c.startDate}</td>
			<td>${c.endDate}</td>
			<td>
				<a href="/QuanLyCongViec/edit-project?ID=${c.ID}&name=${c.name}&startDate=${c.startDate}&endDate=${c.endDate}" type="button" class="btn btn-primary">Edit</a>
				<a href="/QuanLyCongViec/delete-project?ID=${c.ID}" type="button" class="btn btn-danger">Delete</a>
				<a href="/QuanLyCongViec/all-task?idProject=${c.ID}" type="button" class="btn btn-success">Task</a>
			</td>
		</tr>
	</c:forEach>
  </tbody>
</table>
</div>

</body>
</html>