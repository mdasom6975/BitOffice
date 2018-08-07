<%@ page contentType="text/html; charset=EUC-KR"%>

	<!-- 부서등록 Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <h4 class="modal-title">등록하실 부서정보를 입력하세요.</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        <div class="modal-body">
          <div class="form-group">					   
			<label for="departmentNo">부서 번호</label>
				 <input class="form-control"  type="text" name="departmentNo" id="departmentNo" style="width: 270px;
    height: 37px;" autofocus>
			<label for="departmentName">부 서 명</label> 
				<input class="form-control"  type="text" name="departmentName" id="departmentName"  style="width: 270px;
    height: 37px;">
			<span id = "chkMsg"></span>
			</div> 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="addDepartment">등록</button>
        </div>
      </div>     
    </div>
  </div>
	<!--  모달창 End /////////////////////////////////////-->
	
	<!-- 부서 수정 Modal -->
  <div class="modal fade" id="updateModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
      <form id="updateForm">
        <div class="modal-header">
        <h4 class="modal-title">수정하실 부서정보를 입력하세요.</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        <div class="modal-body">
          <div  class="form-group" >					   
			<label for="departmentNo">부서 번호</label>
				 <input class="form-control"  type="text" name="departmentNo" id="departmentNo" style="width: 270px;
    height: 37px;" readonly>
			<label for="departmentName">부 서 명</label> 
				<input class="form-control"  type="text"name="departmentName" id="departmentName" style="width: 270px;
    height: 37px;">
			</div > 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="updateDepartment">수정</button>
        </div>
      </form>     
    </div>
  </div>
  </div>
	<!--  모달창 End /////////////////////////////////////-->
	
	<!--  화면구성 div Start /////////////////////////////////////-->
	<div class="app-title">
	<div>
	<h1>
	<i class="fa fa-list-alt"></i>
		부서관리</h1>
	</div>
</div>

		<!-- table 위쪽 검색 Start /////////////////////////////////////-->
		<div class="tab-pane fade active show">
		
		
	<div class="row">
	
	    	
		
	
	<div class="col-md-12">
		<div class="tile">
			<div class="tile-body">
				<div id="sampleTable_wrapper"
					class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">	
					<div class="row">
						<div class="col-md-6 text-left">
							<p class="text-primary">전체 ${resultPage.totalCount } 건수, 현재
								${resultPage.currentPage} 페이지</p>
						</div>

						<div class="col-md-6 text-right"
							style="display: flex; justify-content: flex-end;">
							<form class="form-inline" name="detailForm">
								<div class="form-group">
						<select class="form-control" name="searchCondition">
							<option value="0"
								${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>부서번호</option>
							<option value="1"
								${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>부서명</option>
						</select>
					</div>

					<div class="form-group">
						<label class="sr-only" for="searchKeyword">검색어</label> <input
							type="text" class="form-control" id="searchKeyword"
							name="searchKeyword" placeholder="검색어"
							value="${! empty search.searchKeyword ? search.searchKeyword : '' }">
					</div>

					<button type="button" class="btn btn-default">검색</button>

					<!-- PageNavigation 선택 페이지 값을 보내는 부분 -->
					<input type="hidden" id="currentPage" name="currentPage" value="0" />

				</form>
			</div>

		</div>
		<!-- table 위쪽 검색 End /////////////////////////////////////-->


		<!--  table Start /////////////////////////////////////-->
		<table class="table table-hover table-striped">
				<div>
				<button type="button" class="btn btn-outline-primary" id="clickAdd" >부서추가</button>
				</div>
			<thead>
				<tr>
					<th>번호</th>
					<th>부서 번호</th>
					<th>부서명</th>
					<th>수정</th>
					<th>삭제</th>
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
	<!--  화면구성 div End /////////////////////////////////////-->


