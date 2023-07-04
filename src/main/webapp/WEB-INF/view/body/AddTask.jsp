<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header2.jsp" />
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <form action="add-task" method="post" id="form-new">
					  <input type="hidden" value="${idProject}" name="idProject">
					  <div class="mb-3">
					    <label for="task" class="form-label">Tên Task</label>
					    <input type="text" class="form-control" id="task" name ="task">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="form-group">
					    <label for="userID">Giao cho</label>
					    <select  name="userID" class="form-control" id="userID">
					        <c:forEach items="${listUser}" var="c">
							<option value="${c.ID}">${c.ten}</option>
							</c:forEach>
					    </select>
					  </div>
					  <div class="mb-3">
					    <label for="description" class="form-label">Description</label>
					    <input type="text" class="form-control" id="description" name ="description">
					    <span class="form-message" style="color: red"></span>
					  </div>
					   <div class="mb-3">
					    <label for="evidence" class="form-label">Evidence</label>
					    <input type="text" class="form-control" id="evidence" name ="evidence">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <button type="submit" class="btn btn-primary">Submit</button>
					</form>
					<script type="text/javascript">
						Validator({
							form : '#form-new',
							errorSelector : '.form-message',
							rules : [Validator.isRequired('#task')],
						});
					</script>
				</div>
                <!-- /.container-fluid -->
<jsp:include page="../Common/footer.jsp" />
            