<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!--  화면구성 div Start /////////////////////////////////////-->
         <div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-pencil "></i>
                ${reservation.mettingRoomName } &nbsp; ${reservation.startTime }-${reservation.endTime }타임 수정</h4>
                <form>


			<div class="row mb-4">
				<div class="col-md-4">
					<label>시작 시간</label><input type="text" class="form-control" id="startTime" name="startTime" value="${reservation.startTime }">
				</div>
				<div class="col-md-4">
					<label>종료 시간</label> <input type="text" class="form-control" id="endTime" name="endTime" value="${reservation.endTime }">
				</div>
				<div class="col-md-4">
					<label>이용 목적</label> <input type="text" class="form-control" id="usePurpose" name="usePurpose" value="${reservation.usePurpose }">
				</div>
			</div>
	<input type="hidden" name="reNum" value="${reservation.reNum }"/>

			<div class="row mb-10">
				<div class="col-md-12">
					<button type="button" class="btn btn-info" id="updateRVV">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>수정
					</button>
					<a class="btn btn-danger btn" href="#" role="button">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>취소
					</a>
				</div>
			</div>

		</form>
      <!-- form End /////////////////////////////////////-->
      </div>
      </div>
   <!--  화면구성 div end /////////////////////////////////////-->