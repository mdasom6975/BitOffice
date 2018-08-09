<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!--  화면구성 div Start /////////////////////////////////////-->
         <div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-pencil "></i>
                ${meetingRoom.mettingRoomName } 수정</h4>
                <form>


			<div class="row mb-4">
				<div class="col-md-4">
					<label>회의실 코드</label><input type="text" class="form-control" id="meetingRoomCode" name="meetingRoomCode" value="${meetingRoom.meetingRoomCode }" placeholder="변경할 회의실 코드">
				</div>
				<div class="col-md-4">
					<label>회의실 이름</label><input type="text" class="form-control" id="mettingRoomName" name="mettingRoomName" value="${meetingRoom.mettingRoomName }" placeholder="변경할 회의실 이름">
				</div>
			</div>

			<div class="row mb-10">
				<div class="col-md-12">
					<button type="button" class="btn btn-info" id="updateRV">
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