<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<div class="app-title">
	<div>
	<h1>
	<i class="fa fa-list-alt"></i>
		��������</h1>
		<p>������ Ŭ���Ͻø� �󼼳����� ���� �� �ֽ��ϴ�.</p>
	</div>
</div>

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
									<span class="newBoard">�ֽűۼ�</span> |<span class="oldBoard">�����ۼ�</span>
									|<span class="boardCount">������ȸ��</span> <select
										class="form-control" name="searchCondition">
										<option value="0"
											${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>�ۼ���</option>
										<option value="1"
											${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>������</option>
										<option value="2"
											${ ! empty search.searchCondition && search.searchCondition==2 ? "selected" : "" }>�۳���</option>
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
					<table class="table" style="margin-top: 10px;">
						<thead>
							<tr>
								<th>��ȣ</th>
								<th>����</th>
								<th>�ۼ���</th>
								<th>�ۼ���</th>
								<th>��ȸ��</th>
								<c:if test="${employee.role=='admin'}">
									<th>����</th>
								</c:if>
							</tr>
						</thead>
						<tbody>
							<c:set var="i" value="0" />
							<c:forEach var="board" items="${list}">
								<c:set var="i" value="${ i+1 }" />
								<tr>
									<td>${i}</td>
									<td class="getBoard" value="${board.boardNo}">${board.boardTitle}</td>
									<td>${board.boardDate}</td>
									<td>${board.employeeName}</td>
									<td>${board.boardCount}</td>
									<c:if test="${employee.role=='admin'}">
										<td class="deleteBoard" value="${board.boardNo}">����</td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- <!-- PageNavigation Start... -->
			<jsp:include page="../common/pageNavigator_new.jsp" />
			<!-- <!-- PageNavigation End... -->
		</div>
	</div>
</div>

