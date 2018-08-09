<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

<!--  화면구성 div Start /////////////////////////////////////-->
<div class="container-fluid">
		<div class="board_div">
			<h2 class="page-header">회의실 목록</h2>

	<div class="row">

		<div class="col-md-6 text-left">
			<p class="text-primary">전체 ${resultPage.totalCount } 건수, 현재
				${resultPage.currentPage} 페이지</p>
		</div>

		<div class="col-md-6 text-right">
			<form class="form-inline" name="detailForm">
				<div class="form-group">
				<select class="form-control" name="searchCondition">
						<option value="0"  ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>회의실 코드</option>
						<option value="1"  ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>회의실 이름</option>					</select>
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

	<table class="table table-striped"
		style="text-align: center; boder: 1px solid #dddddd">

			<thead>
				<tr>
					<th align="center"><button id="create-meetingRoom">회의실 추가</button></th>
				</tr>
			</thead>
			
			<thead>
			<tr>
				<th style="background-color: #eeeeee; text-align: center;">수정</th>
				<th style="background-color: #eeeeee; text-align: center;">회의실 코드</th>
				<th style="background-color: #eeeeee; text-align: center;">회의실 이름</th>
				<th style="background-color: #eeeeee; text-align: center;">삭제</th>

			</tr>
		</thead>
		<tbody>

			<c:set var="i" value="0" />
			<c:forEach var="meetingRoom" items="${list}">
				<c:set var="i" value="${ i+1 }" />
				<tr>
					<td align="center">${i}</td>
					<td align="left" value="${meetingRoom.mR }">${meetingRoom.mR }</td>
					<td align="center">${meetingRoom.meetingRoomCode }</td>
					<td align="center">${meetingRoom.mettingRoomName}</td>
					<td><button type="button" onclick="location.href='deleteMeetingRoom?meetingRoomCode=${meetingRoom.meetingRoomCode}'">삭제</button></td>
				</tr>
			</c:forEach>


		</tbody>
	</table>
</div>

<!-- <!-- PageNavigation Start... --> 
<jsp:include page="../common/pageNavigator_new.jsp" />
<!-- <!-- PageNavigation End... --> 
</div>
  <!--  화면구성 div End /////////////////////////////////////-->
