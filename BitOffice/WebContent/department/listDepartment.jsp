<%@ page contentType="text/html; charset=EUC-KR"%>

	<!-- �μ���� Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <h4 class="modal-title">����Ͻ� �μ������� �Է��ϼ���.</h4>
          <button type="button" class="close" data-dismiss="modal">��</button>
        </div>
        <div class="modal-body">
          <div class="form-group">					   
			<label for="departmentNo">�μ� ��ȣ</label>
				 <input class="form-control"  type="text" name="departmentNo" id="departmentNo" style="width: 270px;
    height: 37px;" autofocus>
			<label for="departmentName">�� �� ��</label> 
				<input class="form-control"  type="text" name="departmentName" id="departmentName"  style="width: 270px;
    height: 37px;">
			<span id = "chkMsg"></span>
			</div> 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="addDepartment">���</button>
        </div>
      </div>     
    </div>
  </div>
	<!--  ���â End /////////////////////////////////////-->
	
	<!-- �μ� ���� Modal -->
  <div class="modal fade" id="updateModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
      <form id="updateForm">
        <div class="modal-header">
        <h4 class="modal-title">�����Ͻ� �μ������� �Է��ϼ���.</h4>
          <button type="button" class="close" data-dismiss="modal">��</button>
        </div>
        <div class="modal-body">
          <div  class="form-group" >					   
			<label for="departmentNo">�μ� ��ȣ</label>
				 <input class="form-control"  type="text" name="departmentNo" id="departmentNo" style="width: 270px;
    height: 37px;" readonly>
			<label for="departmentName">�� �� ��</label> 
				<input class="form-control"  type="text"name="departmentName" id="departmentName" style="width: 270px;
    height: 37px;">
			</div > 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="updateDepartment">����</button>
        </div>
      </form>     
    </div>
  </div>
  </div>
	<!--  ���â End /////////////////////////////////////-->
	
	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="app-title">
	<div>
	<h1>
	<i class="fa fa-list-alt"></i>
		�μ�����</h1>
	</div>
</div>

		<!-- table ���� �˻� Start /////////////////////////////////////-->
		<div class="tab-pane fade active show">
		
		
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
		<!-- table ���� �˻� End /////////////////////////////////////-->


		<!--  table Start /////////////////////////////////////-->
		<table class="table table-hover table-striped">
				<div>
				<button type="button" class="btn btn-outline-primary" id="clickAdd" >�μ��߰�</button>
				</div>
			<thead>
				<tr>
					<th>��ȣ</th>
					<th>�μ� ��ȣ</th>
					<th>�μ���</th>
					<th>����</th>
					<th>����</th>
				</tr>
			</thead>

			<tbody>

				<c:set var="i" value="0" />
				<c:forEach var="department" items="${list}">
					<c:set var="i" value="${ i+1 }" />
					<tr>
						<td>${ i }</td>
						<td>${department.departmentNo}</td>
						<td>${department.departmentName}</td>
						<td data-toggle="modal" data-target="#updateModal"data-whatever="${department.departmentNo},${department.departmentName}" ><i class="fa fa-pencil" aria-hidden="true"></i>
						</td>
						<td class="deleteDepartment" value="${department.departmentNo}"><i class="fa fa-times" aria-hidden="true"></i></td>
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
	</div>
	<!--  ȭ�鱸�� div End /////////////////////////////////////-->


