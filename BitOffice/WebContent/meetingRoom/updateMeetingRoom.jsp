<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
         <div class="tab-pane fade active show" id="user-settings">
              <div class="tile user-settings">
                <h4 class="line-head">
                <i class="fa fa-pencil "></i>
                ${meetingRoom.mettingRoomName } ����</h4>
                <form>


			<div class="row mb-4">
				<div class="col-md-4">
					<label>ȸ�ǽ� �ڵ�</label><input type="text" class="form-control" id="meetingRoomCode" name="meetingRoomCode" value="${meetingRoom.meetingRoomCode }" placeholder="������ ȸ�ǽ� �ڵ�">
				</div>
				<div class="col-md-4">
					<label>ȸ�ǽ� �̸�</label><input type="text" class="form-control" id="mettingRoomName" name="mettingRoomName" value="${meetingRoom.mettingRoomName }" placeholder="������ ȸ�ǽ� �̸�">
				</div>
			</div>

			<div class="row mb-10">
				<div class="col-md-12">
					<button type="button" class="btn btn-info" id="updateRV">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>����
					</button>
					<a class="btn btn-danger btn" href="#" role="button">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>���
					</a>
				</div>
			</div>

		</form>
      <!-- form End /////////////////////////////////////-->
      </div>
      </div>
   <!--  ȭ�鱸�� div end /////////////////////////////////////-->