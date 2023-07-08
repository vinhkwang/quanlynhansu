<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Common/header2.jsp" />
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <form action="edit-contract" method="post" id="form-new">
                      <div class="mb-3">
					    <label for="contract" class="form-label">Mã hợp đồng</label>
					    <input disabled="disabled" type="text" class="form-control" id="IdContract" value="${ct.IDContract}">
					    <input type="hidden" class="form-control" id="ID"  name = "ID" value="${ct.ID}">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="mb-3">
					    <label for="NameContract" class="form-label">Tên Hợp đồng</label>
					    <input disabled="disabled" type="text" class="form-control" id="NameContract" name ="NameContract" value ="${ct.name}">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="mb-3">
					    <label for="NameEm" class="form-label">Tên Nhân viên</label>
					    <input disabled="disabled" type="text" class="form-control" id="NameEm" name ="NameEm" value ="${u.ten}">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="form-group">
					    <label for="role">Role</label>
					    <select disabled="disabled"  name ="role" class="form-control" id="role">
						     <option value="3" ${u.ID_Role == 3 ? 'selected' : ''}>Nhân viên</option>
						     <option value="2" ${u.ID_Role == 2 ? 'selected' : ''}>PM</option>
						     <option value="1" ${u.ID_Role == 1 ? 'selected' : ''}>Admin</option>
						</select>
					  </div>
					  <div class="mb-3">
					    <label for="birthday" class="form-label">Năm sinh</label>
					    <input disabled="disabled" type="date" class="form-control" id="birthday" name ="birthday" placeholder="${u.tuoi }" value="${u.tuoi }">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  
					</form>
					<div>
					<a href="${pageContext.request.contextPath}/all-project?
													id=${user}" type="button" class="btn btn-primary">Xem tất cả Project</a>
					<a href="${pageContext.request.contextPath}/all-task?
													id=${user}" type="button" class="btn btn-primary">Xem tất Task</a>
					<a href="${pageContext.request.contextPath}/edit-contract?
													ID=${user}&type=1" type="button" class="btn btn-primary">Hợp đồng</a>
					</div>
					
				</div>
                <!-- /.container-fluid -->
<jsp:include page="../Common/footer.jsp" />