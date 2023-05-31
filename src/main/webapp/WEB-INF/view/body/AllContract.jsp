<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header.jsp" />
<div class="container">
<a href="${pageContext.request.contextPath}/add-contract" type="button" class="btn btn-primary">Add Contract</a>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Employee</th>
      <th scope="col">Thời hạn</th>
      <th scope="col">Ngày ký</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${listContract}" var="c">
		<tr>
			<td scope="row">${c.ID}</td>
			<td>${c.name}</td>
			<td>${c.nameEmployee}</td>
			<td>${c.thoiHan}</td>
			<td>${c.ngayKy}</td>
			<%-- <td>
				<a href="/QuanLyCongViec/edit-task?ID=${c.ID}&task=${c.name}&status=${c.status}&ID_Project=${c.projectID}&ID_User=${c.userID}" type="button" class="btn btn-primary">Edit</a>
				<a href="/QuanLyCongViec/delete-task?ID=${c.ID}" type="button" class="btn btn-danger">Delete</a>
			</td> --%>
		</tr>
	</c:forEach>
  </tbody>
</table>
</div>

</body>
</html>