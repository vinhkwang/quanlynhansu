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
                    <h1 class="h3 mb-2 text-gray-800">Contract</h1>
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
	                        		<a href="${pageContext.request.contextPath}/add-project" class="btn btn-success btn-icon-split">
	                                        <span class="icon text-white-50">
	                                            <i class="fas fa-tasks"></i>
	                                        </span>
	                                        <span class="text">Add Project</span>
	                             </a>
                        		<%
                        	}
                        %>
                            
                        </div>
                        <div class= "row">
                        	<form method="get" action="all-project">
	                        	<div class = "col-12 input-group" style="align-items: center;">
	                        		<select name="type" class="custom-select">
									  <option value="-1" selected>Search...</option>
									  <option ${type == 1 ? 'selected' : ''} value="1">Tên</option>
									  <option ${type == 2 ? 'selected' : ''} value="2">Số lượng member</option>
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
									      <th>#</th>
									      <th>Name</th>
									      <th>Description</th>
									      <th>Tổng member</th>
									      <%
									      	if(role != null && role == 1)
									      	{
									      		%>
									      			<th>PM</th>
									      		<%
									      	}
									      %>
									      
									      <th>Ngày bắt đầu</th>
									      <th>Ngày kết thúc</th>
									      <th>Action</th>
									    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listProject}" var="c">
											<tr>
												<td scope="row">${c.ID}</td>
												<td>${c.name}</td>
												<td>${c.description}</td>
												<td>${c.countMember}</td>
												<%
											      	if(role != null && role == 1)
											      	{
											      		%>
											      			<td>${c.namePM}</td>
											      		<%
											      	}
											      %>
												<td>${c.startDate}</td>
												<td>${c.endDate}</td>
												<td>
													<a href="${pageContext.request.contextPath}/edit-project?ID=${c.ID}&name=${c.name}&startDate=${c.startDate}&endDate=${c.endDate}&description=${c.description}&ID_PM=${c.ID_PM}" type="button" class="btn btn-primary"><i class="fas fa-edit"></i></a>
													<%-- <a href="/QuanLyCongViec/delete-project?ID=${c.ID}" type="button" class="btn btn-danger">Delete</a> --%>
													<a href="${pageContext.request.contextPath}/all-task?idProject=${c.ID}" type="button" class="btn btn-success"><i class="fas fa-tasks"></i></a>
													<a href="${pageContext.request.contextPath}/all-member?idProject=${c.ID}" type="button" class="btn btn-success"><i class="fas fa-users"></i></a>
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
            