<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


	<div class="container">
		<div class="row">

			<table class="table table-striped"
				style="text-align: center; boder: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">${meetingRoom.mettingRoomName } ����</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>SEQ</td>
						<td><input type="text" class="form-control" id="mR" name="mR" value="${meetingRoom.mR }" readonly>
		      			 <span id="helpBlock" class="help-block">
		      			<strong class="text-danger">SEQ ���� �Ұ�</strong></td>
					</tr>
					<tr>
						<td style="width: 20%">ȸ�ǽ� �ڵ�</td>
						<td><input type="text" class="form-control" id="meetingRoomCode" name="meetingRoomCode" value="${meetingRoom.meetingRoomCode }" placeholder="������ ȸ�ǽ� �ڵ�"></td>
					</tr>
					<tr>
						<td>ȸ�ǽ� �̸�</td>
						<td><input type="text" class="form-control" id="mettingRoomName" name="mettingRoomName" value="${meetingRoom.mettingRoomName }" placeholder="������ ȸ�ǽ� �̸�"></td>
					</tr>
					
				</tbody>
			</table>
			<div class="col-md-12 text-center">
		      <button type="button" class="btn btn-info" id="updateMR">�� &nbsp;��</button>
<!-- 	  			<button type="button" class="btn btn-info" id="getMR">ȸ�ǽ� ����</button> -->
			<a class="btn btn-danger btn" href="#" role="button">��&nbsp;��</a>
			</div>
		</div>
	</div>
