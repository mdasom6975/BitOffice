<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
<div class="app-title">
	<div>
		<h1>
		<i class="fa fa-users" aria-hidden="true"></i>
		������ ���</h1>
		<p>�̸��� Ŭ���Ͻø� �������� ���� �� �ֽ��ϴ�.</p>
	</div>
</div>


		<!-- table ���� �˻� Start /////////////////////////////////////-->
<div class="row">
	<div class="col-md-12">
		<div class="tile">
			<div class="tile-body">
				<div id="sampleTable_wrapper"
					class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
					<div class="row">
						<div class="col-md-6 text-left">
							<p class="text-primary">��ü ${resultPage.totalCount } �Ǽ�, 
							���� ${resultPage.currentPage} ������</p>
						</div>

						<div class="col-md-6 text-right"
							style="display: flex; justify-content: flex-end;">
							<form class="form-inline" name="detailForm">
								<div class="form-group">
									<select class="form-control" name="searchCondition">
										<option value="0"
											${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>�μ�</option>
										<option value="1"
											${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>����</option>
										<option value="2"
											${ ! empty search.searchCondition && search.searchCondition==2 ? "selected" : "" }>��������</option>
									</select>
								</div>

								<div class="form-group">
									<label class="sr-only" for="searchKeyword">�˻���</label> <input
										type="text" class="form-control" id="searchKeyword"
										name="searchKeyword" placeholder="�˻���"
										value="${! empty search.searchKeyword ? search.searchKeyword : '' }">
								</div>

								<button type="button" class="btn btn-default">�˻�</button>

								<!-- PageNavigation ���� ������ ���� ������ �κ� -->
								<input type="hidden" id="currentPage" name="currentPage"
									value="0" />

							</form>
						</div>

					</div>
					<!-- table ���� �˻� Start /////////////////////////////////////-->


					<!--  table Start /////////////////////////////////////-->
					<table class="table" style="margin-top: 10px;">
						<thead>
							<tr>
								<th>��ȣ</th>
								<th>�μ�</th>
								<th>����</th>
								<th>�̸�</th>
								<th>�Ի�⵵</th>
								<th>�̸���</th>
								<th>������ȣ</th>
								<c:if test="${employee.role=='admin'}">
									<th>���ó��</th>
								</c:if>
							</tr>
						</thead>
						<tbody>
							<c:set var="i" value="0" />
							<c:forEach var="employee" items="${list}">
								<c:set var="i" value="${ i+1 }" />
								<tr>
									<td>${ i }</td>
									<td>${employee.departmentName}</td>
									<td>${employee.positionName}</td>
									<td class="getEmployee" title="Click : ������ ���� �󼼺���"
										value='${employee.employeeNo}'>${employee.employeeName}</td>
									<td>${employee.hireDate}</td>
									<td>${employee.email}</td>
									<td>${employee.extension}</td>
									<c:if test="${sessionScope.employee.role == 'admin'}">
										<td class="resignationEmp" value='${employee.employeeNo }'>���ó��</td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!--  table End /////////////////////////////////////-->
				</div>
			</div>
			<!-- PageNavigation Start... -->
			<jsp:include page="../common/pageNavigator_new.jsp" />
			<!-- PageNavigation End... -->
			<!--  ȭ�鱸�� div End /////////////////////////////////////-->
		</div>
	</div>
</div>