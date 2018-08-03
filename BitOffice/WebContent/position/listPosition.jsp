<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

	<div class="modal" style="position: relative; top: auto; right: auto; left: auto; bottom: auto; z-index: 1;" id="aaaa">
                <div class="modal-dialog" role="document">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title">����Ͻ� ���� ������ �Է��ϼ���</h5>
                      <button class="close" type="button" data-dismiss="modal" aria-label="Close">
	      <span aria-hidden="true">��</span></button>
                    </div>
                    <div class="modal-body">
                      <label for="positionNo">���� ��ȣ</label>
				 <input type="text"
					name="positionNo" id="positionNo"
					value="${position.positionNo}"
					class="text ui-widget-content ui-corner-all">
					 <label
					for="positionName">�� �� ��</label> 
					<input type="text"
					name="positionName" id="positionName"
					value="${position.positionName}"
					class="text ui-widget-content ui-corner-all">
					<label for="rankCode">���� ������ȣ</label>
				 <input type="text"
					name="rankCode" id="rankCode"
					value="${position.rankCode}"
					class="text ui-widget-content ui-corner-all">
                    </div>
                    <div class="modal-footer">
                      <button class="btn btn-primary" type="button">Save</button>
                      <button class="btn btn-secondary" type="button" data-dismiss="modal">Close</button>
                    </div>
                  </div>
                </div>
              </div>

	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container">

		<div class="page-header text-info">
			<h3>���� ����</h3>
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
					<th align="center"><button id="addPosition">���� �߰�</button></th>
				</tr>

			</thead>

			<thead>
				<tr>
					<th align="left">No</th>
					<th align="left">���� ��ȣ</th>
					<th align="left">�� �� ��</th>
					<th align="left">���޼�����ȣ</th>
					<th align="left">����</th>
					<th align="left">����</th>
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
						<td align="left"><span value='${position.positionNo}'>����</span></td>
						<td align="left"><span value='${position.positionNo}' >����</span></td>
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
