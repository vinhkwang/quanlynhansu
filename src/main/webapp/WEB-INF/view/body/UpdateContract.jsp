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
					    <input ${onlyview == 1 ? 'disabled' : 'name ="NameContract"'} type="text" class="form-control" id="NameContract" value ="${ct.name}">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="mb-3">
					    <label for="NameEm" class="form-label">Tên Nhân viên</label>
					    <input ${onlyview == 1 ? 'disabled' : 'name ="NameEm"'} type="text" class="form-control" id="NameEm" value ="${u.ten}">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="form-group">
					    <label for="role">Role</label>
					    <select ${onlyview == 1 ? 'disabled' : 'name ="role"'} class="form-control" id="role">
						     <option value="3" ${u.ID_Role == 3 ? 'selected' : ''}>Nhân viên</option>
						     <option value="2" ${u.ID_Role == 2 ? 'selected' : ''}>PM</option>
						     <option value="1" ${u.ID_Role == 1 ? 'selected' : ''}>Admin</option>
						</select>
					  </div>
					  <div class="mb-3">
					    <label for="userName" class="form-label">Tên đăng nhập</label>
					    <input ${onlyview == 1 ? 'disabled' : 'name ="userName"'} type="text" class="form-control" id="userName"  value="${u.username }">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="mb-3">
					    <label for="password" class="form-label">Mật khẩu</label>
					    <input ${onlyview == 1 ? 'disabled' : 'name ="password"'} type="password" class="form-control" id="password" value="${u.pass }">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="mb-3">
					    <label for="birthday" class="form-label">Năm sinh</label>
					    <input ${onlyview == 1 ? 'disabled' : 'name ="birthday"'} type="date" class="form-control" id="birthday" placeholder="${u.tuoi }" value="${u.tuoi }">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <%-- <div class="mb-3">
					    <label for=ThoiHan class="form-label">Thời hạn</label>
					    <input type="number" class="form-control" id="ThoiHan" name ="ThoiHan" value="${ct.thoiHan}">
					    <span class="form-message" style="color: red"></span>
					  </div>
					  <div class="mb-3">
					    <label for="ngayky" class="form-label">Ngày ký</label>
					    <input type="date" class="form-control" id="ngayky" name ="ngayky" placeholder="${ct.ngayKy}" value="${ct.ngayky }">
					    <span class="form-message" style="color: red"></span>
					  </div> --%>
					  <c:if test="${onlyview != 1}">
						    <button type="submit" class="btn btn-primary">Submit</button>
					  </c:if>
					  
					</form>
						<script type="text/javascript">
						Validator({
							form : '#form-new',
							errorSelector : '.form-message',
							rules : [
										Validator.isRequired('#NameContract'),
										Validator.isRequired('#NameEm'),
										Validator.isRequired('#userName'),
										Validator.isRequired('#password'),
										Validator.isRequired('#birthday'),
									],
						});
						</script>
				</div>
                <!-- /.container-fluid -->
<jsp:include page="../Common/footer.jsp" />