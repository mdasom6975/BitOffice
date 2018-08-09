<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">��� ���� �Է��ϼž� �մϴ�</h4>
				<button type="button" class="close" data-dismiss="modal">��</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="meetingRoomCode">ȸ�ǽ� �ڵ�</label> <input
						class="form-control" type="text" name="meetingRoomCode"
						id="MeetingRoomCode" style="width: 270px; height: 37px;" autofocus>
					<label for="mettingRoomName">ȸ�ǽ� �̸�</label> <input
						class="form-control" type="text" name="mettingRoomName"
						id="mettingRoomName" style="width: 270px; height: 37px;">
					<span id="chkMsg"></span>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="addMeetingRoom">���</button>
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
					<h4 class="modal-title">�����Ͻ� ȸ�ǽ� ������ �Է��ϼ���.</h4>
					<button type="button" class="close" data-dismiss="modal">��</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="meetingRoomCode">ȸ�ǽ� �ڵ�</label> <input
							class="form-control" type="text" name="meetingRoomCode"
							id="meetingRoomCode" style="width: 270px; height: 37px;">
						<label for="mettingRoomName">�� �� ��</label> <input
							class="form-control" type="text" name="mettingRoomName"
							id="mettingRoomName" style="width: 270px; height: 37px;">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						id="updateMeetingRoom">����</button>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="app-title">
	<div>
		<h1>ȸ�ǽ� ���</h1>
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
							<p class="text-primary">��ü ${resultPage.totalCount }�� ȸ�ǽ�, ����
								${resultPage.currentPage} ������</p>
							<button type="button" class="btn btn-outline-primary"
								id="clickAdd">ȸ�ǽ� �߰�</button>
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
											style="width: 70px;">ȸ�ǽ� �ڵ�</th>
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="width: 70px;">ȸ�ǽ� �̸�</th>
										<th class="sorting_asc" tabindex="0"
											aria-controls="sampleTable" rowspan="1" colspan="1"
											aria-sort="ascending"
											aria-label="Name: activate to sort column descending"
											style="width: 7px;">����</th>
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Age: activate to sort column ascending"
											style="width: 7px;">����</th>
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

