<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


	<div class="container">
		<div class="row">

			<table class="table table-striped"
				style="text-align: center; boder: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">${reservation.employeeNo } ���� ���� �� ��ȸ</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%">ȸ�ǽ�</td>
						<td colspan="2" style="text-align: left;">${reservation.mettingRoomName }</td>
					</tr>
					<tr>
						<td>���� ��¥</td>
						<td colspan="2" style="text-align: left;">${reservation.reserveDate }</td>
					</tr>
					<tr>
						<td>���� �ð�</td>
						<td colspan="2" style="text-align: left;">${reservation.startTime }</td>
					</tr>
					<tr>
						<td>���� �ð�</td>
						<td colspan="2" style="text-align: left;">${reservation.endTime }</td>
					</tr>
					<tr>
						<td>�̿� ����</td>
						<td colspan="2" style="text-align: left;">${reservation.usePurpose }</td>
					</tr>
					
				</tbody>
			</table>
			<div class="col-md-12 text-center">
			<a class="btn btn-info btn" href="/reservation/updateReservation?reNum=${reservation.reNum}" role="button">�� &nbsp;��</a>		
<!-- 	  			<button type="button" class="btn btn-info" id="getMR">ȸ�ǽ� ����</button> -->
	  		<a class="btn btn-danger btn" href="/reservation/myReservation" role="button">�� &nbsp;��</a>
			</div>
		</div>
	</div>
