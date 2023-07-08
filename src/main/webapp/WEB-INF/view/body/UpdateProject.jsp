<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header2.jsp" />
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <form action="edit-project" method="post" id="form-new">
							<input type="hidden" value="${ID}" name="ID">
						  <div class="mb-3">
						    <label for="name" class="form-label">Tên dự án</label>
						    <input type="text" class="form-control" id="name" name ="name" value="${name}">
						    <span class="form-message" style="color: red"></span>
						  </div>
						  <div class="form-group">
						    <label for="status">PM</label>
						    <select  name ="ID_PM" class="form-control" id="status">
						          <c:forEach items="${PM}" var="c">
										<option value="${c.ID}" ${c.ID == ID_PM ? 'selected' : ''}>${c.ten}</option>
								  </c:forEach>
						    </select>
						  </div>
						  <div class="mb-3">
						    <label for="startDate" class="form-label">Ngày bắt đầu</label>
						    <input type="date" class="form-control" id="startDate" name="startDate" value="${startDate}">
						    <span class="form-message" style="color: red"></span>
						  </div>
						  <div class="mb-3">
						    <label for="endDate" class="form-label">Ngày kết thúc</label>
						    <input type="date" class="form-control" id="endDate" name="endDate" value="${endDate}">
						    <span class="form-message" style="color: red"></span>
						  </div>
						  <div class="mb-3">
						    <label for="description" class="form-label">Description</label>
						    <input type="text" class="form-control" id="description" name ="description" value="${description}">
						    <span class="form-message" style="color: red"></span>
						  </div>
						  <button type="submit" class="btn btn-primary">Submit</button>
						</form>
						<script type="text/javascript">
							Validator({
								form : '#form-new',
								errorSelector : '.form-message',
								rules : [
										Validator.isRequired('#name'),
										Validator.isRequired('#startDate'),
										Validator.isRequired('#endDate'),
										Validator.isDateEndGreaterThanStart('#startDate',
												'#endDate') ],
							});
						</script>
				</div>
                <!-- /.container-fluid -->
<jsp:include page="../Common/footer.jsp" />
            