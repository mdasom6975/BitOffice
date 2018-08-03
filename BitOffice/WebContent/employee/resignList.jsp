<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
<div class="app-title">
	<div>
		<h1>
		<i class="fa fa-th-list" aria-hidden="true"></i>
		����ڸ��</h1>
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
							<p class="text-primary">��ü ${resultPage.totalCount } �Ǽ�, ����
								${resultPage.currentPage} ������</p>
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
								<th align="center">��ȣ</th>
								<th align="left">�μ�</th>
								<th align="left">����</th>
								<th align="left">�̸�</th>
								<th align="left">�Ի���</th>
								<th align="left">�����</th>
								<th align="left">�̸���</th>
							</tr>
						</thead>

						<tbody>


							<c:set var="i" value="0" />
							<c:forEach var="employee" items="${list}">
								<c:set var="i" value="${ i+1 }" />
								<tr>
									<td align="center">${ i }</td>
									<td align="left">${employee.departmentName}</td>
									<td align="left">${employee.positionName}</td>
									<td align="left">${employee.employeeName}</td>
									<td align="left">${employee.hireDate}</td>
									<td align="left">${employee.endDate}</td>
									<td align="left">${employee.email}</td>
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
		</div>
	</div>
</div>
<!--  ȭ�鱸�� div End /////////////////////////////////////-->
