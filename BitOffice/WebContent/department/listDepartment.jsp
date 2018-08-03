<%@ page contentType="text/html; charset=EUC-KR"%>

	<div id="dialog-form" title="�μ� ���">
		<p class="validateTips">����Ͻ� �μ� ������ �Է��ϼ���.</p>

		<form>
			<fieldset>
				<label for="departmentNo">�μ� ��ȣ</label> 
				<input type="text" name="departmentNo" id="departmentNo"
					value="${department.departmentNo}" class="text ui-widget-content ui-corner-all"> 
					
					<label for="departmentName">�� �� ��</label>
					 <input type="text" name="departmentName" id="departmentName"
					value="${department.departmentName}" class="text ui-widget-content ui-corner-all">


<!-- 				Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1"
					style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>

	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container">

		<div class="page-header text-info">
			<h3>�μ� ����</h3>
		</div>

		<!-- table ���� �˻� Start /////////////////////////////////////-->
		<div class="row">

			<div class="col-md-6 text-left">
				<p class="text-primary">��ü ${resultPage.totalCount } �Ǽ�, ����
					${resultPage.currentPage} ������</p>
			</div>

			<div class="col-md-6 text-right">
				<form class="form-inline" name="detailForm">

					<div class="form-group">
						<select class="form-control" name="searchCondition">
							<option value="0"
								${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>�μ���ȣ</option>
							<option value="1"
								${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>�μ���</option>
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
					<input type="hidden" id="currentPage" name="currentPage" value="0" />

				</form>
			</div>

		</div>
		<!-- table ���� �˻� Start /////////////////////////////////////-->


		<!--  table Start /////////////////////////////////////-->
		<table class="table table-hover table-striped">

			<thead>
				<tr>
					<th align="center"><button id="addDepartment">�μ� �߰�</button></th>
				</tr>

			</thead>

			<thead>
				<tr>
					<th align="left">No</th>
					<th align="left">�μ� ��ȣ</th>
					<th align="left">�μ���</th>
					<th align="left">����</th>
					<th align="left">����</th>
				</tr>
			</thead>

			<tbody>

				<c:set var="i" value="0" />
				<c:forEach var="department" items="${list}">
					<c:set var="i" value="${ i+1 }" />
					<tr>
						<td align="left">${ i }</td>
						<td align="left">${department.departmentNo}</td>
						<td align="left">${department.departmentName}</td>
					<td align="left"><span value='${department.departmentNo}'>����</span></td>
					<td align="left"><span value='${department.departmentNo}' >����</span></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		<!--  table End /////////////////////////////////////-->

	</div>
	<!--  ȭ�鱸�� div End /////////////////////////////////////-->


	<!-- PageNavigation Start... -->
	<jsp:include page="../common/pageNavigator_new.jsp" />
	<!-- PageNavigation End... -->

