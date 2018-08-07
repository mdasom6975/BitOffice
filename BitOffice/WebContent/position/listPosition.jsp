<%@ page contentType="text/html; charset=EUC-KR"%>


	<!-- �μ���� Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        
        <h4 class="modal-title">����Ͻ� ���������� �Է��ϼ���.</h4>
          <button type="button" class="close" data-dismiss="modal">��</button>
        </div>
        <div class="modal-body">
          <div class="form-group">	
			<label for="positionNo">���� ��ȣ</label>
				 <input  class="form-control"  type="text" name="positionNo" id="positionNo"  style="width: 270px;
    height: 37px;" autofocus>
			<label for="positionName">�� �� ��</label> 
				<input class="form-control" type="text" name="positionName" id="positionName" style="width: 270px;
    height: 37px;">
				<label for="rankCode">���޼�����ȣ</label> 
				<input class="form-control"type="text" name="rankCode" id="rankCode"  style="width: 270px;
    height: 37px;">
			<span id = "chkMsg"></span>
			</div> 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="addPosition">���</button>
        </div>
      </div>     
    </div>
  </div>
	<!--  ���â End /////////////////////////////////////-->
	
		<!-- ���� ���� Modal -->
  <div class="modal fade" id="updateModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
      <form id="updateForm">
        <div class="modal-header">
        <h4 class="modal-title">�����Ͻ� ���������� �Է��ϼ���.</h4>
          <button type="button" class="close" data-dismiss="modal">��</button>
        </div>
        <div class="modal-body">
          <div  class="form-group" >					   
			<label for="positionNo">���� ��ȣ</label>
				 <input  class="form-control"  type="text" name="positionNo" id="positionNo"  style="width: 270px;
    height: 37px;" readonly>
			<label for="positionName">�� �� ��</label> 
				<input class="form-control" type="text" name="positionName" id="positionName" style="width: 270px;
    height: 37px;">
				<label for="rankCode">���޼�����ȣ</label> 
				<input class="form-control"type="text" name="rankCode" id="rankCode"  style="width: 270px;
    height: 37px;">
			</div > 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="updatePosition">����</button>
        </div>
        </form>
      </div>     
    </div>
  </div>
	<!--  ���â End /////////////////////////////////////-->
	
	<div class="app-title">
	<div>
	<h1>
	<i class="fa fa-list-alt"></i>
		���ް���</h1>
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
								${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>���޹�ȣ</option>
							<option value="1"
								${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>���޸�</option>
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
				<button type="button" class="btn btn-outline-primary" id="clickAdd" >�����߰�</button>
				</div>
			<thead>
				<tr>
					<th>��ȣ</th>
					<th>���޹�ȣ</th>
					<th>���޸�</th>
					<th>���޼�����ȣ</th>
					<th>����</th>
					<th>����</th>
				</tr>
			</thead>

			<tbody>

				<c:set var="i" value="0" />
				<c:forEach var="position" items="${list}">
					<c:set var="i" value="${ i+1 }" />
					<tr>
						<td align="left">${ i }</td>
						<td align="left">${position.positionNo}</td>
						<td align="left">${position.positionName}</td>
						<td align="left">${position.rankCode}</td>
						<td data-toggle="modal" data-target="#updateModal"data-whatever="${position.positionNo},${position.positionName},${position.rankCode}" ><i class="fa fa-pencil" aria-hidden="true"></i>
						<td align="left"><span value='${position.positionNo}' >����</span></td>
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


