<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
									      <th>#</th>
									      <th>Name</th>
									      <th>Employee</th>
									      <th>Thời hạn</th>
									      <th>Ngày ký</th>
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
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
<jsp:include page="../Common/footer.jsp" />
            