<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">모든 값을 입력하셔야 합니다</h4>
				<button type="button" class="close" data-dismiss="modal">×</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="meetingRoomCode">회의실 코드</label> <input
						class="form-control" type="text" name="meetingRoomCode"
						id="MeetingRoomCode" style="width: 270px; height: 37px;" autofocus>
					<label for="mettingRoomName">회의실 이름</label> <input
						class="form-control" type="text" name="mettingRoomName"
						id="mettingRoomName" style="width: 270px; height: 37px;">
					<span id="chkMsg"></span>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="addMeetingRoom">등록</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="updateModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<form id="updateForm">
				<div class="modal-header">
					<h4 class="modal-title">수정하실 회의실 정보를 입력하세요.</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="meetingRoomCode">회의실 코드</label> <input
							class="form-control" type="text" name="meetingRoomCode"
							id="meetingRoomCode" style="width: 270px; height: 37px;">
						<label for="mettingRoomName">부 서 명</label> <input
							class="form-control" type="text" name="mettingRoomName"
							id="mettingRoomName" style="width: 270px; height: 37px;">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						id="updateMeetingRoom">수정</button>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="app-title">
	<div>
		<h1>회의실 목록</h1>
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
							<p class="text-primary">전체 ${resultPage.totalCount }개 회의실, 현재
								${resultPage.currentPage} 페이지</p>
							<button type="button" class="btn btn-outline-primary"
								id="clickAdd">회의실 추가</button>
						</div>

					</div>
					<div class="row">
						<div class="col-sm-12">
							<table
								class="table table-hover table-bordered dataTable no-footer"
								id="sampleTable" role="grid" aria-describedby="sampleTable_info">

								<thead>
									<tr role="row">
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Position: activate to sort column ascending"
											style="width: 70px;">회의실 코드</th>
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="width: 70px;">회의실 이름</th>
										<th class="sorting_asc" tabindex="0"
											aria-controls="sampleTable" rowspan="1" colspan="1"
											aria-sort="ascending"
											aria-label="Name: activate to sort column descending"
											style="width: 7px;">수정</th>
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Age: activate to sort column ascending"
											style="width: 7px;">삭제</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="i" value="0" />
									<c:forEach var="meetingRoom" items="${list}">
										<c:set var="i" value="${ i+1 }" />
										<tr role="row" class="odd">
											<td>${meetingRoom.meetingRoomCode}</td>
											<td>${meetingRoom.mettingRoomName}</td>
											<td data-toggle="modal" data-target="#updateModal"
												data-whatever="${meetingRoom.meetingRoomCode},${meetingRoom.mettingRoomName}"><i
												class="fa fa-pencil" aria-hidden="true"></i></td>
											<td id="deleteMR" value="${meetingRoom.meetingRoomCode }"><i class="fa fa-times" aria-hidden="true"></i></td>
<%-- 											<td><button type="button" onclick="location.href='deleteMeetingRoom?meetingRoomCode=${meetingRoom.meetingRoomCode}'"> --%>
<!-- 													<i class="fa fa-times" aria-hidden="true"></i> -->
<!-- 											</button></td> -->
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- <!-- PageNavigation Start... -->
			<jsp:include page="../common/pageNavigator_new.jsp" />
			<!-- <!-- PageNavigation End... -->
		</div>
	</div>
</div>

