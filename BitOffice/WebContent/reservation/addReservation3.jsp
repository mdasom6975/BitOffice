<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page pageEncoding="EUC-KR"%>

    <!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container">
		<div class="reservation_div">
			<h2 class="page-header">${employee.employeeNo }���� ȸ�ǽ� ����</h2>
			<form class="form-horizontal" enctype="multipart/form-data">
				
				<div class="form-group">
					<label for="reserveEmployee" class="col-sm-offset-1 col-sm-3 control-label">������</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="employeeNo"
							name="employeeNo" value="${employee.employeeNo}">
					</div>
				</div>
				
				<div class="form-group">
					<label for="meetingRoom" class="col-sm-offset-1 col-sm-3 control-label">ȸ�ǽ�</label>
					<div class="col-sm-2">
						<select class="form-control" name="mettingRoomName" id="mettingRoomName">
						<option disabled selected>ȸ�ǽ� ����</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="reserveDate" class="col-sm-offset-1 col-sm-3 control-label">���� ��¥</label>
					<div class="col-xs-8 col-md-4">
						<input type="text" class="form-control" id="reserveDate" name="reserveDate">
				</div>
			</div>

			<div class="form-group">
				<label for="startTime" class="col-sm-offset-1 col-sm-3 control-label">���� �ð�</label>
				<div class="col-xs-8 col-md-4">
					<input type="text" class="form-control" id="startTime" name="startTime">
				</div>
			</div>

			<div class="form-group">
				<label for="endTime" class="col-sm-offset-1 col-sm-3 control-label">���� �ð�</label>
				<div class="col-xs-8 col-md-4">
					<input type="text" class="form-control" id="endTime" name="endTime">
				</div>
			</div>

			<div class="form-group">
				<label for="usePurpose" class="col-sm-offset-1 col-sm-3 control-label">�̿� ����</label>
				<div class="col-xs-8 col-md-4">
					<textarea class="form-control" id="usePurpose" name="usePurpose"/>
				</div>
			</div>
			</form>
			
			<button type="button" class="btn btn-success" style="float: right;">
			<i class="fa fa-magic"></i>&nbsp; �ۼ�</button>
		
		</div>
	</div>
  <!--  ȭ�鱸�� div End /////////////////////////////////////-->
