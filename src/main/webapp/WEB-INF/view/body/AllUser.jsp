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
									      <th>Mã nhân viên</th>
									      <th>Tên người dùng</th>
									      <th>Họ và tên</th>
									      <th>Năm sinh</th>
									      <th></th>
									    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listUser}" var="c">
											<tr>
												<td scope="row">${c.ID}</td>
												<td>${c.username}</td>
												<td>${c.ten}</td>
												<td>${c.tuoi}</td>
												<td>
													<a href="${pageContext.request.contextPath}/detail-member?
													id=${c.ID}" type="button" class="btn btn-primary">Detail</a>
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
            