<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


	<div class="container">
		<div class="row">

			<table class="table table-striped"
				style="text-align: center; boder: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">${reservation.mettingRoomName } &nbsp; ${reservation.startTime }-${reservation.endTime }Ÿ�� ����</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>SEQ</td>
						<td><input type="text" class="form-control" id="reNum" name="reNum" value="${reservation.reNum }" readonly>
		      			 <span id="helpBlock" class="help-block">
		      			<strong class="text-danger">SEQ ���� �Ұ�</strong></td>
					</tr>
					<tr>
						<td style="width: 20%">���� �ð�</td>
						<td><input type="text" class="form-control" id="startTime" name="startTime" value="${reservation.startTime }"></td>
					</tr>
					<tr>
						<td style="width: 20%">���� �ð�</td>
						<td><input type="text" class="form-control" id="endTime" name="endTime" value="${reservation.endTime }"></td>
					</tr>
					<tr>
						<td>�̿� ����</td>
						<td>
						<textarea class="form-control" id="usePurpose" name="usePurpose" rows="7">${reservation.usePurpose }</textarea>
						</td>
					</tr>
					
				</tbody>
			</table>
			<div class="col-md-12 text-center">
		      <button type="button" class="btn btn-info" id="updateRV">�� &nbsp;��</button>
<!-- 	  			<button type="button" class="btn btn-info" id="getMR">ȸ�ǽ� ����</button> -->
			<a class="btn btn-danger btn" href="#" role="button">��&nbsp;��</a>
			</div>
		</div>
	</div>
