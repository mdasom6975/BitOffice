<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


	<div class="col-md-10">
		 <div class="tile">
		 <h3 class="tile-title">�������� �󼼺���</h3>
			<table class="table" >
				<thead>
					<tr>
						<th>������</th>
						<th>${board.boardTitle}</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>�ۼ���</td>
						<td>${board.employeeName}</td>
					</tr>
					<tr>
						<td>�ۼ�����</td>
						<td>${board.boardDate}</td>
					</tr>
					<tr>
						<td>����</td>
						<td>${board.boardContent}</td>
					</tr>
					
				</tbody>
			</table>
			<div class="col-md-12 text-center">
			<c:if test="${employee.employeeNo == board.employeeNo}">
			<button type="button" class="btn btn-primary " value="${board.boardNo }">����</button>
			</c:if>
			<button type="button" class="btn btn-primary ">�������</button>
			</div>
		</div>
	</div>
