<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!--  화면구성 div Start /////////////////////////////////////-->
         <div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-pencil "></i>
                ${employee.employeeNo }님의 회의실 예약</h4>
                <form>


			<div class="row mb-4">
				<div class="col-md-4">
					<label>예약자</label><input type="text" class="form-control" id="employeeNo"
							name="employeeNo" value="${employee.employeeNo}" readonly="readonly">
				</div>
				<div class="col-md-4">
					<label>회의실</label>						
						<select class="form-control" name="mettingRoomName" id="mettingRoomName">
						<option disabled selected>회의실 선택</option>
						</select>
				</div>
				<div class="col-md-4">
					<label>예약 날짜</label><input type="text" class="form-control" id="reserveDate" name="reserveDate">
				</div>
				<div class="col-md-4">
					<label>시작 시간</label><input type="text" class="form-control" id="startTime" name="startTime">
				</div>
				<div class="col-md-4">
					<label>종료 시간</label><input type="text" class="form-control" id="endTime" name="endTime">
				</div>
				<div class="col-md-4">
					<label>이용 목적</label><input type="text" class="form-control" id="usePurpose" name="usePurpose">
				</div>
			</div>

			<div class="row mb-10">
				<div class="col-md-12">
					<button type="button" class="btn btn-success" id="reserve">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>예약
					</button>
				</div>
			</div>

		</form>
      <!-- form End /////////////////////////////////////-->
      </div>
      </div>
   <!--  화면구성 div end /////////////////////////////////////-->