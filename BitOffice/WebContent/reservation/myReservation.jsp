<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="app-title">
        <div>
          <h1> ${employee.employeeNo } ���� ����</h1>
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
			<p class="text-primary">��ü ${resultPage.totalCount } ���� ������ �ֽ��ϴ�.</p>
		</div>
				</div>
					<div class="row">
						<div class="col-sm-12">
							<table
								class="table table-hover table-bordered dataTable no-footer"
								id="sampleTable" role="grid" aria-describedby="sampleTable_info">
								
								<thead>
									<tr role="row">
										<th class="sorting_asc" tabindex="0"
											aria-controls="sampleTable" rowspan="1" colspan="1"
											aria-sort="ascending"
											aria-label="Name: activate to sort column descending"
											style="width: 7px;">����</th>
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Position: activate to sort column ascending"
											style="width: 70px;">ȸ�ǽ�</th>
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="width: 70px;">���� ��¥</th>
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="width: 70px;">���� �ð�</th>
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="width: 70px;">���� �ð�</th>
										<th class="sorting" tabindex="0" aria-controls="sampleTable"
											rowspan="1" colspan="1"
											aria-label="Age: activate to sort column ascending"
											style="width: 7px;">����</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="i" value="0" />
									<c:forEach var="reservation" items="${list}">
										<c:set var="i" value="${ i+1 }" />
										<tr role="row" class="odd">
											<td value="${reservation.reNum }">${reservation.reNum }</td>
											<td>${reservation.mettingRoomName }</td>
											<td>${reservation.reserveDate}</td>
											<td>${reservation.startTime}</td>
											<td>${reservation.endTime}</td>
			 								<td><button type="button" onclick="location.href='cancelReservation?reNum=${reservation.reNum}'">����</button></td>
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

