<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% int status = (int)request.getAttribute("status"); %>
<jsp:include page="../Common/header2.jsp" />
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <form action="edit-task" method="post" id="form-new">
							<input type="hidden" value="${ID_Project}" name="ID_Project">
						  <input type="hidden" value="${ID}" name="ID">
						  <div class="mb-3">
						    <label for="task" class="form-label">Tên Task</label>
						    <input type="text" class="form-control" id="task" ${role == 3 ? 'disabled' : 'name ="task"'} value="${task}">
						  	<span class="form-message" style="color: red"></span>
						  </div>
						  <div class="form-group">
						    <label for="status">Status</label>
						    <select  name ="status" class="form-control" id="status">
						          <option value="1" <% if ((status == 1)) out.print("selected"); %>>Open</option>
								  <option value="2" <% if ((status == 2)) out.print("selected"); %>>Process</option>
								  <option value="4" <% if ((status == 4)) out.print("selected"); %>>Ready for test</option>
								  <c:if test="${status == 1 || status == 2}">
									     <option value="3" <% if ((status == 3)) out.print("selected"); %>>Completed</option>
								  </c:if>
								 
						    </select>
						  </div>
						  <div class="form-group">
						    <label for="assign">Assign</label>
						    <select  name ="ID_User" class="form-control" id="ID_User">
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
						  <div class="mb-3">
						    <label for="description" class="form-label">Description</label>
						    <input type="text" class="form-control" id="description" ${role == 3 ? 'disabled' : 'name ="description"'} value="${description}">
						    <span class="form-message" style="color: red"></span>
						  </div>
						  <div class="mb-3">
						    <label for="evidence" class="form-label">Evidence</label>
						    <input type="text" class="form-control" id="evidence" name ="evidence" value="${evidence}">
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
            