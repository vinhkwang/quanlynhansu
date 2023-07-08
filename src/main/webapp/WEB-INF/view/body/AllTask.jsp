<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%Integer role = null;
	if(session.getAttribute("role")!= null)
	{
		role = (Integer)session.getAttribute("role");
	}	
%>
<jsp:include page="../Common/header2.jsp" />
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Task</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                        <% 
                        	if(role != null && (role ==1 || role ==2))
                        	{
                        		%>
	                        		<a href="${pageContext.request.contextPath}/add-task?idProject=${idProject}" class="btn btn-success btn-icon-split">
	                                        <span class="icon text-white-50">
	                                            <i class="fas fa-tasks"></i>
	                                        </span>
	                                        <span class="text">Add Task</span>
	                             </a>
                        		<%
                        	}
                        %>
                            
                        </div>
                        <div class= "row">
                        	<form method="get" action="all-task">
	                        	<div class = "col-12 input-group" style="align-items: center;">
	                        		<select name="status" class="custom-select">
									  <option value="-1" selected>Trạng Thái</option>
									  <option ${status == 1 ? 'selected' : ''} value="1">Open</option>
									  <option ${status == 2 ? 'selected' : ''} value="2">Process</option>
									  <option ${status == 4 ? 'selected' : ''} value="4">Ready for test</option>
									  <option ${status == 3 ? 'selected' : ''} value="3">Completed</option>
									</select>
									<input type="text" class="form-control" id="search" name = "search" value="${search}">
									<c:if test="${not empty idProject}">
										    <input type="hidden" name="idProject" value="${idProject}">
									</c:if>
		                        	<button type="submit" href="#" class="btn btn-success btn-circle btn-sm ml-2"><i class="fas fa-check"></i></button>
		                        </div>
                        	</form>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
									      <th scope="col">#</th>
									      <th scope="col">Name</th>
									      <th scope="col">Trạng thái</th>
					                        <c:if test="${role == 3}">
												<th scope="col">Project</th>
										    </c:if>
										    <c:if test="${role != 3}">
												<th scope="col">Assign</th>
										    </c:if>
					                        <th scope="col">Start Day</th>
					                        <th scope="col">End Day</th>
									       <th scope="col">Action</th>
									    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listTask}" var="c">
											<tr>
												<td scope="row">${c.ID}</td>
												<td>${c.name}</td>
												<td>${c.status == 1 ? 'Open' : c.status == 2 ? 'Process': c.status == 3 ? 'Complete': 'Ready for test'}</td>
												<c:if test="${role == 3}">
													<td>${c.nameProject}</td>
												</c:if>
												<c:if test="${role != 3}">
													<td>${c.assign}</td>
												</c:if>
												<td>${c.startDay}</td>
												<td>${c.endDay}</td>
												<td>
													<a href="${pageContext.request.contextPath}/edit-task?ID=${c.ID}&task=${c.name}&status=${c.status}&ID_Project=${c.projectID}&ID_User=${c.userID}&description=${c.description}&startDay=${c.startDay}&endDay=${c.endDay}" type="button" class="btn btn-primary"><i class="fas fa-edit"></i></a>
													<c:if test="${role != 3}">
													   <a href="${pageContext.request.contextPath}/delete-task?ID=${c.ID}" type="button" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
													</c:if>
												</td>
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
<jsp:include page="../Common/footer.jsp" />
            