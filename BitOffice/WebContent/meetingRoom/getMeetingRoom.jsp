<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


	<div class="container">
		<div class="row">

			<table class="table table-striped"
				style="text-align: center; boder: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">${meetingRoom.mettingRoomName } ��ȸ</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%">ȸ�ǽ� �ڵ�</td>
						<td colspan="2" style="text-align: left;">${meetingRoom.meetingRoomCode }</td>
					</tr>
					<tr>
						<td>ȸ�ǽ� �̸�</td>
						<td colspan="2" style="text-align: left;">${meetingRoom.mettingRoomName }</td>
					</tr>
					
				</tbody>
			</table>
			<div class="col-md-12 text-center">
			<a class="btn btn-info btn" href="/meetingRoom/updateMeetingRoom?mR=${meetingRoom.mR}" role="button">�� &nbsp;��</a>		
<!-- 	  			<button type="button" class="btn btn-info" id="getMR">ȸ�ǽ� ����</button> -->
	  		<a class="btn btn-danger btn" href="/meetingRoom/listMeetingRoom" role="button">�� &nbsp;��</a>
			</div>
		</div>
	</div>
