<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
         <div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-pencil "></i>
                ${employee.employeeNo }���� ȸ�ǽ� ����</h4>
                <form>


			<div class="row mb-4">
				<div class="col-md-4">
					<label>������</label><input type="text" class="form-control" id="employeeNo"
							name="employeeNo" value="${employee.employeeNo}" readonly="readonly">
				</div>
				<div class="col-md-4">
					<label>ȸ�ǽ�</label>						
						<select class="form-control" name="mettingRoomName" id="mettingRoomName">
						<option disabled selected>ȸ�ǽ� ����</option>
						</select>
				</div>
				<div class="col-md-4">
					<label>���� ��¥</label><input type="text" class="form-control" id="reserveDate" name="reserveDate">
				</div>
				<div class="col-md-4">
					<label>���� �ð�</label><input type="text" class="form-control" id="startTime" name="startTime">
				</div>
				<div class="col-md-4">
					<label>���� �ð�</label><input type="text" class="form-control" id="endTime" name="endTime">
				</div>
				<div class="col-md-4">
					<label>�̿� ����</label><input type="text" class="form-control" id="usePurpose" name="usePurpose">
				</div>
			</div>

			<div class="row mb-10">
				<div class="col-md-12">
					<button type="button" class="btn btn-success" id="reserve">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>����
					</button>
				</div>
			</div>

		</form>
      <!-- form End /////////////////////////////////////-->
      </div>
      </div>
   <!--  ȭ�鱸�� div end /////////////////////////////////////-->