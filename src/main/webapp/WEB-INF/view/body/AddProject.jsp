<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header2.jsp" />
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <form action="add-project" method="post" id="form-new">
					  <div class="mb-3">
					    <label for="project" class="form-label">Tên dự án</label>
					    <input type="text" class="form-control" id="project" name ="project">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="form-group">
						    <label for="status">PM</label>
						    <select  name ="ID_PM" class="form-control" id="status">
								  <c:forEach items="${PM}" var="c">
										<option value="${c.ID}">${c.ten}</option>
								  </c:forEach>
						    </select>
					  </div>
					  
					  <div class="mb-3">
					    <label for="startday" class="form-label">Ngày bắt đầu</label>
					    <input type="date" class="form-control" id="startday" name="startday">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="mb-3">
					    <label for="enddate" class="form-label">Ngày kết thúc</label>
					    <input type="date" class="form-control" id="enddate" name="enddate">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="mb-3">
					    <label for="description" class="form-label">Description</label>
					    <input type="text" class="form-control" id="description" name ="description">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <button type="submit" class="btn btn-primary">Submit</button>
					</form>
                </div>
                <script type="text/javascript">
					Validator({
						form : '#form-new',
						errorSelector : '.form-message',
						rules : [
								Validator.isRequired('#project'),
								Validator.isRequired('#startday'),
								Validator.isRequired('#enddate'),
								Validator.isDateEndGreaterThanStart('#startday',
										'#enddate') ],
					});
				</script>
                <!-- /.container-fluid -->
<jsp:include page="../Common/footer.jsp" />
            