<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
<div class="container-fluid">
		<div class="board_div">
			<h2 class="page-header">ȸ�ǽ� ���</h2>

	<div class="row">

		<div class="col-md-6 text-left">
			<p class="text-primary">��ü ${resultPage.totalCount } �Ǽ�, ����
				${resultPage.currentPage} ������</p>
		</div>

		<div class="col-md-6 text-right">
			<form class="form-inline" name="detailForm">
				<div class="form-group">
				<select class="form-control" name="searchCondition">
						<option value="0"  ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>ȸ�ǽ� �ڵ�</option>
						<option value="1"  ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>ȸ�ǽ� �̸�</option>					</select>
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

	<table class="table table-striped"
		style="text-align: center; boder: 1px solid #dddddd">

			<thead>
				<tr>
					<th align="center"><button id="create-meetingRoom">ȸ�ǽ� �߰�</button></th>
				</tr>
			</thead>
			
			<thead>
			<tr>
				<th style="background-color: #eeeeee; text-align: center;">����</th>
				<th style="background-color: #eeeeee; text-align: center;">ȸ�ǽ� �ڵ�</th>
				<th style="background-color: #eeeeee; text-align: center;">ȸ�ǽ� �̸�</th>
				<th style="background-color: #eeeeee; text-align: center;">����</th>

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
					<td><button type="button" onclick="location.href='deleteMeetingRoom?meetingRoomCode=${meetingRoom.meetingRoomCode}'">����</button></td>
				</tr>
			</c:forEach>


		</tbody>
	</table>
</div>

<!-- <!-- PageNavigation Start... --> 
<jsp:include page="../common/pageNavigator_new.jsp" />
<!-- <!-- PageNavigation End... --> 
</div>
  <!--  ȭ�鱸�� div End /////////////////////////////////////-->
