<%@ page contentType="text/html; charset=EUC-KR"%>


	<!-- 부서등록 Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        
        <h4 class="modal-title">등록하실 직급정보를 입력하세요.</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        <div class="modal-body">
          <div class="form-group">	
			<label for="positionNo">직급 번호</label>
				 <input  class="form-control"  type="text" name="positionNo" id="positionNo"  style="width: 270px;
    height: 37px;" autofocus>
			<label for="positionName">직 급 명</label> 
				<input class="form-control" type="text" name="positionName" id="positionName" style="width: 270px;
    height: 37px;">
				<label for="rankCode">직급순차번호</label> 
				<input class="form-control"type="text" name="rankCode" id="rankCode"  style="width: 270px;
    height: 37px;">
			<span id = "chkMsg"></span>
			</div> 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="addPosition">등록</button>
        </div>
      </div>     
    </div>
  </div>
	<!--  모달창 End /////////////////////////////////////-->
	
		<!-- 직급 수정 Modal -->
  <div class="modal fade" id="updateModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
      <form id="updateForm">
        <div class="modal-header">
        <h4 class="modal-title">수정하실 직급정보를 입력하세요.</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        <div class="modal-body">
          <div  class="form-group" >					   
			<label for="positionNo">직급 번호</label>
				 <input  class="form-control"  type="text" name="positionNo" id="positionNo"  style="width: 270px;
    height: 37px;" readonly>
			<label for="positionName">직 급 명</label> 
				<input class="form-control" type="text" name="positionName" id="positionName" style="width: 270px;
    height: 37px;">
				<label for="rankCode">직급순차번호</label> 
				<input class="form-control"type="text" name="rankCode" id="rankCode"  style="width: 270px;
    height: 37px;">
			</div > 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="updatePosition">수정</button>
        </div>
        </form>
      </div>     
    </div>
  </div>
	<!--  모달창 End /////////////////////////////////////-->
	
	<div class="app-title">
	<div>
	<h1>
	<i class="fa fa-list-alt"></i>
		직급관리</h1>
	</div>
</div>

		<!-- table 위쪽 검색 Start /////////////////////////////////////-->
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
								${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>직급번호</option>
							<option value="1"
								${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>직급명</option>
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
				<button type="button" class="btn btn-outline-primary" id="clickAdd" >직급추가</button>
				</div>
			<thead>
				<tr>
					<th>번호</th>
					<th>직급번호</th>
					<th>직급명</th>
					<th>직급순차번호</th>
					<th>수정</th>
					<th>삭제</th>
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
						<td align="left"><span value='${position.positionNo}' >삭제</span></td>
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
	<!--  화면구성 div End /////////////////////////////////////-->


